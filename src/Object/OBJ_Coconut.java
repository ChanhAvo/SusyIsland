package Object;
import Controls.GamePanel;
import Entity.Entity;
public class OBJ_Coconut extends Entity {

    GamePanel gp;
    int value = 5;

    public OBJ_Coconut(GamePanel gp) {
        super(gp);
        this.gp = gp;
        name = "Coconut";
        down1 = setup("/Objects/coconut");
        description = "[" + name + "]\n a fresh coconut";
        collision = true;
        price = 100;
    }
}
