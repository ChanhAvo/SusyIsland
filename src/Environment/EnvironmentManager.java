package Environment;

import Controls.GamePanel;
import java.awt.Graphics2D;

public class EnvironmentManager extends EnvironmentSystem {

    GamePanel gp;
    public Lighting lighting;

    public EnvironmentManager(GamePanel gp) {
        this.gp = gp;
    }

    public void setup() {
        lighting = new Lighting(gp);
    }

    @Override
    public void update() {
        lighting.update();
    }

    public void draw(Graphics2D g2) {
        lighting.draw(g2);
    }
}
