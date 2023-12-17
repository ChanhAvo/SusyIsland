package Tile;

import Controls.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.*;

public class TileManager {
    GamePanel gp;
    Tile[] tile ;
    int mapTileNum [][];
    public TileManager(GamePanel gp) {
        this.gp = gp;
        tile = new Tile[10];
        mapTileNum = new int[gp.maxScreenCol][gp.maxScreenRow];
        getTileImage();

    }
    public void getTileImage() {
        try {
            File file = new File("res/Tiles/sand.png");
            FileInputStream fis = new FileInputStream(file);
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(fis);

            file = new File("res/Tiles/sand_with_water.png");
            fis = new FileInputStream(file);
            tile[1] = new Tile();
            tile[1].image = ImageIO.read(fis);

            file = new File("res/Tiles/water.png");
            fis = new FileInputStream(file);
            tile[2] = new Tile();
            tile[2].image = ImageIO.read(fis);


        }catch(IOException e){
            e.printStackTrace();

        }
    }

    public void draw(Graphics2D g2) {
        //1 line
        g2.drawImage(tile[0].image, 0, 0, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[0].image, 64, 0, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[0].image, 128, 0, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[0].image, 192, 0, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[0].image, 256, 0, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[0].image, 320, 0, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[0].image, 384, 0, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[0].image, 448, 0, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[0].image, 512, 0, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[0].image, 576, 0, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[0].image, 640, 0, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[0].image, 704, 0, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[0].image, 768, 0, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[0].image, 832, 0, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[0].image, 896, 0, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[0].image, 960, 0, gp.tileSize,gp.tileSize,null);

        //2 line
        g2.drawImage(tile[0].image, 0, 64, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[0].image, 64, 64, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[0].image, 128, 64, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[0].image, 192, 64, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[0].image, 256, 64, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[0].image, 320, 64, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[0].image, 384, 64, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[0].image, 448, 64, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[0].image, 512, 64, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[0].image, 576, 64, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[0].image, 640, 64, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[0].image, 704, 64, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[0].image, 768, 64, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[0].image, 832, 64, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[0].image, 896, 64, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[0].image, 960, 64, gp.tileSize,gp.tileSize,null);

        // 3 line
        g2.drawImage(tile[0].image, 0, 128, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[0].image, 64, 128, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[0].image, 128, 128, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[0].image, 192, 128, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[0].image, 256, 128, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[0].image, 320, 128, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[0].image, 384, 128, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[0].image, 448, 128, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[0].image, 512, 128, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[0].image, 576, 128, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[0].image, 640, 128, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[0].image, 704, 128, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[0].image, 768, 128, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[0].image, 832, 128, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[0].image, 896, 128, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[0].image, 960, 128, gp.tileSize,gp.tileSize,null);

        // 4 line
        g2.drawImage(tile[0].image, 0, 192, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[0].image, 64, 192, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[0].image, 128, 192, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[0].image, 192, 192, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[0].image, 256, 192, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[0].image, 320, 192, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[0].image, 384, 192, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[0].image, 448, 192, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[0].image, 512, 192, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[0].image, 576, 192, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[0].image, 640, 192, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[0].image, 704, 192, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[0].image, 768, 192, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[0].image, 832, 192, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[0].image, 896, 192, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[0].image, 960, 192, gp.tileSize,gp.tileSize,null);

        // 5 line
        g2.drawImage(tile[0].image, 0, 256, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[0].image, 64, 256, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[0].image, 128, 256, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[0].image, 192, 256, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[0].image, 256, 256, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[0].image, 320, 256, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[0].image, 384, 256, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[0].image, 448, 256, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[0].image, 512, 256, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[0].image, 576, 256, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[0].image, 640, 256, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[0].image, 704, 256, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[0].image, 768, 256, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[0].image, 832, 256, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[0].image, 896, 256, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[0].image, 960, 256, gp.tileSize,gp.tileSize,null);

        // 6 line (sand with water)
        g2.drawImage(tile[0].image, 0, 320, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[0].image, 64, 320, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[0].image, 128, 320, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[0].image, 192, 320, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[0].image, 256, 320, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[0].image, 320, 320, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[0].image, 384, 320, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[0].image, 448, 320, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[0].image, 512, 320, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[0].image, 576, 320, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[0].image, 640, 320, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[0].image, 704, 320, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[0].image, 768, 320, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[0].image, 832, 320, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[0].image, 896, 320, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[0].image, 960, 320, gp.tileSize,gp.tileSize,null);

        // line 7 water
        g2.drawImage(tile[1].image, 0, 384, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[1].image, 64, 384, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[1].image, 128, 384, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[1].image, 192, 384, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[1].image, 256, 384, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[1].image, 320, 384, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[1].image, 384, 384, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[1].image, 448, 384, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[1].image, 512, 384, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[1].image, 576, 384, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[1].image, 640, 384, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[1].image, 704, 384, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[1].image, 768, 384, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[1].image, 832, 384, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[1].image, 896, 384, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[1].image, 960, 384, gp.tileSize,gp.tileSize,null);

        // line 8 water
        g2.drawImage(tile[2].image, 0, 448, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[2].image, 64, 448, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[2].image, 128, 448, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[2].image, 192, 448, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[2].image, 256, 448, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[2].image, 320, 448, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[2].image, 384, 448, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[2].image, 448, 448, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[2].image, 512, 448, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[2].image, 576, 448, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[2].image, 640, 448, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[2].image, 704, 448, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[2].image, 768, 448, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[2].image, 832, 448, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[2].image, 896, 448, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[2].image, 960, 448, gp.tileSize,gp.tileSize,null);


        //line 9
        g2.drawImage(tile[2].image, 0, 512, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[2].image, 64, 512, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[2].image, 128, 512, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[2].image, 192, 512, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[2].image, 256, 512, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[2].image, 320, 512, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[2].image, 384, 512, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[2].image, 448, 512, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[2].image, 512, 512, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[2].image, 576, 512, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[2].image, 640, 512, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[2].image, 704, 512, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[2].image, 768, 512, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[2].image, 832, 512, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[2].image, 896, 512, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[2].image, 960, 512, gp.tileSize,gp.tileSize,null);


        //line 10
        g2.drawImage(tile[2].image, 0, 576, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[2].image, 64, 576, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[2].image, 128, 576, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[2].image, 192, 576, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[2].image, 256, 576, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[2].image, 320, 576, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[2].image, 384, 576, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[2].image, 448, 576, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[2].image, 512, 576, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[2].image, 576, 576, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[2].image, 640, 576, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[2].image, 704, 576, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[2].image, 768, 576, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[2].image, 832, 576, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[2].image, 896, 576, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[2].image, 960, 576, gp.tileSize,gp.tileSize,null);


        //line 11
        g2.drawImage(tile[2].image, 0, 640, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[2].image, 64, 640, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[2].image, 128, 640, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[2].image, 192, 640, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[2].image, 256, 640, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[2].image, 320, 640, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[2].image, 384, 640, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[2].image, 448, 640, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[2].image, 512, 640, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[2].image, 576, 640, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[2].image, 640, 640, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[2].image, 704, 640, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[2].image, 768, 640, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[2].image, 832, 640, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[2].image, 896, 640, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[2].image, 960, 640, gp.tileSize,gp.tileSize,null);


        //line 12
        g2.drawImage(tile[2].image, 0, 704, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[2].image, 64, 704, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[2].image, 128, 704, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[2].image, 192, 704, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[2].image, 256, 704, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[2].image, 320, 704, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[2].image, 384, 704, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[2].image, 448, 704, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[2].image, 512, 704, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[2].image, 576, 704, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[2].image, 640, 704, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[2].image, 704, 704, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[2].image, 768, 704, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[2].image, 832, 704, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[2].image, 896, 704, gp.tileSize,gp.tileSize,null);
        g2.drawImage(tile[2].image, 960, 704, gp.tileSize,gp.tileSize,null);

    }
}