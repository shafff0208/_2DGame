package object;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_Gun_Blue extends SuperObject {

    GamePanel gp;

    public OBJ_Gun_Blue(GamePanel gp) {

        this.gp = gp;

        name = "Normal Gun";
        try{

            image = ImageIO.read(getClass().getResourceAsStream("/objects/Gun_Blue.png"));
            uTool.scaleImage(image, gp.tileSize, gp.tileSize);


        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
