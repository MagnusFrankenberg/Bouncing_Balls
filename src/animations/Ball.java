package animations;

import main.DemoPanel;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ball {

    CollisionChecker collisionChecker;
    public int spriteCounter = 0;
    public int spriteNum = 0;
    int flashSpeed;
    int xVelocity;
    int yVelocity;

    public int xPos;
    public int yPos;

    public int xDir = +1;
    public int yDir = +1;

    DemoPanel dp;
    List<BufferedImage> myBall;

    public void calculatePosition(){
        int minY = 0;
        int maxY = 430;
        int minX = 0;
        int maxX = 750;

        if(yPos>maxY){
            yDir=-1;
            yVelocity=randomizeVelocity(yVelocity);
            xVelocity=randomizeVelocity(xVelocity);
        }
        if(yPos<minY) {
            yDir=+1;
            yVelocity=randomizeVelocity(yVelocity);
            xVelocity=randomizeVelocity(xVelocity);
        }
        if(xPos>maxX){
            xDir=-1;
            yVelocity=randomizeVelocity(yVelocity);
            xVelocity=randomizeVelocity(xVelocity);
        }
        if(xPos<minX) {
            xDir=+1;
            yVelocity=randomizeVelocity(yVelocity);
            xVelocity=randomizeVelocity(xVelocity);
        }

        xPos += xDir*xVelocity;
        yPos += yDir*yVelocity;

        collisionChecker.collisionChecker();

    }

    public int randomizeVelocity(int velocity){
        int velocityNew = velocity + new Random().nextInt(-2,3);
        velocityNew = Math.min(8, Math.max(3, velocityNew));
        return velocityNew;
    }



    public Ball(CollisionChecker collisionChecker,DemoPanel dp, int x, int y, List<BufferedImage> myBall, int flashSpeed, int xVelocity,int yVelocity){
        this.collisionChecker = collisionChecker;
        this.dp = dp;
        this.xPos = x;
        this.yPos = y;
        this.myBall = new ArrayList<>(myBall);
        this.flashSpeed = flashSpeed;
        this.xVelocity = xVelocity;
        this.yVelocity = yVelocity;
    }

    public void update(){
        spriteCounter++;
        if(spriteCounter > flashSpeed){
            spriteNum++;
            if(spriteNum>4){
                spriteNum=0;
            }
            spriteCounter = 0;
        }
        calculatePosition();
        }





    public void draw(Graphics2D g2){
        BufferedImage image = null;

        image = myBall.get(spriteNum);
        g2.drawImage(image,xPos,yPos,48,48,null);
    }
}
