public class BifidCipher {
    private static final String stringAlphabet = "abcdefghiklmnopqrstuvwxyz";

    public static String encryptBifid(String original, String key) {
        String square = generatePolybiusSquare(key);
        String text = original.toLowerCase().replace('j', 'i').replaceAll("[^a-z]", "");

        int[] coordinates = new int[text.length() * 2]; // first rows, then cols (0-based)
        for (int i = 0; i < text.length(); i++) {
            char letter = text.charAt(i);
            int index = square.indexOf(letter);
            int y = index / 5;
            int x = index % 5;
            coordinates[i] = y;
            coordinates[i + text.length()] = x;
        }

        StringBuilder output = new StringBuilder();
        for (int i = 0; i < text.length() * 2 - 1; i += 2) {
            int y = coordinates[i];
            int x = coordinates[i + 1];
            int idx = y * 5 + x; // 0-based index into square
            output.append(square.charAt(idx));
        }
        return output.toString();
    }

    private static String removeDuplicates(String input) {
        StringBuilder out = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char letter = Character.toLowerCase(input.charAt(i));
            if (letter == 'j') letter = 'i';
            if (letter >= 'a' && letter <= 'z') {
                if (out.indexOf(String.valueOf(letter)) == -1) {
                    out.append(letter);
                }
            }
        }

        return String.valueOf(out);
    }

    public static String generatePolybiusSquare(String key) {
        StringBuilder square = new StringBuilder(removeDuplicates(key + stringAlphabet));
        if (square.length() > 25) square = new StringBuilder(square.substring(0, 25));
        return square.toString();
    }
}
