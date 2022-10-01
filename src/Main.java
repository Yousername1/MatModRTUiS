package src;

public class Main {

    public static Database database = new Database();

    public static void main(String[] args) {

        database.setParams();
        database.createDatabase();

        PlotBuilder plot = new PlotBuilder();
        plot.showWindow();
    }
}
