import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

// DAVID PARK IS AUTHOR

public final class Newton3 {

    private Newton3() {
    }

    private static double sqrt(double x, double relativeError) {

        double guess = x;
        double newGuess;

        if (x == 0) {
            return 0;
        }

        while (true) {
            newGuess = 0.5 * (guess + x / guess);
            if (Math.abs(newGuess - guess) < relativeError) {
                break;
            }
            guess = newGuess;
        }
        return guess;
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();

        out.println("Enter the relative error: ");
        double relativeError = in.nextDouble();

        out.println(sqrt(16, relativeError));
        out.println(sqrt(4, relativeError));
        out.println(sqrt(81, relativeError));
        out.println(sqrt(0, relativeError));

        in.close();
        out.close();
    }

}
