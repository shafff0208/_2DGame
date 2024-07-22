package main;

import java.util.ArrayList;
import java.util.Random;

import entity.*;
import object.*;

public class AssetSetter {

    GamePanel gp;

    public AssetSetter(GamePanel gp) {
        this.gp = gp;
    }

    public void setObject() {

        gp.obj[0] = new OBJ_Gun_Blue(gp);
        gp.obj[0].worldX = 30 * gp.tileSize;
        gp.obj[0].worldY = 30 * gp.tileSize;

//        gp.obj[1] = new OBJ_Sword(gp);
//        gp.obj[1].worldX = 20 * gp.tileSize;
//        gp.obj[1].worldY = 20 * gp.tileSize;

    }

    public void setCore(){

        if(gp.stage.currentStage == gp.stage.firstStage){
            gp.obj[2] = new OBJ_CORE1(gp);
            gp.obj[2].worldX = 13 * gp.tileSize;
            gp.obj[2].worldY = 39 * gp.tileSize;
        }else if(gp.stage.currentStage == gp.stage.secondStage){
            gp.obj[3] = new OBJ_CORE2(gp);
            gp.obj[3].worldX = 43 * gp.tileSize;
            gp.obj[3].worldY = 35 * gp.tileSize;
        }else if(gp.stage.currentStage == gp.stage.thirdStage){
            gp.obj[4] = new OBJ_CORE3(gp);
            gp.obj[4].worldX = 3 * gp.tileSize;
            gp.obj[4].worldY = 3 * gp.tileSize;
        }
    }

    public void setBASE(){

        if(gp.stage.currentStage == gp.stage.firstStage){
            gp.obj[5] = new BASE_Outer(gp);
            gp.obj[5].worldX = 25 * gp.tileSize;
            gp.obj[5].worldY = 31 * gp.tileSize;
            gp.obj[6] = new BASE_Outer(gp);
            gp.obj[6].worldX = 25 * gp.tileSize;
            gp.obj[6].worldY = 32 * gp.tileSize;
            gp.obj[7] = new BASE_Outer(gp);
            gp.obj[7].worldX = 25 * gp.tileSize;
            gp.obj[7].worldY = 33 * gp.tileSize;
            gp.obj[8] = new BASE_Outer(gp);
            gp.obj[8].worldX = 27 * gp.tileSize;
            gp.obj[8].worldY = 31 * gp.tileSize;
            gp.obj[9] = new BASE_Outer(gp);
            gp.obj[9].worldX = 27 * gp.tileSize;
            gp.obj[9].worldY = 32 * gp.tileSize;
            gp.obj[10] = new BASE_Outer(gp);
            gp.obj[10].worldX = 27 * gp.tileSize;
            gp.obj[10].worldY = 33 * gp.tileSize;

            gp.obj[11] = new BASE_Inner(gp);
            gp.obj[11].worldX = 26 * gp.tileSize;
            gp.obj[11].worldY = 31 * gp.tileSize;
            gp.obj[12] = new BASE_Inner(gp);
            gp.obj[12].worldX = 26 * gp.tileSize;
            gp.obj[12].worldY = 32 * gp.tileSize;
            gp.obj[13] = new BASE_Inner(gp);
            gp.obj[13].worldX = 26 * gp.tileSize;
            gp.obj[13].worldY = 33 * gp.tileSize;

        }else if(gp.stage.currentStage == gp.stage.secondStage){

            gp.obj[14] = new BASE_Outer(gp);
            gp.obj[14].worldX = 13 * gp.tileSize;
            gp.obj[14].worldY = 39 * gp.tileSize;
            gp.obj[15] = new BASE_Outer(gp);
            gp.obj[15].worldX = 13 * gp.tileSize;
            gp.obj[15].worldY = 39 * gp.tileSize;
            gp.obj[16] = new BASE_Outer(gp);
            gp.obj[16].worldX = 13 * gp.tileSize;
            gp.obj[16].worldY = 39 * gp.tileSize;
            gp.obj[17] = new BASE_Outer(gp);
            gp.obj[17].worldX = 13 * gp.tileSize;
            gp.obj[17].worldY = 39 * gp.tileSize;
            gp.obj[18] = new BASE_Outer(gp);
            gp.obj[18].worldX = 13 * gp.tileSize;
            gp.obj[18].worldY = 39 * gp.tileSize;
            gp.obj[19] = new BASE_Outer(gp);
            gp.obj[19].worldX = 13 * gp.tileSize;
            gp.obj[19].worldY = 39 * gp.tileSize;

            gp.obj[20] = new BASE_Inner(gp);
            gp.obj[20].worldX = 13 * gp.tileSize;
            gp.obj[20].worldY = 39 * gp.tileSize;
            gp.obj[21] = new BASE_Inner(gp);
            gp.obj[21].worldX = 13 * gp.tileSize;
            gp.obj[21].worldY = 39 * gp.tileSize;
            gp.obj[22] = new BASE_Inner(gp);
            gp.obj[22].worldX = 13 * gp.tileSize;
            gp.obj[22].worldY = 39 * gp.tileSize;

        }else if(gp.stage.currentStage == gp.stage.thirdStage){
            gp.obj[23] = new BASE_Outer(gp);
            gp.obj[23].worldX = 13 * gp.tileSize;
            gp.obj[23].worldY = 39 * gp.tileSize;
            gp.obj[24] = new BASE_Outer(gp);
            gp.obj[24].worldX = 13 * gp.tileSize;
            gp.obj[24].worldY = 39 * gp.tileSize;
            gp.obj[25] = new BASE_Outer(gp);
            gp.obj[25].worldX = 13 * gp.tileSize;
            gp.obj[25].worldY = 39 * gp.tileSize;
            gp.obj[26] = new BASE_Outer(gp);
            gp.obj[26].worldX = 13 * gp.tileSize;
            gp.obj[26].worldY = 39 * gp.tileSize;
            gp.obj[27] = new BASE_Outer(gp);
            gp.obj[27].worldX = 13 * gp.tileSize;
            gp.obj[27].worldY = 39 * gp.tileSize;
            gp.obj[28] = new BASE_Outer(gp);
            gp.obj[28].worldX = 13 * gp.tileSize;
            gp.obj[28].worldY = 39 * gp.tileSize;

            gp.obj[29] = new BASE_Inner(gp);
            gp.obj[29].worldX = 13 * gp.tileSize;
            gp.obj[29].worldY = 39 * gp.tileSize;
            gp.obj[30] = new BASE_Inner(gp);
            gp.obj[30].worldX = 13 * gp.tileSize;
            gp.obj[30].worldY = 39 * gp.tileSize;
            gp.obj[31] = new BASE_Inner(gp);
            gp.obj[31].worldX = 13 * gp.tileSize;
            gp.obj[31].worldY = 39 * gp.tileSize;

        }
    }

