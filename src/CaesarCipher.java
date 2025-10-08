public class CaesarCipher {
    private static final char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();

    public static String encryptCaesar(String original, int key, boolean keepUppercase) {
        StringBuilder out = new StringBuilder();
        char[] originalArray = original.toCharArray();
        int letterIndex = 0;
        int newIndex = 0;

        for (char letter : originalArray) {
            letterIndex = getIndexInAlphabet(letter);
            newIndex = letterIndex + key;
            if (newIndex < 0) newIndex += 26;
            char character = alphabet[newIndex % alphabet.length];
            out.append((Character.isLowerCase(letter) && keepUppercase) ? character : Character.toUpperCase(character));
        }
        return String.valueOf(out);
    }

    private static int getIndexInAlphabet(char letter) {
        for (int i = 0; i < alphabet.length; i++) {
            if (alphabet[i] == (Character.toLowerCase(letter))) {
                return i;
            }
        }
        return 0;
    }
}
