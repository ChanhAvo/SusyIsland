package Object;


import Controls.GamePanel;
import Entity.Entity;


public class OBJ_Bait extends Entity {


    public OBJ_Bait(GamePanel gp) {
        super(gp);
        name = "Rod";
        down1 = setup("/Objects/bait");
        fishingValue = 1;
        description = "[" + name + "]\n a yummy bait for susy fish";
    }
}