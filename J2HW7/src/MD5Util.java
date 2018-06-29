/**
 * Support encryption MD5, SHA-256
 *
 * @author Andrew Shevelev, Information support devcolibri.com
 * @version 1.0 dated Jun 27, 2018
 */

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

class MD5Util {

    public static String md5Custom(String st) {
        MessageDigest messageDigest = null;
        byte[] digest = new byte[0];

        try {
            messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(st.getBytes());
            digest = messageDigest.digest();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        BigInteger bigInt = new BigInteger(1, digest);
        String md5Hex = bigInt.toString(16);

        while( md5Hex.length() < 32 ){
            md5Hex = "0" + md5Hex;
        }

        return md5Hex;
    }

    public static String SHA256Custom (String str) {
        MessageDigest messageDigest = null;
        byte[] digest = new byte[0];
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.reset();
            messageDigest.update(str.getBytes());
            digest = messageDigest.digest();

        }catch (Exception ex) {
            ex.printStackTrace();
        }

        BigInteger bigInt = new BigInteger(1, digest);
        String sha256Hex = bigInt.toString(16);


        return sha256Hex;
    }

}
