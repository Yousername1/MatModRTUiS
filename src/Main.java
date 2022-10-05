package src;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;

import java.io.File;
import java.io.IOException;

public class Main {

    public static Database database = new Database();


    public static void main(String[] args) {

        database.setParams();
        database.createDatabase();

//        PlotBuilder plot = new PlotBuilder();
//        plot.showWindow();

        JFreeChart chart = ChartFactory.createXYLineChart("Quantile",
                "x",
                "p",
                database.getDatabase(),
                PlotOrientation.VERTICAL,
                true,
                true,
                false);

//        JFreeChart chart = ChartFactory.createXYLineChart("CDF",
//                "x",
//                "P(x)",
//                database.getDatabase(),
//                PlotOrientation.VERTICAL,
//                true,
//                true,
//                false);

        try{
//            ChartUtilities.saveChartAsJPEG(new File("src/QuantileChart.JPEG"), chart, 1080, 720);
            ChartUtilities.saveChartAsJPEG(new File("src/QuantileLast.JPEG"), chart, 1080, 720);
        } catch(IOException e) {
            System.out.println("Error");
        }
    }
}
