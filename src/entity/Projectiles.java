package entity;

import main.GamePanel;

public class Projectiles extends Entity {

    public Projectiles(GamePanel gp){
        super(gp);
    }
    public void set(int worldX, int worldY, String direction, boolean alive){
        this.worldX = worldX;
        this.worldY = worldY;
        this.direction = direction;
        this.alive = alive;
        this.life = this.maxLife;
    }
    public void update(){

        int monIndex = gp.cDetection.checkEntity(this, gp.monster);
        if(monIndex != 999){
            gp.player.damageMonster(monIndex, attack);
            alive = false;
        }

        switch(direction){
            case"up": worldY -=speed; break;
            case "down": worldY +=speed; break;
            case "left": worldX -= speed; break;
            case "right": worldX += speed; break;
        }

        life--;
        if(life <= 0){
            alive = false;
        }

        spriteCounter++;
        if(spriteCounter >12){
            if(spriteNum ==1){
                spriteNum = 2;
            }else if (spriteNum == 2){
                spriteNum = 1;
            }
            spriteCounter = 0;
        }
    }
}
