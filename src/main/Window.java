package main;

import javax.swing.*;
import java.awt.*;

public class Window {

    DemoPanel demoPanel;

    public Window(){
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Graphic Game 1");

        JPanel bottomPanel = new JPanel();
        bottomPanel.setPreferredSize(new Dimension(800, 480));
        bottomPanel.setBackground(new Color(30,30,30));
        bottomPanel.setLayout(new BorderLayout(2,2));

        demoPanel = new DemoPanel();

        bottomPanel.add(demoPanel, BorderLayout.CENTER);


        window.add(bottomPanel);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }




    public static void main(String[] args) {
        Window m = new Window();
    }
}
