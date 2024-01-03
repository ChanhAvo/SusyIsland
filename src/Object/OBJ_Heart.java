package Object;

import Controls.GamePanel;
import Entity.Entity;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;

public class OBJ_Heart extends Entity {

    GamePanel gp;
    public OBJ_Heart(GamePanel gp) {

        super(gp);
        name = "Heart";
        down1 = setup("/Objects/heart_full");
        down2 = setup("/Objects/heart_half_full");
        down3 = setup("/Objects/die");
    }

}
