package com.pichincha.automationtest.util.apis.encrypt;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.pichincha.automationtest.util.apis.enumsEncrypt.EnumMsgEncrypt.*;

public class Encrypt {

  private static final String DESEDE = "DESede";
  private static final String SECRET_KEY = PHRASSE_SECURITY.getMensaje();
  private static final Logger LOGGER = Logger.getLogger(Encrypt.class.getName());

  private Encrypt() {}

  public static String encrypt(String texto) {
    String base64EncryptedString = "";
    try {
      MessageDigest md = MessageDigest.getInstance("MD5");
      byte[] digestOfPassword = md.digest(SECRET_KEY.getBytes(StandardCharsets.UTF_8));
      byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);
      SecretKey key = new SecretKeySpec(keyBytes, DESEDE);
      Cipher cipher = Cipher.getInstance(DESEDE);
      cipher.init(Cipher.ENCRYPT_MODE, key);
      byte[] plainTextBytes = texto.getBytes(StandardCharsets.UTF_8);
      byte[] buf = cipher.doFinal(plainTextBytes);
      byte[] base64Bytes = Base64.encodeBase64(buf);
      base64EncryptedString = new String(base64Bytes);
    } catch (NoSuchAlgorithmException
        | IllegalBlockSizeException
        | BadPaddingException
        | NoSuchPaddingException
        | InvalidKeyException e) {
      LOGGER.log(Level.WARNING, ENCRYPT_ERROR.getMensaje(), e);
    }
    return base64EncryptedString;
  }

  public static void main(String[] args) {
    LOGGER.log(Level.INFO, encrypt("david01@gmail.com"));
    LOGGER.log(Level.INFO, encrypt("123456"));
//    LOGGER.log(Level.INFO, decrypt("/WCbTIfn5OG00fIF9NfXaX1gQOdDFuv79DmAzJOLrwI="));
//    LOGGER.log(Level.INFO, decrypt("X2b4XSnhin3TyzodYEuJQQ=="));
  }

  public static String decrypt(String textoEncriptado) {
    String base64EncryptedString = "";
    try {
      byte[] message = Base64.decodeBase64(textoEncriptado.getBytes(StandardCharsets.UTF_8));
      MessageDigest md = MessageDigest.getInstance("MD5");
      byte[] digestOfPassword = md.digest(SECRET_KEY.getBytes(StandardCharsets.UTF_8));
      byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);
      SecretKey key = new SecretKeySpec(keyBytes, DESEDE);
      Cipher decipher = Cipher.getInstance(DESEDE);
      decipher.init(Cipher.DECRYPT_MODE, key);
      byte[] plainText = decipher.doFinal(message);
      base64EncryptedString = new String(plainText, StandardCharsets.UTF_8);
    } catch (NoSuchAlgorithmException
        | IllegalBlockSizeException
        | BadPaddingException
        | NoSuchPaddingException
        | InvalidKeyException e) {
      LOGGER.log(Level.WARNING, DECRYPT_ERROR.getMensaje(), e);
    }
    return base64EncryptedString;
  }
}
