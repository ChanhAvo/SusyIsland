package Object;

import Controls.GamePanel;
import Entity.Entity;
public class OBJ_Flounder extends Entity {
    GamePanel gp;
    public OBJ_Flounder(GamePanel gp ){
        super(gp);
        this.gp = gp;
        type = type_flounder;
        name = "Flounder";
        down1 = setup("/Items/FlounderNormal",gp.tileSize, gp.tileSize);
        price = 100;

    }
}
