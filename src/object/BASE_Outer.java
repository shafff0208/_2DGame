package object;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class BASE_Outer extends SuperObject {

    GamePanel gp;

    public BASE_Outer(GamePanel gp) {

        this.gp = gp;

        name = "BASE Outer";
        try{

            image = ImageIO.read(getClass().getResourceAsStream("/base/Base0.png"));
            uTool.scaleImage(image, gp.tileSize, gp.tileSize);


        }catch (IOException e){
            e.printStackTrace();
        }
        collision = true;

    }
}
