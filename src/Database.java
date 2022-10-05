package src;

import java.io.IOException;
import java.util.*;
import org.jfree.chart.*;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

//import javax.*;
import java.io.File;

public class Database {
    private int range;
    HashMap<Double, Double> database = new HashMap<Double, Double>();
    XYSeries xySeries = new XYSeries("Quantile");
    XYSeriesCollection dataset = new XYSeriesCollection();

    Quantile distribution = new Quantile();

    CDF cdf = new CDF();

    public static double[] keysArray;
    public static double[] valuesArray;

    private String function;

    public int getRange() {
        return range;
    }

    private void setFunction() {
        System.out.print("Введите название функции, график которой нужно построить " +
                "(QUANTILE, CDF): ");
        Scanner takeData = new Scanner(System.in);
        this.function = takeData.nextLine();
    }

    public String getFunction() {
        return function;
    }

    public void setParams() {
        Scanner takeData = new Scanner(System.in);
        System.out.print("Введите количество чисел в последовательности: ");
        this.range = takeData.nextInt();
        System.out.println();
        setFunction();
        System.out.println();
        if(getFunction().equalsIgnoreCase("QUANTILE") || getFunction().startsWith("Q")) {
            System.out.print("Введите параметр экспоненциального распределения: ");
            distribution.setLambda();
            System.out.println();
        } else if(getFunction().equalsIgnoreCase("CDF") || getFunction().startsWith("C")) {
            System.out.print("Введите параметр экспоненциального распределения: ");
            cdf.setLambda();
            System.out.println();
        }

    }

    private double[] emptyKeysArray(){
        return keysArray = new double[getRange()];
    }

    private double[] emptyValuesArray(){
        return valuesArray = new double[getRange()];
    }


    private double[] createValuesArray(double[] array) throws UnsupportedOperationException  {
        if(getFunction().equalsIgnoreCase("QUANTILE") || getFunction().startsWith("Q")) {
            return distribution.generateExponentialDistribution(array);
        } else if(getFunction().equalsIgnoreCase("CDF") || getFunction().startsWith("C")) {
            return cdf.generateCDF(array);
        }
        throw new UnsupportedOperationException();
    }

    public double[] getValuesArray() {
        return createValuesArray(emptyValuesArray());
    }

    private double[] createKeysArray(double[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = i+1;
        }
        Arrays.sort(array);
        return array;
    }

    public double[] getKeysArray() {
        return createKeysArray(emptyKeysArray());
    }

    private void fillDatabase(double[] keysArray, double[] valuesArray, int range) {
        for (int i = 0; i < getRange(); i++) {
            database.put(keysArray[i], valuesArray[i]);
        }
        Map<Double, Double> keySortedDatabase = new TreeMap<>(database);
        keySortedDatabase.entrySet().forEach(System.out::println); //????????????????????????????????????????????
    }

//    public void createDatabase() {
//        fillDatabase(getKeysArray(), getValuesArray(), getRange());
//    }

    private void fillSeries(double[] keysArray, double[] valuesArray, int range) {
        for (int i = 0; i < getRange(); i++) {
            xySeries.add(keysArray[i], valuesArray[i]);
        }
    }

    public void createDatabase() {
        fillDatabase(getKeysArray(), getValuesArray(), getRange());
        fillSeries(getKeysArray(), getValuesArray(), getRange());
        dataset.addSeries(xySeries);
    }

    public XYSeriesCollection getDatabase() {
        return dataset;
    }

}
