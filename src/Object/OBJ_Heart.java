package Object;

import Controls.GamePanel;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;

public class OBJ_Heart extends SuperObject {

    GamePanel gp;
    public OBJ_Heart(GamePanel gp) {

        this.gp = gp;

        name = "Heart";
        try (InputStream fileHeartFull = new FileInputStream("res/Objects/full heart.png");
             InputStream fileHeartHalf = new FileInputStream("res/Objects/half.png");
             InputStream fileHeartBlank = new FileInputStream("res/Objects/die.png")) {
            image = ImageIO.read(fileHeartFull);
            image2 = ImageIO.read(fileHeartHalf);
            image3 = ImageIO.read(fileHeartBlank);
            image = uTool.scaleImage(image, gp.tileSize, gp.tileSize);
            image2 = uTool.scaleImage(image2, gp.tileSize, gp.tileSize);
            image3 = uTool.scaleImage(image3, gp.tileSize, gp.tileSize);

        } catch(IOException e) {
            e.printStackTrace();
        }
    }

}
