package Object;

import Controls.GamePanel;
import Entity.Entity;

public class OBJ_Coin_Bronze extends Entity {
    public OBJ_Coin_Bronze(GamePanel gp){
        super(gp);
        name = "Coin";
        down1 = setup("/Objects/coin");
    }
}
