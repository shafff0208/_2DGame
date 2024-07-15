package entity;

import main.GamePanel;
import java.util.Random;

public class MON_MutantTreant extends Entity {

    GamePanel gp;


    public MON_MutantTreant (GamePanel gp){

        super(gp);
        this.gp = gp;

        type = 1;
        name = "MutantTreant";
        direction = "right";
        speed= 1;
        maxLife = 5;
        life = maxLife;
        
        getImage();
        setAction();

    }

    public void getImage(){

        up1 = setup("/monster/MutantTreant_Up1");
        up2 = setup("/monster/MutantTreant_Up2");
        down1 = setup("/monster/MutantTreant_Down1");
        down2 = setup("/monster/MutantTreant_Down2");
        left1 = setup("/monster/MutantTreant_Left1");
        left2 = setup("/monster/MutantTreant_Left2");
        right1 = setup("/monster/MutantTreant_Right1");
        right2 = setup("/monster/MutantTreant_Right2");
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
