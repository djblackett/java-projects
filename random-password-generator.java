import java.io.ByteArrayOutputStream;

/* 
Password generator
 use random int generator to make a random password with proper ascii character codes.
    // check conditions, if fails, run again until it passes

        use multiple random number generators:
        1: numeral
        2: uppercase letter
        3: lowercase letter

        a master random number generator that randomly calls one of the 3 character generators
        call it 8 times
*/
public class Solution {
    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() {
        ByteArrayOutputStream out = new ByteArrayOutputStream(8);
        byte[] characters = new byte[8];
        boolean containsUpper = false;
        boolean containsLower = false;
        boolean containsNumeral = false;

        while (!(containsNumeral && containsUpper && containsLower)) {
            containsUpper = false;
            containsLower = false;
            containsNumeral = false;
            characters = randomArrayFiller();
            for (int i = 0; i < characters.length; i++) {
                if (characters[i] >= 48 && characters[i] <= 57) {
                    containsNumeral = true;
                } else if (characters[i] >= 65 && characters[i] <= 90) {
                    containsUpper = true;
                } else if (characters[i] >= 97 && characters[i] <= 122) {
                    containsLower = true;
                }
            }
        }

        out.write(characters, 0, 8);
            return out;
        }


    //TODO check the boundaries of the random functions to make sure they are getting the 1st and last characters correct;

    public static int getRandomNumeral() {
        int max = 57;
        int min = 48;
        int range = max - min + 1;
        int rand = 0;

        // generate random numeral
        for (int i = 0; i < max; i++) {
            rand = (int) (Math.random() * range) + min;
        }
        return rand;
    }

    public static int getRandomUppercase() {
        int max = 90;
        int min = 65;
        int range = max - min + 1;
        int rand = 0;

        // generate random uppercase letter
        for (int i = 0; i < max; i++) {
            rand = (int) (Math.random() * range) + min;
        }
        return rand;
    }

    public static int getRandomLowercase() {
        int max = 122;
        int min = 97;
        int range = max - min + 1;
        int rand = 0;

        // generate random lowercase letter
        for (int i = 0; i < max; i++) {
            rand = (int) (Math.random() * range) + min;
        }
        return rand;
    }

    public static int randomFunctionCaller() {
        int max = 3;
        int min = 1;
        int range = max - min + 1;
        int rand = 0;

        // generate random numbers to call functions at random
        for (int i = 0; i < max; i++) {
            rand = (int) (Math.random() * range) + min;
        }

        if (rand == 1) {
            return getRandomNumeral();
        } else if (rand == 2) {
            return getRandomUppercase();
        } else {
            return getRandomLowercase();
        }
    }

    public static byte[] randomArrayFiller() {
        byte[] bytes = new byte[8];
        for (int i = 0; i < 8; i++) {
            bytes[i] = (byte) randomFunctionCaller();
        }
        return bytes;
    }
}
