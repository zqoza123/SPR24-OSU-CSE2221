import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

public class sampleClass {

    /*
     * public static void main(String[] args) { SimpleReader fileIn = new
     * SimpleReader1L("test.txt"); SimpleWriter consoleOut = new
     * SimpleWriter1L();
     *
     * String firstLine = fileIn.nextLine(); String secLine = fileIn.nextLine();
     * String thirdLine = fileIn.nextLine();
     *
     * consoleOut.println(firstLine + " " + secLine + " " + thirdLine);
     *
     * fileIn.close(); consoleOut.close();
     *
     *
     *
     * String one = "hello world"; String two = "hello world";
     *
     * consoleOut.println(one == two); consoleOut.println(one.equals(two));
     *
     * one = one + "!"; two = two + "!";
     *
     * consoleOut.println(one == two); consoleOut.println(one.equals(two));
     *
     *
     * }
     */

    public static void main(String[] args) {
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();

        String password = "";

        out.println("enter password");
        while (in.nextLine() != "" && isOK(in.nextLine) == false) {
            out.println("password accepted");
            password = in.nextLine();
        }
        if (isOK(password)) {
            out.println("password accepted");
        } else {
            out.println("password not accepted");
        }

        boolean finale = false;
        for (int i = 0; i < num.length; i++) {
            for (int c = 1; c < num.length; c++) {
                if (numbers[i] == numbers[c]) {
                    finale = true;
                }
            }
        }
        return finale;

        /*
         * int[] a = { 9, 7, 5, 2, -2 };
         * 
         * boolean isOrdered = true;
         * 
         * for (int i = 0; i < a.length - 1; i++) { if (a[i] < a[i + 1]) {
         * isOrdered = false; } } out.println(isOrdered);
         * 
         * /* } String x = in.nextLine();
         *
         * for (int i = 0; i < x.length(); i += 1) { if
         * (Character.isUpperCase(x.charAt(i))) { out.print(x.charAt(i)); } }
         *
         * out.println();
         *
         * for (int i = 1; i < x.length(); i += 2) { out.print(x.charAt(i)); }
         *
         * out.println();
         *
         * for (int i = 0; i < x.length(); i += 1) { if (x.charAt(i) == 'a' ||
         * x.charAt(i) == 'e' || x.charAt(i) == 'i' || x.charAt(i) == 'o' ||
         * x.charAt(i) == 'u' || x.charAt(i) == 'A' || x.charAt(i) == 'E' ||
         * x.charAt(i) == 'I' || x.charAt(i) == 'O' || x.charAt(i) == 'U') {
         * out.print("_"); } else { out.print(x.charAt(i)); } }
         *
         * int counter = 0;
         *
         * out.println();
         *
         * for (int i = 0; i < x.length(); i += 1) { if (x.charAt(i) == 'a' ||
         * x.charAt(i) == 'e' || x.charAt(i) == 'i' || x.charAt(i) == 'o' ||
         * x.charAt(i) == 'u' || x.charAt(i) == 'A' || x.charAt(i) == 'E' ||
         * x.charAt(i) == 'I' || x.charAt(i) == 'O' || x.charAt(i) == 'U') {
         * counter += 1; } } out.print(counter);
         *
         * out.println();
         *
         * for (int i = 0; i < x.length(); i += 1) { if (x.charAt(i) == 'a' ||
         * x.charAt(i) == 'e' || x.charAt(i) == 'i' || x.charAt(i) == 'o' ||
         * x.charAt(i) == 'u' || x.charAt(i) == 'A' || x.charAt(i) == 'E' ||
         * x.charAt(i) == 'I' || x.charAt(i) == 'O' || x.charAt(i) == 'U') {
         * out.print(i + ", "); } }
         *
         *
         * /*
         *
         * XMLTree1 t = new XMLTree1("tree.xml");
         *
         * if (t.isTag()) { for (int i = 0; i < t.numberOfChildren(); i++) {
         * XMLTree child = t.child(i); out.println("Label: " + child.label());
         * if (child.isTag()) { for (String attribute : child.attributeNames())
         * { out.println("attribute: " + attribute); out.println( "value: " +
         * child.attributeValue(attribute)); } } } }
         *
         * /* output.print("Number of points: "); int n = input.nextInteger();
         *
         * int ptsInInterval = 0, ptsInSubinterval = 0;
         *
         * Random rnd = new Random1L();
         *
         * while (ptsInInterval < n) { double x = rnd.nextDouble();
         * ptsInInterval++; if (x <= 0.5) { ptsInSubinterval++; } }
         *
         * double estimate = (100.0 * ptsInSubinterval) / ptsInInterval;
         * output.println("Estimate of percentage: " + estimate + "%");
         *
         *
         */

        in.close();
        out.close();
    }
}
