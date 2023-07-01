package main;

import animations.*;

import javax.swing.*;
import java.awt.*;

public class DemoPanel extends JPanel implements Runnable {

    int FPS = 60;
    Scene scene;

    Thread demoThread;
    public Scene1 scene1 = new Scene1(this);

    public DemoPanel(){
        this.setPreferredSize((new Dimension(800,400)));
        this.setBackground(new Color(50,50,50));
        this.setDoubleBuffered(true);
        setStartScene();
        startDemoThread();
    }

    public void setStartScene(){
        scene = scene1;
        scene.configuration1();
    }

    public void startDemoThread(){
        demoThread = new Thread(this);
        demoThread.start();
    }

    @Override
    public void run(){

        double drawInterval = 1000000000 / FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        while (demoThread != null){

            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;

            if(delta >= 1){
                update();
                repaint();
                delta--;
            }
        }
    }

    public void update(){
        scene.update();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        scene.draw(g2);
        g2.dispose();
    }

}
