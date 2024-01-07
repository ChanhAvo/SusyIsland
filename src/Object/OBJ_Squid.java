package Object;

import Controls.GamePanel;
import Entity.Entity;
public class OBJ_Squid extends Entity {
    GamePanel gp;
    public OBJ_Squid(GamePanel gp ){
        super(gp);
        this.gp = gp;
        type = type_squid;
        name = "Squid";
        down1 = setup("/Items/Squidvip",gp.tileSize, gp.tileSize);
        price = 200;
    }
}
