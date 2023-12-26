package Object;


import Controls.GamePanel;
import Entity.Entity;


import java.awt.image.BufferedImage;


public class OBJ_Rod extends Entity {


    public OBJ_Rod(GamePanel gp) {
        super(gp);
        name = "Rod";
        down1 = setup("/Objects/rod");
        fishingValue = 1;
    }
}