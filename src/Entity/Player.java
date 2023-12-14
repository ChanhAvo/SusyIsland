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

    public Player(GamePanel gp, KeyHandler keyH){
        this.gp = gp;
        this.keyH = keyH;
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
        if(keyH.upPressed){
            direction = "up";
            y -= speed;
        }
        else if (keyH.downPressed){
            direction = "down";
            y += speed;
        }
        else if (keyH.leftPressed){
            direction = "left";
            x -= speed;
        }
        else if (keyH.rightPressed){
            direction = "right";
            x += speed;
        }
    }
    public void draw(Graphics2D g2){
        BufferedImage image = null;

        switch (direction) {
            case "up" -> image = up1;
            case "down" -> image = down1;
            case "left" -> image = left1;
            case "right" -> image = right1;
        }

        g2.drawImage(image, x,y, gp.tileSize, gp.tileSize, null);

    }
}
