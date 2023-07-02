package animations;

import java.util.List;
import java.lang.Math;

import static java.lang.Math.abs;


public class CollisionChecker {

    List<Ball> balls;
    public CollisionChecker(List<Ball> balls){
        this.balls = balls;
    }


    public void collisionChecker(Ball b1, Ball b2) {
        // multiple ball collisions.

        float distX = b2.xPos - b1.xPos;
        float distY = b2.yPos - b1.yPos;
        float dist = (float) Math.sqrt(distX*distX + distY*distY);

        if(dist < b1.radius + b2.radius){
            float angle = (float) Math.atan2(distY,distX);
            float sin = (float) Math.sin(angle);
            float cos = (float) Math.cos(angle);

            float x1 = 0, y1 = 0;
            float x2 = distX * cos + distY * sin;
            float y2 = distY * cos - distX * sin;

            //rotate velocity
            float xSpeed1 = b1.xSpeed * cos + b1.ySpeed * sin;
            float ySpeed1 = b1.ySpeed * cos - b1.xSpeed * sin;
            float xSpeed2 = b2.xSpeed * cos + b2.ySpeed * sin;
            float ySpeed2 = b2.ySpeed * cos - b2.xSpeed * sin;

            //resolve the 1D case
            float xSpeed1Final = ((b1.mass-b2.mass)*xSpeed1 + 2*b2.mass*xSpeed2) / (b1.mass+b2.mass);
            float xSpeed2Final = ((b2.mass-b1.mass)*xSpeed2 + 2*b1.mass*xSpeed1) / (b1.mass+b2.mass);

            xSpeed1 = xSpeed1Final;
            xSpeed2 = xSpeed2Final;

            // fix the glitch by moving ball part equal to the overlap
            float absV = Math.abs(xSpeed1) + Math.abs(xSpeed2);
            float overlap = (b1.radius + b2.radius)- Math.abs(x1-x2);
            x1 += xSpeed1/absV*overlap;
            x2 += xSpeed2/absV*overlap;

            // rotate the relative positions back
            float x1final = x1*cos-y1*sin;
            float y1final = y1*cos+x1*sin;
            float x2final = x2*cos-y2*sin;
            float y2final = y2*cos+x2*sin;

            // finally compute the new absolute positions
            b2.xPos = b1.xPos + x2final;
            b2.yPos = b1.yPos + y2final;

            b1.xPos = b1.xPos + x1final;
            b1.yPos = b1.yPos + y1final;

            //rotate vel back
            b1.xSpeed = xSpeed1*cos-ySpeed1*sin;
            b1.ySpeed = ySpeed1*cos+xSpeed1*sin;
            b2.xSpeed = xSpeed2*cos-ySpeed2*sin;
            b2.ySpeed = ySpeed2*cos+xSpeed2*sin;



        }

    }
}
