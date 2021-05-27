/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SIS;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;


/**
 *
 * @author Usuario
 */
public class Datos 
{
     private static byte[] key = {
            0x74, 0x68, 0x69, 0x73, 0x49, 0x73, 0x41, 0x53, 0x65, 0x63, 0x72, 0x65, 0x74, 0x4b, 0x65, 0x79
    };//"thisIsASecretKey";

    public Datos() 
    {
    }
    
    public static String Dencriptar(String Cadena)
    {
        try
        {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
            final SecretKeySpec secretKey = new SecretKeySpec(key, "AES");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            final String decryptedString = new String(cipher.doFinal(Base64.decodeBase64(Cadena)));
            return decryptedString;
        }
        catch (Exception e)
        {
            

        }
        return null;
    }

    public static String Encriptar(String Cadena) throws Exception 
    {
        try
        {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            final SecretKeySpec secretKey = new SecretKeySpec(key, "AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            final String encryptedString = Base64.encodeBase64String(cipher.doFinal(Cadena.getBytes()));
            return encryptedString;
        }
        catch (Exception e)
        {
            throw e;
        }
        //return null;

    }
    
    
    
}
