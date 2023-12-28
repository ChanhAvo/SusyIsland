package Controls;

import Entity.Entity;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import Object.OBJ_Heart;
import Object.OBJ_Coin_Bronze;


public class UI {
    GamePanel gp;
    Graphics2D g2;
    Font customFont;
    BufferedImage coin;
    BufferedImage house;
    BufferedImage heart_full, heart_half, heart_blank;
    public String currentDialogue = "";
    public int commandNum = 0;
    public int playerSlotCol = 0;
    public int playerSlotRow = 0;
    public int npcSlotCol = 0;
    public int npcSlotRow = 0;
    int subState = 0;
    public Entity npc;

    public UI(GamePanel gp){
        this.gp = gp;
        customFont = new Font("VT323", Font.PLAIN,40);
        loadFont();
        getMenuImage();
        Entity bronzeCoin = new OBJ_Coin_Bronze(gp);
        coin = bronzeCoin.down1;

        //CREATE HUD OBJECT
        Entity heart = new OBJ_Heart(gp);
        heart_full = heart.down1;
        heart_half = heart.down2;
        heart_blank = heart.down3;
    }
    public void loadFont() {
        try (InputStream fontStream = getClass().getResourceAsStream("/Background/VT323-Regular.ttf")) {
            customFont = Font.createFont(Font.TRUETYPE_FONT, fontStream);
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }
    }
    public void getMenuImage(){
        try {
            InputStream image = new FileInputStream(new File("res/Background/MenuImage.png"));

            house = ImageIO.read(image);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void draw(Graphics2D g2 ){
        this.g2 = g2;
        g2.setFont(customFont);
        g2.setColor(Color.white);

        //TITLE STATE
        if(gp.gameState == gp.titleState){
            drawTitleScreen();
        }
        //PLAY STATE
        if (gp.gameState == gp.playState){
            drawPlayerLife();
        }
        //PAUSE STATE
        if(gp.gameState == gp.pauseState){
            drawPlayerLife();
            drawPauseScreen();
        }
        //DIALOGUE STATE
        if(gp.gameState == gp.dialogueState){
            drawPlayerLife();
            drawDialogueScreen();
        }
        // CHARACTER STATE
        if(gp.gameState == gp.characterState) {
            drawPlayerLife();
            drawCharacterScreen();

        }
        //INVENTORY
        if(gp.gameState == gp.inventoryState) {
            drawPlayerLife();
            drawInventory(gp.player,true);
        }
        //TRADE STATE
        if(gp.gameState == gp.tradeState) {
            drawPlayerLife();
            drawTradeScreen();
        }

    }
    public void drawPlayerLife() {

        gp.player.life = 7;

        int x = gp.tileSize / 2;
        int y = gp.tileSize / 2;
        int i = 0;

        //DRAW MAX LIFE
        while(i < gp.player.maxLife/2) {
            g2.drawImage(heart_blank, x, y, null);
            i++;
            x += gp.tileSize;
        }

        //RESET
        x = gp.tileSize / 2;
        y = gp.tileSize / 2;
        i = 0;

        //DRAW CURRENT LIFE
        while(i < gp.player.life) {
            g2.drawImage(heart_half, x, y, null);
            i++;
            if(i < gp.player.life) {
                g2.drawImage(heart_full, x, y, null);
            }
            i++;
            x += gp.tileSize;
        }
    }
    public void drawTitleScreen() {
        //TITLE IMAGE
        g2.drawImage(house,0,0, gp.screenWidth, gp.screenHeight, null);

//        g2.setColor(new Color(78, 166, 237));
//        g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);

        //TITLE NAME
        g2.setFont(customFont.deriveFont(Font.BOLD, 150f));
        String text = "SUSY FISHY";
        int x = getXforCenteredText(text);
        int y = gp.tileSize * 3;
        //SHADOW
        g2.setColor(Color.white);
        g2.drawString(text,x + 5,y + 5);
        //MAIN COLOR +
        g2.setColor(new Color(1, 30, 54));
        g2.drawString(text, x, y);
        //MENU
        g2.setFont(customFont.deriveFont(Font.BOLD, 90f));

        //NEW GAME OPTION
        text = "NEW GAME";
        x = getXforCenteredText(text);
        y += gp.tileSize * 7;
        g2.drawString(text,x,y);
        if(commandNum == 0){
            g2.drawString(">", x - gp.tileSize,y);
        }

        //EXIT OPTION
        text = "EXIT";
        x = getXforCenteredText(text);
        y += gp.tileSize * 1.5;
        g2.drawString(text,x,y);
        if(commandNum == 1){
            g2.drawString(">", x - gp.tileSize,y);
        }
    }
    public void drawPauseScreen () {

        g2.setColor(new Color(128, 128, 128, 200));
        g2.fillRect(0, 0, gp.getWidth(), gp.getHeight()); // Fill the entire screen

        g2.setColor(Color.white);
        g2.setFont(customFont.deriveFont(Font.PLAIN, 204f));
        String text = "PAUSED";
        int x = getXforCenteredText(text);
        int y = gp.screenHeight / 2;

        g2.drawString(text, x, y);
    }
    public void drawDialogueScreen () {
        //WINDOW
        int x = gp.tileSize * 2;
        int y = gp.tileSize / 2;
        int width = gp.screenWidth - (gp.tileSize * 4);
        int height = gp.tileSize * 3;
        drawSubWindow(x, y, width, height);

        g2.setFont(customFont.deriveFont(Font.PLAIN, 40f));
        x += gp.tileSize;
        y += gp.tileSize;

        //LINE BREAK
        for(String line : currentDialogue.split("\n")){
            g2.drawString(line, x, y);
            y += 40;
        }
    }
    //CHARACTER STATE
    public void drawCharacterScreen(){
        //CREAT A FRAME
        final int frameX = gp.tileSize*2;
        final int frameY = gp.tileSize;
        final int frameWidth = gp.tileSize*5;
        final int frameHeight = gp.tileSize*6;
        drawSubWindow(frameX, frameY, frameWidth,frameHeight);
        //TEXT
        g2.setColor(Color.white);
        g2.setFont(customFont.deriveFont(Font.PLAIN, 40f));
        int textX = frameX + 20;
        int textY  = frameY + gp.tileSize;
        final int lineHeight = 32;
        // NAME
        g2.drawString("Strength",textX,textY);
        textY += lineHeight;
        g2.drawString("Dexterity",textX,textY);
        textY += lineHeight;

        g2.drawString("EXP",textX,textY);
        textY += lineHeight;
        g2.drawString("Next Level",textX,textY);
        textY += lineHeight;
        g2.drawString("Coin",textX,textY);
        textY += lineHeight;
        g2.drawString("Rob",textX,textY);
        textY += lineHeight;
        g2.drawString("Bait",textX,textY);
        textY += lineHeight;

        // VALUE
        int tailX = (frameX + frameWidth) -30;
        // rest textY
        textY = frameY +gp.tileSize;
        String value;



        value = String.valueOf(gp.player.strength);
        textX = getXforAlignToRightText(value, tailX);
        g2.drawString(value,textX, textY);
        textY += lineHeight;

        value = String.valueOf(gp.player.dexterity);
        textX = getXforAlignToRightText(value, tailX);
        g2.drawString(value,textX, textY);
        textY += lineHeight;



        value = String.valueOf(gp.player.exp);
        textX = getXforAlignToRightText(value, tailX);
        g2.drawString(value,textX, textY);
        textY += lineHeight;

        value = String.valueOf(gp.player.nextLevelExp);
        textX = getXforAlignToRightText(value, tailX);
        g2.drawString(value,textX, textY);
        textY += lineHeight;

        value = String.valueOf(gp.player.coin);
        textX = getXforAlignToRightText(value, tailX);
        g2.drawString(value,textX, textY);
        textY += lineHeight;

        g2.drawImage(gp.player.currentRod.down1,tailX - gp.tileSize, textY,null);
        textY += gp.tileSize;

        g2.drawImage(gp.player.currentBait.down1,tailX - gp.tileSize, textY,null);

    }
    public void drawInventory(Entity entity, boolean cursor) {

        int frameX = 0 ;
        int frameY = 0;
        int frameWidth = 0;
        int frameHeight = 0;
        int slotCol = 0;
        int slotRow = 0;

        if (entity == gp.player) {
            frameX = gp.tileSize * 9;
            frameY= gp.tileSize;
            frameWidth = gp.tileSize * 6;
            frameHeight= gp.tileSize * 5;
            slotCol = playerSlotCol;
            slotRow = playerSlotRow;
        }else{
            frameX = gp.tileSize * 2;
            frameY= gp.tileSize;
            frameWidth = gp.tileSize * 6;
            frameHeight= gp.tileSize * 5;
            slotCol = npcSlotCol;
            slotRow = npcSlotRow;
        }
        //FRAME
        drawSubWindow(frameX, frameY, frameWidth,frameHeight);

        //Slots
        final int slotXstart = frameX + 20;
        final int slotYstart = frameY + 20;
        int slotX = slotXstart;
        int slotY = slotYstart;
        int slotSize = gp.tileSize +3;

        //Draw player's items
        for(int i = 0; i < entity.inventory.size(); i++) {
            g2.drawImage(entity.inventory.get(i).down1, slotX, slotY, null);
            slotX += slotSize;

            if(i == 4 || i == 9 || i == 14){
                slotX = slotXstart;
                slotY += slotSize;
            }
        }

        //Cursor
        if(cursor == true){
            int cursorX = slotXstart + (slotSize * slotCol);
            int cursorY = slotYstart + (slotSize * slotRow);
            int cursorWidth = gp.tileSize;
            int cursorHeight = gp.tileSize;
            //Draw cursor
            g2.setColor(Color.white);
            g2.drawRoundRect(cursorX, cursorY, cursorWidth,cursorHeight, 10,10);
            //DESCRIPTION FRAME
            int dFrameX = frameX;
            int dFrameY = frameY + frameHeight;
            int dFrameWidth = frameWidth;
            int dFrameHeight = gp.tileSize*3;

            //Draw description text
            int textX = dFrameX +20;
            int textY = dFrameY + gp.tileSize;
            g2.setFont(customFont.deriveFont(Font.PLAIN, 32f));
            int itemIndex = getItemIndexOnSlot(slotCol, slotRow);
            if(itemIndex < entity.inventory.size()) {
                drawSubWindow(dFrameX, dFrameY, dFrameWidth, dFrameHeight);
                for (String line : entity.inventory.get(itemIndex).description.split("\n")) {
                    g2.drawString(line, textX, textY);
                    textY += 32;
                }
            }
        }
    }
    public void drawTradeScreen(){
        switch(subState){
            case 0:
                trade_select();
                break;
            case 1:
                trade_buy();
                break;
            case 2:
                trade_sell();
                break;
        }
        gp.keyH.enterPressed = false;
    }
    public void trade_select(){
        drawDialogueScreen();

        //DRAW WINDOW
        int x = gp.tileSize * 11;
        int y = gp.tileSize * 4;
        int width = gp.tileSize * 3;
        int height = (int)(gp.tileSize * 3.5);
        drawSubWindow(x,y,width,height);

        //DRAW TEXTS
        x += gp.tileSize;
        y += gp.tileSize;
        g2.drawString("Buy",x,y);
        if(commandNum == 0){
            g2.drawString(">", x-24,y);
            if(gp.keyH.enterPressed == true){
                subState = 1;
            }
        }
        y += gp.tileSize;
        g2.drawString("Sell",x,y);
        if(commandNum == 1){
            g2.drawString(">", x-24,y);
            if(gp.keyH.enterPressed == true){
                subState = 2;
            }
        }
        y += gp.tileSize;
        g2.drawString("Leave",x,y);
        if(commandNum == 2){
            g2.drawString(">", x-24,y);
            if(gp.keyH.enterPressed == true){
                commandNum = 0;
                gp.gameState = gp.dialogueState;
                currentDialogue = "Come again next time!";
            }
        }
    }
    public void trade_buy(){
        //DRAW PLAYER INVENTORY
        drawInventory(gp.player,false);
        //DRAW NPC INVENTORY
        drawInventory(npc,true);
        //DRAW HINT WINDOW
        int x = gp.tileSize * 2;
        int y = gp.tileSize * 9;
        int width = gp.tileSize * 6;
        int height= gp.tileSize * 2;
        drawSubWindow(x,y,width,height);
        g2.drawString("[ESC] BACK " , x + 24, y + 60 );

        //DRAW COIN WINDOW
        x = gp.tileSize * 10;
        y = gp.tileSize * 9;
        width = gp.tileSize * 5;
        height= gp.tileSize * 2;
        drawSubWindow(x,y,width,height);
        g2.drawString("YOUR COIN:  " + gp.player.coin, x + 24, y + 60 );

        //DRAW PRICE WINDOW
        int itemIndex = getItemIndexOnSlot(npcSlotCol,npcSlotRow);
        if(itemIndex < npc.inventory.size()){
            x = (int)(gp.tileSize * 5.5);
            y = (int)(gp.tileSize * 5.5);
            width = (int)(gp.tileSize * 2.5);
            height= gp.tileSize;
            drawSubWindow(x,y,width,height);
            g2.drawImage(coin,x + 10, y + 15,32,32,null);

            int price = npc.inventory.get(itemIndex).price;
            String text = "" + price;
            x = getXforAlignToRightText(text,gp.tileSize * 8 - 20);
            g2.drawString(text,x,y + 40);

            //BUY ITEM
            if(gp.keyH.enterPressed == true){
                if(npc.inventory.get(itemIndex).price > gp.player.coin){
                    subState = 0;
                    gp.gameState = gp.dialogueState;
                    currentDialogue = "Not enough coin to purchase this item";
                    drawDialogueScreen();
                }
                else if(gp.player.inventory.size() == gp.player.maxInventorySize){
                    subState = 0;
                    gp.gameState = gp.dialogueState;
                    currentDialogue = "Not space to add this item";
                }
                else{
                    gp.player.coin -= npc.inventory.get(itemIndex).price;
                    gp.player.inventory.add(npc.inventory.get(itemIndex));

                }
            }
        }
    }
    public void trade_sell(){
        //DRAW PLAYER INVENTORY
        drawInventory(gp.player, true);

        int x;
        int y;
        int width;
        int height;
        //DRAW HINT WINDOW
        x = gp.tileSize * 2;
        y = gp.tileSize * 9;
        width = gp.tileSize * 6;
        height= gp.tileSize * 2;
        drawSubWindow(x,y,width,height);
        g2.drawString("[ESC] BACK " , x + 24, y + 60 );

        //DRAW COIN WINDOW
        x = gp.tileSize * 10;
        y = gp.tileSize * 9;
        width = gp.tileSize * 5;
        height= gp.tileSize * 2;
        drawSubWindow(x,y,width,height);
        g2.drawString("YOUR COIN:  " + gp.player.coin, x + 24, y + 60 );

        //DRAW PRICE WINDOW
        int itemIndex = getItemIndexOnSlot(playerSlotCol,playerSlotRow);
        if(itemIndex < gp.player.inventory.size()){
            x = (int)(gp.tileSize * 12.5);
            y = (int)(gp.tileSize * 5.5);
            width = (int)(gp.tileSize * 2.5);
            height= gp.tileSize;
            drawSubWindow(x,y,width,height);
            g2.drawImage(coin,x + 10, y + 15,32,32,null);

            int price = gp.player.inventory.get(itemIndex).price / 2;
            String text1 = "" + price;
            x = getXforAlignToRightText(text1,gp.tileSize * 15 - 30 + 10);
            g2.drawString(text1,x,y + 40);

            //SELL ITEM
            if(gp.keyH.enterPressed){
                gp.player.inventory.remove(itemIndex);
                gp.player.coin += price;
            }
        }
    }
    public int getItemIndexOnSlot(int slotCol, int slotRow){
        int itemIndex = slotCol + (slotRow*5);
        return itemIndex;
    }

    public void drawSubWindow ( int x, int y, int width, int height){
        Color c = new Color(0, 0, 0, 200);
        g2.setColor(c);
        g2.setStroke(new BasicStroke(3));
        g2.fillRoundRect(x, y, width, height, 35, 35);

        c = new Color(255, 255, 255);
        g2.setColor(c);
        g2.setStroke(new BasicStroke(5));
        g2.drawRoundRect(x + 5, y + 5, width - 10, height - 10, 25, 25);

    }

    public int getXforCenteredText (String text){
        int length = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        int x = gp.screenWidth / 2 - length / 2;
        return x;
    }
    public int getXforAlignToRightText (String text, int tailX){
        int length = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        int x = tailX - length;
        return x;
    }
}