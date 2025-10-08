public class CaesarCipher {
    private static final char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();

    /**
     * This method returns the encrypted text when passed through the Caesar cipher
     * @param original the text to be encrypted
     * @param key the offset used to encode the text
     * @param keepUppercase if Uppercase letters should remain Uppercase
     * @return the encrypted version of the inputted text
     */
    public static String encryptCaesar(String original, int key, boolean keepUppercase) {
        // declare and initialize variables
        StringBuilder out = new StringBuilder();
        char[] originalArray = original.toCharArray();
        int letterIndex;
        int newIndex;

        // for every letter in the original text run the code
        for (char letter : originalArray) {
            // gets index of letter
            letterIndex = getIndexInAlphabet(letter);

            // add offset to index
            newIndex = letterIndex + key;

            // make sure it stays in bounds
            if (newIndex < 0) newIndex += 26;

            // get the encoded character
            char character = alphabet[newIndex % alphabet.length];

            // add it to the output, and capitalize it if keepUppercase AND it is supposed to be uppercase
            out.append((Character.isLowerCase(letter) && keepUppercase) ? character : Character.toUpperCase(character));
        }

        // return the output from the encoding
        return String.valueOf(out);
    }

    /**
     * This method will return the index of the specified letter in the alphabet.
     * @param letter letter is the letter we want to get the index of
     * @return the index of letter, if it is not found, 0 is returned
     */
    private static int getIndexInAlphabet(char letter) {
        // repeat over the alphabet
        for (int i = 0; i < alphabet.length; i++) {
            // check if out letter (in lowercase) is equal to the letter from the alphabet
            if (alphabet[i] == (Character.toLowerCase(letter))) {
                // if so, return the index of that letter
                return i;
            }
        }
        // if it can't find that letter, return 0, this should never happen though, if the method is correctly used
        return 0;
    }
}
