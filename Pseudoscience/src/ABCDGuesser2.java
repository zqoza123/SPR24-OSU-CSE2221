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
public final class ABCDGuesser2 {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private ABCDGuesser2() {
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
         * Asks user to input a positive real double. Then parse the double from
         * input string and return it.
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
         * Asks user to input a a positive real double that is NOT equal to 1.0.
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
     * Searches for the best approximation of a given constant (mu) using the de
     * Jager formula with four input values and a set of exponents. It iterates
     * through all combinations of the exponents for the input values to find
     * the combination that results in the value closest to mu, minimizing the
     * relative error.
     *
     *
     * @param out
     *            output stream
     * @param constantMu
     *            user entered number to be approximated
     * @param exponents
     *            final double array where the exponents will be used
     * @param input1
     *            first user entered number to be approximated by raising to
     *            different powers
     * @param input2
     *            second user entered number to be approximated by raising to
     *            different powers
     * @param input3
     *            third user entered number to be approximated by raising to
     *            different powers
     * @param input4
     *            fourth user entered number to be approximated by raising to
     *            different powers
     */
    private static void bestApproximationSearch(SimpleWriter out,
            double constantMu, double input1, double input2, double input3,
            double input4, double[] exponents) {
        // Initialize variables to hold the best approx after the de jager
        // approximation found and the corresponding exponents
        double bestApproximation = 0;
        double bestA = 0, bestB = 0, bestC = 0, bestD = 0;
        final double hundred = 100;
        // 4 four loops to solve for the de jager value
        // First loop selects an exponent for i
        for (int i = 0; i < exponents.length; i++) {
            // Second loop selects an exponent for j
            for (int j = 0; j < exponents.length; j++) {
                // Third loop selects an exponent for k
                for (int k = 0; k < exponents.length; k++) {
                    // Fourth loop selects an exponent for l
                    for (int l = 0; l < exponents.length; l++) {

                        // Update the best approximation and
                        // exponents if the current one is closer to mu
                        double currentApproximation = Math.pow(input1,
                                exponents[i]) * Math.pow(input2, exponents[j])
                                * Math.pow(input3, exponents[k])
                                * Math.pow(input4, exponents[l]);
                        // Calculate the current approximation
                        // using the selected exponents
                        if (Math.abs(constantMu - currentApproximation) < Math
                                .abs(constantMu - bestApproximation)) {
                            bestApproximation = currentApproximation;
                            bestA = exponents[i];
                            bestB = exponents[j];
                            bestC = exponents[k];
                            bestD = exponents[l];
                        }
                    }
                }
            }
        }

        // Output the best approximation found and its details
        out.println("Best approximation: " + bestApproximation);
        out.println("Exponents: a=" + bestA + ", b=" + bestB + ", c=" + bestC
                + ", d=" + bestD);
        out.println("Smallest relative error: ");
        out.print((bestApproximation - constantMu) / constantMu * hundred, 2,
                false);
        out.print("%");

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

        // Prompt the user for four positive double values that are not equal to one.
        // These values will be used in the approximation process.
        double input1 = getPositiveDoubleNotOne(in, out);
        double input2 = getPositiveDoubleNotOne(in, out);
        double input3 = getPositiveDoubleNotOne(in, out);
        double input4 = getPositiveDoubleNotOne(in, out);

        // Define an array of exponent values to try in the approximation
        final double[] exponents = { -5.0, -4.0, -3.0, -2.0, -1.0, -1.0 / 2.0,
                -1.0 / 3.0, -1.0 / 4.0, 0.0, 1.0 / 4.0, 1.0 / 3.0, 1.0 / 2.0,
                1.0, 2.0, 3.0, 4.0, 5.0 };

        // Call the bestApproximationSearch method with the gathered inputs and exponents.
        // This method will compute and print the best approximation to the value 'mu'
        // using a combination of the input values raised to the power of the exponents.
        bestApproximationSearch(out, mu, input1, input2, input3, input4,
                exponents);

        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
