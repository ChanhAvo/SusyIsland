package Object;
import Controls.GamePanel;
import Entity.Entity;
public class OBJ_Coconut extends Entity {

    public OBJ_Coconut(GamePanel gp) {
        super(gp);
        name = "Coconut";
        down1 = setup("/Objects/coconut");
        description = "[" + name + "]\n a fresh coconut";
        collision = true;
    }

}
