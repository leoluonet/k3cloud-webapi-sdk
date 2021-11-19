package com.kingdee.bos.webapi.sdk;

public class LoginResult {
  String Message;
  String MessageCode;
  int LoginResultType;
  boolean IsSuccessByAPI;
  Context Context;

  public String getMessage() {
    return this.Message;
  }

  public void setMessage(String message) {
    this.Message = message;
  }

  public String getMessageCode() {
    return this.MessageCode;
  }

  public void setMessageCode(String messageCode) {
    this.MessageCode = messageCode;
  }

  public int getLoginResultType() {
    return this.LoginResultType;
  }

  public void setLoginResultType(int loginResultType) {
    this.LoginResultType = loginResultType;
  }

  public boolean getIsSuccessByAPI() {
    return this.IsSuccessByAPI;
  }

  public void setIsSuccessByAPI(boolean isSuccessByAPI) {
    this.IsSuccessByAPI = isSuccessByAPI;
  }

  public Context getContext() {
    return this.Context;
  }

  public void setContext(Context context) {
    this.Context = context;
  }
}
