package entity;

import main.GamePanel;

public class Scientist extends Entity {

    GamePanel gp;
    public String[] dialogue = new String[20];
    public int dialogueIndex = 0;
    public boolean scientistON = true;
    public int desperateCounter = 0;


    public Scientist (GamePanel gp){

        super(gp);
        this.gp = gp;

        name = "Scientist";
        direction = "left";

        getImage();
        setDialogue();

    }

    public void getImage(){

        up1 = setup("/scientist/Scientist_Up1");
        up2 = setup("/scientist/Scientist_Up2");
        down1 = setup("/scientist/Scientist_Down1");
        down2 = setup("/scientist/Scientist_Down2");
        left1 = setup("/scientist/Scientist_Left1");
        left2 = setup("/scientist/Scientist_Left2");
        right1 = setup("/scientist/Scientist_Right1");
        right2 = setup("/scientist/Scientist_Right2");
    }

    public void setDialogue(){

        dialogue[0] = "Hello good sir, I am a humble genius" + "\n" + "scientist would you like some assistance?";
        dialogue[1] = "I see you appreciate my assistance.." + "\n" + "do you want my assistance again?";
        dialogue[2] = "HAHAHAHA, you must be really weak!" + "\n" + "I will offer you my assistance!";
        dialogue[3] = "Please accept my assistance, you will need" + "\n" + "it. You will face strong enemies ahead";
        dialogue[4] = "You will regret not taking my assistance" + "\n" + "I offer you my assistance!";
        dialogue[5] = "Please accept my assistance, don't kill me "+ "\n" + "hehehe... HAHAHAHAHA!";
    }

    public void speak(){

        if(desperateCounter == 1){
            dialogueIndex = 3;
        }
        if(desperateCounter == 2){
            dialogueIndex = 5;
        }
        if(dialogue[dialogueIndex] == null){
            dialogueIndex = 0;
        }
        gp.ui.currentDialogue = dialogue[dialogueIndex];
        dialogueIndex++;
    }

    public void buffPlayer(){
        gp.player.speed++;
        gp.player.life = 10;

        if(gp.stage.currentStage == gp.stage.secondStage){
            gp.player.life = 20;
        }
        else if(gp.stage.currentStage == gp.stage.thirdStage){
            gp.player.life = 99999;
        }

    }

    public void resetBuff(){
        gp.player.speed = 4;
        gp.player.life = 5;
    }
}
