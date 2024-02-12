import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Put a short phrase describing the program here.
 *
 * @author David Park
 *
 */
public final class CheckPassword {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private CheckPassword() {
    }

    /**
     * Put a short phrase describing the static method myMethod here.
     */

    private static boolean containsUpperCaseLetter(String str) {
        boolean hasUpperCase = false;
        for (int i = 0; i < str.length(); i++) {
            if (Character.isUpperCase(str.charAt(i)) == true) {
                hasUpperCase = true;
            }
        }
        return hasUpperCase;
    }

    private static void checkPasswords(String passwordCandidate,
            SimpleWriter out) {
        if (passwordCandidate.length() > 7) {
            out.println("the password fulfills the 8 character requirement");

        } else {
            out.println(
                    "the password does not fulfill the 8 character requirement");
        }
    }

    private static boolean containsLowerCaseAndDigit(String str) {
        boolean hasLowerCase = false;
        for (int i = 0; i < str.length(); i++) {
            if (Character.isLowerCase(str.charAt(i)) == true
                    || Character.isDigit(str.charAt(i))) {
                hasLowerCase = true;
            }
        }
        return hasLowerCase;
    }

    public static void main(String[] args) {
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();

        /*
         * Put your main program code here; it may call myMethod as shown
         */
        out.println(containsUpperCaseLetter("ksdfL"));
        out.println(containsLowerCaseAndDigit("ksdfL1"));
        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
