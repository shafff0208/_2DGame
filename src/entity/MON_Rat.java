//package entity;
//
//import main.GamePanel;
//
//import java.awt.*;
//import java.awt.image.BufferedImage;
//import java.util.Random;
//
//public class MON_Rat extends Entity {
//
//    GamePanel gp;
//
//
//    public MON_Rat (GamePanel gp){
//
//        super(gp);
//
//        this.gp = gp;
//
//        name= "Rat";
//        direction = "down";
//        speed= 3;
//        maxLife = 2;
//        life = maxLife;
//
//        getImage();
//        setAction();
//
//    }
//
//    public void getImage(){
//
//        up1 = setup("/monster/Rat_0");
//        up2 = setup("/monster/Rat_1");
//        down1 = setup("/monster/Rat_0");
//        down2 = setup("/monster/Rat_1");
//        left1 = setup("/monster/Rat_0");
//        left2 = setup("/monster/Rat_1");
//        right1 = setup("/monster/Rat_0");
//        right2 = setup("/monster/Rat_1");
//    }
//
//    public void setAction(){
//
//        actionLockCounter ++;
//        if(actionLockCounter == 120){
//
//            Random random = new Random();
//            int i = random.nextInt(100) + 1;
//
//            if (i <= 25){
//                direction = "up";
//            }if (i > 25 && i < 50){
//                direction = "down";
//            }if (i > 50 && i < 75){
//                direction = "right";
//            }if (i > 75 && i < 100){
//                direction = "left";
//            }
//
//            actionLockCounter = 0;
//
//        }
//
//
//
//    }
//
//    public void draw(Graphics2D g2){
//
//        BufferedImage image = null;
//        switch (direction){
//            case "up":
//                if (spriteNum == 1){
//                    image = up1;
//                }
//                if (spriteNum == 2){
//                    image = up2;
//                }
//                break;
//            case "down":
//                if (spriteNum == 1){
//                    image = down1;
//                }
//                if (spriteNum == 2){
//                    image = down2;
//                }
//                break;
//            case "left":
//                if (spriteNum == 1){
//                    image = left1;
//                }
//                if (spriteNum == 2){
//                    image = left2;
//                }
//                break;
//            case "right":
//                if (spriteNum == 1){
//                    image = right1;
//                }
//                if (spriteNum == 2){
//                    image = right2;
//                }
//                break;
//        }
//        g2.drawImage(image, worldX, worldY, null);
//
//    }
//}
