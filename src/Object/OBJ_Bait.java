package Object;


import Controls.GamePanel;
import Entity.Entity;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;


public class OBJ_Bait extends Entity {
    public OBJ_Bait(GamePanel gp) {
        super(gp);
        String name = "Bait";
        try (InputStream inputStream01 = new FileInputStream(new File("res/Objects/bait.png"))) {

            bait = ImageIO.read(inputStream01);

        } catch (IOException e) {
            e.printStackTrace();
        }
        baitingValue = 1;
    }
}
