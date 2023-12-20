package Entity;

import Controls.GamePanel;
import Controls.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

import java.awt.*;
import java.io.*;
import java.util.Objects;

public class Player extends Entity {

    GamePanel gp;
    KeyHandler keyH;

    public final int screenX;
    public final int screenY;

    public Player(GamePanel gp, KeyHandler keyH){
        this.gp = gp;
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
    }
    public void getPlayerImage(){
        try
                (InputStream inputStream01 = new FileInputStream(new File("res/Player/left1.png"));
                 InputStream inputStream02 = new FileInputStream(new File("res/Player/left2.png"));
                 InputStream inputStream03 = new FileInputStream(new File("res/Player/right1.png"));
                 InputStream inputStream04 = new FileInputStream(new File("res/Player/right2.png"));
                 InputStream inputStream05 = new FileInputStream(new File("res/Player/down1.png"));
                 InputStream inputStream06 = new FileInputStream(new File("res/Player/down2.png"));
                 InputStream inputStream07 = new FileInputStream(new File("res/Player/up1.png"));
                 InputStream inputStream08 = new FileInputStream(new File("res/Player/up2.png"))){

            left1 = ImageIO.read(inputStream01);
            left2 = ImageIO.read(inputStream02);
            right1 = ImageIO.read(inputStream03);
            right2 = ImageIO.read(inputStream04);
            down1 = ImageIO.read(inputStream05);
            down2 = ImageIO.read(inputStream06);
            up1 = ImageIO.read(inputStream07);
            up2 = ImageIO.read(inputStream08);


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
    }
    public void draw(Graphics2D g2){
        BufferedImage image = null;

//        int playerX = (gp.screenWidth - (16 * gp.tileSize)) / 2 + worldX - (gp.tileSize / 2);
//        int playerY = (gp.screenHeight - (12 * gp.tileSize)) / 2 + worldY - (gp.tileSize / 2);

        switch (direction) {
            case "up":
                image = up1;
                if(spriteNum == 1){
                    image = up1;
                }
                if(spriteNum == 1){
                    image = up2;
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
                break;
            case "left":
                image = left1;
                if(spriteNum == 1){
                    image = left1;
                }
                if(spriteNum == 2){
                    image = left2;
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
                break;
        }

        g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);

    }
}