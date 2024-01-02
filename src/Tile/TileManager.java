package Tile;

import Controls.GamePanel;
import Controls.UtilityTool;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.*;

public class TileManager {
    GamePanel gp;
    public Tile[] tile;

    public int[][] mapTileNum;

    public TileManager(GamePanel gp) {
        this.gp = gp;
        tile = new Tile[20];
        mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];
        getTileManager();
        loadMap("res/Maps/newmap.txt");
    }

    public void getTileManager() {

        setup(0, "sand", false);
        setup(1, "sand_with_water", true);
        setup(2, "water", true);
        setup(3, "clam", true);
        setup(4, "cockle", true);
        setup(5, "walking_path", false);
        setup(6,"shop",true);
        setup(7,"grass_with_sand",false);
        setup(8,"cactus",true);
        setup(9,"tree",false);
        setup(10,"coral",true);
        setup(11,"down_pool",true);
        setup(12,"left_down_corner",true);
        setup(13,"left_pool",true);
        setup(14,"left_up_corner",true);
        setup(15,"right_down_corner",true);
        setup(16,"right_pool",true);
        setup(17,"right_up_corner",true);
        setup(18,"up_pool",true);


    }

    public void setup(int index, String imagePath, boolean collision) {

        UtilityTool uTool = new UtilityTool();
        String filePath = "res/Tiles/" + imagePath + ".png";
        File imageFile = new File(filePath);

        try (FileInputStream fis = new FileInputStream(imageFile)) {

            tile[index] = new Tile();
            tile[index].image = ImageIO.read(fis);
            tile[index].image = uTool.scaleImage(tile[index].image, gp.tileSize, gp.tileSize);
            tile[index].collision = collision;

        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void loadMap(String filePath) {
        try (InputStream is = new FileInputStream(filePath);
             BufferedReader br = new BufferedReader(new InputStreamReader(is))) {

            int col = 0;
            int row = 0;
            String line;

            while ((line = br.readLine()) != null && row < gp.maxWorldRow) {
                // Skip empty lines
                if (line.trim().isEmpty()) {
                    continue;
                }

                String numbers[] = line.split(" ");

                // Make sure the array is not longer than maxWorldCol
                int numCount = Math.min(numbers.length, gp.maxWorldCol);

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

        while (worldCol < gp.maxWorldCol && worldRow < gp.maxWorldRow) {

            int tileNum = mapTileNum[worldCol][worldRow];

            int worldX = worldCol * gp.tileSize;

            int worldY = worldRow * gp.tileSize;

            int screenX = worldX - gp.player.worldX + gp.player.screenX;

            int screenY = worldY - gp.player.worldY + gp.player.screenY;

            //Stop camera moving at the edge
            if(gp.player.screenX > gp.player.worldX){
                screenX = worldX;
            }if(gp.player.screenY > gp.player.worldY) {
                screenY = worldY;
            }
            int rightOffset = gp.screenWidth - gp.player.screenX;
            if(rightOffset > gp.worldWidth - gp.player.worldX){
                screenX = gp.screenWidth - (gp.worldWidth - worldX);
            }
            int bottomOffset = gp.screenHeight - gp.player.screenY;
            if(bottomOffset > gp.worldHeight - gp.player.worldY){
                screenY = gp.screenHeight - (gp.worldHeight - worldY);
            }

            if(worldX + gp.tileSize> gp.player.worldX - gp.player.screenX &&
                    worldX - gp.tileSize < gp.player.worldX + gp.player.screenX &&
                    worldY + gp.tileSize > gp.player.worldY - gp.player.screenY &&
                    worldY - gp.tileSize< gp.player.worldY + gp.player.screenY) {
                if (tile[tileNum] != null && tile[tileNum].image != null) {
                    g2.drawImage(tile[tileNum].image, screenX, screenY, gp.tileSize, gp.tileSize, null);
                }
            }else if(gp.player.screenX > gp.player.worldX ||
                    gp.player.screenY > gp.player.worldY ||
                    rightOffset > gp.worldWidth - gp.player.worldX ||
                    bottomOffset > gp.worldHeight - gp.player.worldY){
                g2.drawImage(tile[tileNum].image, screenX, screenY, gp.tileSize, gp.tileSize, null);
            }
            worldCol++;
            if(worldCol == gp.maxWorldCol) {
                worldCol = 0;
                worldRow++;
            }
        }
    }
}