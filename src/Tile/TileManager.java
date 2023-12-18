package Tile;
import Controls.GamePanel;
import java.awt.*;
import java.io.*;
import javax.imageio.ImageIO;

public class TileManager {
    GamePanel gp;
    public Tile[] tile;

    public int[][] mapTileNum;

    public TileManager(GamePanel gp) {
        this.gp = gp;
        tile = new Tile[3];
        mapTileNum = new int[gp.maxScreenCol][gp.maxScreenRow];
        getTileManager();
        loadMap("res/Maps/map01.txt");
    }

    public void getTileManager() {

        try (InputStream fileTile01 = new FileInputStream("res/Tiles/sand.png");
             InputStream fileTile02 = new FileInputStream("res/Tiles/sand_with_water.png");
             InputStream fileTile03 = new FileInputStream("res/Tiles/water.png")) {

            tile[0] = new Tile();
            tile[0].image = ImageIO.read(fileTile01);


            tile[1] = new Tile();
            tile[1].image = ImageIO.read(fileTile02);
            tile[1].collision = true;

            tile[2] = new Tile();
            tile[2].image = ImageIO.read(fileTile03);
            tile[2].collision = true;


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void loadMap(String filePath) {
        try (InputStream is = new FileInputStream(filePath);
             BufferedReader br = new BufferedReader(new InputStreamReader(is))) {

            int col = 0;
            int row = 0;
            String line;

            while ((line = br.readLine()) != null && row < gp.maxScreenRow) {
                // Skip empty lines
                if (line.trim().isEmpty()) {
                    continue;
                }

                String numbers[] = line.split(" ");

                // Make sure the array is not longer than maxWorldCol
                int numCount = Math.min(numbers.length, gp.maxScreenCol);

                for (col = 0; col < numCount; col++) {
                    int num = Integer.parseInt(numbers[col]);
                    mapTileNum[col][row] = num;
                }
                col = 0;
                row++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void draw(Graphics2D g2) {

        int worldCol = 0;

        int worldRow = 0;

        while (worldCol < gp.maxScreenCol && worldRow < gp.maxScreenRow) {

            int tileNum = mapTileNum[worldCol][worldRow];

            int worldX = worldCol * gp.tileSize;

            int worldY = worldRow * gp.tileSize;

            int screenX = worldX - gp.player.worldX + gp.player.screenX;

            int screenY = worldY - gp.player.worldY + gp.player.screenY;

            if(worldX + gp.tileSize> gp.player.worldX - gp.player.screenX && worldX -gp.tileSize < gp.player.worldX + gp.player.screenX && worldY + gp.tileSize > gp.player.worldY - gp.player.screenY && worldY - gp.tileSize< gp.player.worldY + gp.player.screenY) {
                if (tile[tileNum] != null && tile[tileNum].image != null) {
                    g2.drawImage(tile[tileNum].image, screenX, screenY, gp.tileSize, gp.tileSize, null);
                }
            }
            worldCol++;
            if(worldCol == gp.maxScreenCol) {
                worldCol = 0;
                worldRow++;
            }
        }
    }
}