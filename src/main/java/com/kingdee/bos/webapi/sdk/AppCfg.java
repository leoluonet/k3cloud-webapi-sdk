package com.kingdee.bos.webapi.sdk;

public class AppCfg {
  private String serverUrl;
  private String dCID;
  private int lCID = 2052;
  private String userName;
  private String pwd;
  String appId;
  String appSecret;
  String orgNum;
  String secSmartKet;
  int connectTimeout;
  int requestTimeout;
  int stockTimeout;
  String proxy;

  public String getServerUrl() {
    return this.serverUrl;
  }

  public AppCfg setServerUrl(String serverUrl) {
    this.serverUrl = serverUrl;
    return this;
  }

  public String getdCID() {
    return this.dCID;
  }

  public AppCfg setdCID(String dCID) {
    this.dCID = dCID;
    return this;
  }

  public int getlCID() {
    return this.lCID;
  }

  public AppCfg setlCID(int lCID) {
    this.lCID = lCID;
    return this;
  }

  public String getUserName() {
    return this.userName;
  }

  public AppCfg setUserName(String userName) {
    this.userName = userName;
    return this;
  }

  public String getPwd() {
    return this.pwd;
  }

  public AppCfg setPwd(String pwd) {
    this.pwd = pwd;
    return this;
  }

  public String getAppId() {
    return this.appId;
  }

  public AppCfg setAppId(String appId) {
    this.appId = appId;
    return this;
  }

  public String getAppSecret() {
    return this.appSecret;
  }

  public AppCfg setAppSecret(String appSecret) {
    this.appSecret = appSecret;
    return this;
  }

  public String getOrgNum() {
    return this.orgNum;
  }

  public void setOrgNum(String orgNum) {
    this.orgNum = orgNum;
  }

  public String getSecSmartKet() {
    return this.secSmartKet;
  }

  public void setSecSmartKet(String secSmartKet) {
    this.secSmartKet = secSmartKet;
  }

  public int getConnectTimeout() {
    return this.connectTimeout;
  }

  public void setConnectTimeout(int connectTimeout) {
    this.connectTimeout = connectTimeout;
  }

  public int getRequestTimeout() {
    return this.requestTimeout;
  }

  public void setRequestTimeout(int requestTimeout) {
    this.requestTimeout = requestTimeout;
  }

  public int getStockTimeout() {
    return this.stockTimeout;
  }

  public void setStockTimeout(int stockTimeout) {
    this.stockTimeout = stockTimeout;
  }

  public String getProxy() {
    return this.proxy;
  }

  public void setProxy(String proxy) {
    this.proxy = proxy;
  }
}
