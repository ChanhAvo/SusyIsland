package Object;

import Controls.GamePanel;
import Entity.Entity;
public class OBJ_Halibut extends Entity {
    GamePanel gp;
    public OBJ_Halibut(GamePanel gp ){
        super(gp);
        this.gp = gp;
        type = type_halibut;
        name = "Halibut";
        down1 = setup("/Items/HalibutNormal",gp.tileSize, gp.tileSize);
        price = 100;

    }
}
