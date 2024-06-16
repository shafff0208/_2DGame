package main;

import entity.Entity;
import entity.Player;
import object.SuperObject;
import tiles.TileManager;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {

    //Screen Settings
    final int originalTileSize = 16; // 16x16
    final int scale = 3;
    public int tileSize = originalTileSize * scale; //48 tiles
    public int maxScreenCol = 16;
    public final int maxScreenRow = 12;
    public final int screenWidth = tileSize * maxScreenCol;
    public final int screenHeight = tileSize * maxScreenRow;

    //World Settings
    public final int maxWorldCol = 42;
    public final int maxWorldRow = 32;

    // FPS
    int FPS = 60;

    //System
    TileManager tileM = new TileManager(this);
    Thread gameThread;
    KeyHandler keyH = new KeyHandler(this);
    public CollisionDetection cDetection = new CollisionDetection(this);
    public AssetSetter aSetter = new AssetSetter(this);
    public UI ui = new UI(this);


    //Entity, Object
    public Player player = new Player(this,keyH);
    public Entity[] rat = new Entity[10];
    public SuperObject[] obj = new SuperObject[10];

    //Game State
    public int gameState;
    public final int playState = 1;
    public final int pauseState = 2;

    public GamePanel() {

        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    public void setupGame(){

        aSetter.setObject();
//        aSetter.setMON();
        gameState = playState;

    }


    public void startGameThread() {
        //introducing a time element into the game
        gameThread = new Thread(this);
        gameThread.start();
    }

    public void run(){
        double drawInterval = 1000000000/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        long drawCount = 0;

        while (gameThread != null){

            currentTime = System.nanoTime();
            delta += (currentTime - lastTime)/drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;


            if(delta >=1){
                update();
                repaint();
                delta--;
                drawCount++;
            }

            if (timer >= 1000000000){

                //display FPS
                System.out.println("FPS: " + drawCount);
                drawCount = 0;
                timer = 0;
            }
        }
    }

    public void update() {

        if(gameState == playState){
            player.update();
        }
        if(gameState == pauseState){
            //nothing
        }

    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        //Draw Tiles
        tileM.draw(g2);

        //Draw Object
        for(int i = 0; i < obj.length; i++){
            if (obj[i] != null){
                obj[i].draw(g2, this);
            }
        }

        //Draw Monster
//        for(int i = 0; i < rat.length; i++){
//            if (rat[i] != null){
//                rat[i].draw(g2);
//            }
//        }

        //Draw Player
        player.draw(g2);

        //Draw UI
        ui.draw(g2);

        g2.dispose();


    }
}
