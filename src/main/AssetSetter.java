package main;

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

        gp.obj[1] = new OBJ_Sword(gp);
        gp.obj[1].worldX = 20 * gp.tileSize;
        gp.obj[1].worldY = 20 * gp.tileSize;

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

    public void setMON() {
        gp.monster[0] = new MON_Bear(gp);
        gp.monster[0].worldX = 13 * gp.tileSize;
        gp.monster[0].worldY = 15 * gp.tileSize;

        gp.monster[1] = new MON_Bear(gp);
        gp.monster[1].worldX = 18 * gp.tileSize;
        gp.monster[1].worldY = 16 * gp.tileSize;

        gp.monster[2] = new MON_Bear(gp);
        gp.monster[2].worldX = 17 * gp.tileSize;
        gp.monster[2].worldY = 16 * gp.tileSize;

        gp.monster[3] = new MON_Bear(gp);
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

        gp.monster[14] = new MON_Pred(gp);
        gp.monster[14].worldX = 13 * gp.tileSize;
        gp.monster[14].worldY = 18 * gp.tileSize;

        gp.monster[15] = new MON_Pred(gp);
        gp.monster[15].worldX = 16 * gp.tileSize;
        gp.monster[15].worldY = 13 * gp.tileSize;
    }

    }
