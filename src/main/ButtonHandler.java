package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonHandler implements ActionListener {

    Window window;
    DemoPanel dp;

    public ButtonHandler(Window window, DemoPanel dp){
        this.window = window;
        this.dp = dp;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource().equals(window.button1)){
            dp.nextScene();
        }
        if(e.getSource().equals(window.button2)){
            dp.nextConfiguration();
        }
    }
}
