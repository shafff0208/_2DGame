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
    public String message = "";
    public int messageCounter = 0;
    public int commandNum = 0;


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
            drawPlayerLife();
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

    public void drawPauseScreen(){

        String text = "PAUSED";
        g2.setFont(g2.getFont().deriveFont(Font.PLAIN,80F));
        int x = getXCenteredText(text);

        int y = gp.screenHeight/2;
        g2.drawString(text, x, y);

    }

    public int getXCenteredText(String text){

        int length = (int)g2.getFontMetrics().getStringBounds(text,g2).getWidth();
        int x = gp.screenWidth/2 - length/2;
        return x;

    }
}




