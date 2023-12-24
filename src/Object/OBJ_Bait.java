package Object;


import Controls.GamePanel;
import Entity.Entity;


import java.awt.image.BufferedImage;


public class OBJ_Bait extends Entity {
    public OBJ_Bait(GamePanel gp) {
        super(gp);
        String name = "Bait";
        down1 = setup("/Objects/bait.png", gp.tileSize, gp.tileSize);
        baitingValue = 1;
    }
    public BufferedImage setup(String path, int tileSize, int tileSize1) {
        return null;
    }
}
