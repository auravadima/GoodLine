import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Passwords {

    public static final int COUNT_OF_SYMBOLS = 25;


    public static String hash(String text) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(text.getBytes());

        byte byteData[] = md.digest();

        StringBuffer sb = new StringBuffer();
        for (byte aByteData : byteData) {
            sb.append(Integer.toString((aByteData & 0xff) + 0x100, 16).substring(1));
        }
        return sb.toString();
    }

    public static String randSalt() {
        String symbols = "abcdefghijklmopqwertuvwxyz1234567890";
        StringBuilder randString = new StringBuilder();
        for (int i = 0; i < COUNT_OF_SYMBOLS; i++)
            randString.append(symbols.charAt((int) (Math.random() * symbols.length())));
        return randString.toString();
    }

}
