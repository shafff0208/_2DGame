package object;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class BASE_Inner extends SuperObject {

    GamePanel gp;

    public BASE_Inner(GamePanel gp) {

        this.gp = gp;

        name = "BASE Inner";
        try{

            image = ImageIO.read(getClass().getResourceAsStream("/base/Base1.png"));
            uTool.scaleImage(image, gp.tileSize, gp.tileSize);


        }catch (IOException e){
            e.printStackTrace();
        }
        collision = true;

    }
}