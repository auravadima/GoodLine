package main;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

class Passwords {

    private static final int COUNT_OF_SYMBOLS = 25;

    /**
     * Возвращает хэшированную по 128-битному алгоритму строку
     */
    private static String hash(String pass) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        //Обновление дайджеста массивом байтов
        md.update(pass.getBytes());

        byte byteData[] = md.digest();
        //Инициализация объекта класса StringBuilder
        StringBuilder sb = new StringBuilder();
        for (byte aByteData : byteData) {
            /*
            Без значения & 0xff значения, превышающие 0x7f, окажутся отрицательными значениями int.
            добавление 0x10  просто включает бит в индекс 8 (так как он гарантированно равен 0 in (aByteData & 0xff)
            Причина первого добавления 0x100, должна гарантировать три шестнадцатеричные цифры в конечном результате.
            В противном случае значения байтов ниже 0x10 в результате будут переведены в шестнадцатеричный.
            Затем снимается лишняя шетнадцатиричная цифра с помощью substring(1) для получения двух цифр.
            */
            sb.append(Integer.toString((aByteData & 0xff) + 0x100 ,16)).substring(1);
        }
        return sb.toString();
    }

    /**
     * Возвращает рандомную строку длины 25, состоящую из элементов [a-zA-Z0-9]
     */
    static String randSalt() {
        //Набор символов
        String symbols = "abcdefghijklmopqwertuvwxyz1234567890";
        //Инициализация объекта класса StringBuilder
        StringBuilder randString = new StringBuilder();
        //Добавление в строку рандомного символа один за другим
        for (int i = 0; i < COUNT_OF_SYMBOLS; i++) {
            randString.append(symbols.charAt((int) (Math.random() * symbols.length())));
        }
        randString.reverse();
        return randString.toString();
    }

    /**
     * Возвращает строку хэшированную в виде hash(hash(STR) + ANOTHER_STR))
     */
    static String getHash(String pass, String salt) throws NoSuchAlgorithmException {
        return hash(hash(pass) + salt);
    }

    static boolean isEqual(byte[] a, byte[] b) {
        if (a.length != b.length) {
            return false;
        }

        int result = 0;
        for (int i = 0; i < a.length; i++) {
            result |= a[i] ^ b[i];
        }
        return result == 0;
    }
}
