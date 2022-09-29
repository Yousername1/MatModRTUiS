package src;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import javax.swing.*;

public class PlotBuilder extends JFrame{
    private final int width = 1080;
    private final int height = 720;

    JFrame frame = new JFrame();
    DrawingCanvas container = new DrawingCanvas(width, height);

    public void showWindow() {
        frame.setSize(width, height);
        frame.setTitle("Exponential Distribution");
        frame.add(container);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
