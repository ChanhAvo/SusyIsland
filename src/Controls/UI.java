package Controls;


import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;


public class UI {
    GamePanel gp;
    Graphics2D g2;
    Font customFont;
    BufferedImage house;
    public String currentDialogue = "";
    public int commandNum = 0;
    public UI(GamePanel gp){
        this.gp = gp;
        loadFont();
        getMenuImage();
    }
    private void loadFont() {
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

        //TITLE STATE
        if(gp.gameState == gp.titleState){
            drawTitleScreen();
        }
        //PLAY STATE
        if (gp.gameState == gp.playState){

        }
        //PAUSE STATE
        if(gp.gameState == gp.pauseState){
            drawPauseScreen();
        }
        //DIALOGUE STATE
        if(gp.gameState == gp.dialogueState){
            drawDialogueScreen();
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
        g2.drawString(currentDialogue, x, y);
    }
    public void drawSubWindow ( int x, int y, int width, int height){
        Color c = new Color(0, 0, 0, 200);
        g2.setColor(c);
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
}
