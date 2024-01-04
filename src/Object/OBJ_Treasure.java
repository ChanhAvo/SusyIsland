package Object;

import Controls.GamePanel;
import Entity.Entity;
public class OBJ_Treasure extends Entity {
    GamePanel gp;
    public OBJ_Treasure(GamePanel gp ){
        super(gp);
        this.gp = gp;
        type = type_sardine;
        name = "Treasure";
        down1 = setup("/Objects/treasure",gp.tileSize, gp.tileSize);
        //description = "[" + name + "]\nAn empty box.\nYou already get the rod";
        //price = 0;
        collision = true;
    }
}
