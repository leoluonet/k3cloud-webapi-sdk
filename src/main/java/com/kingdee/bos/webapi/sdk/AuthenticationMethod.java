package com.kingdee.bos.webapi.sdk;

public class AuthenticationMethod {
  public static final int AuthenticationType_DomainAuthentication = 0;
  public static final int AuthenticationType_PwdAuthentication = 1;
  int AuthenticationMethodType;
  String Name;

  public int getAuthenticationMethodType() {
    return this.AuthenticationMethodType;
  }

  public void setAuthenticationMethodType(int authenticationMethodType) {
    this.AuthenticationMethodType = authenticationMethodType;
  }

  public String getName() {
    return this.Name;
  }

  public void setName(String name) {
    this.Name = name;
  }
}
