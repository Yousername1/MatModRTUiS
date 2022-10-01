package src;

import java.awt.*;

public class Main {

    public static Database database = new Database();

    public static void main(String[] args) {

//        Database database = new Database();

        database.setRange();
        database.createDatabase();

        PlotBuilder plot = new PlotBuilder();
        plot.showWindow();
    }
}
