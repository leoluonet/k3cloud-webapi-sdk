package com.kingdee.bos.webapi.sdk;

import java.util.Base64;

public class Base64Utils {
  public static String encodingToBase64(byte[] buffer) {
    byte[] b64buffer = null;
    try {
      b64buffer = Base64.getEncoder().encode(buffer);
      return new String(b64buffer).toString();
    } catch (Exception e) {
      throw e;
    }
  }

  public static byte[] decodingFromBase64(String base64) {
    byte[] b64buffer = null;
    try {
      b64buffer = base64.getBytes();
      return Base64.getDecoder().decode(b64buffer);
    } catch (Exception e) {
      throw e;
    }
  }
}
