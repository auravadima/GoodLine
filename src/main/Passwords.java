package main;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Passwords {

    private static final int COUNT_OF_SYMBOLS = 25;

    //Возвращает хэшированную по 128-битному алгоритму строку
    private static String hash(String pass) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(pass.getBytes());

        byte byteData[] = md.digest();

        StringBuilder sb = new StringBuilder();
        for (byte aByteData : byteData) {
            sb.append(Integer.toString((aByteData & 0xff) + 0x100, 16).substring(1));
        }
        return sb.toString();
    }

    //Возвращает рандомную строку длины 25, состоящую из элементов [a-zA-Z0-9]
    public static String randSalt() {
        String symbols = "abcdefghijklmopqwertuvwxyz1234567890";
        StringBuilder randString = new StringBuilder();
        for (int i = 0; i < COUNT_OF_SYMBOLS; i++)
            randString.append(symbols.charAt((int) (Math.random() * symbols.length())));
        return randString.toString();
    }

    //Возвращает строку хэшированную в виде hash(hash(STR) + ANOTHER_STR))
    public static String getHash(String pass, String salt) throws NoSuchAlgorithmException {
        return hash(hash(pass) + salt);
    }
}
