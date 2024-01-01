package Object;

import Controls.GamePanel;
import Entity.Entity;

public class OBJ_Coconut extends Entity{
    GamePanel gp;
    int value = 5;
    public OBJ_Coconut(GamePanel gp) {
        super(gp);
        type = type_consumable;
        name = "Coconut";
        down1 = setup("/Objects/coconut");
        description = "Fresh Coconut for healing ";

    }
    public void use(Entity entity){
        gp.gameState = gp.dialogueState;
        gp.ui.currentDialogue = "You drink the" + name + "!\n" +
                "Your life has been recovered by " + value + ".";
    }
}
