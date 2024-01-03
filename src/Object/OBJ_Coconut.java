package Object;

import Controls.GamePanel;
import Entity.Entity;

<<<<<<<<< Temporary merge branch 1
public class OBJ_Coconut extends Entity{
    GamePanel gp;
    int value = 5;
    public OBJ_Coconut(GamePanel gp) {
        super(gp);
        this.gp = gp;
        type = type_consumable;
//        boolean drink = true;
        name = "Coconut";
        down1 = setup("/Objects/coconut",gp.tileSize, gp.tileSize);
        description = "Fresh Coconut for healing ";
        collision = true;
    }
    public void use(Entity entity){
        gp.gameState = gp.dialogueState;
        gp.playSE(3);
        gp.ui.currentDialogue = "You drink the" + name + "!\n" +
                "Your life has been recovered by " + value + ".";
        entity.life += value;
           if(gp.player.life < gp.player.maxLife) {
           gp.player.life = gp.player.maxLife;
        }

=========
    GamePanel gp;
    int value = 5;

    public OBJ_Coconut(GamePanel gp) {
        super(gp);
        this.gp = gp;
        name = "Coconut";
        down1 = setup("/Objects/coconut");
        description = "[" + name + "]\n a fresh coconut";
        collision = true;
        price = 100;
>>>>>>>>> Temporary merge branch 2
    }
}
