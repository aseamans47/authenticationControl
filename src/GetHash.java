
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author whataruckus
 */
public class GetHash {

    public String getMD5Hash(String password) {

        // This MessageDigest class provides applications 
        // the functionality of a message digest algorithm
        MessageDigest md = null;
        String hashedPassword = null;
        StringBuffer sb = new StringBuffer();

        if (password != null) {
            try {
                md = MessageDigest.getInstance("MD5");
                md.update(password.getBytes());
                byte[] digest = md.digest();

                for (byte b : digest) {
                    sb.append(String.format("%02x", b & 0xff));
                }

                hashedPassword = sb.toString();
            } catch (NoSuchAlgorithmException nsae) {
                System.err.println(nsae);
            }
        }

        return hashedPassword;
    }
}
