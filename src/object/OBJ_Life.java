package object;
import main.GamePanel;
import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_Life extends SuperObject{
    GamePanel gp;
    public OBJ_Life(GamePanel gp){

        this.gp = gp;

        name= "Life";

        try{
            image = ImageIO.read(getClass().getResourceAsStream("/life/Heart.png"));
            image = uTool.scaleImage(image, gp.tileSize*2, gp.tileSize*2);

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}