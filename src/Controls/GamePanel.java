package Controls;

import java.awt.*;
import javax.swing.JPanel;
import Entity.Player;
import Tile.TileManager;

public class GamePanel extends JPanel implements Runnable {

    //Screen settings
    final int originalTileSize = 16; // 16x16 tiles
    final int scale = 4;

    public final int tileSize = originalTileSize * scale; // 64x64 tiles
    public final int maxScreenCol = 16;
    public final int maxScreenRow = 12;
    public final int screenWidth = tileSize * maxScreenCol; // 1024 pixels
    public final int screenHeight = tileSize * maxScreenRow; // 704 pixels

    //WORLD SETTING
    public final int maxWorldCol = 16;
    public final int maxWorldRow = 12;
    public final int worldWidth = tileSize * maxWorldCol;
    public final int worldHeight = tileSize * maxWorldRow;

    //FPS
    int FPS = 60;
    TileManager tileM = new TileManager(this);
    KeyHandler keyH = new KeyHandler();
    Sound sound = new Sound();
    Thread gameThread;
    public CollisionDetection cDetection = new CollisionDetection(this);
    public Player player = new Player (this, keyH);

//    //Player's default position
//    int playerX = 100;
//    int playerY = 100;
//    int playerSpeed = 3;

    public GamePanel(){
        this.setPreferredSize(new Dimension (screenWidth, screenHeight));
        this.setBackground(Color.white);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
        playMusic(0);
    }

    public void startGameThread(){

        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run(){

        double drawInterval = 1000000000/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;

        while(gameThread != null){

            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;

            if (delta >= 1) {
                update();
                repaint();
                delta--;
                drawCount++;

            }
            if (timer >= 1000000000){
                System.out.println("FPS: " + drawCount);
                drawCount = 0;
                timer = 0;
            }
        }
    }
    public void update(){
        player.update();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;

        //debug
        long drawStart = 0;
        if(keyH.checkDrawTime == true) {
            drawStart = System.nanoTime();
        }

        tileM.draw(g2);
        player.draw(g2);

        //debug
        if(keyH.checkDrawTime == true) {
            long drawEnd = System.nanoTime();
            long passed = drawEnd - drawStart;
            g2.setColor(Color.white);
            g2.drawString("Draw Time:" + passed, 10, 400);
            System.out.println("Draw Time: " + passed);
        }


        g2.dispose();
    }
    public void playMusic(int i) {
        sound.setFile(i);
        sound.play();
        sound.loop();

    }
    public void stopMusic(){
        sound.stop();
    }
    public void playSE(int i){
        sound.setFile(i);
        sound.play();
    }
}