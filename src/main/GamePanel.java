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
    public final int maxScreenCol = 16;
    public final int maxScreenRow = 12;
    public final int screenWidth = tileSize * maxScreenCol;
    public final int screenHeight = tileSize * maxScreenRow;

    //World Settings
    public final int maxWorldCol = 50;
    public final int maxWorldRow = 50;

    // FPS
    int FPS = 60;
    //System
    TileManager tileM = new TileManager(this);
    Thread gameThread;
    KeyHandler keyH = new KeyHandler(this);
    public CollisionDetection cDetection = new CollisionDetection(this);
    public AssetSetter aSetter = new AssetSetter(this);
    public UI ui = new UI(this);
    Sound sound = new Sound();

    //Entity, Object
    public Player player = new Player(this,keyH);
    public Entity[] monster = new Entity[50];
    public SuperObject[] obj = new SuperObject[50];

    //Game State
    public int gameState;
    public final int titleState = 0;
    public final int playState = 1;
    public final int pauseState = 2;
    public final int continueState = 3; //Can change to scientist interaction State
    public final int endState = 4; //Can display different endings (need add more states)

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


    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);

        stageTimer = new Timer(1000, e -> updateStageTime());

    }

    public void setupGame() {
        playMusic(0);
        gameState = titleState;
        currentStage = firstStage;
        aSetter.setObject();
        aSetter.setMON();
    }

    public void checkStage() {

            long currentTime = System.currentTimeMillis();
            long elapsedTime = (currentTime - stageStartTime) / 1000;
            stageMinutes = (int) (elapsedTime / 60);
            stageSeconds = (int) (elapsedTime % 60);

        //Change stageSeconds to stageMinutes for stage progression
        if (currentStage == firstStage && stageSeconds ==0){
            player.setupPlayerPos();
            tileM.setupMap();
            ui.stageOn = true;

        }
        else if (currentStage == firstStage && stageSeconds >= 20) {
            gameState = continueState;
            currentStage++;
            player.setupPlayerPos();
            tileM.setupMap();
            ui.stageOn = true;
            stageStartTime = System.currentTimeMillis();

        } else if (currentStage == secondStage && stageSeconds >= 20) {
            gameState = continueState;
            currentStage++;
            player.setupPlayerPos();
            tileM.setupMap();
            ui.stageOn = true;
            stageStartTime = System.currentTimeMillis();

        } else if (currentStage == thirdStage && stageSeconds >= 20) {
            currentStage = firstStage;
            tileM.setupMap();
            gameState = endState;
            player.worldX= tileSize * 26;
            player.worldY= tileSize * 27;
        }
//        //DEBUG
//         System.out.println("Stage: " + currentStage);

    }

    public void startStageTimer() {

        if (gameState == playState) {
            stageStartTime = System.currentTimeMillis();
            stageTimer.start();
        }else{
            stageTimer.stop();
        }
    }

    private void updateStageTime() {
        if (gameState == playState) {
            checkStage();
        }else{
            stageTimer.stop();
        }
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    public void run() {
        double drawInterval = 1000000000/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        while (gameThread != null) {
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime)/drawInterval;
            lastTime = currentTime;

            if(delta >= 1) {
                update();
                repaint();
                delta--;
            }
        }
    }

    public void update() {
        if(gameState == playState) {
            player.update();
            for(int i = 0; i < monster.length; i++) {
                if(monster[i] != null) {
                    monster[i].update();
                }
            }
            checkStage();
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        //Title Screen
        if (gameState == titleState) {
            ui.draw(g2);
        }else if(gameState == continueState){
            ui.draw(g2);
        }else if(gameState == endState){
            ui.draw(g2);
        }else {

            //Draw Tiles
            tileM.draw(g2);


            //Draw Objects
            for(int i = 0; i < obj.length; i++) {
                if (obj[i] != null) {
                    obj[i].draw(g2, this);
                }
            }

            //Draw Monsters
            for(int i = 0; i < monster.length; i++) {
                if (monster[i] != null) {
                    monster[i].draw(g2);
                }
            }

            //Draw Player
            player.draw(g2);

            //Draw UI
            ui.draw(g2);
        }

        g2.dispose();
    }
    public void playMusic(int i) {
        sound.setFile(i);
        sound.play();
        sound.loop();
    }

    public void stopMusic() {
        sound.stop();
    }

    public void playSE(int i) {
        sound.setFile(i);
        sound.play();
    }

}