    public ArrayList<Integer> getRandomPos() {
        ArrayList<ArrayList<Integer>> availableTiles = gp.tileM.availableTiles;
        int nTiles = availableTiles.size() - 1;

        System.out.println("nTiles: " + nTiles);

        Random rand = new Random();
        int tileIdx = rand.nextInt(nTiles);

        return availableTiles.get(tileIdx);
    }


    public void setEntityPos(Entity entity, ArrayList<Integer> position, int tileSize) {
        entity.worldX = position.get(0) * tileSize;
        entity.worldY = position.get(1) * tileSize;
    }

    public Entity getMonster(int stageIdx, boolean isBoss) {
        Entity monster;
        switch (stageIdx) {
            case 1:
                if (isBoss) {
                    monster = new MON_Bear(gp);
                } else
                    monster = new MON_Worm(gp);
                break;
            case 2:
                if (isBoss) {
                    monster = new MON_Bear(gp);
                } else
                    monster = new MON_Rat(gp);
                break;
            case 3:
                if (isBoss) {
                    monster = new MON_MutantTreant(gp);
                } else
                    monster = new MON_Pred(gp);
                break;
            default:
                monster = new MON_Worm(gp);
                break;
        }
        return monster;
    }

    public void setMON() {
        if (gp.monsterInitialized) {
            return;
        }
        int stageIdx = gp.stage.currentStage;
        int nMonster = 50;
        System.out.println("Current stage: " + stageIdx);
        for (int i = 0; i < nMonster; i++) {
            Entity monster = getMonster(stageIdx, false);
            setEntityPos(monster, getRandomPos(), gp.tileSize);
            gp.monster[i] = monster;
        }
        gp.monster[nMonster] = getMonster(stageIdx, true);
        gp.monsterInitialized = true;
    }

}
