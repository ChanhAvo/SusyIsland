package Entity;

import Controls.GamePanel;

import java.util.Random;

public class Crab_Monster extends Entity {
    public Crab_Monster(GamePanel gp){
        super(gp);
        type = type_Crab;
        name = "Crab Monster";
        speed = 1;
        maxLife = 4;
        life = maxLife;

        solidArea.x = 8;
        solidArea.y = 16;
        solidArea.width = 30;
        solidArea.height = 30;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        getImage();
        setAction();
    }
    public void getImage() {
//        try (InputStream inputStream01 = new FileInputStream(new File("res/Crab/crab1.png"));
//             InputStream inputStream02 = new FileInputStream(new File("res/Crab/crab2.png"));
//             InputStream inputStream03 = new FileInputStream(new File("res/Crab/crab1.png"));
//             InputStream inputStream04 = new FileInputStream(new File("res/Crab/crab2.png"));
//             InputStream inputStream05 = new FileInputStream(new File("res/Crab/crab1.png"));
//             InputStream inputStream06 = new FileInputStream(new File("res/Crab/crab2.png"));
//             InputStream inputStream07 = new FileInputStream(new File("res/Crab/crab1.png"));
//             InputStream inputStream08 = new FileInputStream(new File("res/Crab/crab2.png"))){
//
//            left1 = ImageIO.read(inputStream01);
//            left2 = ImageIO.read(inputStream02);
//            right1 = ImageIO.read(inputStream03);
//            right2 = ImageIO.read(inputStream04);
//            down1 = ImageIO.read(inputStream05);
//            down2 = ImageIO.read(inputStream06);
//            up1 = ImageIO.read(inputStream07);
//            up2 = ImageIO.read(inputStream08);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
        left1 = setup("Crab/crab1");
        left2 = setup("Crab/crab2");
        right1 = setup("Crab/crab1");
        right2 = setup("Crab/crab2");
        down1 = setup("Crab/crab1");
        down2 = setup("Crab/crab2");
        up1 = setup("Crab/crab1");
        up2 = setup("Crab/crab2");

    }
    public void setAction() {

        actionLockCounter ++;
        if(actionLockCounter == 120){
            Random random  = new Random();
            int i = random.nextInt(101)+1; //pick up a number from 1 to 99
            if(i <= 25){
                direction = "up";
            }
            if(i > 25 && i <= 50) {
                direction = "down";
            }
            if(i > 50 && i <= 75) {
                direction = "left";
            }
            if(i > 75 && i <= 100) {
                direction = "right";
            }
            actionLockCounter = 0;
        }
    }
}
