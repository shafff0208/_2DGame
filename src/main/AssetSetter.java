package main;

//import entity.Entity;
//import entity.MON_Rat;
import object.OBJ_Gun_Blue;
import object.OBJ_Life;
import object.OBJ_Sword;

public class AssetSetter {

    GamePanel gp;
    public AssetSetter(GamePanel gp){
        this.gp = gp;
    }

    public void setObject(){

        gp.obj[0] = new OBJ_Gun_Blue(gp);
        gp.obj[0].worldX = 6 * gp.tileSize;
        gp.obj[0].worldY = 5 * gp.tileSize;

        gp.obj[2] = new OBJ_Sword(gp);
        gp.obj[2].worldX = 22 * gp.tileSize;
        gp.obj[2].worldY = 8 * gp.tileSize;

        gp.obj[3] = new OBJ_Life(gp);
        gp.obj[3].worldX = 6 * gp.tileSize;
        gp.obj[3].worldY = 19 * gp.tileSize;

    }

//    public void setMON(){
//        gp.rat[0] = new MON_Rat(gp);
//        gp.rat[0].worldX = 22 * gp.tileSize;
//        gp.rat[0].worldY = 8 * gp.tileSize;
//    }
}
