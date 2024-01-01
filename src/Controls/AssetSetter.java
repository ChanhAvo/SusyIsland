package Controls;
import Object.OBJ_Coconut;
import Entity.NPC_Merchant;
public class AssetSetter {
    GamePanel gp;

    public AssetSetter(GamePanel gp){
        this.gp = gp;
    }
    public void setObject(){
        int i = 0;
        gp.obj[i] = new OBJ_Coconut(gp);
        gp.obj[i].worldX = 9 * gp.tileSize;
        gp.obj[i].worldY = 5 * gp.tileSize;
        i++;
        gp.obj[i] = new OBJ_Coconut(gp);
        gp.obj[i].worldX = 10 * gp.tileSize;
        gp.obj[i].worldY = 6 * gp.tileSize;
        i++;
        gp.obj[i] = new OBJ_Coconut(gp);
        gp.obj[i].worldX = 14 * gp.tileSize;
        gp.obj[i].worldY = 8 * gp.tileSize;

    }

    public void setNPC(){

        gp.npc[0] = new NPC_Merchant(gp);
        gp.npc[0].worldX = 13 * gp.tileSize;
        gp.npc[0].worldY = 4 * gp.tileSize;
    }
}