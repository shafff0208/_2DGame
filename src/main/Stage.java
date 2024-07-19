package main;

import javax.swing.*;

public class Stage {

    GamePanel gp;

    //Stage Timer
    public Timer stageTimer;
    public long stageStartTime;
    public int stageSeconds;
    public int stageMinutes;

    //Stages
    public int currentStage;
    public final int firstStage = 1;
    public final int secondStage = 2;
    public final int thirdStage = 3;

    public Stage(GamePanel gp){
        this.gp = gp;
    }

    public void checkStage() {

        long currentTime = System.currentTimeMillis();
        long elapsedTime = (currentTime - stageStartTime) / 1000;
        stageMinutes = (int) (elapsedTime / 60);
        stageSeconds = (int) (elapsedTime % 60);

        if(gp.gameState == gp.playState){

            //Change stageSeconds to stageMinutes for stage progression
            if (currentStage == firstStage && stageSeconds ==0){
                gp.player.setupPlayer();
                gp.tileM.setupMap();
                gp.ui.stageOn = true;
            }
            else if (currentStage == firstStage && stageSeconds >= 20) {
                gp.gameState = gp.continueState;
                currentStage++;
                gp.player.setupPlayer();
                gp.tileM.setupMap();
                gp.ui.stageOn = true;
                stageStartTime = System.currentTimeMillis();

            } else if (currentStage == secondStage && stageSeconds >= 20) {
                gp.gameState = gp.continueState;
                currentStage++;
                gp.player.setupPlayer();
                gp.tileM.setupMap();
                gp.ui.stageOn = true;
                stageStartTime = System.currentTimeMillis();

            } else if (currentStage == thirdStage && stageSeconds >= 20 || gp.player.life == 0) {
                resetStage();
            }
//        //DEBUG
//         System.out.println("Stage: " + currentStage);

        }
    }

    //RESET STAGE if player dies or player reach STAGE 3
    public void resetStage(){

        gp.gameState = gp.endState;
        currentStage = firstStage;
        gp.player.setupPlayer();
        gp.tileM.setupMap();

    }

    public void checkStageTimer() {

        if (gp.gameState == gp.playState) {
            stageStartTime = System.currentTimeMillis();
            stageTimer.start();
        }else{
            stageTimer.stop();
        }
    }

    public void updateStageTime() {
        if (gp.gameState == gp.playState) {
            checkStage();
        }else{
            stageTimer.stop();
        }
    }

}
