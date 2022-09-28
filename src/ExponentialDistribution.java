package src;

import java.util.Arrays;

public class ExponentialDistribution {

    private double lambda;

    public ExponentialDistribution(double lambda) {
        this.lambda = lambda;
    }

    public double getLambda() {
        return lambda;
    }

    public void setLambda(double lambda) {
        this.lambda = lambda;
    }

//    public void generateExponentialDistribution(double[] array) {
//        for (int i = 0; i < array.length; i++) {
//            array[i] = Math.log(1 - Math.random())/(-lambda);
//        }
//        Arrays.sort(array);
//        for (int i = 0; i < array.length; i++) {
//            System.out.println(array[i]);
//        }
//    }

    public double[] generateExponentialDistribution(double[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = Math.log(1 - Math.random())/(-lambda);
        }
        Arrays.sort(array);
//        for (int i = 0; i < array.length; i++) {
//            System.out.println(array[i]);
//        }
        return array;
    }
}
