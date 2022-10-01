package src;

import java.awt.*;
import java.awt.geom.Path2D;
import javax.swing.*;

import static src.Main.database;

public class DrawingCanvas extends JComponent{

    private int width;
    private int height;

//    Database database = new Database();   //создаётся объект с полями null, вот в чём ошибка
//    double[] arrayX = database.getKeysArray();
//    double[] arrayY = database.getValuesArray();

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


//        double[] arrayX = {10, 50, 90, 130, 170};
//        double[] arrayY = {50, 110, 90, 130, 100};


        //DEBUG ONLY!!!!!!
//        for (int i = 0; i < arrayX.length; i++) {
//            System.out.print(arrayX[i] + " ");
//        }

        for (int i = 1; i < database.getRange(); i++) {
            p.moveTo(arrayX[i-1], arrayY[i-1]);
            p.lineTo(arrayX[i], arrayY[i]);
            g2d.draw(p);
        }
    }

}
