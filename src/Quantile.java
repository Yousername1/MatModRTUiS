package src;

import java.util.*;

public class Quantile extends Lambda {
    public double[] generateExponentialDistribution(double[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = (Math.log(1 - Math.random()))/(-getLambda());
        }
        Arrays.sort(array);
        return array;
    }


}
