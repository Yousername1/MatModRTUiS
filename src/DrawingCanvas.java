package src;

import java.awt.*;
import java.awt.geom.Path2D;
import javax.swing.*;

public class DrawingCanvas extends JComponent{

    private int width;
    private int height;

    Database database = new Database();

    public DrawingCanvas(int width, int height) {
        this.width = width;
        this.height = height;
    }


    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        Path2D.Double p = new Path2D.Double();
//        for (int i = 0; i < arrayX.length-1; i++) {
//            p.moveTo(arrayX[i], arrayY[i]);
//            p.lineTo(arrayX[i+1], arrayY[i+1]);
//            g2d.draw(p);
//        }

        double[] arrayX = database.createKeyArray();
        double[] arrayY = database.createValuesArray();

        for (int i = 0; i < arrayX.length - 1; i++) {
            p.moveTo(arrayX[i], arrayY[i]);
            p.lineTo(arrayX[i+1], arrayY[i+1]);
            g2d.draw(p);
        }
    }

}
