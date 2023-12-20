package Object;

import javax.imageio.ImageIO;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class OBJ_Shop extends SuperObject {

    public OBJ_Shop(){
        name = "Shop";
        try
            (InputStream fileShop = new FileInputStream("res/Items/table.png")){

            image = ImageIO.read(fileShop);

        }catch (IOException e){
            e.printStackTrace();
        }
        collision = true;
    }


}
