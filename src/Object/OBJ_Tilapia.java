package Object;

import Controls.GamePanel;
import Entity.Entity;
public class OBJ_Tilapia extends Entity {
    GamePanel gp;
    public OBJ_Tilapia(GamePanel gp ){
        super(gp);
        this.gp = gp;
        type = type_tilapia;
        name = "Tilapia";
        down1 = setup("/Items/TilapiaNormal",gp.tileSize, gp.tileSize);
        price = 100;

    }
}
