package entity;

import main.GamePanel;
import java.util.Random;

public class MON_Worm extends Entity {

    GamePanel gp;


    public MON_Worm (GamePanel gp){

        super(gp);
        this.gp = gp;

        type = 1;
        name= "Worm";
        direction = "right";
        speed= 2;
        maxLife = 2;
        life = maxLife;

        getImage();
        setAction();

    }

    public void getImage(){

        up1 = setup("/monster/Worm_Up1");
        up2 = setup("/monster/Worm_Up2");
        down1 = setup("/monster/Worm_Down1");
        down2 = setup("/monster/Worm_Down2");
        left1 = setup("/monster/Worm_Left1");
        left2 = setup("/monster/Worm_Left2");
        right1 = setup("/monster/Worm_Right1");
        right2 = setup("/monster/Worm_Right2");
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
