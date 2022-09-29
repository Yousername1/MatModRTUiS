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

    public double[] generateExponentialDistribution(double[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = Math.log(1 - Math.random())/(-lambda);
        }
        Arrays.sort(array);
        return array;
    }
}
