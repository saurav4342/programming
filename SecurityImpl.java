package project1;

import java.io.UnsupportedEncodingException;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.Security;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidKeySpecException;

import java.security.spec.KeySpec;

import java.util.Arrays;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;

public class SecurityImpl
{
    private static final String EOL = System.getProperty("line.separator");

    public static void main(final String[] args) throws NoSuchAlgorithmException, NoSuchPaddingException,
                         
                                                        InvalidKeySpecException, InvalidKeyException,
                                                        InvalidAlgorithmParameterException,
                                                        UnsupportedEncodingException, IllegalBlockSizeException,
                                                        BadPaddingException {
        String s="Welcome@12";
         byte[] mSalt = {(byte)0x91, (byte)0x9B, (byte)0xE8, (byte)0x09,
                                       (byte)0x46, (byte)0x85, (byte)0xE3, (byte)0x13};
        String mPassPhrase = "GHcPvvdmz5oTurKnFqzur9ShLDMhAfiu";
        KeySpec keySpec = new PBEKeySpec(mPassPhrase.toCharArray());
        AlgorithmParameterSpec paramSpec = new PBEParameterSpec(mSalt, 87);

        Cipher ciph = Cipher.getInstance("PBEWithMD5AndTripleDES");
        System.out.println(ciph.getAlgorithm());
        SecretKey key = SecretKeyFactory.getInstance("PBEWithMD5AndDES").generateSecret(keySpec);
        ciph.init(Cipher.ENCRYPT_MODE, key, paramSpec);
        byte[] utf8 = s.getBytes("UTF8");

        // Encrypt
        byte[] enc = ciph.doFinal(utf8);

        // Encode bytes to base64 to get a string
        String encryptedString = new sun.misc.BASE64Encoder().encode(enc);
        System.out.println(encryptedString);

    }
}
