package animations;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SpriteLoader {

    private static SpriteLoader instance;

    public List<BufferedImage> ballGreen = new ArrayList<>();
    public List<BufferedImage> ballBlue = new ArrayList<>();
    public List<BufferedImage> ballRed = new ArrayList<>();
    public List<BufferedImage> ballYellow = new ArrayList<>();

    private SpriteLoader(){
        loadSprites();
    }

    public static SpriteLoader getInstance(){
        if(instance == null){
            instance = new SpriteLoader();
        }
        return instance;
    }

    public void loadSprites(){
        try{

            ballGreen.add(ImageIO.read(getClass().getClassLoader().getResourceAsStream("Green01/Green_0.png")));
            ballGreen.add(ImageIO.read(getClass().getClassLoader().getResourceAsStream("Green01/Green_1.png")));
            ballGreen.add(ImageIO.read(getClass().getClassLoader().getResourceAsStream("Green01/Green_2.png")));
            ballGreen.add(ImageIO.read(getClass().getClassLoader().getResourceAsStream("Green01/Green_3.png")));
            ballGreen.add(ImageIO.read(getClass().getClassLoader().getResourceAsStream("Green01/Green_4.png")));

            ballBlue.add(ImageIO.read(getClass().getClassLoader().getResourceAsStream("Blue01/Blue_0.png")));
            ballBlue.add(ImageIO.read(getClass().getClassLoader().getResourceAsStream("Blue01/Blue_1.png")));
            ballBlue.add(ImageIO.read(getClass().getClassLoader().getResourceAsStream("Blue01/Blue_2.png")));
            ballBlue.add(ImageIO.read(getClass().getClassLoader().getResourceAsStream("Blue01/Blue_3.png")));
            ballBlue.add(ImageIO.read(getClass().getClassLoader().getResourceAsStream("Blue01/Blue_4.png")));

            ballRed.add(ImageIO.read(getClass().getClassLoader().getResourceAsStream("Red01/Red_0.png")));
            ballRed.add(ImageIO.read(getClass().getClassLoader().getResourceAsStream("Red01/Red_1.png")));
            ballRed.add(ImageIO.read(getClass().getClassLoader().getResourceAsStream("Red01/Red_2.png")));
            ballRed.add(ImageIO.read(getClass().getClassLoader().getResourceAsStream("Red01/Red_3.png")));
            ballRed.add(ImageIO.read(getClass().getClassLoader().getResourceAsStream("Red01/Red_4.png")));

            ballYellow.add(ImageIO.read(getClass().getClassLoader().getResourceAsStream("Yellow01/Yellow_0.png")));
            ballYellow.add(ImageIO.read(getClass().getClassLoader().getResourceAsStream("Yellow01/Yellow_1.png")));
            ballYellow.add(ImageIO.read(getClass().getClassLoader().getResourceAsStream("Yellow01/Yellow_2.png")));
            ballYellow.add(ImageIO.read(getClass().getClassLoader().getResourceAsStream("Yellow01/Yellow_3.png")));
            ballYellow.add(ImageIO.read(getClass().getClassLoader().getResourceAsStream("Yellow01/Yellow_4.png")));


        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
