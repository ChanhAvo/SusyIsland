package Entity;

import Controls.GamePanel;
import Controls.KeyHandler;
import Controls.UtilityTool;
import Object.OBJ_Bait;
import Object.OBJ_Rod;
import Object.OBJ_Coconut;
import Object.OBJ_Halibut;
import Object.OBJ_Flounder;
import Object.OBJ_Squid;
import Object.OBJ_Tilapia;
import Object.OBJ_Sardine;


import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import Controls.UtilityTool;
import java.io.*;


public class Player extends Entity {

    public KeyHandler keyH;
    public final int screenX;
    public final int screenY;
    int standCounter = 0;
    public boolean lightUpdated = false;


    public Player(GamePanel gp, KeyHandler keyH) {

        super(gp);
        this.keyH = keyH;

        screenX = gp.screenWidth / 2 - (gp.tileSize / 2);
        screenY = gp.screenHeight / 2 - (gp.tileSize / 2);

        solidArea = new Rectangle();
        solidArea.x = 8;
        solidArea.y = 16;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        solidArea.width = 32;
        solidArea.height = 32;

        setDefaultValues();
        getPlayerImage();
        getPlayerFishingImage();
        setItems();
    }


    public void setDefaultValues(){
        worldX =  gp.tileSize;
        worldY =  gp.tileSize;
>>>>>>>>> Temporary merge branch 2
        speed = 4;
        direction = "right";

        // PLAYER STATUS
        level = 1;
        maxLife = 20;
        life = maxLife;
        strength = 1;
        dexterity = 1;
        exp = 0;
        nextLevelExp = 5;
        coin = 100;
        currentRod = new OBJ_Rod(gp);
        currentBait = new OBJ_Bait(gp);
        currentHalibut = new OBJ_Halibut(gp);
        currentSardine = new OBJ_Sardine(gp);
        currentSquid = new OBJ_Squid(gp);
        currentTilapia = new OBJ_Tilapia(gp);
        currentFlounder = new OBJ_Flounder(gp);
        currentCoconut = new OBJ_Coconut(gp);
        fishing = getFishing(); // the total fishing value is decided by strengt and rob

    }
    public void setDefaultPosition(){
        worldX =  gp.tileSize;
        worldY =  gp.tileSize;
        speed = 4;
        direction = "right";
    }
    public void restoreLife(){
        life = maxLife;
        invincible = false;
    }
    public void setItems(){
        inventory.clear();
        inventory.add(currentRod);

        for (int i = 0; i < 9; i++){
            inventory.add(currentBait);
        }
    }
    public int getFishing(){
        return fishing = strength * currentRod.fishingValue;
    }

    public void getPlayerImage() {

        left1 = setup("left1", gp.tileSize, gp.tileSize);
        left2 = setup("left2", gp.tileSize, gp.tileSize);
        right1 = setup("right1", gp.tileSize, gp.tileSize);
        right2 = setup("right2", gp.tileSize, gp.tileSize);
        down1 = setup("down1", gp.tileSize, gp.tileSize);
        down2 = setup("down2", gp.tileSize, gp.tileSize);
        up1 = setup("up1", gp.tileSize, gp.tileSize);
        up2 = setup("up2", gp.tileSize, gp.tileSize);
        down3 = setup("stand1", gp.tileSize, gp.tileSize);
        left3 = setup("stand2", gp.tileSize, gp.tileSize);
        right3 = setup("stand3", gp.tileSize, gp.tileSize);
        up3 = setup("stand4", gp.tileSize, gp.tileSize);
    }
    public void getPlayerFishingImage(){
        fishingMove1 = setup("fishing_move1",gp.tileSize,gp.tileSize*2);
        fishingMove2 = setup("fishing_move2",gp.tileSize,gp.tileSize*2);
        fishingMove3 = setup("fishing_move3",gp.tileSize*2,gp.tileSize);
        fishingMove4 = setup("fishing_move4",gp.tileSize*2,gp.tileSize);
        fishingMove5 = setup("fishing_move5",gp.tileSize*2,gp.tileSize);
        fishingMove6 = setup("fishing_move6",gp.tileSize*2,gp.tileSize);
    }

    public BufferedImage setup(String imageName, int tileSize, int size) {

        UtilityTool uTool = new UtilityTool();
        BufferedImage image = null;
        String filePath = "res/Player/" + imageName + ".png";
        File imageFile = new File(filePath);

        try (FileInputStream fis = new FileInputStream(imageFile)) {
            image = ImageIO.read(imageFile);
            image = uTool.scaleImage(image, gp.tileSize, gp.tileSize);

        } catch(IOException e) {
            e.printStackTrace();
        }
        return image;
    }

