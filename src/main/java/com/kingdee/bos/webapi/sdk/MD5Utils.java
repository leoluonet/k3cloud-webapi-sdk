package com.kingdee.bos.webapi.sdk;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.MessageDigest;

public class MD5Utils {
  public static String encrypt(String dataStr) {
    try {
      MessageDigest m = MessageDigest.getInstance("MD5");
      m.update(dataStr.getBytes("UTF8"));
      byte[] s = m.digest();
      String result = "";
      for (int i = 0; i < s.length; i++) {
        result = result + Integer.toHexString(0xFF & s[i] | 0xFF00).substring(6);
      }
      return result;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return "";
  }

  public static String hashMAC(String data, String secret) {
    try {
      Mac kdmac = Mac.getInstance("HmacSHA256");
      SecretKeySpec secret_key = new SecretKeySpec(secret.getBytes(), "HmacSHA256");
      kdmac.init(secret_key);
      byte[] rawHmac = kdmac.doFinal(data.getBytes());
      return Base64Utils.encodingToBase64(bytesToHex(rawHmac).getBytes());
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  private static String bytesToHex(byte[] hashInBytes) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < hashInBytes.length; i++) {
      String hex = Integer.toHexString(hashInBytes[i] & 0xFF);
      if (hex.length() < 2) {
        hex = "0" + hex;
      }
      sb.append(hex);
    }
    return sb.toString();
  }
}
