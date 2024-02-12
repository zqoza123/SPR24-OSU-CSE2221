import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

public final class CoinChange2 {

    private CoinChange2() {
    }

    public static void main(String[] args) {
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();

        int[] arr = { 100, 50, 25, 10, 5, 1 };
        int[] array = { 0, 0, 0, 0, 0, 0 };

        int changeInCents = 0;

        out.println("What number of cents do you want change for?");
        changeInCents = in.nextInteger();

        int count = 0;
        while (changeInCents > 0 && count <= 5) {
            while (changeInCents >= arr[count]) {
                changeInCents -= arr[count];
                array[count] += 1;
            }
            count += 1;
        }

        out.println("for your change, you will need, ");

        for (int i = 0; i < 6; i++) {
            out.print("[" + array[i] + ", " + arr[i] + " cents ]");
        }

        in.close();
        out.close();
    }

}
