package src;

import java.util.Arrays;
import java.util.Collections;

public class CDF extends Lambda {

    public double[] generateCDF(double[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = (Math.log(Math.exp((-getLambda())*Math.random()))) / (-getLambda());
        }
        return reverseArray(array);
    }

    private double[] reverseArray(double[] array) {
        Double[] reversingArray = new Double[array.length];
        for (int i = 0; i < array.length; i++) {
            reversingArray[i] = (Double) array[i];
        }
        Arrays.sort(reversingArray, Collections.reverseOrder());
//        Arrays.stream(array).forEach(System.out::println);
        for (int i = 0; i < array.length; i++) {
            array[i] = (double) reversingArray[i];
        }
        return array;
    }
}
