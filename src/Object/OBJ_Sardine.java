package Object;

import Controls.GamePanel;
import Entity.Entity;
public class OBJ_Sardine extends Entity {
    GamePanel gp;
    public OBJ_Sardine(GamePanel gp ){
        super(gp);
        this.gp = gp;
        type = type_sardine;
        name = "Sardine";
        down1 = setup("/Items/SardineNormal",gp.tileSize, gp.tileSize);
        price = 100;
    }
}
