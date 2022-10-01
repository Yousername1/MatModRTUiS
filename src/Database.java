package src;

import java.io.*;
import java.util.*;

public class Database {
    private int range;
    HashMap<Double, Double> database = new HashMap<Double, Double>();

    ExponentialDistribution distribution = new ExponentialDistribution(1.0);

    public static double[] keysArray;
    public static double[] valuesArray;

    public int getRange() {
        return range;
    }

    public void setRange() {
        Scanner takeData = new Scanner(System.in);
        System.out.print("Введите количество чисел в последовательности: ");
        this.range = takeData.nextInt();
        System.out.println();
        System.out.print("Введите параметр экспоненциального распределения: ");
        distribution.setLambda();
    }

    private double[] emptyKeysArray(){
        return keysArray = new double[getRange()];
    }

    private double[] emptyValuesArray(){
        return valuesArray = new double[getRange()];
    }


    private double[] createValuesArray(double[] array) {
        return distribution.generateExponentialDistribution(array);
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
        for (int i = 0; i < range; i++) {
            database.put(keysArray[i], valuesArray[i]);
        }
        Map<Double, Double> keySortedDatabase = new TreeMap<>(database);
        keySortedDatabase.entrySet().forEach(System.out::println); //????????????????????????????????????????????
    }

    public void createDatabase() {
        fillDatabase(getKeysArray(), getValuesArray(), getRange());
    }

}
