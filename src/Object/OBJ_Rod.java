package Object;


import Controls.GamePanel;
import Entity.Entity;


import java.awt.image.BufferedImage;


public class OBJ_Rod extends Entity {


    public OBJ_Rod(GamePanel gp) {
        super(gp);
        String name = "Rod";
        down1 = setup("/Objects/rod.png", gp.tileSize, gp.tileSize);
        fishingValue = 1;
    }

    public BufferedImage setup(String path, int tileSize, int tileSize1) {
        return null;
    }
}