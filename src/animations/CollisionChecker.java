package animations;

import java.util.List;

public class CollisionChecker {

    List<Ball> balls;
    public CollisionChecker(List<Ball> balls){
        this.balls = balls;
    }


    public void collisionChecker() {
        if ((Math.abs(balls.get(0).xPos - balls.get(1).xPos) < 24) && (Math.abs(balls.get(0).yPos - balls.get(1).yPos) < 24)) {

            if(balls.get(0).xVelocity>balls.get(0).yVelocity) {
                balls.get(0).xDir *= -1;
            }else{
                balls.get(0).yDir *= -1;
            }

            if(balls.get(1).xVelocity>balls.get(1).yVelocity) {
                balls.get(1).xDir *= -1;
            }else{
                balls.get(1).yDir *= -1;
            }
        }
    }
}
