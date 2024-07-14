package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    GamePanel gp;

    public boolean upPressed, downPressed, leftPressed, rightPressed, shootKeyPressed;

    public KeyHandler(GamePanel gp){

        this.gp = gp;

    }
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {

        int code = e.getKeyCode();

        //Title State
        if(gp.gameState == gp.titleState){

            //Decrease commandNum by 1 for selection
            if(code == KeyEvent.VK_W){
                gp.ui.commandNum--;
                if(gp.ui.commandNum < 0){
                    gp.ui.commandNum = 2;
                }
            }

            //Increase commandNum by 1 for selection
            if(code == KeyEvent.VK_S){
                gp.ui.commandNum++;
                if(gp.ui.commandNum > 2){
                    gp.ui.commandNum = 0;
                }
            }

            if(code == KeyEvent.VK_SPACE){
                if (gp.ui.commandNum == 0){

                    gp.gameState = gp.playState;

                }if(gp.ui.commandNum == 1){

                    //Save & Load Function

                }if(gp.ui.commandNum == 2){

                    System.exit(0);

                }
            }

        }

        //Play State
        else if(gp.gameState == gp.playState){
  
            if(code == KeyEvent.VK_W){
                upPressed= true;
            }
            if(code == KeyEvent.VK_A){
                leftPressed= true;
            }
            if(code == KeyEvent.VK_S){
                downPressed= true;
            }
            if(code == KeyEvent.VK_D){
                rightPressed= true;
            }
            if(code == KeyEvent.VK_SPACE){
                shootKeyPressed = true;
            }
            if(code == KeyEvent.VK_E){
                gp.gameState = gp.pauseState;

            }
        }

        //Pause State
        else if(gp.gameState == gp.pauseState){


            //Decrease pauseNum by 1 for selection
            if(code == KeyEvent.VK_A){
                gp.ui.pauseNum--;
                if(gp.ui.pauseNum < 0){
                    gp.ui.pauseNum = 2;
                }
            }

            //Increase pauseNum by 1 for selection
            if(code == KeyEvent.VK_D){
                gp.ui.pauseNum++;
                if(gp.ui.pauseNum > 2){
                    gp.ui.pauseNum = 0;
                }
            }

            if(code == KeyEvent.VK_SPACE){
                if (gp.ui.pauseNum == 0){

                    gp.gameState = gp.playState;

                }if(gp.ui.pauseNum == 1){

                    //Save Function

                }if(gp.ui.pauseNum == 2){

                    gp.gameState = gp.titleState;

                }
            }

        }
    }



    @Override
    public void keyReleased(KeyEvent e) {

        int code = e.getKeyCode();
        if(code == KeyEvent.VK_W){
            upPressed= false;
        }
        if(code == KeyEvent.VK_A){
            leftPressed= false;
        }
        if(code == KeyEvent.VK_S){
            downPressed= false;
        }
        if(code == KeyEvent.VK_D){
            rightPressed= false;
        }
        if(code == KeyEvent.VK_SPACE){
            shootKeyPressed = false;
        }

    }
}
