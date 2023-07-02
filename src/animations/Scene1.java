package animations;

import main.DemoPanel;

import java.awt.*;

public class Scene1 extends Scene{

    public Scene1(DemoPanel dp){
        this.dp = dp;
    }

    @Override
    public void configuration1() {
        balls.add(new Ball(this.collisionChecker,this.dp, 100,100,48,2,200,spriteLoader.ballRed,5));
        balls.add(new Ball(this.collisionChecker,this.dp, 500,200,24,2,30,spriteLoader.ballGreen,5));
        balls.add(new Ball(this.collisionChecker,this.dp, 200,200,70,4,30,spriteLoader.ballBlue,5));
        balls.add(new Ball(this.collisionChecker,this.dp, 300,300,12,2,30,spriteLoader.ballYellow,5));
    }


    @Override
    public void update() {
        balls.forEach(b->b.update());

        for(int i = 0; i < balls.size()-1;i++){
            for(int j = i+1; j< balls.size();j++){
                collisionChecker.collisionChecker(balls.get(i),balls.get(j));
            }
        }


    }

    @Override
    public void draw(Graphics2D g2) {
        balls.forEach(b->b.draw(g2));




    }
}
