import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Put a short phrase describing the program here.
 *
 * @DAVID PARK PARK.3508
 *
 */
public final class Hailstone3 {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private Hailstone3() {
    }

    /**
     * Put a short phrase describing the static method myMethod here.
     */
    private static void generateSeries(int n, SimpleWriter out) {
        int max = n;
        out.println(n);
        while (n != 1) {
            if (n != 0 && n % 2 == 0) {
                n = n / 2;
            } else if (n != 0 && n % 2 != 0) {
                n = ((3 * n) + 1);
            }

            if (n > max) {
                max = n;
            }

            out.println(n);
        }
        out.println("maximum is " + max);
    }

    public static void main(String[] args) {
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();

        generateSeries(17, out);

        in.close();
        out.close();
    }

}
