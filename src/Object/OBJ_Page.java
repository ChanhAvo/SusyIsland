package Object;

import Controls.GamePanel;
import Entity.Entity;
public class OBJ_Page extends Entity {
    GamePanel gp;
    public OBJ_Page(GamePanel gp ){
        super(gp);
        this.gp = gp;
        type = type_page;
        name = "Page";
        down1 = setup("/Objects/page",gp.tileSize, gp.tileSize);
        description = "[" + name + "]\nThat looks like an old page from a book...";
        price = 0;
    }
}
