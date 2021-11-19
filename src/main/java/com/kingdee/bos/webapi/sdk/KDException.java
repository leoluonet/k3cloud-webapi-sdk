package com.kingdee.bos.webapi.sdk;

import com.google.gson.Gson;

public class KDException {
  String Message;
  KDException InnerExWrapper;
  KDException InnerException;

  public static KDException parse(String json) {
    try {
      int index = json.indexOf("{");
      if (index < 0) {
        json = json.substring(index);
      }
      Gson gson = new Gson();
      return (KDException) gson.fromJson(json, KDException.class);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  public String getMessage() {
    return this.Message;
  }

  public void setMessage(String message) {
    this.Message = message;
  }

  public KDException getInnerExWrapper() {
    return this.InnerExWrapper;
  }

  public void setInnerExWrapper(KDException innerExWrapper) {
    this.InnerExWrapper = innerExWrapper;
  }

  public KDException getInnerException() {
    return this.InnerException;
  }

  public void setInnerException(KDException innerException) {
    this.InnerException = innerException;
  }
}
