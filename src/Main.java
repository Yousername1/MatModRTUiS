package src;

public class Main {
    public static void main(String[] args) {
        Database database = new Database();
        ExponentialDistribution distribution = new ExponentialDistribution(1.0);
        database.setRange();
        database.createDatabase();
    }
}
