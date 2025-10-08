public class VigenereCipher {
    private static final char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();

    public static String encryptVigenere(String original, String key, boolean keepUppercase) {
        if (original.isEmpty() || key.isEmpty()) return "Invalid String or Key";

        key = processKey(key, original);

        System.out.println(original);
        System.out.println(key);

        StringBuilder out = new StringBuilder();
        char[] originalArray = original.toCharArray();
        char[] keyArray = key.toCharArray();

        int letterIndex;
        int keyIndex = 0;

        for (char letter : originalArray) {
            if (String.valueOf(letter).matches("^[A-Za-z]$")) {
                letterIndex = getIndexInAlphabet(letter);
                letterIndex += getIndexInAlphabet(keyArray[keyIndex]);

                if (letterIndex < 0) letterIndex += 26;

                char character = alphabet[letterIndex % alphabet.length];
                out.append((Character.isLowerCase(letter) && keepUppercase) ? character : Character.toUpperCase(character));

                keyIndex++;
            } else {
                out.append(letter);
            }
        }
        return String.valueOf(out);
    }

    private static String processKey(String key, String original) {
        int numberOfKeyRepeats = (original.length() / key.length()) + 1;
        key = key.repeat(numberOfKeyRepeats);
        return key.substring(0, original.length());
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
