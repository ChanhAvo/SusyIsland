package Object;

import Controls.GamePanel;
import Entity.Entity;

public class OBJ_Shop extends Entity {

    public OBJ_Shop(GamePanel gp){
        super(gp);
        name = "Shop";
        down1 = setup("/Items/table");
        collision = true;
    }
}
