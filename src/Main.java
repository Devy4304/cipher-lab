public class Main {
    public static void main(String[] args) {
        System.out.println("Running tests...\n\n");
        System.out.println("Testing Vigenere Cipher:");
        System.out.println("Mhkg al a usukev awlscuw!!!".equals(VigenereCipher.encryptVigenere("This is a secret message!!!", "tacos", true, false)) ? "Test passed" : "Test failed");
        System.out.println("G Vqdih, Jgqgf, aawjihfvx sjx vysn Jgqgf?".equals(VigenereCipher.encryptVigenere("O Romeo, Romeo, wherefore art thou Romeo?", "secrets", true, false)) ? "Test passed" : "Test failed");
        System.out.println("Tig hwxkukn yq xvtt it dxx f sfacock, hbznpyq.".equals(VigenereCipher.encryptVigenere("The essence of life is but a mystery, unknown.", "abcdefghijklmnop", true, false)) ? "Test passed" : "Test failed");
        System.out.println(" ");
        System.out.println("Testing Bifid Cipher:");
        System.out.println("yfdncsatyekbfvt".equals(BifidCipher.encryptBifid("bifid cipher test", "key")) ? "Test passed" : "Test failed");
        System.out.println("rddvvnbrfummummenl".equals(BifidCipher.encryptBifid("This is a bifid cipher", "nvidia")) ? "Test passed" : "Test failed");
        System.out.println("waqbrmqyraimofchtqeuesmutarmby".equals(BifidCipher.encryptBifid("What to be this text, that I am reading?", "ocean")) ? "Test passed" : "Test failed");
    }
}
