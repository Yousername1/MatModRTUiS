package src;

import java.io.*;
import java.util.*;

public class Database {
    private int range;
    HashMap<Double, Double> database = new HashMap<Double, Double>();

    ExponentialDistribution distribution = new ExponentialDistribution(1.0);

    private double[] keysArray;
    private double[] valuesArray;

    public int getRange() {
        return range;
    }

    public void setRange() {
        Scanner takeData = new Scanner(System.in);
        System.out.print("Введите количество чисел в последовательности: ");
        this.range = takeData.nextInt();
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

    //-------------------------------------------------------------------------------------------------------------

    public void toWrite(HashMap<Double, Double> database) {
        try{
            File file = new File("src/output.txt");
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(database);
            oos.flush();
            oos.close();
            fos.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void toWrite2(HashMap<Double,Double> database) {
        try {
            File fileTwo = new File("src/output.txt");
            FileOutputStream fos = new FileOutputStream(fileTwo);
            PrintWriter pw = new PrintWriter(fos);

            for (Map.Entry<Double, Double> m : database.entrySet()) {
                pw.println(m.getKey() + "=" + m.getValue());
            }
            pw.flush();
            pw.close();
            fos.close();
        } catch (Exception e) {
        }
    }






//    private double getKey(int number){
//        Set<Double> keys = database.keySet();
//        return keys.iterator().next();
//    }
//    public double getKeyPoint(int index) {
//        double[] keysArray = new double[getRange()];
//        for (int i = 0; i < keysArray.length; i++) {
//            keysArray[i] = getKey(i);
//        }
//        return keysArray[index];
//    }
//
//    private ArrayList<Double> valuesToArrayList() {
//        return new ArrayList<>(database.values());
//    }
//
//    private double getValue(int index) {
//        return valuesToArrayList().get(index);
//    }
//
//    public double getValuePoint(int index) {
//        double[] valuesArray = new double[getRange()];
//        for (int i = 0; i < valuesArray.length; i++) {
//            valuesArray[i] = getValue(i);
//        }
//        return valuesArray[index];
//    }
}
