package Controls;


import java.awt.*;
import java.io.IOException;
import java.io.InputStream;


public class UI {
    GamePanel gp;
    Graphics2D g2;
    Font customFont;
    public UI(GamePanel gp){
        this.gp = gp;
        loadFont();
    }
    private void loadFont() {
        try (InputStream fontStream = getClass().getResourceAsStream("/Background/VT323-Regular.ttf")) {
            customFont = Font.createFont(Font.TRUETYPE_FONT, fontStream);
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }
    }
    public void draw(Graphics2D g2 ){
        this.g2 = g2;

        if (gp.gameState == gp.playState){

        }
        if(gp.gameState == gp.pauseState){
            drawPauseScreen();
        }
    }
    public void drawPauseScreen() {

        g2.setColor(new Color(128, 128, 128, 200)); // Grey color with alpha (transparency)
        g2.fillRect(0, 0, gp.getWidth(), gp.getHeight()); // Fill the entire screen

        g2.setColor(Color.white);
        g2.setFont(customFont.deriveFont(Font.PLAIN, 90f));
        String text = "PAUSED";
        int x = getXforCenteredText(text);
        int y = gp.screenHeight/2;

        g2.drawString(text, x, y);
    }
    public int getXforCenteredText(String text) {
        int length = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        int x = gp.screenWidth/2 - length/2;
        return x;
    }
    public void drawCharacterScreen() {
        // Create a frame
        final int frameX = gp.tileSize *2;
        final int frameY = gp.tileSize;
        final int frameWidth = gp.tileSize * 5;
        final int frameHeight = gp.tileSize * 10;
        drawSubWindow(frameX, frameY, frameWidth, frameHeight);
    }

    public void drawSubWindow(int x, int y, int width, int height) {
    //    Color c = new Color(0,0,0,210);
    //    g2.setColor(c);
    //    g2.fillRoundRect(x,y,width,height, 35,35);
    //    c = new Color(255,255,255);
    //    g2.setColor(c);
    //    g2.setStroke(new BasicStroke(5));
    //    g2.drawRoundRect(x+5,y+5, width -10, height -10, 25,25);

    }
}