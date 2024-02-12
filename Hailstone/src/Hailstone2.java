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
public final class Hailstone2 {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private Hailstone2() {
    }

    /**
     * Put a short phrase describing the static method myMethod here.
     */
    private static void generateSeries(int n, SimpleWriter out) {
        int counter = 1;
        out.println(n);
        while (n != 1) {
            if (n != 0 && n % 2 == 0) {
                n = n / 2;
                out.println(n);
                counter += 1;
            } else if (n != 0 && n % 2 != 0) {
                n = ((3 * n) + 1);
                out.println(n);
                counter += 1;
            }
        }
        out.println("length is " + counter);
    }

    public static void main(String[] args) {
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();

        generateSeries(17, out);

        in.close();
        out.close();
    }

}
