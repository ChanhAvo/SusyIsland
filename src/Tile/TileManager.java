package Tile;

import Controls.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class TileManager {
    private final GamePanel gp;
    public final Tile[] tiles;
    public final int[][] mapTileNum;

    public TileManager(GamePanel gp) {
        this.gp = gp;
        tiles = new Tile[3];
        // MAP DATA
        mapTileNum = new int[][] {
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
                {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
                {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
                {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
                {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}
        };
        loadTiles();
        tiles[1].collision = true;
        tiles[2].collision = true;
    }

    private void loadTileImage(String path, int index) throws IOException {
        File file = new File(path);
        FileInputStream fis = new FileInputStream(file);
        tiles[index] = new Tile();
        tiles[index].image = ImageIO.read(fis);
    }

    private void loadTiles() {
        try {
            loadTileImage("res/Tiles/sand.png", 0);
            loadTileImage("res/Tiles/sand_with_water.png", 1);
            loadTileImage("res/Tiles/water.png", 2);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2) {
        for (int i = 0; i < mapTileNum.length; i++) {
            for (int j = 0; j < mapTileNum[i].length; j++) {
                int tileIndex = mapTileNum[i][j];
                g2.drawImage(tiles[tileIndex].image, j * gp.tileSize, i * gp.tileSize, gp.tileSize, gp.tileSize, null);
            }
        }
    }
}
