package Object;

import Controls.GamePanel;
import Entity.Entity;

public class OBJ_Table extends Entity{
    public OBJ_Table(GamePanel gp) {
        super(gp);
        name = "Table";
        down1 = setup("/Objects/table");
        collision = true;
    }
}
