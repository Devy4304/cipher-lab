public class Main {
    public static void main(String[] args) {
        System.out.println("Running tests...");

        System.out.println("Testing Vigenere Cipher:");
        System.out.println(("Mhkg al a usukev awlscuw!!!".equals(VigenereCipher.encryptVigenere("This is a secret message!!!", "tacos", true, false))) ? "Test passed" : "Test failed");
        System.out.println(("G Vqdih, Jgqgf, aawjihfvx sjx vysn Jgqgf?".equals(VigenereCipher.encryptVigenere("O Romeo, Romeo, wherefore art thou Romeo?", "secrets", true, false))) ? "Test passed" : "Test failed");
        System.out.println(("Tig hwxkukn yq xvtt it dxx f sfacock, hbznpyq.".equals(VigenereCipher.encryptVigenere("Tig hwxkukn yq xvtt it dxx f sfacock, hbznpyq.", "abcdefghijklmnop", true, false))) ? "Test passed" : "Test failed");
    }
}
