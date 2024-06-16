package main;

import object.OBJ_Life;
import object.SuperObject;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.awt.Font;


public class UI {

    GamePanel gp;
    Graphics2D g2;
    Font courier_35;
    BufferedImage Heart;


    public UI(GamePanel gp) {
        this.gp = gp;

        courier_35 = new Font("Courier", Font.PLAIN, 35);

        //Life HUD
        SuperObject life;
        life = new OBJ_Life(gp);
        Heart = life.image;
    }

    public void draw(Graphics2D g2) {

        this.g2 = g2;
        g2.setFont(courier_35);
        g2.setColor(Color.white);

        if(gp.gameState == gp.playState){
            //Do play stuff
            drawPlayerLife();
        }
        if(gp.gameState == gp.pauseState){

            //Do pause stuff
            drawPauseScreen();
        }

    }

    public void drawPlayerLife() {

        g2.drawString("x " + gp.player.life, 74, 68);
        g2.drawImage(Heart, gp.tileSize/2, gp.tileSize/2, gp.tileSize, gp.tileSize, null);

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




