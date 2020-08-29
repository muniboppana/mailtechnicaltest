package com.dxc.mail.technicaltest.util;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class SecurityHelper {

    private static SecretKeySpec secretKey;
    private static byte[] key;

    private static void setKey(String aesformat, String algorithmFormat)
    {
        MessageDigest sha = null;
        try {
            key = aesformat.getBytes("UTF-8");
            sha = MessageDigest.getInstance("SHA-256");
            key = sha.digest(key);
            secretKey = new SecretKeySpec(key, algorithmFormat);
        }
        catch (NoSuchAlgorithmException e) {
            System.out.println("Exception occured not specific algorthim "+e);
        }
        catch (UnsupportedEncodingException e) {
            System.out.println("Unsupported Encoding exception "+e);
        }
    }

    public static String encrypt(String strToEncrypt, String secret,String algorithmFormat)
    {
        try
        {
            setKey(secret, algorithmFormat);
            Cipher cipher = Cipher.getInstance(algorithmFormat);
            KeyGenerator keygen = KeyGenerator.getInstance(algorithmFormat) ;
            keygen.init(256) ;
            byte[] key = keygen.generateKey().getEncoded();
            SecretKeySpec skeySpec = new SecretKeySpec(key, algorithmFormat);
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
            byte[] outputBytes = cipher.doFinal(strToEncrypt.getBytes("UTF-8"));
          return  Base64.encodeBase64String(outputBytes);
        }
        catch (Exception e)
        {
            System.out.println("Error while encrypting: " + e.toString());
        }
        return null;

    }
}

