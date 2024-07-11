package main;

//import entity.Entity;
//import entity.MON_Rat;
import entity.MON_Rat;
import entity.MON_Worm;
import entity.MON_MutantTreant;
import entity.MON_Pred;
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

        gp.monster[4] = new MON_Worm(gp);
        gp.monster[4].worldX = 15 * gp.tileSize;
        gp.monster[4].worldY = 13 * gp.tileSize;

        gp.monster[5] = new MON_Worm(gp);
        gp.monster[5].worldX = 16 * gp.tileSize;
        gp.monster[5].worldY = 18 * gp.tileSize;

        gp.monster[6] = new MON_Worm(gp);
        gp.monster[6].worldX = 16 * gp.tileSize;
        gp.monster[6].worldY = 17 * gp.tileSize;

        gp.monster[7] = new MON_Worm(gp);
        gp.monster[7].worldX = 17 * gp.tileSize;
        gp.monster[7].worldY = 17 * gp.tileSize;

        gp.monster[8] = new MON_MutantTreant(gp);
        gp.monster[8].worldX = 15 * gp.tileSize;
        gp.monster[8].worldY = 18 * gp.tileSize;

        gp.monster[9] = new MON_MutantTreant(gp);
        gp.monster[9].worldX = 12 * gp.tileSize;
        gp.monster[9].worldY = 17 * gp.tileSize;

        gp.monster[10] = new MON_MutantTreant(gp);
        gp.monster[10].worldX = 18 * gp.tileSize;
        gp.monster[10].worldY = 15 * gp.tileSize;

        gp.monster[11] = new MON_MutantTreant(gp);
        gp.monster[11].worldX = 19 * gp.tileSize;
        gp.monster[11].worldY = 16 * gp.tileSize;

        gp.monster[12] = new MON_Pred(gp);
        gp.monster[12].worldX = 15 * gp.tileSize;
        gp.monster[12].worldY = 16 * gp.tileSize;

        gp.monster[13] = new MON_Pred(gp);
        gp.monster[13].worldX = 16 * gp.tileSize;
        gp.monster[13].worldY = 17 * gp.tileSize;

        gp.monster[10] = new MON_Pred(gp);
        gp.monster[10].worldX = 13 * gp.tileSize;
        gp.monster[10].worldY = 18 * gp.tileSize;

        gp.monster[11] = new MON_Pred(gp);
        gp.monster[11].worldX = 16 * gp.tileSize;
        gp.monster[11].worldY = 13 * gp.tileSize;
    }

}
