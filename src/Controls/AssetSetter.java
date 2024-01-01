package Controls;
import Entity.NPC_Merchant;
import Object.OBJ_Coconut;
public class AssetSetter {
    GamePanel gp;

    public AssetSetter(GamePanel gp){
        this.gp = gp;
    }
    public void setObject(){

        gp.obj[0] = new OBJ_Coconut(gp);
        gp.obj[0].worldX = 3 * gp.tileSize;
        gp.obj[0].worldY = 2 * gp.tileSize;

        gp.obj[1] = new OBJ_Coconut(gp);
        gp.obj[1].worldX = 9 * gp.tileSize;
        gp.obj[1].worldY = 8 * gp.tileSize;

        gp.obj[2] = new OBJ_Coconut(gp);
        gp.obj[2].worldX = 7 * gp.tileSize;
        gp.obj[2].worldY = 5 * gp.tileSize;


    }
    public void setNPC(){

        gp.npc[0] = new NPC_Merchant(gp);
        gp.npc[0].worldX = 13 * gp.tileSize;
        gp.npc[0].worldY = 4 * gp.tileSize;
    }
}