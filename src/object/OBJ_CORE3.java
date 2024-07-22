package object;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_CORE3 extends SuperObject {

    GamePanel gp;

    public OBJ_CORE3(GamePanel gp) {

        this.gp = gp;

        name = "Core 3";
        try{

            image = ImageIO.read(getClass().getResourceAsStream("/objects/Purifier3_Activator.png"));
            uTool.scaleImage(image, gp.tileSize, gp.tileSize);


        }catch (IOException e){
            e.printStackTrace();
        }

    }
}

