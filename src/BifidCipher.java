public class BifidCipher {
    private static final String stringAlphabet = "abcdefghiklmnopqrstuvwxyz";

    public static String encryptBifid(String original, String key) {
        // create our polybius square using the method
        String square = generatePolybiusSquare(key);
        // make sure or text is lowercase, replace 'j' with 'i', and remove special characters, as this cipher does not support them
        String text = original.toLowerCase().replace('j', 'i').replaceAll("[^a-z]", "");

        // create out coordinate array
        int[] coordinates = new int[text.length() * 2];
        // iterate through every letter in the text
        for (int i = 0; i < text.length(); i++) {
            char letter = text.charAt(i);
            // get the index in the square
            int index = square.indexOf(letter);

            // find the x and y coordinates
            int y = index / 5;
            int x = index % 5;

            // put those coordinates in the array where they belong
            coordinates[i] = y;
            coordinates[i + text.length()] = x;
        }

        StringBuilder output = new StringBuilder();
        // iterate through our array
        for (int i = 0; i < text.length() * 2 - 1; i += 2) {
            // retrieve coordinates from our array
            int y = coordinates[i];
            int x = coordinates[i + 1];

            // convert that to a square index
            int idx = y * 5 + x;
            // append that character
            output.append(square.charAt(idx));
        }
        // output result
        return output.toString();
    }

    private static String removeDuplicates(String input) {
        StringBuilder out = new StringBuilder();
        // iterate through input
        for (int i = 0; i < input.length(); i++) {
            // get the lowercase version of that letter
            char letter = Character.toLowerCase(input.charAt(i));
            // re-assign 'j' to 'i', just in case
            if (letter == 'j') letter = 'i';
            // make sure the letter is in range
            if (letter >= 'a' && letter <= 'z') {
                // if the string does not contain the letter, add it
                if (out.indexOf(String.valueOf(letter)) == -1) {
                    out.append(letter);
                }
            }
        }

        // return output
        return String.valueOf(out);
    }

    private static String generatePolybiusSquare(String key) {
        // remove duplicates from the square, by concatenating the key then the alphabet
        String square = removeDuplicates(key + stringAlphabet);
        if (square.length() > 25) square = square.substring(0, 25);
        return square;
    }
}