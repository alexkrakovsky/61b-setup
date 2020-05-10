package hw2;

public class PercolationStatsTest {

    public static void main(String[] args) {
        PercolationFactory fac = new PercolationFactory();
        PercolationStats P = new PercolationStats(10, 50, fac);
        System.out.print(P.confidenceHigh());
    }
}
