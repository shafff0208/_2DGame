package entity;

import main.GamePanel;
import java.util.Random;

public class MON_Rat extends Entity {

    GamePanel gp;


    public MON_Rat (GamePanel gp){

        super(gp);
        this.gp = gp;

        type = 1;
        name= "Rat";
        direction = "right";
        speed= 4;
        maxLife = 2;
        life = maxLife;

        getImage();
        setAction();

    }

    public void getImage(){

        up1 = setup("/monster/Rat_6");
        up2 = setup("/monster/Rat_7");
        down1 = setup("/monster/Rat_4");
        down2 = setup("/monster/Rat_5");
        left1 = setup("/monster/Rat_2");
        left2 = setup("/monster/Rat_3");
        right1 = setup("/monster/Rat_0");
        right2 = setup("/monster/Rat_1");
    }

    public void setAction(){

        actionLockCounter ++;
        if(actionLockCounter == 120){

            Random random = new Random();
            int i = random.nextInt(100) + 1;

            if (i <= 25){
                direction = "up";
            }if (i > 25 && i < 50){
                direction = "down";
            }if (i > 50 && i < 75){
                direction = "right";
            }if (i > 75 && i < 100){
                direction = "left";
            }

            actionLockCounter = 0;

        }


    }

}
