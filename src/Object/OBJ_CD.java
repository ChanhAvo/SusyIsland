package Object;

import Controls.GamePanel;
import Entity.Entity;
public class OBJ_CD extends Entity {
    GamePanel gp;
    public OBJ_CD(GamePanel gp ){
        super(gp);
        this.gp = gp;
        type = type_CD;
        name = "A broken CD";
        down1 = setup("/Objects/broken_CD",gp.tileSize, gp.tileSize);
        description = "[" + name + "]\nThis broken CD seems\nnon-reusable";
        price = 0;
    }
}
