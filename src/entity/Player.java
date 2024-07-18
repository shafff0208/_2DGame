package entity;

import main.GamePanel;
import main.KeyHandler;
import java.awt.*;
import java.awt.image.BufferedImage;


public class Player extends Entity{

    GamePanel gp;
    KeyHandler keyH;
    public final int screenX;
    public final int screenY;
    int hasGun = 0;
    int hasSword = 0;

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

//        //Player position
//        worldX= gp.tileSize * 26;
//        worldY= gp.tileSize * 27;

        //Player Status
        speed = 4;
        direction = "right";
        maxLife = 5;
        life = maxLife;
    }

    public void getPlayerImage(){

        up1 = setup("/player/Player_Up1");
        up2 = setup("/player/Player_Up2");
        down1 = setup("/player/Player_Down1");
        down2 = setup("/player/Player_Down2");
        left1 = setup("/player/Player_Left1");
        left2 = setup("/player/Player_Left2");
        right1 = setup("/player/Player_Right1");
        right2 = setup("/player/Player_Right2");

    }

    public void setupPlayerPos(){
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
//        //DEBUG
//        System.out.println(STR."X: \{worldX} Y: \{worldY}");

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

    }

    public void pickUpObj(int i){
        if(i != 999){
            String objectName = gp.obj[i].name;
            switch (objectName){
                case "Normal Gun":
                    gp.playSE(4);
                    hasGun++;
                    gp.obj[i] = null;
                    gp.ui.showMessage("+1 Normal Gun");

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

}
