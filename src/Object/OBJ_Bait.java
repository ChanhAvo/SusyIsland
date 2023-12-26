package Object;


import Controls.GamePanel;
import Entity.Entity;


import java.awt.image.BufferedImage;


public class OBJ_Bait extends Entity {
    public OBJ_Bait(GamePanel gp) {
        super(gp);
        name = "Bait";
        down1 = setup("/Objects/bait");
        baitingValue = 1;
    }

}
