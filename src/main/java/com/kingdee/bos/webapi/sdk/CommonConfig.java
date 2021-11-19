package com.kingdee.bos.webapi.sdk;

public class CommonConfig {
  boolean ResponseUnzip;
  String CustomLoginUI;

  public boolean getResponseUnzip() {
    return this.ResponseUnzip;
  }

  public void setResponseUnzip(boolean responseUnzip) {
    this.ResponseUnzip = responseUnzip;
  }

  public String getCustomLoginUI() {
    return this.CustomLoginUI;
  }

  public void setCustomLoginUI(String customLoginUI) {
    this.CustomLoginUI = customLoginUI;
  }
}
