package objects;
import main.GamePanel;
import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_Life extends SuperObject{
    GamePanel gp;
    public OBJ_Life(GamePanel gp){

        this.gp = gp;

        name= "Life";

        try{
            image = ImageIO.read(getClass().getResourceAsStream("/LifeBar/LifeBar_00.png"));
            image2 = ImageIO.read(getClass().getResourceAsStream("/LifeBar/LifeBar_02.png"));
            image3 = ImageIO.read(getClass().getResourceAsStream("/LifeBar/LifeBar_04.png"));
            image4 = ImageIO.read(getClass().getResourceAsStream("/LifeBar/LifeBar_06.png"));
            image5 = ImageIO.read(getClass().getResourceAsStream("/LifeBar/LifeBar_08.png"));
            image6 = ImageIO.read(getClass().getResourceAsStream("/LifeBar/LifeBar_10.png"));
            image7 = ImageIO.read(getClass().getResourceAsStream("/LifeBar/Heart.png"));

            image = uTool.scaleImage(image, gp.tileSize*2, gp.tileSize*2);
            image2 = uTool.scaleImage(image2, gp.tileSize*2, gp.tileSize*2);
            image3 = uTool.scaleImage(image3, gp.tileSize*2, gp.tileSize*2);
            image4 = uTool.scaleImage(image4, gp.tileSize*2, gp.tileSize*2);
            image5 = uTool.scaleImage(image5, gp.tileSize*2, gp.tileSize*2);
            image6 = uTool.scaleImage(image6, gp.tileSize*2, gp.tileSize*2);
            image7 = uTool.scaleImage(image7, gp.tileSize*2, gp.tileSize*2);

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}