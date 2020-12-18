package gmail.xrapalex.game;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class MovesCode {

    private final String moves;
    private final SecretKey secretKey;

    public MovesCode(String moves) {
        this.moves = moves;
        this.secretKey = generateKey();
    }

    public String getSecretKey() {
        byte[] bytes = secretKey.getEncoded();
        return convertToHex(bytes);
    }

    private SecretKey generateKey() {
        SecretKey secretKey = null;
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacSHA256");
            SecureRandom secureRandom = new SecureRandom();
            int keyBitSize = 128;
            keyGenerator.init(keyBitSize, secureRandom);
            secretKey = keyGenerator.generateKey();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return secretKey;
    }

    public String getCodeHex(){
        String hex = "";
        try {
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(secretKey);
            byte[] movesByte = moves.getBytes(StandardCharsets.UTF_8);
            byte[] macBytes = mac.doFinal(movesByte);
            hex = convertToHex(macBytes);
        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
            e.printStackTrace();
        }
        return hex ;
    }

    private String convertToHex(byte[] bytes){
        StringBuilder sb = new StringBuilder();
        for (byte i : bytes) {
            sb.append(byteToHex(i));
        }
        return sb.toString();
    }

    private String byteToHex(byte num) {
        char[]hexDigits = new char[2];
        hexDigits[0]= Character.forDigit((num >> 4) & 0xF, 16);
        hexDigits[1]= Character.forDigit((num & 0xF), 16);
        return new String(hexDigits).toUpperCase();
    }
}
