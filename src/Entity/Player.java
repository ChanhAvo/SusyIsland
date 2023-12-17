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

    public Player(GamePanel gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;

        solidArea = new Rectangle();
        solidArea.x = 5;
        solidArea.y = 10;
        solidArea.width = 16;
        solidArea.height = 16;

        getPlayerImage();
        setDefaultValues();
    }
    public void setDefaultValues(){
        x = 100;
        y = 100;
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

            //If collision is false, player can move
            if(collisionOn == false) {
                switch(direction) {
                    case "up":
                        y -= speed;
                        break;
                    case "down":
                        y += speed;
                        break;
                    case "left":
                        x -= speed;
                        break;
                    case "right":
                        x += speed;
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

        g2.drawImage(image, x,y, gp.tileSize, gp.tileSize, null);

    }
}