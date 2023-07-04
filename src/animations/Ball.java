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
    public float xSpeed;
    public float ySpeed;

    public float xPos;
    public float yPos;
    public float radius;
    public float mass;

    DemoPanel dp;
    List<BufferedImage> myBall;

    int maxY;
    int maxX;

    public Ball(CollisionChecker collisionChecker,DemoPanel dp, float xPos, float yPos,float radius, float speed, float angleInDegree, List<BufferedImage> myBall, int flashSpeed){
        this.collisionChecker = collisionChecker;
        this.dp = dp;
        this.xPos = xPos+radius;
        this.yPos = yPos+radius;
        this.radius = radius;
        this.xSpeed = (float)(speed * Math.cos(Math.toRadians(angleInDegree)));
        this.ySpeed = (float)(-speed * (float)Math.sin(Math.toRadians(angleInDegree)));
        this.myBall = new ArrayList<>(myBall);
        this.flashSpeed = flashSpeed;
        this.maxY = dp.dpHeight;
        this.maxX = dp.dpWidth;
        this.mass = radius*radius;
    }


    public void calculatePosition(){

        if(yPos + radius > maxY){
            yPos=maxY-radius;
            ySpeed = - ySpeed;
        }
        if(yPos < radius) {
            yPos=radius;
            ySpeed = - ySpeed;
        }
        if(xPos + radius > maxX){
            xPos=maxX-radius;
            xSpeed = - xSpeed;
        }
        if(xPos < radius) {
            xPos=radius;
            xSpeed = - xSpeed;
        }

        xPos += xSpeed;
        yPos += ySpeed;

        // collisionChecker.collisionChecker();

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
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

        image = myBall.get(spriteNum);
        g2.drawImage(image,(int)(xPos-radius),(int)(yPos-radius),(int)(2*radius),(int)(2*radius),null);
    }
}
