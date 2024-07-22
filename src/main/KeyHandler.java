package main;
import entity.Player;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    GamePanel gp;

    public boolean upPressed, downPressed, leftPressed, rightPressed, shootKeyPressed;

    public KeyHandler(GamePanel gp) {

        this.gp = gp;

    }

    @Override
    public void keyTyped(KeyEvent e) {
    }


    @Override
    public void keyPressed(KeyEvent e) {

        int code = e.getKeyCode();

        //Title State
        if (gp.gameState == gp.titleState) {

            //Decrease commandNum by 1 for selection
            if (code == KeyEvent.VK_W) {
                gp.ui.commandNum--;
                if (gp.ui.commandNum < 0) {
                    gp.ui.commandNum = 2;
                }
            }

            //Increase commandNum by 1 for selection
            if (code == KeyEvent.VK_S) {
                gp.ui.commandNum++;
                if (gp.ui.commandNum > 2) {
                    gp.ui.commandNum = 0;
                }
            }

            if (code == KeyEvent.VK_SPACE) {
                if (gp.ui.commandNum == 0) { //NEW GAME

                    gp.stage.resetStage();
                    gp.gameState = gp.playState;
                    gp.stage.checkStageTimer();
                    gp.playSE(2);


                }
                if (gp.ui.commandNum == 1) { //LOAD GAME

                    //Save & Load Function
                    gp.gameState = gp.playState;
                    gp.stage.checkStageTimer();
                    gp.playSE(2);


                }
                if (gp.ui.commandNum == 2) { //EXIT

                    System.exit(0);

                }
            }

        }

        //Play State
        else if (gp.gameState == gp.playState) {

            if (code == KeyEvent.VK_W) {
                upPressed = true;
            }
            if (code == KeyEvent.VK_A) {
                leftPressed = true;
            }
            if (code == KeyEvent.VK_S) {
                downPressed = true;
            }
            if (code == KeyEvent.VK_D) {
                rightPressed = true;
            }
            if (code == KeyEvent.VK_SPACE) {
                shootKeyPressed = true;
            }
            if (code == KeyEvent.VK_E) {
                gp.gameState = gp.pauseState;
            }
            if (code == KeyEvent.VK_0) {
                gp.player.weaponButtonPress(0);
            }
            if (code == KeyEvent.VK_1) {
                gp.player.weaponButtonPress(1);
            }
            //if (code == KeyEvent.VK_2) {
            //    gp.player.weaponButtonPress(2);
            //}
        }

        //Pause State
        else if (gp.gameState == gp.pauseState) {

            if (code == KeyEvent.VK_E) {
                gp.gameState = gp.playState;
                gp.playMusic(1);
            }

            //Decrease pauseNum by 1 for selection
            if (code == KeyEvent.VK_A) {
                gp.ui.pauseNum--;
                if (gp.ui.pauseNum < 0) {
                    gp.ui.pauseNum = 2;
                }
            }

            //Increase pauseNum by 1 for selection
            if (code == KeyEvent.VK_D) {
                gp.ui.pauseNum++;
                if (gp.ui.pauseNum > 2) {
                    gp.ui.pauseNum = 0;
                }
            }

            if (code == KeyEvent.VK_SPACE) {
                if (gp.ui.pauseNum == 0) { //BACK

                    gp.gameState = gp.playState;
                    gp.playSE(2);

                }
                if (gp.ui.pauseNum == 1) { //SAVE

                    //Save Function
                    gp.playSE(2);

                }
                if (gp.ui.pauseNum == 2) { //BACK TO TITLE
                    gp.playSE(2);
                    gp.gameState = gp.titleState;

                }
            }


        }

        //Continue State
        else if (gp.gameState == gp.continueState) {

            //Decrease stageNum by 1 for selection
            if (code == KeyEvent.VK_A) {
                gp.ui.stageNum--;
                if (gp.ui.stageNum < 0) {
                    gp.ui.stageNum = 1;
                }
            }

            //Increase stageNum by 1 for selection
            if (code == KeyEvent.VK_D) {
                gp.ui.stageNum++;
                if (gp.ui.stageNum > 1) {
                    gp.ui.stageNum = 0;
                }
            }
            if (code == KeyEvent.VK_SPACE) {
                if (gp.ui.stageNum == 0) {
                    gp.stage.checkStage();
                    if(gp.scientist.scientistON == true){
                        gp.gameState = gp.dialogueState;
                    }else{
                        gp.gameState = gp.playState;
                    }
                    gp.playSE(2);

                    //DEBUG
                    System.out.println("Stage: " + gp.stage.currentStage);

                }
                if (gp.ui.stageNum == 1) {
                    gp.playSE(2);
                    gp.gameState = gp.titleState;
                }

            }
        }

        //Scientist Interaction
        else if (gp.gameState == gp.dialogueState){

            //Decrease scientistNum by 1 for selection
            if (code == KeyEvent.VK_A) {
                gp.ui.scientistNum--;
                if (gp.ui.scientistNum < 0) {
                    gp.ui.scientistNum = 2;
                }
            }

            //Increase scientistNum by 1 for selection
            if (code == KeyEvent.VK_D) {
                gp.ui.scientistNum++;
                if (gp.ui.scientistNum > 2) {
                    gp.ui.scientistNum = 0;
                }
            }
            if (code == KeyEvent.VK_SPACE) {
                if (gp.ui.scientistNum == 0) { //YES

                    //ADD BUFF
                    gp.scientist.buffPlayer();
                    gp.gameState = gp.playState;
                    gp.playSE(2);

                }
                if (gp.ui.scientistNum == 1) { //NO

                    //IGNORE
                    gp.playSE(2);
                    gp.scientist.desperateCounter++;
                    gp.scientist.resetBuff();
                    gp.gameState = gp.playState;

                    //DEBUG
                    System.out.println("Desperate counter: " + gp.scientist.desperateCounter);
                }

                if (gp.ui.scientistNum == 2){ //KILL
                    gp.scientist.scientistON = false;
                    gp.scientist.resetBuff();
                    gp.gameState = gp.playState;
                }

            }

        }

        //Ending
        else if (gp.gameState == gp.endState){

            if (code == KeyEvent.VK_SPACE) {
                if (gp.ui.endNum == 0) {
                    gp.gameState = gp.titleState;
                    System.out.println("Game Over");
                }

            }
        }
    }
        @Override
        public void keyReleased (KeyEvent e){

            int code = e.getKeyCode();
            if (code == KeyEvent.VK_W) {
                upPressed = false;
            }
            if (code == KeyEvent.VK_A) {
                leftPressed = false;
            }
            if (code == KeyEvent.VK_S) {
                downPressed = false;
            }
            if (code == KeyEvent.VK_D) {
                rightPressed = false;
            }
            if (code == KeyEvent.VK_SPACE) {
                shootKeyPressed = false;
            }

        }
    }
