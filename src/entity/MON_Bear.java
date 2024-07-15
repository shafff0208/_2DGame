package entity;

import main.GamePanel;
import java.util.Random;

public class MON_Bear extends Entity {

    GamePanel gp;


    public MON_Bear (GamePanel gp){

        super(gp);
        this.gp = gp;

        type = 1;
        name = "Bear";
        direction = "right";
        speed= 1;
        maxLife = 5;
        life = maxLife;

        getImage();
        setAction();

    }

    public void getImage(){

        up1 = setup("/monster/Bear_Up1");
        up2 = setup("/monster/Bear_Up2");
        down1 = setup("/monster/Bear_Down1");
        down2 = setup("/monster/Bear_Down2");
        left1 = setup("/monster/Bear_Left1");
        left2 = setup("/monster/Bear_Left2");
        right1 = setup("/monster/Bear_Right1");
        right2 = setup("/monster/Bear_Right2");
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
