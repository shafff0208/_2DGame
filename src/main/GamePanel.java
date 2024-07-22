package main;

import entity.Entity;
import entity.Player;
import entity.Scientist;
import object.SuperObject;
import tiles.TileManager;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GamePanel extends JPanel implements Runnable {

    // Screen Settings
    final int originalTileSize = 16; // 16x16
    final int scale = 3;
    public int tileSize = originalTileSize * scale; // 48 tiles
    public final int maxScreenCol = 16;
    public final int maxScreenRow = 12;
    public final int screenWidth = tileSize * maxScreenCol;
    public final int screenHeight = tileSize * maxScreenRow;

    // World Settings
    public final int maxWorldCol = 50;
    public final int maxWorldRow = 50;

    // FPS
    int FPS = 60;

    // System
    TileManager tileM = new TileManager(this);
    Thread gameThread;
    public KeyHandler keyH = new KeyHandler(this);
    public CollisionDetection cDetection = new CollisionDetection(this);
    public AssetSetter aSetter = new AssetSetter(this);
    public UI ui = new UI(this);
    public Stage stage = new Stage(this);
    Sound sound = new Sound();

    // Entity, Object
    public Player player = new Player(this, keyH);
    public Scientist scientist = new Scientist(this);
    public Entity[] monster = new Entity[50];
    public SuperObject[] obj = new SuperObject[50];
    public ArrayList<Entity> projectileList = new ArrayList<>();
    public ArrayList<Entity> entityList= new ArrayList<>();
    public boolean monsterInitialized = false;

    // Game State
    public int gameState;
    public final int titleState = 0;
    public final int playState = 1;
    public final int pauseState = 2;
    public final int continueState = 3;
    public final int endState = 4;
    public final int dialogueState = 5;



    public GamePanel() {

        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    public void setupGame() {
        playMusic(0);
        gameState = titleState;
        stage.currentStage = stage.firstStage;
        aSetter.setObject();
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

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    public void run() {

        double drawInterval = 1e9 / FPS; //60 FPS
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        double collideCD = 0;

        while (gameThread != null) {
            currentTime = System.nanoTime();
            double d = currentTime - lastTime;
            delta += (d) / drawInterval;
            lastTime = currentTime;

            //Temporary invisibility during collision
            if (!player.newCollision) {
                collideCD += (d / 1e9);
            }
            if (collideCD >= 1) {
                player.newCollision = true;
                collideCD = 0;
            }
            if (delta >= 1) {
                update();
                repaint();
                delta--;
            }
        }
    }


    public void update() {
        if (gameState == playState) {
            player.update();
            for (int i = 0; i < monster.length; i++) {
                if (monster[i] != null) {
                    monster[i].update();
                }
            }
            for(int i =0; i<projectileList.size(); i++){
                if(projectileList.get(i) !=null){
                    if(projectileList.get(i).alive == true){
                        projectileList.get(i).update();
                    }
                    if(projectileList.get(i).alive == false){
                        projectileList.remove(i);
                    }
                }
            }
            stage.checkStage();
        }

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        // Title Screen
        if (gameState == titleState) {
            ui.draw(g2);
        } else if (gameState == continueState) { //Continue Screen
            ui.draw(g2);
        } else if (gameState == endState) { //END Screen
            ui.draw(g2);
        } else {
            // Draw Tiles
            tileM.draw(g2);
            // Draw Objects
            for (int i = 0; i < obj.length; i++) {
                if (obj[i] != null) {
                    obj[i].draw(g2, this);
                }
            }
            // Draw Monsters
            for (int i = 0; i < monster.length; i++) {
                if (monster[i] != null) {
                    monster[i].draw(g2);
                }
            }

            //Entity List\
            entityList.clear();
            for (int i = 0; i < projectileList.size(); i++){
                if(projectileList.get(i) !=null){
                    entityList.add(projectileList.get(i));
                }
            }
            // Draw Player
            player.draw(g2);

            //Draw entity
            for(int i = 0; i <entityList.size(); i++){
                if(entityList.get(i) !=null) {
                    entityList.get(i).draw(g2);
                }
            }


            // Draw UI
            ui.draw(g2);
        }
        g2.dispose();
    }
}
