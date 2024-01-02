package Controls;
import Entity.Crab_Monster;
import Entity.NPC_Merchant;
import Object.OBJ_Coconut;
public class AssetSetter {
    GamePanel gp;

    public AssetSetter(GamePanel gp){
        this.gp = gp;
    }
    public void setObject(){

        gp.obj[0] = new OBJ_Coconut(gp);
        gp.obj[0].worldX = 5 * gp.tileSize;
        gp.obj[0].worldY = 8 * gp.tileSize;

        gp.obj[1] = new OBJ_Coconut(gp);
        gp.obj[1].worldX = 14 * gp.tileSize;
        gp.obj[1].worldY = 12 * gp.tileSize;

        gp.obj[2] = new OBJ_Coconut(gp);
        gp.obj[2].worldX = 28 * gp.tileSize;
        gp.obj[2].worldY = 16 * gp.tileSize;


    }
    public void setNPC(){

        gp.npc[0] = new NPC_Merchant(gp);
        gp.npc[0].worldX = 5 * gp.tileSize;
        gp.npc[0].worldY = 23 * gp.tileSize;
    }
    public void setCrab(){

        gp.crab[0] = new Crab_Monster(gp);
        gp.crab[0].worldX = gp.tileSize * 9;
        gp.crab[0].worldY = gp.tileSize * 24;

        gp.crab[1] = new Crab_Monster(gp);
        gp.crab[1].worldX = gp.tileSize * 15;
        gp.crab[1].worldY = gp.tileSize * 25;

        gp.crab[2] = new Crab_Monster(gp);
        gp.crab[2].worldX = gp.tileSize * 10;
        gp.crab[2].worldY = gp.tileSize * 22;

    }
}