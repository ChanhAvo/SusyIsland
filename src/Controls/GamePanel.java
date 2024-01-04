package Controls;

import Entity.Entity;
import Entity.Player;
import Environment.EnvironmentManager;
import Tile.TileManager;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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
    public final int maxWorldCol = 41;
    public final int maxWorldRow = 43;
    public final int worldWidth = tileSize * maxWorldCol;
    public final int worldHeight = tileSize * maxWorldRow;

    //FPS
    int FPS = 60;

    // SYSTEM
    TileManager tileM = new TileManager(this);
    public KeyHandler keyH = new KeyHandler(this);
    Sound sound = new Sound();

    public CollisionDetection cDetection = new CollisionDetection(this);
    public AssetSetter aSetter = new AssetSetter(this);
    public UI ui = new UI (this);
    public EventHandler eHandler = new EventHandler (this);
    public EnvironmentManager eManager = new EnvironmentManager(this);

    Thread gameThread;

    // ENTITY & OBJECTS
    public Player player = new Player(this, keyH);
    public Entity obj[] = new Entity[10];
    public Entity npc[] = new Entity[10];
    public Entity[] crab = new Entity[20];
    public Entity[] tre = new Entity[10];

    ArrayList<Entity> entityList = new ArrayList<>();

    //GAME STATE
    public int gameState;
    public final int titleState = 0;
    public final int playState = 1;
    public final int pauseState = 2;
    public final int dialogueState = 3;
    public final int characterState = 4;
    public final int inventoryState = 5;
    public final int tradeState = 6;
    public final int fishingState = 7;
    public final int gameOverState = 8;
    public final int gameDoneState = 9;


    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.white);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    public void setupGame() {
        aSetter.setNPC();
        aSetter.setObject();
        aSetter.setCrab();
        aSetter.setTreasure();
        playMusic(0);
        eManager.setup();

        gameState = titleState;
    }
    public void retry(){
        player.setDefaultPosition();
        player.restoreLife();
        aSetter.setCrab();
        aSetter.setObject();
    }
    public void restart(){
        player.setDefaultPosition();
        player.setDefaultValues();
        player.restoreLife();
        player.setItems();
        aSetter.setNPC();
        aSetter.setObject();
        aSetter.setCrab();
        playMusic(0);
    }
    public void startGameThread() {

        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run(){

        double drawInterval = 1000000000 / FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;

        while (gameThread != null) {

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
        if(gameState == playState){
            player.update();
            eManager.update();

            for (int i = 0; i < npc.length; i++){
                if(npc[i] != null){
                    npc[i].update();
                }
            }
            for (int i = 0; i < crab.length; i++) {
                if (crab[i] != null) {
                    crab[i].update();
                }
            }
        }
        if(gameState == pauseState){
            //nothing
        }
        if(gameState == gameOverState) {

        }
    }

    public void playMusic(int i) {
        sound.setFile(i);
        sound.play();
        sound.loop();
    }
    public void stopMusic(){
        sound.stop();
    }
    public void playSE(int i) {
        sound.setFile(i);
        sound.play();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        //TITLE SCREEN OR GAME OVER
        if (gameState == titleState ) {
            ui.draw(g2);
        }

        //OTHERS
        else {
            //TILE
            tileM.draw(g2);
            //add entity to the list
            entityList.add(player);
            for (int i = 0; i < npc.length; i++) {
                if (npc[i] != null) {
                    entityList.add(npc[i]);
                }
            }
            for (int i = 0; i < obj.length; i++) {
                if (obj[i] != null) {
                    entityList.add(obj[i]);
                }
            }
            for (int i = 0; i < crab.length; i++) {
                if (crab[i] != null) {
                    entityList.add(crab[i]);
                }
            }
            for (int i = 0; i < tre.length; i++) {
                if (tre[i] != null) {
                    entityList.add(tre[i]);
                }
            }
//            for (int i = 0; i < coconut.length; i++) {
//                if (coconut[i] != null) {
//                    entityList.add(coconut[i]);
//                }
//            }
            // sort
            Collections.sort(entityList, new Comparator<Entity>() {
                @Override
                public int compare(Entity e1, Entity e2) {
                    int result = Integer.compare(e1.worldY, e2.worldY);
                    return result;
                }
            });
            //DRAW ENTITY
            for (int i = 0; i < entityList.size(); i++) {
                entityList.get(i).draw(g2);
            }
            //EMPTY ENTITY LIST
            for (int i = 0; i < entityList.size(); i++) {
                entityList.remove(i);
            }
            //ENVIRONMENT
            eManager.draw(g2);

            //UI
            ui.draw(g2);
        }
        g2.dispose();
    }
}
