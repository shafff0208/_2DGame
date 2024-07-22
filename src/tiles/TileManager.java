package tiles;

import main.GamePanel;
import main.UtilityTool;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class TileManager {

    GamePanel gp;
    public Tile[] tile;
    public int[][] mapTileNum;
    public ArrayList<ArrayList<Integer>> availableTiles;


    public TileManager (GamePanel gp){

        this.gp = gp;
        tile = new Tile [10];
        availableTiles = new ArrayList<>(); 
        getTileImage();
        mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];

    }

    public void setupMap(){
        if(gp.stage.currentStage == gp.stage.firstStage){
            loadMap("/maps/Map0(50x50).txt");
        }else if (gp.stage.currentStage == gp.stage.secondStage){
            loadMap("/maps/Map1(50x50).txt");
        }else if (gp.stage.currentStage == gp.stage.thirdStage){
            loadMap("/maps/Map2(50x50).txt");
        }
//        //DEBUG
//        System.out.println(STR."File \{gp.currentStage} Loaded");

    }


    //Read map txt file
    public void loadMap(String filePath){

        try{
            InputStream is = getClass().getResourceAsStream(filePath);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col = 0;
            int row = 0;

            availableTiles = new ArrayList<>(); 

            while (col < gp.maxWorldCol && row < gp.maxWorldRow){

                String line = br.readLine();

                while(col < gp.maxWorldCol){

                    String numbers [] = line.split(" ");

                    int num = Integer.parseInt(numbers[col]);

                    mapTileNum[col][row] = num;

                    // if num == 0 -> available tile to spawn
                    if (num == 0 || num == 2) {
                        // int curTiles = availableTiles.length;
                        // availableTiles[curTiles][0] = col;
                        // availableTiles[curTiles][1] = row;
                        ArrayList<Integer> posTile = new ArrayList<>();
                        posTile.add(col);
                        posTile.add(row);

                        // System.out.printf("(%d, %d)%n", col, row);

                        availableTiles.add(posTile);
                    }

                    col++;

                }

                if (col == gp.maxWorldCol){

                    col = 0;
                    row ++;

                }

            }
            System.out.println("nTiles: " + availableTiles.size());
            gp.aSetter.setMON();
            
            br.close();



        }catch(Exception e){

            e.printStackTrace();

        }

    }

    public void setup(int index, String imageName, boolean collision){

        UtilityTool uTool = new UtilityTool();

        try{
            tile[index] = new Tile();
            tile[index].image = ImageIO.read(getClass().getResourceAsStream("/tiles/" + imageName + ".png"));
            tile[index].image = uTool.scaleImage(tile[index].image, gp.tileSize, gp.tileSize);
            tile[index].collision = collision;

        }catch(IOException e){
            e.printStackTrace();
        }

    }

    public void getTileImage(){

            setup(0, "Grass", false);
            setup(1, "Water", true);
            setup(2, "Dirt", false);
            setup(3, "Wall", true);

    }


    public void draw(Graphics2D g2){

        int worldCol = 0;
        int worldRow = 0;

        while (worldCol < gp.maxWorldCol && worldRow < gp.maxWorldRow ){

            int tileNum = mapTileNum[worldCol][worldRow];

            int worldX = worldCol * gp.tileSize;
            int worldY = worldRow * gp.tileSize;
            int screenX = worldX - gp.player.worldX + gp.player.screenX;
            int screenY = worldY - gp.player.worldY + gp.player.screenY;


            if (worldX + gp.tileSize > gp.player.worldX - gp.player.screenX &&
                worldX - gp.tileSize < gp.player.worldX + gp.player.screenX &&
                worldY + gp.tileSize > gp.player.worldY - gp.player.screenY &&
                worldY - gp.tileSize < gp.player.worldY + gp.player.screenY){

                g2.drawImage(tile[tileNum].image, screenX, screenY,null);

            }

            worldCol ++;

            if (worldCol == gp.maxWorldCol){
                worldCol = 0;
                worldRow++;

            }

        }

    }

}
