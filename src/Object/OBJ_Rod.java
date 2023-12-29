package Object;


import Controls.GamePanel;
import Entity.Entity;


public class OBJ_Rod extends Entity {


    public OBJ_Rod(GamePanel gp) {
        super(gp);
        name = "Rod";
        down1 = setup("/Objects/rod");
        fishingValue = 1;
        description = "[" + name + "]\n a normal rod";
        price = 150;
    }
 }