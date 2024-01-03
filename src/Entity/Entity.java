package Entity;

import Controls.GamePanel;
import Controls.UtilityTool;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Entity {

    public GamePanel gp;
    public int worldX, worldY;
    public int speed;

    public BufferedImage up1, up2, up3, down1, down2, down3, left1, left2, left3, right1, right2, right3, bait;
    public BufferedImage fishingMove1, fishingMove2, fishingMove3, fishingMove4, fishingMove5, fishingMove6;

    public String direction = "down";
    public int spriteCounter = 0;
    public int spriteNum = 1;
    public Rectangle solidArea = new Rectangle (0,0 , 48, 48);
    public Rectangle fishingArea = new Rectangle (0,0,0,0);
    public int solidAreaDefaultX, solidAreaDefaultY;
    public boolean collisionOn = false;
    public boolean isFishing = false;
    public int fishingLockCounter = 0;
    //    public int actionLockCounter = 0;
    public BufferedImage image, image2, image3;
    public String name;
    public String imagePath;
    public boolean collision = false;
    String dialogues[] = new String[20];
    int dialogueIndex = 0;


    //CHARACTER ATTRIBUTES
    public int maxLife;
    public int life;

    public int level;
    public int strength;
    public int dexterity;
    public int fishing;
    public int exp;
    public int nextLevelExp;
    public int coin;
    public Entity currentRod;
    public Entity currentBait;
    public Entity currentCoconut;
    public Entity currentHalibut;
    public Entity currentTilapia;
    public Entity currentSquid;
    public Entity currentFlounder;
    public Entity currentSardine;
    public boolean  invincible = false;
    public int invincibleCounter = 0;
    // ITEM ATTRIBUTES
    public ArrayList<Entity> inventory = new ArrayList<>();
    public final int maxInventorySize = 20;
    public int fishingValue;
    public int baitingValue;
    public int actionLockCounter;


    public String description = "";
    public int price;
    public int useCost;
    //type
    public int type;
    public final int type_player = 0;
    public final int type_npc = 1;
    public final int type_rod = 2;
    public final int type_bait = 3;
    public final int type_consumable = 4;
    public final int type_flounder = 5;
    public final int type_halibut = 6;
    public final int type_sardine = 7;
    public final int type_squid = 8;
    public final int type_tilapia = 9;
    public final int type_Crab = 10;


    public Entity(GamePanel gp){

        this.gp = gp;
    }

    public void setAction(){}
    public void speak(){
        if(dialogues[dialogueIndex] == null){
            dialogueIndex = 0;
        }
        gp.ui.currentDialogue = dialogues[dialogueIndex];
        dialogueIndex++;
    }
    public void use(Entity entity){}
    public void fishingEvent(Entity entity){
        int itemIndex = gp.ui.getItemIndexOnSlot(gp.ui.playerSlotCol, gp.ui.playerSlotRow);
        if(itemIndex < inventory.size()) {
            Entity selectedItem = inventory.get(itemIndex);
            if (selectedItem.type == type_bait) {
                currentBait = selectedItem;
            }
        }
        boolean hasBait = inventory.contains(currentBait);
        if (hasBait){
            Random rand = new Random();
            int i = rand.nextInt(10);
            switch(i) {
                case 1:

                case 2:
                    inventory.add(currentHalibut);
                    gp.player.life--;
                    inventory.remove(currentBait);
                    gp.ui.currentDialogue = "You are fishing.\nCheck your inventory when everything\nis done";
                    gp.gameState = gp.dialogueState;
                    break;
                case 3:
                case 4:
                    inventory.add(currentTilapia);
                    gp.player.life--;
                    inventory.remove(currentBait);
                    gp.ui.currentDialogue = "You are fishing.\nCheck your inventory when everything\nis done";
                    gp.gameState = gp.dialogueState;
                    break;
                case 5:
                    inventory.add(currentSquid);
                    gp.player.life--;
                    inventory.remove(currentBait);
                    gp.ui.currentDialogue = "You are fishing.\nCheck your inventory when everything\nis done";
                    gp.gameState = gp.dialogueState;
                    break;
                case 6:
                case 7:
                    inventory.add(currentSardine);
                    gp.player.life--;
                    inventory.remove(currentBait);
                    gp.ui.currentDialogue = "You are fishing.\nCheck your inventory when everything\nis done";
                    gp.gameState = gp.dialogueState;
                    break;
                case 8:
                case 9:
                    inventory.add(currentFlounder);
                    gp.player.life--;
                    inventory.remove(currentBait);
                    gp.ui.currentDialogue = "You are fishing.\nCheck your inventory when everything\nis done";
                    gp.gameState = gp.dialogueState;
                    break;
            }
        }
        else{
            isFishing = false;
            gp.ui.currentDialogue = "Not enough bait to fish.\nCheck the shop for baits";
            gp.gameState = gp.dialogueState;
        }
        if(gp.player.life == 1){
            gp.ui.currentDialogue = "You are about to pass out. Be careful!!!";
            gp.gameState = gp.dialogueState;
        }
        if(gp.player.life == 0){
            //Game over
        }
    }
    public void update(){
        setAction();

        collisionOn = false;
        gp.cDetection.checkTile(this);
        gp.cDetection.checkObject(this, false);
        gp.cDetection.checkPlayer(this);
        gp.cDetection.checkNPC(this,gp.npc);

//        if(this.type == type_Crab && contactPlayer = true) {
//            if(gp.player.invincible == false){
//                gp.player.life -= 2;
//                gp.player.invincible = true;
//            }
//        }
        //If collision is false, player can move
        if(!collisionOn) {
            switch(direction) {
                case "up":
                    worldY -= speed;
                    break;
                case "down":
                    worldY += speed;
                    break;
                case "left":
                    worldX -= speed;
                    break;
                case "right":
                    worldX += speed;
                    break;
            }
        }
        spriteCounter++;
        if(spriteCounter > 12){
            if(spriteNum == 1){
                spriteNum = 2;
            }
            else if(spriteNum == 2){
                spriteNum = 1;
            }
            spriteCounter = 0;
        }

    }

    public void draw(Graphics g2){

        BufferedImage image = null;
        int screenX = worldX - gp.player.worldX + gp.player.screenX;
        int screenY = worldY - gp.player.worldY + gp.player.screenY;

        // STOP MOVING CAMERA
        if(gp.player.worldX < gp.player.screenX) {
            screenX = worldX;
        }
        if(gp.player.worldY < gp.player.screenY) {
            screenY = worldY;
        }
        int rightOffset = gp.screenWidth - gp.player.screenX;
        if(rightOffset > gp.worldWidth - gp.player.worldX) {
            screenX = gp.screenWidth - (gp.worldWidth - worldX);
        }
        int bottomOffset = gp.screenHeight - gp.player.screenY;
        if(bottomOffset > gp.worldHeight - gp.player.worldY) {
            screenY = gp.screenHeight - (gp.worldHeight - worldY);
        }

        switch (direction) {
            case "up":
                if(!isFishing){
                    if(spriteNum == 1){image = up1;}
                    if(spriteNum == 2){image = up2;}
                    if(spriteNum == 3){image = up3;}
                }
                if(isFishing){
                    if(spriteNum == 1){image = fishingMove1;}
                    if(spriteNum == 2){image = fishingMove2;}

                }
                break;
            case "down":
                if(!isFishing){
                    image = down1;
                    if(spriteNum == 1){image = down1;}
                    if(spriteNum == 2){image = down2;}
                    if(spriteNum == 3){image = down3;}
                }
                if(isFishing){
                    if(spriteNum == 1){image = fishingMove1;}
                    if(spriteNum == 2){image = fishingMove2;}

                }
                break;
            case "left":
                if(!isFishing){
                    image = left1;
                    if(spriteNum == 1){image = left1;}
                    if(spriteNum == 2){image = left2;}
                    if(spriteNum == 3){image = left3;}
                }
                if(isFishing){
                    if(spriteNum == 1){image = fishingMove4;}
                    if(spriteNum == 2){image = fishingMove3;}

                }
                break;
            case "right":
                if(!isFishing){
                    image = right1;
                    if (spriteNum == 1){image = right1;}
                    if (spriteNum == 2){image = right2;}
                    if(spriteNum == 3){image = right3;}
                }
                if(isFishing){
                    if(spriteNum == 1){image = fishingMove6;}
                    if(spriteNum == 2){image = fishingMove5;}
                }
                break;
        }

        if(worldX + gp.tileSize > gp.player.worldX - gp.player.screenX &&
                worldX - gp.tileSize < gp.player.worldX + gp.player.screenX &&
                worldY + gp.tileSize > gp.player.worldY - gp.player.screenY &&
                worldY - gp.tileSize < gp.player.worldY + gp.player.screenY) {
            g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
        }
        // If player is around the edge, draw everything
        else if(gp.player.worldX < gp.player.screenX ||
                gp.player.worldY < gp.player.screenY ||
                rightOffset > gp.worldWidth - gp.player.worldX ||
                bottomOffset > gp.worldHeight - gp.player.worldY) {
            g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
        }
    }
    public BufferedImage setup(String imageName, int width, int height) {

        UtilityTool uTool = new UtilityTool();
        BufferedImage image = null;
        String imagePath =  "res/" + imageName + ".png";
        File imageFile = new File(imagePath);

        try (FileInputStream fis = new FileInputStream(imageFile)) {
            image = ImageIO.read(fis);
            image = uTool.scaleImage(image, width, height);

        } catch(IOException e) {
            e.printStackTrace();
        }
        return image;
    }
}