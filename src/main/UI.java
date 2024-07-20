package main;

import object.OBJ_Life;
import object.SuperObject;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.awt.Font;
import java.io.IOException;
import java.io.InputStream;


public class UI {

    GamePanel gp;
    Graphics2D g2;
    Font customFont;
    BufferedImage Heart;
    public boolean messageOn = false;
    public boolean stageOn = true;
    public String message = "";
    public String currentDialogue = "";
    public int messageCounter = 0;
    public int stageOnCounter = 0;
    public int commandNum = 0;
    public int pauseNum = 0;
    public int stageNum = 0;
    public int endNum = 0;
    public int scientistNum = 0;


    public UI(GamePanel gp) {

        this.gp = gp;
        try{
            InputStream is = getClass().getResourceAsStream("/font/x12y16pxMaruMonica.ttf");
            customFont = Font.createFont(Font.TRUETYPE_FONT, is);
        }catch(FontFormatException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }

    }
    public void showMessage(String text){

        message = text;
        messageOn = true;

    }

    public void draw(Graphics2D g2) {

        this.g2 = g2;
        g2.setFont(customFont);
        g2.setColor(Color.white);

        //Title State
        if(gp.gameState == gp.titleState){
            //Do title stuff
            drawTitleScreen();
        }

        //Play State
        if(gp.gameState == gp.playState){
            //Do play stuff

            drawTimer();
            drawPlayerLife();
            drawStartingStage();

            if (messageOn == true){
                g2.setFont(g2.getFont().deriveFont(20F));
                g2.drawString(message, gp.tileSize/2, gp.tileSize*5 );

                messageCounter++;
                if (messageCounter > 60){
                    messageCounter = 0;
                    messageOn = false;
                }
            }
        }
        //Pause State
        if(gp.gameState == gp.pauseState){
            //Do pause stuff
            drawPauseScreen();
        }
        //Continue State
        if(gp.gameState == gp.continueState){
            drawStagePrompt();
        }
        //End State
        if(gp.gameState == gp.endState){
            drawGameOverScreen();
        }

        //Dialogue
        if(gp.gameState == gp.dialogueState){
            drawScientistINT();
        }

    }

    public void drawPlayerLife() {

        //Life HUD
        SuperObject life;
        life = new OBJ_Life(gp);
        Heart = life.image;

        g2.setFont(g2.getFont().deriveFont(50F));
        g2.drawImage(Heart, gp.tileSize/2, gp.tileSize/2, gp.tileSize, gp.tileSize, null);
        g2.drawString("x" + gp.player.life, 74, 68);

    }

    public void drawTitleScreen(){

        //Title Screen color
        g2.setColor(new Color(181, 210, 156));
        g2.fillRect(0,0, gp.screenWidth, gp.screenHeight);

        //Title Name
        g2.setFont(g2.getFont().deriveFont(Font.BOLD,96F));
        String text = "Purifier's Quest";
        int x = getXCenteredText(text);
        int y = gp.tileSize * 3;

        //Text Shadow
        g2.setColor(Color.black);
        g2.drawString(text, x+5, y+5);

        //Text Primary Color
        g2.setColor(Color.white);
        g2.drawString(text, x, y);

        //Menu Selection
        g2.setFont(g2.getFont().deriveFont(Font.BOLD,48F));

        text = "New Game";
        x = getXCenteredText(text);
        y += gp.tileSize * 4;
        g2.drawString(text, x, y );
        if (commandNum == 0){
            g2.drawString(">", x-gp.tileSize, y);
        }

        text = "Load Game";
        x = getXCenteredText(text);
        y += gp.tileSize;
        g2.drawString(text, x, y );
        if (commandNum == 1){
            g2.drawString(">", x-gp.tileSize, y);
        }

        text = "Quit";
        x = getXCenteredText(text);
        y += gp.tileSize;
        g2.drawString(text, x, y );
        if (commandNum == 2){
            g2.drawString(">", x-gp.tileSize, y);
        }

    }

    public void drawScientistINT(){

        int x = gp.tileSize * 2;
        int y = gp.tileSize*7;
        int width = gp.screenWidth - (gp.tileSize * 4);
        int height = gp.tileSize * 4;
        drawDialogueWindow(x, y, width, height);

        x += (int) (gp.tileSize * 10.5);
        y += gp.tileSize * 2;
        g2.drawImage(gp.scientist.left1, x, y, gp.tileSize*3, gp.tileSize*3, null );

        g2.setFont(g2.getFont().deriveFont(Font.BOLD,30F));

        x = (int) (gp.tileSize * 2.5);
        y = gp.tileSize * 8;

        for(String line : currentDialogue.split("\n")){
            g2.drawString(line, x, y);
            y+= 40;
        }

        String text = "Yes";
        x = gp.tileSize*4;
        y = (int) (gp.tileSize*10.5);
        g2.drawString(text, x, y );
        if (scientistNum == 0){
            g2.drawString(">", x-gp.tileSize, y);
        }

        text = "No";
        x = getXCenteredText(text);
        y = (int) (gp.tileSize*10.5);
        g2.drawString(text, x, y );
        if (scientistNum == 1){
            g2.drawString(">", x-gp.tileSize, y);
        }

        text = "Kill Him";
        x = (int) (gp.tileSize*10.5);
        y = (int) (gp.tileSize*10.5);
        g2.drawString(text, x, y );
        if (scientistNum == 2){
            g2.drawString(">", x-gp.tileSize, y);
        }


    }

