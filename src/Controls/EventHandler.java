package Controls;

import Entity.Entity;


import java.awt.*;

public class EventHandler {
    GamePanel gp;
    EventRect eventRect[][];
    int previousEventX, previousEventY;
    boolean canTouchEvent = true;


    public EventHandler(GamePanel gp){
        this.gp = gp;

        eventRect = new EventRect[gp.maxWorldCol][gp.maxWorldRow];

        int col = 0;
        int row = 0;
        while(col < gp.maxWorldCol && row < gp.maxWorldRow){

            eventRect[col][row] = new EventRect();
            eventRect[col][row].x = 64;
            eventRect[col][row].y = 64;
            eventRect[col][row].width = 32;
            eventRect[col][row].height = 32;
            eventRect[col][row].eventRectDefaultX = eventRect[col][row].x;
            eventRect[col][row].eventRectDefaultY = eventRect[col][row].y;

            col++;
            if(col == gp.maxWorldCol){
                col = 0;
                row++;
            }
        }
    }
    public void checkEvent(){
        int xDistance = Math.abs(gp.player.worldX - previousEventX);
        int yDistance = Math.abs(gp.player.worldY - previousEventY);
        int distance = Math.max(xDistance, yDistance);
        if(distance > gp.tileSize){
            canTouchEvent = true;
        }

        if (canTouchEvent == true){
            if(hit(4,24,"up") == true){
                gp.player.isFishing = false;
                speak(gp.npc[0]);
            }
            for (int column = 1; column < 40; column++) {
                if (hit(column, 35, "down") == true) {
                    fishingEvent(gp.player);
                }
            }
            if(hit(0,0,"right") == true){
                System.out.println("hit");
                welcomeMessage(0,0,gp.dialogueState);
            }
        }
    }

    public boolean hit (int col, int row, String reqDirection){
        boolean hit = false;
        gp.player.solidArea.x = gp.player.worldX + gp.player.solidArea.x;
        gp.player.solidArea.y = gp.player.worldY + gp.player.solidArea.y;
        eventRect[col][row].x = col * gp.tileSize + eventRect[col][row].x;
        eventRect[col][row].y = row * gp.tileSize + eventRect[col][row].y;

        if(gp.player.solidArea.intersects(eventRect[col][row]) && eventRect[col][row].eventDone == false){
            if(gp.player.direction.contentEquals(reqDirection) || reqDirection.contentEquals("any")){
                hit = true;

                previousEventX = gp.player.worldX;
                previousEventY = gp.player.worldY;


            }
        }
        gp.player.solidArea.x = gp.player.solidAreaDefaultX;
        gp.player.solidArea.y = gp.player.solidAreaDefaultY;
        eventRect[col][row].x = eventRect[col][row].eventRectDefaultX;
        eventRect[col][row].y = eventRect[col][row].eventRectDefaultY;

        return hit;
    }
    public void speak(Entity entity){
        if(gp.keyH.enterPressed){
            gp.gameState = gp.dialogueState;
            entity.speak();
        }
    }
    public void fishingEvent(Entity entity){
        if(gp.keyH.enterPressed){
            gp.gameState = gp.fishingState;
            entity.fishingEvent(gp.player);
        }
    }
    public void welcomeMessage(int col, int row, int gameState){
        gp.ui.currentDialogue = "Oh, this is the Susy Island.\nLet's find something interesting here.";
        gp.gameState = gp.dialogueState;
        eventRect[col][row].eventDone = true;

    }

}
