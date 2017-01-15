package controllers;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SaltyPassword {
    
    public SaltyPassword() {
        
    }

    public  String getSecurePassword(String passwordToHash, byte[] salt) {
        return hashPassword(hashPassword(hashPassword(passwordToHash, salt), salt), salt);
    }

    private static String hashPassword(String passwordToHash, byte[] salt) {
        String generatedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(salt);

            byte[] bytes = md.digest(passwordToHash.getBytes());
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return generatedPassword;
    }

    public  byte[] getSalt() {
        SecureRandom sr = null;
        try {
            sr = SecureRandom.getInstance("SHA1PRNG", "SUN");
        } catch (NoSuchAlgorithmException | NoSuchProviderException ex) {
            Logger.getLogger(SaltyPassword.class.getName()).log(Level.SEVERE, null, ex);
        }
        byte[] salt = new byte[16];
        sr.nextBytes(salt);
        return salt;
    }
}
