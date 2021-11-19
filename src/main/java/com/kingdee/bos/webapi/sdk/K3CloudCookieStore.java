package com.kingdee.bos.webapi.sdk;

import java.util.HashMap;

public class K3CloudCookieStore {
  String SID;
  HashMap<String, Cookie> cookies;

  public String getSID() {
    return this.SID;
  }

  public void setSID(String sID) {
    this.SID = sID;
  }

  public HashMap<String, Cookie> getCookies() {
    if (this.cookies == null) {
      this.cookies = new HashMap();
    }
    return this.cookies;
  }

  public void setCookies(HashMap<String, Cookie> cookies) {
    this.cookies = cookies;
  }
}
