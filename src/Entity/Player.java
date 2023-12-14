package Entity;

import Controls.GamePanel;
import Controls.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

import java.awt.*;
import java.io.IOException;
import java.util.Objects;

public class Player extends Entity {

    GamePanel gp;
    KeyHandler keyH;

    public Player(GamePanel gp, KeyHandler keyH){
        this.gp = gp;
        this.keyH = keyH;

        setDefaultValues();
    }
    public void setDefaultValues(){
        x = 100;
        y = 100;
        speed = 4;
        direction = "down";
    }
    public void getPlayerImage(){
        try{
            up1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Player/up1.png")));
            up2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Player/up2.png")));
            down1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Player/down1.png")));
            down2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Player/down2.png")));
            left1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Player/left1.png")));
            left2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Player/left2.png")));
            right1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Player/right1.png")));
            right2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Player/right2.png")));
            stand1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Player/stand1.png")));
            stand2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Player/stand2.png")));
            stand3 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Player/stand3.png")));
            stand4 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Player/stand4.png")));

        }
        catch(IOException e){
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

        switch(direction){
            case "up":
                image = up1;
                break;
            case "down":
                image = down1;
                break;
            case "left":
                image = left1;
                break;
            case "right":
                image = right1;
                break;
            case "stand":
                image = stand1;
                break;
        }

        g2.drawImage(image, x,y, gp.tileSize, gp.tileSize, null);


    }
}
