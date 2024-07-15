package object;

import entity.Projectiles;
import main.GamePanel;

public class OBJ_Projectile_Blue extends Projectiles {

    GamePanel gp;
    public OBJ_Projectile_Blue(GamePanel gp) {
        super(gp);
        this.gp = gp;
        name = "Projectile Blue";
        speed = 5;
        maxLife = 80;
        life = maxLife;
        getImage();
    }

    public void getImage(){
        up1 = setup("/projectiles/projectiles_down");
        down1 = setup("/projectiles/projectiles_down");
        left1 = setup("/projectiles/projectile_left");
        right1 = setup("/projectiles/projectile_right");

    }
}
