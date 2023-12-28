package Object;

import Controls.GamePanel;
import Entity.Entity;


public class OBJ_Heart extends Entity{

    public OBJ_Heart(GamePanel gp) {

        super(gp);
        name = "Heart";
        down1 = setup("/Objects/full");
        down2 = setup("/Objects/half");
        down3 = setup("/Objects/die");
    }

}