    public void drawDialogueWindow(int x, int y, int width, int height){

        Color c = new Color(0,0,0,210);
        g2.setColor(c);
        g2.fillRoundRect(x, y, width, height, 35,35);

        c = new Color(255,255,255);
        g2.setColor(c);
        g2.setStroke(new BasicStroke(5));
        g2.drawRoundRect(x+5, y+5, width -10, height -10, 25,25);


    }


    public void drawPauseScreen(){

        String text = "PAUSED";
        g2.setFont(g2.getFont().deriveFont(Font.PLAIN,80F));
        int x = getXCenteredText(text);
        int y = gp.screenHeight/2;
        g2.drawString(text, x, y);

        g2.setFont(g2.getFont().deriveFont(Font.PLAIN,45F));
        text = "Back";
        x = gp.tileSize*4;
        y = gp.tileSize*10;
        g2.drawString(text, x, y );
        if (pauseNum == 0){
            g2.drawString(">", x-gp.tileSize, y);
        }

        text = "Save";
        x = getXCenteredText(text);
        y = gp.tileSize*10;
        g2.drawString(text, x, y );
        if (pauseNum == 1){
            g2.drawString(">", x-gp.tileSize, y);
        }

        text = "Quit";
        x = (int) (gp.tileSize*10.5);
        y = gp.tileSize*10;
        g2.drawString(text, x, y );
        if (pauseNum == 2){
            g2.drawString(">", x-gp.tileSize, y);
        }

    }

    public void drawTimer(){

        g2.setFont(g2.getFont().deriveFont(Font.PLAIN,45F));
        int x = gp.screenWidth/2 - gp.tileSize;
        g2.drawString(gp.stage.stageMinutes + "m" + gp.stage.stageSeconds + "s", x, 68);

    }

    public void drawStartingStage(){

       if (stageOn == true){

           g2.setFont(g2.getFont().deriveFont(Font.PLAIN,80F));
           String text = "STAGE " + gp.stage.currentStage;
           int x = getXCenteredText(text);
           int y = gp.screenHeight/2;
           g2.drawString(text, x, y);
           stageOnCounter++;
           if (stageOnCounter > 90){
               stageOnCounter = 0;
               stageOn = false;
           }
       }
    }

    public void drawStagePrompt(){

        String text = "STAGE COMPLETE";
        g2.setFont(g2.getFont().deriveFont(Font.PLAIN,80F));
        int x = getXCenteredText(text);
        int y = gp.screenHeight/2;
        g2.drawString(text, x, y);

        text = "Continue?";
        g2.setFont(g2.getFont().deriveFont(Font.PLAIN,45F));
        x = getXCenteredText(text);
        y += gp.tileSize;
        g2.drawString(text, x, y );

        g2.setFont(g2.getFont().deriveFont(Font.PLAIN,45F));
        text = "Yes";
        x = gp.screenWidth/2 - (gp.tileSize*3);
        y = gp.tileSize*10;
        g2.drawString(text, x, y );
        if (stageNum == 0){
            g2.drawString(">", x-gp.tileSize, y);
        }

        text = "No";
        x = gp.screenWidth/2 + (gp.tileSize*2);
        y = gp.tileSize*10;
        g2.drawString(text, x, y );
        if (stageNum == 1){
            g2.drawString(">", x-gp.tileSize, y);
        }
    }

    public void drawGameOverScreen(){

        String text = "GAME OVER";
        g2.setFont(g2.getFont().deriveFont(Font.PLAIN,80F));
        int x = getXCenteredText(text);
        int y = gp.screenHeight/2;
        g2.drawString(text, x, y);

        g2.setFont(g2.getFont().deriveFont(Font.PLAIN,45F));
        text = "Thanks For Playing";
        x = getXCenteredText(text);
        y += gp.tileSize;
        g2.drawString(text, x, y );

        text = "Back to Title Screen";
        x = getXCenteredText(text);
        y = gp.tileSize*10;
        g2.drawString(text, x, y );
        if (endNum == 0){
            g2.drawString(">", x-gp.tileSize, y);
        }

    }

    public int getXCenteredText(String text){

        int length = (int)g2.getFontMetrics().getStringBounds(text,g2).getWidth();
        int x = gp.screenWidth/2 - length/2;
        return x;

    }

}




