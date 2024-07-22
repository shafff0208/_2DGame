package object;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_CORE2 extends SuperObject {

    GamePanel gp;

    public OBJ_CORE2(GamePanel gp) {

        this.gp = gp;

        name = "Core 2";
        try{

            image = ImageIO.read(getClass().getResourceAsStream("/objects/Purifier2_Heart.png"));
            uTool.scaleImage(image, gp.tileSize, gp.tileSize);


        }catch (IOException e){
            e.printStackTrace();
        }

    }
}

