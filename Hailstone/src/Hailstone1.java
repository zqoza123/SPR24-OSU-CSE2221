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
public final class Hailstone1 {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private Hailstone1() {
    }

    /**
     * Put a short phrase describing the static method myMethod here.
     */
    private static void generateSeries(int n, SimpleWriter out) {
        out.println(n);
        while (n != 1) {
            if (n != 0 && n % 2 == 0) {
                n = n / 2;
                out.println(n);
            } else if (n != 0 && n % 2 != 0) {
                n = ((3 * n) + 1);
                out.println(n);
            }
        }
    }

    public static void main(String[] args) {
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();

        generateSeries(23, out);

        in.close();
        out.close();
    }

}
