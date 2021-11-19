package com.kingdee.bos.webapi.sdk;

public class ObjectUtils {
  public static boolean anyNotNull(Object obj) {
    if (obj == null) {
      return false;
    }
    return true;
  }

  public static int ConvertToInt(Object obj) {
    if (obj == null) {
      return 0;
    }
    String cv = obj.toString();
    int pIndex = cv.indexOf(".");
    if (pIndex > -1) {
      cv = cv.substring(0, pIndex);
    }
    return Integer.parseInt(cv);
  }

  public static String ConvertToString(Object obj) {
    if (obj == null) {
      return null;
    }
    return obj.toString();
  }
}
