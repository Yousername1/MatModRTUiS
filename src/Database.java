package src;

import java.util.*;

public class Database {
    private int range;

    HashMap<Double, Double> database = new HashMap<Double, Double>();

    ExponentialDistribution distribution = new ExponentialDistribution(1.0);

    public int getRange() {
        return range;
    }

    public void setRange() {
        Scanner takeData = new Scanner(System.in);
        System.out.print("Введите количество чисел в последовательности: ");
        this.range = takeData.nextInt();
    }

    private double[] emptyValuesArray(){
        return new double[getRange()];
    }


    public double[] createValuesArray() {
        return distribution.generateExponentialDistribution(emptyValuesArray());
    }

    private double[] createKeysArray(double[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = i+1;
        }
        Arrays.sort(array);
        return array;
    }

    private void fillDatabase(double[] keysArray, double[] valuesArray, int range) {
        for (int i = 0; i < range; i++) {
            database.put(keysArray[i], valuesArray[i]);
        }
        Map<Double, Double> keySortedDatabase = new TreeMap<>(database);
        keySortedDatabase.entrySet().forEach(System.out::println); //????????????????????????????????????????????!!!!!!!!!!!!
    }

    public void createDatabase() {
        fillDatabase(createKeysArray(emptyValuesArray()), createValuesArray(), getRange());
    }
}
