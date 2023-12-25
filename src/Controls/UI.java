package Controls;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.awt.Font;

public class UI {
    GamePanel gp;
    Graphics2D g2;
    Font vt323_40;

    public UI(GamePanel gp) {
        this.gp = gp;
        vt323_40 = new Font("VT323", Font.PLAIN,40);
        loadFont();
    }

    private void loadFont() {
        try (InputStream fontStream = getClass().getResourceAsStream("/Background/VT323-Regular.ttf")) {
            vt323_40 = Font.createFont(Font.TRUETYPE_FONT, fontStream);
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2){

        this.g2 = g2;

        g2.setFont(vt323_40);
        g2.setColor(Color.white);

        if(gp.gameState == gp.playState) {
            // Do playSate stuff later
        }
        if(gp.gameState == gp.pauseState) {
            drawPauseScreen();
        }
    }

    public void drawPauseScreen() {

        g2.setColor(new Color(128, 128, 128, 200)); // Grey color with alpha (transparency)
        g2.fillRect(0, 0, gp.getWidth(), gp.getHeight()); // Fill the entire screen

        g2.setColor(Color.white);
        g2.setFont(vt323_40.deriveFont(Font.PLAIN, 90f));
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
