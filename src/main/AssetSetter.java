package main;

//import entity.Entity;
//import entity.MON_Rat;
import entity.MON_Rat;
import object.*;

public class AssetSetter {

    GamePanel gp;
    public AssetSetter(GamePanel gp){
        this.gp = gp;
    }

    public void setObject(){

        gp.obj[0] = new OBJ_Gun_Blue(gp);
        gp.obj[0].worldX = 22 * gp.tileSize;
        gp.obj[0].worldY = 25 * gp.tileSize;

        gp.obj[2] = new OBJ_Sword(gp);
        gp.obj[2].worldX = 3 * gp.tileSize;
        gp.obj[2].worldY = 3 * gp.tileSize;

        gp.obj[3] = new OBJ_Sword(gp);
        gp.obj[3].worldX = 4 * gp.tileSize;
        gp.obj[3].worldY = 3 * gp.tileSize;

        gp.obj[4] = new OBJ_Life(gp);
        gp.obj[4].worldX = 29 * gp.tileSize;
        gp.obj[4].worldY = 9 * gp.tileSize;

    }

    public void setMON(){
        gp.monster[0] = new MON_Rat(gp);
        gp.monster[0].worldX = 13 * gp.tileSize;
        gp.monster[0].worldY = 15 * gp.tileSize;

        gp.monster[1] = new MON_Rat(gp);
        gp.monster[1].worldX = 18 * gp.tileSize;
        gp.monster[1].worldY = 16 * gp.tileSize;

        gp.monster[2] = new MON_Rat(gp);
        gp.monster[2].worldX = 17 * gp.tileSize;
        gp.monster[2].worldY = 16 * gp.tileSize;

        gp.monster[3] = new MON_Rat(gp);
        gp.monster[3].worldX = 16 * gp.tileSize;
        gp.monster[3].worldY = 15 * gp.tileSize;
    }

}
