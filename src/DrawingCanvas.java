package src;

import java.awt.*;
import java.awt.geom.Path2D;
import javax.swing.*;

import static src.Main.database;

public class DrawingCanvas extends JComponent{

    private int width;
    private int height;

    double[] arrayX = Database.keysArray;
    double[] arrayY = Database.valuesArray;


    public DrawingCanvas(int width, int height) {
        this.width = width;
        this.height = height;
    }


    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        Path2D.Double p = new Path2D.Double();

        for (int i = 0; i < database.getRange() - 1; i++) {
            p.moveTo(arrayX[i] + 100, (100 - arrayY[i])*5);
            p.lineTo(arrayX[i+1] + 100, (100 - arrayY[i+1])*5);
            g2d.draw(p);
        }
    }

}
