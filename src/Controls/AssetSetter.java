package Controls;
import Entity.NPC_Merchant;
import Object.OBJ_Table;
public class AssetSetter {
    GamePanel gp;

    public AssetSetter(GamePanel gp){
        this.gp = gp;
    }
    public void setObject(){
        int i = 0;

        gp.obj[0] = new OBJ_Table(gp);
        gp.obj[0].worldX = 10 * gp.tileSize;
        gp.obj[0].worldY = 5 * gp.tileSize;

    }
    public void setNPC(){
        int i = 0;

        gp.npc[0] = new NPC_Merchant(gp);
        gp.npc[0].worldX = 13 * gp.tileSize;
        gp.npc[0].worldY = 4 * gp.tileSize;
    }
}