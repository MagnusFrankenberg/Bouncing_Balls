package animations;

import main.DemoPanel;

import java.awt.*;

public class Scene1 extends Scene{

    public Scene1(DemoPanel dp){
        this.dp = dp;
    }

    @Override
    public void configuration1() {
        balls.add(new Ball(this.collisionChecker,this.dp, 200,100,spriteLoader.ballRed,5, 5,5));
        balls.add(new Ball(this.collisionChecker,this.dp, 200,200,spriteLoader.ballGreen,5, 5,5));
    }


    @Override
    public void update() {
        balls.forEach(b->b.update());


    }

    @Override
    public void draw(Graphics2D g2) {
        balls.forEach(b->b.draw(g2));


    }
}
