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
        gp.obj[0].worldX = 10 * gp.tileSize;
        gp.obj[0].worldY = 16 * gp.tileSize;

    }

    public void setCore(){

        if(gp.stage.currentStage == gp.stage.firstStage){
            gp.obj[2] = new OBJ_CORE1(gp);
            gp.obj[2].worldX = 45 * gp.tileSize; //PlayerX : 8
            gp.obj[2].worldY = 41 * gp.tileSize; //PlayerY : 16
        }else if(gp.stage.currentStage == gp.stage.secondStage){
            gp.obj[3] = new OBJ_CORE2(gp);
            gp.obj[3].worldX = 43 * gp.tileSize; //PlayerX: 40
            gp.obj[3].worldY = 35 * gp.tileSize; //PlayerY: 12
        }else if(gp.stage.currentStage == gp.stage.thirdStage){
            gp.obj[4] = new OBJ_CORE3(gp);
            gp.obj[4].worldX = 3 * gp.tileSize; //PlayerX : 26
            gp.obj[4].worldY = 3 * gp.tileSize; //PlayerY : 27
        }
    }

    public void setBASE(){

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
    }

    public ArrayList<Integer> getRandomPos() {
        ArrayList<ArrayList<Integer>> availableTiles = gp.tileM.availableTiles;
        int nTiles = availableTiles.size() - 1;

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
