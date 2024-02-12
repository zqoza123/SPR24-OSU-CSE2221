import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

// DAVID PARK IS AUTHOR

public final class Newton2 {

    private Newton2() {
    }

    private static double sqrt(double x) {
        double guess = x;

        double relativeError = 0.01;

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
        /*
         * Put your main program code here; it may call myMethod as shown
         */
        out.println(sqrt(4));
        out.println(sqrt(16));
        out.println(sqrt(81));
        out.println(sqrt(0));

        in.close();
        out.close();
    }

}
