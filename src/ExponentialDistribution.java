package src;

import java.util.*;

public class ExponentialDistribution {

    private double lambda;

    public ExponentialDistribution(double lambda) {
        this.lambda = lambda;
    }

    public double getLambda() {
        return lambda;
    }

    public void setLambda() {
        Scanner takeData = new Scanner(System.in);
        this.lambda = takeData.nextInt();
    }

    public double[] generateExponentialDistribution(double[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = Math.log(1 - Math.random())/(-lambda);
        }
        Arrays.sort(array);
        return array;
    }
}
