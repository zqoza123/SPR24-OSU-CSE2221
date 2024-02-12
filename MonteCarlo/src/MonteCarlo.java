import components.random.Random;
import components.random.Random1L;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Monte Carlo Estimate: compute percentage of pseudo-random points in [0.0,1.0)
 * interval that fall in the left half subinterval [0.0,0.5).
 */
public final class MonteCarlo {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private MonteCarlo() {
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments; unused here
     */
    public static void main(String[] args) {

        SimpleReader input = new SimpleReader1L();
        SimpleWriter output = new SimpleWriter1L();

        /*
         * output.print("Number of points: "); int n = input.nextInteger(); int
         * ptsInSquare = 0, ptsInCircle = 0;
         *
         * Random rnd = new Random1L();
         *
         * while (ptsInSquare < n) { double x = 2 * rnd.nextDouble(); //
         * generates x point in 0.0, 2.0 plane double y = 2 * rnd.nextDouble();
         * // generates y point in 0.0, 2.0 plane ptsInSquare++;
         *
         * // Check if x, y is inside the circle centered at (1,1) with radius 1
         * if ((x - 1.0) * (x - 1.0) + ((y - 1.0) * (y - 1.0)) <= 1.0) {
         * ptsInCircle++; } } final double quadPlane = 4.0;
         *
         * double estimate = (quadPlane * ptsInCircle) / ptsInSquare;
         * output.println("Estimate of area in circle: " + estimate);
         *
         * input.close(); output.close();
         */

        output.println(numberOfPointsInCircle(1000));
        output.println(pointIsInCircle(0.9, 0.7));
    }

    private static int numberOfPointsInCircle(int n) {
        int ptsInSquare = 0, ptsInCircle = 0;

        Random rnd = new Random1L();

        while (ptsInSquare < n) {
            double x = 2 * rnd.nextDouble(); // generates x point in 0.0, 2.0 plane
            double y = 2 * rnd.nextDouble(); // generates y point in 0.0, 2.0 plane
            ptsInSquare++;

            // Check if x, y is inside the circle centered at (1,1) with radius 1
            if ((x - 1.0) * (x - 1.0) + ((y - 1.0) * (y - 1.0)) <= 1.0) {
                ptsInCircle++;
            }
        }
        return ptsInCircle;
    }

    private static boolean pointIsInCircle(double xCoord, double yCoord) {
        if ((xCoord - 1.0) * (xCoord - 1.0)
                + ((yCoord - 1.0) * (yCoord - 1.0)) <= 1.0) {
            return true;
        }
        return false;
    }

}
