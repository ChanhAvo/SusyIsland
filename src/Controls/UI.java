package Controls;


import java.awt.*;


public class UI {
    GamePanel gp;
    Font vt323_40;
    public UI(GamePanel gp){
        this.gp = gp;
        vt323_40 = new Font("VT323", Font.PLAIN,40);
    }
    public void draw(Graphics2D g2 ){
        g2.setFont(vt323_40);
        g2.setColor(Color.white);


    }
}
