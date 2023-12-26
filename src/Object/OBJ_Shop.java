package Object;

import javax.imageio.ImageIO;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import Controls.GamePanel;
import Entity.Entity;

public class OBJ_Shop extends Entity  {
    public OBJ_Shop(GamePanel gp){
        super(gp);
        name = "Shop";
        down1 = setup("/Objects/table");
        collision = true;
    }
}
