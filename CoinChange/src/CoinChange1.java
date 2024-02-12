import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

public final class CoinChange1 {

    private CoinChange1() {
    }

    public static void main(String[] args) {
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();

        int changeInCents = 0;
        int dollar = 100;
        int halfDollar = 50;
        int quarter = 25;
        int dime = 10;
        int nickel = 5;
        int penny = 1;

        out.println("What number of cents do you want change for?");
        changeInCents = in.nextInteger();

        out.println("You will have " + changeInCents % dollar + " dollars "
                + changeInCents);

        in.close();
        out.close();
    }

}
