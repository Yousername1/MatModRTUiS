package src;

import java.util.Scanner;

public class Lambda {

    private double lambda;

    public Lambda() {
        this.lambda = lambda;
    }

    public double getLambda() {
        return lambda;
    }

    public void setLambda() {
        Scanner takeData = new Scanner(System.in);
        this.lambda = takeData.nextDouble();
    }

}
