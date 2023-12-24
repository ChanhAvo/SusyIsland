package Controls;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.awt.Font;

public class UI {
    GamePanel gp;
    Graphics2D g2;
    Font arial_40;
    public BufferedImage image;
    public UI(GamePanel gp){
        this.gp = gp;

        arial_40 = new Font("Serif", Font.PLAIN, 40);
    }
    public void draw(Graphics2D g2 ){

        this.g2 = g2;

        g2.setFont(arial_40 );
        g2.setColor(Color.white);

        if(gp.gameState == gp.playState) {
            // Do playSate stuff later
        }
        if(gp.gameState == gp.pauseState) {
            drawPauseScreen();
            //g2.drawImage(image, gp.screenWidth, gp.screenHeight, null);
        //}
        //if (gp.gameState == gp.pauseState) {
            //drawPauseScreen();
            //if (image != null) {
                //g2.drawImage(image, gp.screenWidth, gp.screenHeight, null);
            //}
        }
    }

    public void drawPauseScreen() {

        //try (InputStream filePause = getClass().getResourceAsStream("res/Background/pause_screen.png")){
            //if (filePause != null) {
            //assert filePause != null;
            //image = ImageIO.read(filePause);
                //g2.drawImage(image, gp.screenWidth, gp.screenHeight, null);
            //} else {
                //System.err.println("Image not found!");
            //}
        //}catch (IOException e){
            //e.printStackTrace();

        //}

        g2.setColor(new Color(128, 128, 128, 200)); // Grey color with alpha (transparency)
        g2.fillRect(0, 0, gp.getWidth(), gp.getHeight()); // Fill the entire screen

        g2.setColor(Color.white);
        g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 80F));
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

}
