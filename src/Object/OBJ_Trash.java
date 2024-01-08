package Object;

import Controls.GamePanel;
import Entity.Entity;
public class OBJ_Trash extends Entity {
    GamePanel gp;
    public OBJ_Trash(GamePanel gp ){
        super(gp);
        this.gp = gp;
        type = type_trash;
        name = "Trash";
        down1 = setup("/Objects/trash",gp.tileSize, gp.tileSize);
        description = "[" + name + "]\nUrgh that smell.\nWhy trash in here?";
        price = 0;
    }
}
