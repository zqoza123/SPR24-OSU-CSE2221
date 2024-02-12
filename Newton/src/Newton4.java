import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

// DAVID PARK IS AUTHOR

public final class Newton4 {

    private Newton4() {
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

        out.println("enter a number to calculate its sqrt");
        double x = in.nextDouble();

        while (x >= 0) {
            double result = sqrt(x, relativeError);
            out.println(result);

            out.println("Enter another number. (neg to cancel)");
            x = in.nextDouble();
        }
        in.close();
        out.close();
    }

}
