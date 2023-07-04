package animations;

import main.DemoPanel;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public abstract class Scene {

    DemoPanel dp;
    public ConfigState myConfigState;

    SpriteLoader spriteLoader = SpriteLoader.getInstance();
    List<Ball> balls = new ArrayList<>();
    CollisionChecker collisionChecker = new CollisionChecker(balls);
    public abstract void configuration1();
    public abstract void configuration2();
    public abstract void configuration3();
    public abstract void update();
    public abstract void draw(Graphics2D g2);

}