    public void update(){
        if(isFishing){
            fishing();
        }
        else if(keyH.upPressed == true ||
                keyH.downPressed == true ||
                keyH.leftPressed == true ||
                keyH.rightPressed == true ||
                keyH.enterPressed == true){

            if(keyH.upPressed){
                direction = "up";
            }
            else if (keyH.downPressed){
                direction = "down";
            }
            else if (keyH.leftPressed){
                direction = "left";
            }
            else if (keyH.rightPressed){
                direction = "right";
            }

            //Check tile collision
            collisionOn = false;
            gp.cDetection.checkTile(this);

            //Check object collision
            int objIndex = gp.cDetection.checkObject(this, true);
            pickUpObject(objIndex);

            //Check NPC collision
            int npcIndex = gp.cDetection.checkNPC(this, gp.npc);
            interactNPC(npcIndex);
            //Check crab collision
            int crabIndex = gp.cDetection.checkNPC(this,gp.crab);
            contactCrab(crabIndex);

            //CHECK EVENT
            gp.eHandler.checkEvent();


            //If collision is false, player can move
            if(!collisionOn && !keyH.enterPressed) {
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
            gp.keyH.enterPressed = false;

            spriteCounter++;
            if(spriteCounter < 12) {
                spriteNum = 1;
            }
            if(spriteCounter > 12 && spriteCounter < 24) {
                spriteNum = 2;
            }
            if(spriteCounter > 24) {
                spriteCounter = 0;
            }
        }
        else {
            standCounter++;
            if(standCounter == 24) {
                spriteNum = 3;
                standCounter = 0;
            }
        }
        // set timer for the crab to attack the char
        if(invincible == true){
            invincibleCounter++;
            if(invincibleCounter > 15){
                invincible = false;
                invincibleCounter = 0;
            }
        }
        if(life <=0 ){
            gp.gameState = gp.gameOverState;
            gp.playSE(7);

        }
    }
    public void fishing(){
        spriteCounter++;

        if(spriteCounter <= 20){
            spriteNum = 1;
        }
        if(spriteCounter > 20 && spriteCounter <= 70){
            spriteNum =2;
        }
        if(spriteCounter > 70){
            spriteNum = 3;
            spriteCounter = 0;
            isFishing = false;
        }
    }

    public void interactNPC(int i) {
        if(gp.keyH.enterPressed == true){
            if(i != 999){
                gp.gameState = gp.dialogueState;
                gp.npc[i].speak();
            }else{isFishing = true;}
        }
    }
    public void pickUpObject(int i){
        if (i != 999) {

            String text;
            gp.playSE(5);
            if(inventory.size() != maxInventorySize){
                inventory.add(gp.obj[i]);
                text = "Got a " + gp.obj[i].name + "!";
            } else {
                text = "You cannot carry any more!";
            }
            gp.ui.addMessage(text);
            gp.obj[i] = null;
        }
    }
    public void selectItem() {
        int itemIndex = gp.ui.getItemIndexOnSlot(gp.ui.playerSlotCol, gp.ui.playerSlotRow);
        if(itemIndex < inventory.size()){
            Entity selectedItem = inventory.get(itemIndex);
            if(selectedItem.type == type_rod || selectedItem.type == type_bait) {
                currentRod = selectedItem;

            }
            if(selectedItem.type == type_consumable){
                selectedItem.use(this);
                inventory.remove(itemIndex);
//                if(selectedItem.drink)
                currentCoconut = selectedItem;
                gp.player.life = gp.player.maxLife;

            }

        }
    }
    public void contactCrab(int i ){
        if(i != 999){
           if(invincible == false){
                life -= 2;
                gp.playSE(4);
                invincible = true;
           }
        }
    }
    public void draw(Graphics2D g2){
        BufferedImage image = null;

//        int playerX = (gp.screenWidth - (16 * gp.tileSize)) / 2 + worldX - (gp.tileSize / 2);
//        int playerY = (gp.screenHeight - (12 * gp.tileSize)) / 2 + worldY - (gp.tileSize / 2);

        switch (direction) {
            case "up":
                if(spriteNum == 1){image = up1;}
                if(spriteNum == 2){image = up2;}
                if(spriteNum == 3){image = up3;}

                break;
            case "down":
                image = down1;
                if(spriteNum == 1){image = down1;}
                if(spriteNum == 2){image = down2;}
                if(spriteNum == 3){image = down3;}

                break;
            case "left":
                image = left1;
                if(spriteNum == 1){image = left1;}
                if(spriteNum == 2){image = left2;}
                if(spriteNum == 3){image = left3;}

                break;
            case "right":
                image = right1;
                if (spriteNum == 1){image = right1;}
                if (spriteNum == 2){image = right2;}
                if(spriteNum == 3){image = right3;}

                break;
        }
        int x = screenX;
        int y = screenY;
        if(screenX > worldX){
            x = worldX;
        }
        if(screenY > worldY){
            y = worldY;
        }
        int rightOffset = gp.screenWidth - screenX;
        if(rightOffset > gp.worldWidth - worldX){
            x = gp.screenWidth - (gp.worldWidth - worldX);
        }
        int bottomOffset = gp.screenHeight - screenY;
        if(bottomOffset > gp.worldHeight - worldY){
            y = gp.screenHeight - (gp.worldHeight - worldY);
        }

        g2.drawImage(image, x, y, null);

    }
}