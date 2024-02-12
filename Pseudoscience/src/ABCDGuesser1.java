import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import components.utilities.FormatChecker;

/**
 * Put a short phrase describing the program here.
 *
 * @author David Park
 *
 */
public final class ABCDGuesser1 {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private ABCDGuesser1() {
    }

    /**
     * Repeatedly asks the user for a positive real number until the user enters
     * one. Returns the positive real number.
     *
     * @param in
     *            the input stream
     * @param out
     *            the output stream
     * @return a positive real number entered by the user
     */
    private static double getPositiveDouble(SimpleReader in, SimpleWriter out) {
        /*
         * Asks user to input a a positive real double. Then parse the double
         * from input string and return it.
         */
        double mu = 0;
        String s = "";
        while (mu <= 0) {
            out.println("Please input a positive double: ");
            s = in.nextLine();
            if (FormatChecker.canParseDouble(s)) {
                // this checks to see if the number is valid to be parsed into a double
                mu = Double.parseDouble(s);
                if (mu <= 0) {
                    out.println("The number must be positive. enter again");
                }
            } else {
                out.println("not a valid double. enter again");
            }
        }
        return mu;
    }

    /**
     * Repeatedly asks the user for a positive real number not equal to 1.0
     * until the user enters one. Returns the positive real number.
     *
     * @param in
     *            the input stream
     * @param out
     *            the output stream
     * @return a positive real number not equal to 1.0 entered by the user
     */
    private static double getPositiveDoubleNotOne(SimpleReader in,
            SimpleWriter out) {
        /*
         * Asks user to input a positive real double that is NOT equal to 1.0.
         * Then parse the double from input string and return it.
         */
        double input = 0;
        String s = "";
        while ((input <= 0 && input != 1) || !FormatChecker.canParseDouble(s)) {
            //repeating while input is less than or equal to
            out.println("Please input a positive double: ");
            s = in.nextLine();
            if (FormatChecker.canParseDouble(s)
                    // check if the double inside the string can be parsed.
                    && Double.parseDouble(s) != 1.0) {
                input = Double.parseDouble(s);
                if (input <= 0) {
                    out.println("The number must be positive. enter again");
                }
            } else {
                out.println("not a valid double. enter again");
            }
        }
        return input;
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

        double mu = getPositiveDouble(in, out);

        // Prompt user for four input values, ensuring they're positive and not one
        double input1 = getPositiveDoubleNotOne(in, out);
        double input2 = getPositiveDoubleNotOne(in, out);
        double input3 = getPositiveDoubleNotOne(in, out);
        double input4 = getPositiveDoubleNotOne(in, out);

        // Define an array of exponent values to try in the approximation
        final double[] exponents = { -5.0, -4.0, -3.0, -2.0, -1.0, -1.0 / 2.0,
                -1.0 / 3.0, -1.0 / 4.0, 0.0, 1.0 / 4.0, 1.0 / 3.0, 1.0 / 2.0,
                1.0, 2.0, 3.0, 4.0, 5.0 };

        // Initialize variables to hold the best approx after the de jager
        // approximation found and the corresponding exponents
        double bestApprox = 0;
        double bestA = 0, bestB = 0, bestC = 0, bestD = 0;
        final double hundred = 100;
        // the 4 while loops will be calculating the de jager value.
        int i = 0;
        while (i < exponents.length) { // First loop selects an exponent for a
            double a = exponents[i];
            int j = 0;
            while (j < exponents.length) { // Second loop selects an exponent for b
                double b = exponents[j];
                int k = 0;
                while (k < exponents.length) { // Third loop selects an exponent for c
                    double c = exponents[k];
                    int l = 0;
                    // Fourth loop selects an exponent for d
                    while (l < exponents.length) {
                        double d = exponents[l];
                        // Update the best approximation and
                        // exponents if the current one is closer to mu
                        double currentApproximation = Math.pow(input1, a)
                                // Calculate the current approximation
                                // using the selected exponents
                                * Math.pow(input2, b) * Math.pow(input3, c)
                                * Math.pow(input4, d);
                        if (Math.abs(mu - currentApproximation) < Math
                                .abs(mu - bestApprox)) {
                            bestApprox = currentApproximation;
                            bestA = a;
                            bestB = b;
                            bestC = c;
                            bestD = d;
                        }
                        l++;
                    }
                    k++;
                }
                j++;
            }
            i++;
        }

        // Output the best approximation found and its details

        out.println("Best approximation: " + bestApprox);
        out.println("Exponents: a=" + bestA + ", b=" + bestB + ", c=" + bestC
                + ", d=" + bestD);
        out.println("Smallest relative error: ");
        out.print((bestApprox - mu) / mu * hundred, 2, false);
        out.print("%");

        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
