package object;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_CORE1 extends SuperObject {

    GamePanel gp;

    public OBJ_CORE1(GamePanel gp) {

        this.gp = gp;

        name = "Core 1";
        try{

            image = ImageIO.read(getClass().getResourceAsStream("/objects/Purifier1_Base.png"));
            uTool.scaleImage(image, gp.tileSize, gp.tileSize);


        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
