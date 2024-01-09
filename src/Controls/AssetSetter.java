package Controls;
import Entity.Crab_Monster;
import Entity.NPC_Merchant;
import Object.*;
public class AssetSetter {
    GamePanel gp;

    public AssetSetter(GamePanel gp){
        this.gp = gp;
    }
    public void setObject(){

        gp.obj[0] = new OBJ_Coconut(gp);
        gp.obj[0].worldX = 17 * gp.tileSize;
        gp.obj[0].worldY = 34 * gp.tileSize;

        gp.obj[1] = new OBJ_Coconut(gp);
        gp.obj[1].worldX = 20 * gp.tileSize;
        gp.obj[1].worldY = 27 * gp.tileSize;

        gp.obj[2] = new OBJ_Coconut(gp);
        gp.obj[2].worldX = 11 * gp.tileSize;
        gp.obj[2].worldY = 28 * gp.tileSize;

        gp.obj[3] = new OBJ_Coconut(gp);
        gp.obj[3].worldX = 25 * gp.tileSize;
        gp.obj[3].worldY = 30 * gp.tileSize;

        gp.obj[4] = new OBJ_Coconut(gp);
        gp.obj[4].worldX = 37 * gp.tileSize;
        gp.obj[4].worldY = 25 * gp.tileSize;

        gp.obj[5] = new OBJ_Coconut(gp);
        gp.obj[5].worldX = 3 * gp.tileSize;
        gp.obj[5].worldY = 33 * gp.tileSize;

    }
    public void setNPC(){

        gp.npc[0] = new NPC_Merchant(gp);
        gp.npc[0].worldX = 5 * gp.tileSize;
        gp.npc[0].worldY = 23 * gp.tileSize;
    }
    public void setCrab(){

        gp.crab[0] = new Crab_Monster(gp);
        gp.crab[0].worldX = gp.tileSize *11;
        gp.crab[0].worldY = gp.tileSize * 2;

        gp.crab[1] = new Crab_Monster(gp);
        gp.crab[1].worldX = gp.tileSize * 37;
        gp.crab[1].worldY = gp.tileSize * 11;

        gp.crab[2] = new Crab_Monster(gp);
        gp.crab[2].worldX = gp.tileSize * 15;
        gp.crab[2].worldY = gp.tileSize * 8;

        gp.crab[3] = new Crab_Monster(gp);
        gp.crab[3].worldX = gp.tileSize * 15;
        gp.crab[3].worldY = gp.tileSize * 13;

        gp.crab[4] = new Crab_Monster(gp);
        gp.crab[4].worldX = gp.tileSize * 8;
        gp.crab[4].worldY = gp.tileSize * 14;

        gp.crab[5] = new Crab_Monster(gp);
        gp.crab[5].worldX = gp.tileSize * 21;
        gp.crab[5].worldY = gp.tileSize * 12;

        gp.crab[6] = new Crab_Monster(gp);
        gp.crab[6].worldX = gp.tileSize * 34;
        gp.crab[6].worldY = gp.tileSize * 15;

        gp.crab[7] = new Crab_Monster(gp);
        gp.crab[7].worldX = gp.tileSize * 38;
        gp.crab[7].worldY = gp.tileSize * 2;

        gp.crab[8] = new Crab_Monster(gp);
        gp.crab[8].worldX = gp.tileSize * 19;
        gp.crab[8].worldY = gp.tileSize * 1;


    }
    public void setTreasure(){
        gp.tre[0] = new OBJ_Treasure(gp);
        gp.tre[0].worldX = 30 * gp.tileSize;
        gp.tre[0].worldY = 22 * gp.tileSize;
    }
}