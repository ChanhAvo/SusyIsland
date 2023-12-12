package Controls;

import java.awt.*;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable {

    //Screen settings
    final int originalTileSize = 16; // 16x16 tiles
    final int scale = 3;
    final int tileSize = originalTileSize * scale; // 48x48 tiles
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int screenWidth = tileSize * maxScreenCol; // 768 pixels
    final int screenHeight = tileSize * maxScreenRow; // 576 pixels

    //FPS
    int FPS = 60;
    KeyHandler keyH = new KeyHandler();
    Thread gameThread;

    //Player's default position
    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 4;

    public GamePanel(){
        this.setPreferredSize(new Dimension (screenWidth, screenHeight));
        this.setBackground(Color.white);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);

    }

    public void startGameThread(){

        gameThread = new Thread(this);
        gameThread.start();
    }


    @Override
    public void run() {

        double drawInterval = 1000000000/FPS;
        double nextDrawTime = System.nanoTime() + drawInterval;

        while(gameThread != null){
            //Update info such as char position
            update();
            //Draw the screen with the updated info
            repaint();

        }
    }
    public void update(){
        if(keyH.upPressed){
            playerY -= playerSpeed;
        }
        else if (keyH.downPressed){
            playerY += playerSpeed;
        }
        else if (keyH.leftPressed){
            playerY -= playerSpeed;
        }
        else if (keyH.rightPressed){
            playerY += playerSpeed;
        }
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        // g2.setColor(Color.white);
        // g2.fillRect(playerX,playerY,tileSize,tileSize);
        // g2.dispose();



    }
}
