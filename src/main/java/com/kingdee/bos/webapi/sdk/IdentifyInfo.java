package com.kingdee.bos.webapi.sdk;

public class IdentifyInfo {
  private String serverUrl;
  private String dCID;
  private int lCID = 2052;
  private String userName;
  private String pwd;
  String appId;
  String appSecret;
  String orgNum;
  int lcid;

  public String getServerUrl() {
    return this.serverUrl;
  }

  public IdentifyInfo setServerUrl(String serverUrl) {
    this.serverUrl = serverUrl;
    return this;
  }

  public String getdCID() {
    return this.dCID;
  }

  public IdentifyInfo setdCID(String dCID) {
    this.dCID = dCID;
    return this;
  }

  public int getlCID() {
    return this.lCID;
  }

  public IdentifyInfo setlCID(int lCID) {
    this.lCID = lCID;
    return this;
  }

  public String getUserName() {
    return this.userName;
  }

  public IdentifyInfo setUserName(String userName) {
    this.userName = userName;
    return this;
  }

  public String getPwd() {
    return this.pwd;
  }

  public IdentifyInfo setPwd(String pwd) {
    this.pwd = pwd;
    return this;
  }

  public String getAppId() {
    return this.appId;
  }

  public IdentifyInfo setAppId(String appId) {
    this.appId = appId;
    return this;
  }

  public String getAppSecret() {
    return this.appSecret;
  }

  public IdentifyInfo setAppSecret(String appSecret) {
    this.appSecret = appSecret;
    return this;
  }

  public String getOrgNum() {
    return this.orgNum;
  }

  public void setOrgNum(String orgNum) {
    this.orgNum = orgNum;
  }

  public int getLcid() {
    return this.lcid;
  }

  public IdentifyInfo setLcid(int lcid) {
    this.lcid = lcid;
    return this;
  }
}
