public class VigenereCipher {
    private static final char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();

    /**
     * This method will return the encrypted text using the Vigenère cipher
     * @param original the text to be encrypted
     * @param key the key used to encrypt the text
     * @param keepUppercase if Uppercase letters should remain Uppercase
     * @return the encrypted version of the inputted text
     */
    public static String encryptVigenere(String original, String key, boolean keepUppercase) {
        // check if inputs are valid
        if (original.isEmpty() || key.isEmpty()) return "Invalid String or Key";

        // process the key so it the proper length
        key = processKey(key, original);

        // declare and initialize variables
        StringBuilder out = new StringBuilder();
        char[] originalArray = original.toCharArray();
        char[] keyArray = key.toCharArray();

        // indexes for where in the string (and key) it is processing
        int letterIndex;
        int keyIndex = 0;

        // for every letter in the original text run the code
        for (char letter : originalArray) {
            // detects if the character is a letter
            if (String.valueOf(letter).matches("^[A-Za-z]$")) {
                // find where that letter is in the alphabet
                letterIndex = getIndexInAlphabet(letter);
                // add an offset based on the key at keyIndex
                letterIndex += getIndexInAlphabet(keyArray[keyIndex]);

                // find that character
                char character = alphabet[letterIndex % alphabet.length];
                // add it to the output and capitalize it if keepUppercase, AND it is supposed to be uppercase
                out.append((Character.isLowerCase(letter) && keepUppercase) ? character : Character.toUpperCase(character));

                // only increment keyIndex if the letter is a letter
                keyIndex++;
            } else {
                // the character is not a letter, add it as is.
                out.append(letter);
            }
        }
        // return final output, in String type
        return String.valueOf(out);
    }

    private static String processKey(String key, String original) {
        // make the key long enough to be trimmed, then cut out the leftover bits based on the length of the unencrypted text
        return key.repeat((original.length() / key.length()) + 1).substring(0, original.length());
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
