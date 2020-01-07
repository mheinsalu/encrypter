package ee.mrtnh.encrypter_demo.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

@Resource
public class AES {
    // Class from https://howtodoinjava.com/security/java-aes-encryption-example/

    private static SecretKeySpec secretKey;
    private static byte[] key;

    private static final Logger logger = LoggerFactory.getLogger(AES.class);

    public static void setKey(String myKey) {
        MessageDigest sha = null;
        try {
            key = myKey.getBytes(StandardCharsets.UTF_8);
            sha = MessageDigest.getInstance("SHA-1");
            key = sha.digest(key);
            key = Arrays.copyOf(key, 16);
            secretKey = new SecretKeySpec(key, "AES");
        } catch (NoSuchAlgorithmException e) {
            logger.error("NoSuchAlgorithmException in class AES method setKey", e);
        }
    }

    public static String encrypt(String strToEncrypt, String secret) {
        try {
            setKey(secret);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));
        } catch (Exception e) {
            logger.error("Exception in class AES method encrypt", e);
        }
        return null;
    }

    public static String decrypt(String strToDecrypt, String secret) {
        try {
            setKey(secret);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
        } catch (IllegalBlockSizeException e) {
            logger.error("IllegalBlockSizeException in class AES method decrypt", e);
            return "Invalid input: input length must be multiple of 16";
        } catch (IllegalArgumentException e) {
            logger.error("IllegalArgumentException in class AES method decrypt", e);
            return "Invalid input: last unit does not have enough valid bits";
        } catch (Exception e) {
            logger.error("Exception in class AES method decrypt", e);
        }
        return "Error: unknown error";
    }
}
