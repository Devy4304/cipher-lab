public class VigenereCipher {
    private static final char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();

    public static String encryptVigenere(String original, String key, boolean keepUppercase) {
        if (original.isEmpty() || key.isEmpty()) return "Invalid String or Key";

        key = processKey(key, original.length());

        System.out.println(original);
        System.out.println(key);

        StringBuilder out = new StringBuilder();
        char[] originalArray = original.toCharArray();
        char[] keyArray = key.toCharArray();

        int letterIndex;
        int textIndex = 0;

        for (char letter : originalArray) {
            if (String.valueOf(letter).matches("^[A-Za-z]$")) {
                letterIndex = getIndexInAlphabet(letter);
                letterIndex += getIndexInAlphabet(keyArray[textIndex]);

                if (letterIndex < 0) letterIndex += 26;

                char character = alphabet[letterIndex % alphabet.length];
                out.append((Character.isLowerCase(letter) && keepUppercase) ? character : Character.toUpperCase(character));
            } else {
                out.append(letter);
            }

            textIndex++;
        }
        return String.valueOf(out);
    }

    private static String processKey(String key, String original) {
        int numberOfKeyRepeats = (original.length() / key.length()) + 1;
        StringBuilder keyOut = new StringBuilder(key.repeat(numberOfKeyRepeats));

        int index = original.indexOf(" ");
        if (index > 0) {
            keyOut.insert(index, " ");
        }
        while(index >= 0) {
            System.out.println(index);
            index = original.indexOf(" ", index+1);
            keyOut.insert(index, " ");
        }

        return String.valueOf(keyOut.substring(0, original.length()));
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
