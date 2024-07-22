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
        stageTimer = new Timer(1000, e -> updateStageTime());
    }

    public void checkStage() {



        long currentTime = System.currentTimeMillis();
        long elapsedTime = (currentTime - stageStartTime) / 1000;
        stageMinutes = (int) (elapsedTime / 60);
        stageSeconds = (int) (elapsedTime % 60);

        if(gp.gameState == gp.playState){

            //Change stageSeconds to stageMinutes for stage progression
            if (currentStage == firstStage && stageSeconds == 0){
                gp.gameState = gp.dialogueState;
                gp.scientist.speak();
                gp.aSetter.setBASE();
                gp.aSetter.setCore();
                gp.player.setupPlayer();
                gp.tileM.setupMap();
                gp.ui.stageOn = true;

            }
            else if (currentStage == firstStage && stageMinutes >= 1) {
                setupStageProgress();

            } else if (currentStage == secondStage && stageMinutes >= 1) {
                setupStageProgress();

            } else if (currentStage == thirdStage && stageMinutes >= 1 || gp.player.life == 0) {
                resetStage();
            }
        //DEBUG
         System.out.println("Stage: " + currentStage);

        }
    }

    public void setupStageProgress(){

        gp.gameState = gp.continueState;
        gp.scientist.speak();
        currentStage++;
        gp.aSetter.setBASE();
        gp.aSetter.setCore();
        gp.player.setupPlayer();
        gp.tileM.setupMap();
        gp.ui.stageOn = true;
        stageStartTime = System.currentTimeMillis();
    }

    //RESET STAGE if player dies or player reach STAGE 3
    public void resetStage(){

        gp.gameState = gp.endState;
        currentStage = firstStage;
        gp.scientist.desperateCounter = 0;
        gp.scientist.dialogueIndex = 0;
        gp.scientist.resetBuff();
        gp.player.setupPlayer();
        gp.tileM.setupMap();
//        gp.aSetter.setCore();
//        gp.aSetter.setBASE();
        gp.player.resetWeapon();
        gp.player.setCurrentWeapon(0);
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
