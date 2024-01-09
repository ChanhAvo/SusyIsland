package Environment;

import Controls.GamePanel;

import java.awt.*;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class Lighting {
    GamePanel gp;
    BufferedImage darknessFilter;
    Font customFont;
    int dayCounter;
    float filterAlpha = 0f;

    //Day State
    final int day = 0;
    final int dusk = 1;
    final int night = 2;
    public int dayState = day;

    public Lighting(GamePanel gp) {
        this.gp = gp;
        customFont = new Font("VT323", Font.PLAIN,40);
        loadFont();
        setLightSource();
    }

    public void setLightSource() {

        //Create a buffered image
        darknessFilter = new BufferedImage(gp.screenWidth, gp.screenHeight, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = (Graphics2D)darknessFilter.getGraphics();

        //Create a screen-sized rectangle area
        Area screenArea = new Area(new Rectangle2D.Double(0,0,gp.screenWidth, gp.screenHeight));

//        //Get the center x and y of the light circle
//        int centerX = gp.player.screenX + (gp.tileSize)/2;
//        int centerY = gp.player.screenY + (gp.tileSize)/2;

//        //Get the top left x and y of light circle
//        double x = centerX - 150;
//        double y = centerY - 150;

//        //Create a gradation effect within the light circle
//        Color color[] = new Color[12];
//        float fraction[] = new float[12];

//        color[0] = new Color(0, 0, 0.1f, 0.1f);
//        color[1] = new Color(0, 0, 0.1f, 0.42f);
//        color[2] = new Color(0, 0, 0.1f, 0.52f);
//        color[3] = new Color(0, 0, 0.1f, 0.61f);
//        color[4] = new Color(0, 0, 0.1f, 0.69f);
//        color[5] = new Color(0, 0, 0.1f, 0.76f);
//        color[6] = new Color(0, 0, 0.1f, 0.82f);
//        color[7] = new Color(0, 0, 0.1f, 0.87f);
//        color[8] = new Color(0, 0, 0.1f, 0.91f);
//        color[9] = new Color(0, 0, 0.1f, 0.94f);
//        color[10] = new Color(0, 0, 0.1f, 0.96f);
//        color[11] = new Color(0, 0, 0.1f, 0.98f);
//
//        fraction[0] = 0f;
//        fraction[1] = 0.4f;
//        fraction[2] = 0.5f;
//        fraction[3] = 0.6f;
//        fraction[4] = 0.65f;
//        fraction[5] = 0.7f;
//        fraction[6] = 0.75f;
//        fraction[7] = 0.8f;
//        fraction[8] = 0.85f;
//        fraction[9] = 0.9f;
//        fraction[10] = 0.95f;
//        fraction[11] = 1f;

//        //Create a gradation paint settings for the light circle
//        RadialGradientPaint gPaint = new RadialGradientPaint(centerX, centerY, 150, fraction, color);

        //Set the gradient data on g2
        //g2.setPaint(gPaint);


        //Set color (black) to draw the rectangle
        g2.setColor(new Color(0, 0, 0.1f, 0.7f));

        //Draw the screen rectangle without the light circle area
        g2.fill(screenArea);

        //g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);
        g2.dispose();
    }
    public void update() {

        //Check the state of the day
        if(dayState == day) {
            dayCounter++;

            if(dayCounter > 18000) { //18000 = 5 minutes, 3600 = 1 minutes
                dayState = dusk;
                dayCounter = 0;
            }
        }
        else if(dayState == dusk) {
            filterAlpha += 0.001f; // 0.001f ~ 16s

            if(filterAlpha > 1f) {
                filterAlpha = 1f;
                dayState = night;
            }
        }
        else if(dayState == night) {
            dayCounter++;

            if(dayCounter > 600) { // 600 = 10 seconds
                gp.player.life = 0;
                dayCounter = 0;
                filterAlpha = 0f;
                dayState = day;
                gp.playSE(7);
            }
        }
    }
    public void resetDay() {
        dayCounter = 0;
        filterAlpha = 0f;
        dayState = day;
    }


    public void draw(Graphics2D g2) {

        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, filterAlpha));
        g2.drawImage(darknessFilter, 0, 0, null);
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));

        //DEBUG
        String situation = "";

        switch(dayState) {
            case day: situation = "Day"; break;
            case dusk: situation = "Dusk"; break;
            case night: situation = "Night"; break;
        }

        g2.setColor(Color.WHITE);
        g2.setFont(customFont.deriveFont(Font.PLAIN, 50f));
        g2.drawString(situation, 850, 650);
    }

    public void loadFont() {
        try (InputStream fontStream = getClass().getResourceAsStream("/Background/VT323-Regular.ttf")) {
            customFont = Font.createFont(Font.TRUETYPE_FONT, fontStream);
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }
    }


}
