package Controls;

import Entity.Entity;


import java.awt.*;

public class EventHandler {
    GamePanel gp;
    Rectangle eventRect;
    int eventRectDefaultX, eventRectDefaultY;
//    int previousEventX, previousEventY;
//    boolean canTouchEvent = true;

    public EventHandler(GamePanel gp){
        this.gp = gp;

        eventRect = new Rectangle();
        eventRect.x = 64;
        eventRect.y = 64;
        eventRect.width = 32;
        eventRect.height = 32;
        eventRectDefaultX = eventRect.x;
        eventRectDefaultY = eventRect.y;


    }
    public void checkEvent(){
        if(hit(4,24,"up") == true ){
            System.out.println("hit shop");
            speak(gp.npc[0]);
        }

        if(hit(10,1,"up") == true) {
            damagePit(gp.dialogueState);
        }
    }

    public boolean hit (int eventCol, int eventRow, String reqDirection){
        boolean hit = false;
        //Getting player's current solidArea positions
        gp.player.solidArea.x = gp.player.worldX + gp.player.solidArea.x;
        gp.player.solidArea.y = gp.player.worldY + gp.player.solidArea.y;
        //Getting eventRect's solidArea positions
        eventRect.x = eventCol * gp.tileSize + eventRect.x;
        eventRect.y = eventRow * gp.tileSize + eventRect.y;

        if(gp.player.solidArea.intersects(eventRect)){
            if(gp.player.direction.contentEquals(reqDirection) || reqDirection.contentEquals("any")){
                hit = true;
            }
        }
        //Reset
        gp.player.solidArea.x = gp.player.solidAreaDefaultX;
        gp.player.solidArea.y = gp.player.solidAreaDefaultY;
        eventRect.x = eventRectDefaultX;
        eventRect.y = eventRectDefaultY;

        return hit;
    }
    public void speak(Entity entity){
        if(gp.keyH.enterPressed){
            gp.gameState = gp.dialogueState;
            entity.speak();
        }
    }

    public void damagePit(int gameState) {
        gp.gameState = gameState;
        gp.ui.currentDialogue = "You fall into a pit";
        gp.player.life -= 1;
    }
}

