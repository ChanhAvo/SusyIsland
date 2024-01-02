package Object;

import Controls.GamePanel;
import Entity.Entity;


public class OBJ_Heart extends Entity{

    public OBJ_Heart(GamePanel gp) {

        super(gp);
        name = "Heart";
        down1 = setup("/Objects/full", gp.tileSize, gp.tileSize);
        down2 = setup("/Objects/half", gp.tileSize, gp.tileSize);
        down3 = setup("/Objects/die", gp.tileSize, gp.tileSize);
    }

}
