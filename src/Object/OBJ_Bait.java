package Object;


import Controls.GamePanel;
import Entity.Entity;


public class OBJ_Bait extends Entity {


    public OBJ_Bait(GamePanel gp) {
        super(gp);
        type = type_bait;
        name = "Bait";
        down1 = setup("/Objects/bait",gp.tileSize, gp.tileSize);
        fishingValue = 1;
        description = "[" + name + "]\n a yummy bait for susy fish";
        price = 20;
    }
}