package Entity;

import Controls.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

public class NPC_Merchant extends Entity {

    public NPC_Merchant(GamePanel gp){
        super(gp);
        direction = "down";
        speed = 0;

        solidArea = new Rectangle();
        solidArea.x = 8;
        solidArea.y = 16;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        solidArea.width = 32;
        solidArea.height = 32;

        getNPCImage();
        setDialogue();
    }
    public void getNPCImage(){
        try (InputStream inputStream01 = new FileInputStream(new File("res/NPC/npc.png"));
             InputStream inputStream02 = new FileInputStream(new File("res/NPC/npc.png"));
             InputStream inputStream03 = new FileInputStream(new File("res/NPC/npc.png"));
             InputStream inputStream04 = new FileInputStream(new File("res/NPC/npc.png"));
             InputStream inputStream05 = new FileInputStream(new File("res/NPC/npc.png"));
             InputStream inputStream06 = new FileInputStream(new File("res/NPC/npc.png"));
             InputStream inputStream07 = new FileInputStream(new File("res/NPC/npc.png"));
             InputStream inputStream08 = new FileInputStream(new File("res/NPC/npc.png"))){

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
    public void setDialogue(){
        dialogues[0] = "Hello, welcome to my small shop!";
        dialogues[1] = "I have some good stuffs here.";
        dialogues[2] = "You have anything for me?";
    }
    public void speak(){

        if(dialogues[dialogueIndex] == null){
            dialogueIndex = 0;
        }
        gp.ui.currentDialogue = dialogues[dialogueIndex];
        dialogueIndex++;

    }
}