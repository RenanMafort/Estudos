package br.com.devdojo.varargs.encripty;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordEncoder {

    public static String encryptPassword(String password) throws NoSuchAlgorithmException, NoSuchAlgorithmException {


        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(password.getBytes());
        byte[] byteData = md.digest();

        StringBuilder sb = new StringBuilder();
        for (byte b : byteData) {
            sb.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
        }

        return sb.toString();
    }

    public static boolean verify(String senha)   {
         String chave = "1d3017106a23c6ec255d5c49d31d1dcaa3c1a4f19778906a8b979fe481e4fb08";
        MessageDigest mg = null;
        try {
            mg = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

        mg.update(senha.getBytes());
        byte[] byteData = mg.digest();

        StringBuilder sb = new StringBuilder();
        for (byte b : byteData) {
            sb.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
        }

        String senhaaaa = sb.toString();
        if (senhaaaa.equals(chave)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        String token = "59de30582ea912f033c92cda267dda93275ab3a35478cf5a9b7ce831573f7d93";
        String senha1 = PasswordEncoder.encryptPassword("renan1010");
        String senha2 = PasswordEncoder.encryptPassword("renan1010");
        System.out.println(senha1.equals(senha2));
        System.out.println(token.equals(senha1) || token.equals(senha2));
    }
}
