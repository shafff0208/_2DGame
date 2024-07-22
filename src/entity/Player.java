package entity;

import main.GamePanel;
import main.KeyHandler;
import object.OBJ_Projectile_Blue;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;


public class Player extends Entity{

    GamePanel gp;
    KeyHandler keyH;
    public final int screenX;
    public final int screenY;
    private boolean hasGun = false;
    private int currentWeapon = 0;
    int hasSword = 0;

    public boolean newCollision = true;

    public Player (GamePanel gp, KeyHandler keyH){

        super(gp);
        this.gp = gp;
        this.keyH = keyH;

        screenX = gp.screenWidth/2 - (gp.tileSize/2);
        screenY = gp.screenHeight/2 - (gp.tileSize/2);

        setDefaultValues();
        getPlayerImage();

        solidArea = new Rectangle();
        solidArea.x = 8;
        solidArea.y = 16;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        solidArea.height = 32;
        solidArea.width = 32;
    }

    public void setDefaultValues(){

        //Player Status
        speed = 4;
        direction = "right";
        maxLife = 5;
        life = maxLife;
        projectile = new OBJ_Projectile_Blue(gp);
    }

    public void getPlayerImage(){
        if (currentWeapon == 1) {
            //Sprites player with blue gun
            up1 = setup("/player/PlayerBlueGun_Up");
            up2 = setup("/player/PlayerBlueGun_Up");
            down1 = setup("/player/PlayerBlueGun_Down");
            down2 = setup("/player/PlayerBlueGun_Down");
            left1 = setup("/player/PlayerBlueGun_Left");
            left2 = setup("/player/PlayerBlueGun_Left");
            right1 = setup("/player/PlayerBlueGun_Right");
            right2 = setup("/player/PlayerBlueGun_Right");
        }else{
            //Default player sprites
            up1 = setup("/player/Player_Up1");
            up2 = setup("/player/Player_Up2");
            down1 = setup("/player/Player_Down1");
            down2 = setup("/player/Player_Down2");
            left1 = setup("/player/Player_Left1");
            left2 = setup("/player/Player_Left2");
            right1 = setup("/player/Player_Right1");
            right2 = setup("/player/Player_Right2");
        }
    }



    public void setupPlayer(){
        if(gp.stage.currentStage == gp.stage.firstStage){

            worldX= gp.tileSize * 8;
            worldY= gp.tileSize * 16;

        }else if (gp.stage.currentStage == gp.stage.secondStage){

            worldX= gp.tileSize * 40;
            worldY= gp.tileSize * 12;

        }else if (gp.stage.currentStage == gp.stage.thirdStage){
            worldX= gp.tileSize * 26;
            worldY= gp.tileSize * 27;
        }

        //RESET PLAYER LIFE EVERY NEW STAGE
        gp.player.life = maxLife;

//        //DEBUG
//        System.out.println(STR."X: \{worldX} Y: \{worldY}");

    }
    public void weaponButtonPress(int button){
        if (button == 1 && hasGun){
            currentWeapon = 1; // Equip blue gun
        }else{
            currentWeapon = 0; // Unequip weapon
        }
        getPlayerImage();
    }

    public void update(){

        if (keyH.upPressed == true || keyH.downPressed == true ||
                keyH.leftPressed == true || keyH.rightPressed == true){

            if (keyH.upPressed == true) {
                direction = "up";

            } else if (keyH.downPressed == true) {
                direction = "down";

            } else if (keyH.leftPressed == true) {
                direction = "left";

            } else if (keyH.rightPressed == true) {
                direction = "right";

            }


            //Check Tile Collision
            collisionOn = false;
            gp.cDetection.checkTile(this);

            //Check Obj Collision
            int objIndex = gp.cDetection.checkObject(this, true);
            pickUpObj(objIndex);

            //Check Entity Collision
            int monIndex = gp.cDetection.checkEntity(this, gp.monster);
            interactMON(monIndex);


            if(collisionOn == false){
                switch (direction){
                    case "up": worldY -= speed;
                        break;
                    case "down": worldY += speed;
                        break;
                    case "left": worldX -= speed;
                        break;
                    case "right": worldX += speed;
                        break;

                }
            }

            spriteCounter++;
            if (spriteCounter > 12){
                if (spriteNum == 1){
                    spriteNum = 2;
                }else if (spriteNum == 2){
                    spriteNum =1;
                }
                spriteCounter = 0;
            }
        }
        if( currentWeapon == 1 && gp.keyH.shootKeyPressed == true && projectile.alive == false && shotAvailableCounter == 30 && hasGun == true ){


            projectile.set(worldX, worldY, direction, true);

            gp.projectileList.add(projectile);

            shotAvailableCounter= 0;

            gp.playSE(10);
        }

        if(shotAvailableCounter < 30){
            shotAvailableCounter++;
        }
    }

    public void pickUpObj(int i){
        if(i != 999){
            String objectName = gp.obj[i].name;
            switch (objectName){
                case "Normal Gun":
                    gp.playSE(4);
                    hasGun = true;
                    currentWeapon = 1;
                    gp.obj[i] = null;
                    gp.ui.showMessage("+1 Normal Gun");
                    getPlayerImage();

                    break;

                case "XCALIBA" :
                    gp.playSE(4);
                    hasSword++;
                    gp.obj[i] = null;
                    gp.ui.showMessage("+1 XCALIBA");
                    break;

                case "Life":
                    gp.playSE(3);
                    life++;
                    gp.obj[i] = null;
                    gp.ui.showMessage("+1 life");

                    break;

            }
        }
    }

    public void interactMON(int i){
        if(i != 999){
            gp.playSE(7);
            System.out.println("Collision!");
            // if player enter new collision, reduce HP
            if (newCollision) {
                life--;
                newCollision = false;
            }
        }
    }

    public void damageMonster(int i, int attack){
        if(i != 999){
            System.out.println("Hit!");
        }else{
            System.out.println("Miss!");
        }
    }

    public void draw(Graphics2D g2){

        BufferedImage image = null;
        switch (direction){
            case "up":
                if (spriteNum == 1){
                    image = up1;
                }
                if (spriteNum == 2){
                    image = up2;
                }
                break;
            case "down":
                if (spriteNum == 1){
                    image = down1;
                }
                if (spriteNum == 2){
                    image = down2;
                }
                break;
            case "left":
                if (spriteNum == 1){
                    image = left1;
                }
                if (spriteNum == 2){
                    image = left2;
                }
                break;
            case "right":
                if (spriteNum == 1){
                    image = right1;
                }
                if (spriteNum == 2){
                    image = right2;
                }
                break;
        }
        g2.drawImage(image, screenX, screenY, null);

    }

    public Rectangle getBounds() {
        return new Rectangle(gp.player.worldX, gp.player.worldY, gp.tileSize, gp.tileSize);
    }

    public boolean isHasGun(){
        return hasGun;
    }

    public void setCurrentWeapon(int weapon){
        currentWeapon = weapon;
        getPlayerImage();
    }
}
