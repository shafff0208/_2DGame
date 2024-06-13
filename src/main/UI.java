package main;

import objects.OBJ_Life;
import objects.SuperObject;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.awt.Font;


public class UI {

    GamePanel gp;
    Graphics2D g2;
    Font courier_35;
    BufferedImage Life_5, Life_4, Life_3, Life_2, Life_1, Life_0, Heart;


    public UI(GamePanel gp) {
        this.gp = gp;

        courier_35 = new Font("Courier", Font.PLAIN, 35);

        //Life HUD
        SuperObject life;
        life = new OBJ_Life(gp);
        Life_5 = life.image;
        Life_4 = life.image2;
        Life_3 = life.image3;
        Life_2 = life.image4;
        Life_1 = life.image5;
        Life_0 = life.image6;
        Heart = life.image7;
    }

    public void draw(Graphics2D g2) {

        this.g2 = g2;
        drawPlayerLife();
    }

    public void drawPlayerLife() {


        g2.setFont(courier_35);
        g2.setColor(Color.white);
        g2.drawString("x " + gp.player.life, 74, 68);
        g2.drawImage(Heart, gp.tileSize/2, gp.tileSize/2, gp.tileSize, gp.tileSize, null);

    }
}

//package main;
//
//import objects.OBJ_Life;
//import objects.SuperObject;
//
//import java.awt.*;
//import java.awt.image.BufferedImage;
//
//public class UI {
//
//    GamePanel gp;
//    Graphics2D g2;
//    BufferedImage[] lifeImages;
//
//    public UI(GamePanel gp) {
//        this.gp = gp;
//
//        // Life HUD
//        OBJ_Life life = new OBJ_Life(gp);
//        lifeImages = new BufferedImage[6];
//        for (int i = 0; i < 6; i++) {
//            lifeImages[i] = life.getLifeImage(i);
//        }
//    }
//
//    public void draw(Graphics2D g2) {
//        this.g2 = g2;
//        int x = gp.tileSize / 2;
//        int y = gp.tileSize / 2;
//        g2.drawImage(lifeImages[0], x, y, null);
//    }
//
////    public void drawPlayerLife() {
////
////        int x = gp.tileSize / 2;
////        int y = gp.tileSize / 2;
////        int i = 0;
////        g2.drawImage(Life_0, x, y, null);
////
////    }
//}


