package Entity;

import Controls.GamePanel;
import Controls.KeyHandler;
import Object.OBJ_Bait;
import Object.OBJ_Rod;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Player extends Entity {

    KeyHandler keyH;
    public final int screenX;
    public final int screenY;
    int standCounter = 0;

    public Player(GamePanel gp, KeyHandler keyH){

        super(gp);
        this.keyH = keyH;

        screenX = gp.screenWidth/2 - (gp.tileSize/2);
        screenY = gp.screenHeight/2 - (gp.tileSize/2);

        solidArea = new Rectangle();
        solidArea.x = 8;
        solidArea.y = 16;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        solidArea.width = 32;
        solidArea.height = 32;
        
        setDefaultValues();
        getPlayerImage();


    }
    public void setDefaultValues(){
        worldX = 9 * gp.tileSize;
        worldY = 9 * gp.tileSize;
        speed = 4;
        direction = "down";

    // PLAYER STATUS
        level = 1;
    //  maxLife = 3; anh Bảo làm phần tym thì bỏ cái cmt phần này của em nha
    // life = maxLife;
        strength = 1; //the more strength he has, the more fishing he caught
        dexterity = 1;
        exp = 0;
        nextLevelExp = 5;
        coin = 100;
        currentRod = new OBJ_Rod(gp);
        currentBait = new OBJ_Bait(gp);
        fishing = getFishing(); // the total fishing value is decided by strengt and rob

    }
    public int getFishing(){
        return fishing = strength * currentRod.fishingValue;
    }
    public void getPlayerImage(){
        try
                (InputStream inputStream01 = new FileInputStream(new File("res/Player/left1.png"));
                 InputStream inputStream02 = new FileInputStream(new File("res/Player/left2.png"));
                 InputStream inputStream03 = new FileInputStream(new File("res/Player/stand2.png"));
                 InputStream inputStream04 = new FileInputStream(new File("res/Player/right1.png"));
                 InputStream inputStream05 = new FileInputStream(new File("res/Player/right2.png"));
                 InputStream inputStream06 = new FileInputStream(new File("res/Player/stand3.png"));
                 InputStream inputStream07 = new FileInputStream(new File("res/Player/down1.png"));
                 InputStream inputStream08 = new FileInputStream(new File("res/Player/down2.png"));
                 InputStream inputStream09 = new FileInputStream(new File("res/Player/stand1.png"));
                 InputStream inputStream10 = new FileInputStream(new File("res/Player/up1.png"));
                 InputStream inputStream11 = new FileInputStream(new File("res/Player/up2.png"));
                 InputStream inputStream12 = new FileInputStream(new File("res/Player/stand4.png"))){

            left1 = ImageIO.read(inputStream01);
            left2 = ImageIO.read(inputStream02);
            left3 = ImageIO.read(inputStream03);
            right1 = ImageIO.read(inputStream04);
            right2 = ImageIO.read(inputStream05);
            right3 = ImageIO.read(inputStream06);
            down1 = ImageIO.read(inputStream07);
            down2 = ImageIO.read(inputStream08);
            down3 = ImageIO.read(inputStream09);
            up1 = ImageIO.read(inputStream10);
            up2 = ImageIO.read(inputStream11);
            up3 = ImageIO.read(inputStream12);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void update(){
        if(keyH.upPressed == true || keyH.downPressed == true || keyH.leftPressed == true ||keyH.rightPressed == true ){
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

            //Check NPC collision
            int npcIndex = gp.cDetection.checkNPC(this, gp.npc);
            interactNPC(npcIndex);

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
    }
    public void interactNPC(int i) {
        if(i != 999){
            System.out.println("hit npc");
        }
    }
    public void draw(Graphics2D g2){
        BufferedImage image = null;

//        int playerX = (gp.screenWidth - (16 * gp.tileSize)) / 2 + worldX - (gp.tileSize / 2);
//        int playerY = (gp.screenHeight - (12 * gp.tileSize)) / 2 + worldY - (gp.tileSize / 2);

        switch (direction) {
            case "up":
                image = up3;
                if(spriteNum == 1){
                    image = up1;
                }
                if(spriteNum == 2){
                    image = up2;
                }
                if(spriteNum == 3){
                    image = up3;
                }
                break;
            case "down":
                image = down1;
                if(spriteNum == 1){
                    image = down1;
                }
                if(spriteNum == 2){
                    image = down2;
                }
                if(spriteNum == 3){
                    image = down3;
                }
                break;
            case "left":
                image = left1;
                if(spriteNum == 1){
                    image = left1;
                }
                if(spriteNum == 2){
                    image = left2;
                }
                if(spriteNum == 3){
                    image = left3;
                }
                break;
            case "right":
                image = right1;
                if (spriteNum == 1){
                    image = right1;
                }
                if (spriteNum == 2){
                    image = right2;
                }
                if(spriteNum == 3){
                    image = right3;
                }
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

        g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);

    }
}