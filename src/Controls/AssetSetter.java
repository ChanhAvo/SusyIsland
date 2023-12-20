package Controls;
import Object.OBJ_Shop;
public class AssetSetter {
    GamePanel gp;

    public AssetSetter(GamePanel gp){
        this.gp = gp;
    }
    public void setObject(){
        gp.obj[0] = new OBJ_Shop();
        gp.obj[0].worldX = 13 * gp.tileSize;
        gp.obj[0].worldY = 5 * gp.tileSize;
    }
}
