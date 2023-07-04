package animations;

import main.DemoPanel;

import java.awt.*;

public class Scene2 extends Scene{
    public Scene2(DemoPanel dp){
        this.dp = dp;
        configuration1();
    }

    public void configuration1() {
        balls.clear();
        balls.add(new Ball(this.collisionChecker,this.dp, 100,100,20,2,200,spriteLoader.ballRed,2));
        balls.add(new Ball(this.collisionChecker,this.dp, 200,200,20,4,30,spriteLoader.ballRed,2));
        balls.add(new Ball(this.collisionChecker,this.dp, 300,200,20,6,30,spriteLoader.ballRed,2));
        balls.add(new Ball(this.collisionChecker,this.dp, 400,300,20,5,30,spriteLoader.ballRed,2));
        balls.add(new Ball(this.collisionChecker,this.dp, 500,100,20,2,200,spriteLoader.ballBlue,2));
        balls.add(new Ball(this.collisionChecker,this.dp, 600,200,20,4,30,spriteLoader.ballBlue,2));
        balls.add(new Ball(this.collisionChecker,this.dp, 700,200,20,6,30,spriteLoader.ballBlue,2));
        balls.add(new Ball(this.collisionChecker,this.dp, 750,300,20,5,30,spriteLoader.ballBlue,2));
        myConfigState = ConfigState.CONFIG1;
    }

    public void configuration2() {
        balls.clear();
        balls.add(new Ball(this.collisionChecker,this.dp, 100,100,20,4,200,spriteLoader.ballGreen,5));
        balls.add(new Ball(this.collisionChecker,this.dp, 500,200,20,4,30,spriteLoader.ballGreen,5));
        balls.add(new Ball(this.collisionChecker,this.dp, 200,200,20,4,30,spriteLoader.ballGreen,5));
        balls.add(new Ball(this.collisionChecker,this.dp, 300,300,20,2,30,spriteLoader.ballGreen,5));
        balls.add(new Ball(this.collisionChecker,this.dp, 100,100,30,4,200,spriteLoader.ballBlue,5));
        balls.add(new Ball(this.collisionChecker,this.dp, 500,200,30,4,30,spriteLoader.ballBlue,5));
        balls.add(new Ball(this.collisionChecker,this.dp, 200,200,30,4,30,spriteLoader.ballBlue,5));
        balls.add(new Ball(this.collisionChecker,this.dp, 300,300,30,2,30,spriteLoader.ballBlue,5));
        myConfigState = ConfigState.CONFIG2;
    }

    public void configuration3() {
        balls.clear();
        balls.add(new Ball(this.collisionChecker,this.dp, 100,100,20,4,200,spriteLoader.ballYellow,1));
        balls.add(new Ball(this.collisionChecker,this.dp, 500,200,20,4,30,spriteLoader.ballYellow,1));
        balls.add(new Ball(this.collisionChecker,this.dp, 200,200,30,4,30,spriteLoader.ballRed,1));
        balls.add(new Ball(this.collisionChecker,this.dp, 300,300,30,4,30,spriteLoader.ballRed,3));
        balls.add(new Ball(this.collisionChecker,this.dp, 100,100,30,4,200,spriteLoader.ballRed,3));
        balls.add(new Ball(this.collisionChecker,this.dp, 500,200,40,4,30,spriteLoader.ballGreen,3));
        balls.add(new Ball(this.collisionChecker,this.dp, 200,200,40,4,30,spriteLoader.ballGreen,5));
        balls.add(new Ball(this.collisionChecker,this.dp, 300,300,40,4,30,spriteLoader.ballGreen,5));
        myConfigState = ConfigState.CONFIG3;
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




