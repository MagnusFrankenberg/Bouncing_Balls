package main;

import animations.*;

import javax.swing.*;
import java.awt.*;

public class DemoPanel extends JPanel implements Runnable {

    int FPS = 60;
    Scene scene;
    public int dpWidth = 800;
    public int dpHeight = 400;

    Thread demoThread;
    ButtonHandler buttonHandler;
    public Scene1 scene1 = new Scene1(this);
    public Scene2 scene2 = new Scene2(this);
    public Scene3 scene3 = new Scene3(this);

    public DemoPanel(ButtonHandler buttonHandler){
        this.buttonHandler = buttonHandler;
        this.setPreferredSize((new Dimension(dpWidth,dpHeight)));
        this.setBackground(new Color(50,50,50));
        this.setDoubleBuffered(true);
        setStartScene();
        startDemoThread();
    }

    public void nextScene(){
        if(scene instanceof Scene1){
            scene = scene2;
        }else if(scene instanceof Scene2){
            scene = scene3;
        }else if(scene instanceof Scene3){
            scene = scene1;
        }
    }

    public void nextConfiguration() {
        if (scene.myConfigState == ConfigState.CONFIG1){
            scene.configuration2();
        }else if(scene.myConfigState==ConfigState.CONFIG2){
            scene.configuration3();
        }else if(scene.myConfigState==ConfigState.CONFIG3){
            scene.configuration1();
        }
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
