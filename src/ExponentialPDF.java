package src;

import javax.xml.crypto.Data;
import java.util.Arrays;
import java.util.Collections;

public class ExponentialPDF extends Lambda {
    public double[] generateExponentialPDF(double[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = (getLambda()) * Math.exp(-getLambda() * Math.random());
        }
        Arrays.sort(array);
        return array;
//        return reverseSorting(array);
    }

    public double[] reverseSorting(double[] array) {
        double[] reverseArray = Arrays.stream(array)
                .boxed()
                .sorted(Collections.reverseOrder())
                .mapToDouble(Double::doubleValue)
                .toArray();
        return reverseArray;
    }


}
