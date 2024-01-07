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

            //Hit damage pit
//            if(hit(22,0,"right") == true)   {
//                damagePit(22,0,gp.dialogueState);
//            }
//            if(hit(22,0,"up") == true) {
//                damagePit(22,0,gp.dialogueState);
//            }
            if(hit(30,2,"down") == true) {
                damagePit(30,2,gp.dialogueState);
            }
            if(hit(2,16,"left") == true) {
                damagePit(2,16,gp.dialogueState);
            }
            if(hit(13,6,"left") == true) {
                damagePit(13,6,gp.dialogueState);
            }
            if(hit(30,18,"down") == true) {
                damagePit(30,18,gp.dialogueState);
            }
            if(hit(17,25,"left") == true) {
                damagePit(17,25,gp.dialogueState);
            }
            if(hit(28,28,"down") == true) {
                damagePit(28,28,gp.dialogueState);
            }
            if(hit(15,32,"left") == true) {
                damagePit(17,25,gp.dialogueState);
            }
            if(hit(30,34,"down") == true) {
                damagePit(30,34,gp.dialogueState);
            }
            if(hit(11,33,"down") == true) {
                damagePit(11,33,gp.dialogueState);
            }

            //Hit healing pool
            if(hit(27,7,"right") == true){
                System.out.println("hit pool");
                healingPool(27,5,gp.dialogueState);
            }
            if(hit(27,5,"right") == true){
                System.out.println("hit pool");
                healingPool(27,5,gp.dialogueState);
            }
            if(hit(30,4,"down") == true){
                System.out.println("hit pool");
                healingPool(30,4,gp.dialogueState);
            }
            if(hit(31,4,"down") == true){
                System.out.println("hit pool");
                healingPool(30,4,gp.dialogueState);
            }
            if(hit(32,4,"down") == true){
                System.out.println("hit pool");
                healingPool(30,4,gp.dialogueState);
            }
            if(hit(33,4,"down") == true){
                System.out.println("hit pool");
                healingPool(30,4,gp.dialogueState);
            }
            if(hit(34,4,"down") == true){
                System.out.println("hit pool");
                healingPool(30,4,gp.dialogueState);
            }
        }

    }

    public boolean hit (int col, int row, String reqDirection){
        boolean hit = false;
        //Getting player's current solidArea positions
        gp.player.solidArea.x = gp.player.worldX + gp.player.solidArea.x;
        gp.player.solidArea.y = gp.player.worldY + gp.player.solidArea.y;
        eventRect[col][row].x = col * gp.tileSize + eventRect[col][row].x;
        eventRect[col][row].y = row * gp.tileSize + eventRect[col][row].y;

        if(gp.player.solidArea.intersects(eventRect[col][row]) && !eventRect[col][row].eventDone){
            if(gp.player.direction.contentEquals(reqDirection) || reqDirection.contentEquals("any")){
                hit = true;
                previousEventX = gp.player.worldX;
                previousEventY = gp.player.worldY;
            }
        }
        //Reset
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

    public void damagePit(int col, int row, int gameState) {
        gp.gameState = gameState;
        gp.ui.currentDialogue = "You fall into a pit!!!";
        gp.player.life -= 1;
        eventRect[col][row].eventDone = true;
    }

    public void healingPool(int col, int row, int gameState) {
        if(gp.keyH.enterPressed == true){
            gp.player.isFishing = false;
            gp.gameState = gameState;
            gp.ui.currentDialogue = "You drink the water.\nYour life has been recovered.";
            gp.player.life = gp.player.maxLife;
        }
    }
}

