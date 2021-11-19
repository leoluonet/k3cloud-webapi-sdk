package com.kingdee.bos.webapi.sdk;

public class Context {
  String DBid;
  String SessionId;
  int UserId;
  String UserName;
  String DisplayVersion;
  String DataCenterName;

  public String getDBid() {
    return this.DBid;
  }

  public void setDBid(String dBid) {
    this.DBid = dBid;
  }

  public String getSessionId() {
    return this.SessionId;
  }

  public void setSessionId(String sessionId) {
    this.SessionId = sessionId;
  }

  public int getUserId() {
    return this.UserId;
  }

  public void setUserId(int userId) {
    this.UserId = userId;
  }

  public String getUserName() {
    return this.UserName;
  }

  public void setUserName(String userName) {
    this.UserName = userName;
  }

  public String getDisplayVersion() {
    return this.DisplayVersion;
  }

  public void setDisplayVersion(String displayVersion) {
    this.DisplayVersion = displayVersion;
  }

  public String getDataCenterName() {
    return this.DataCenterName;
  }

  public void setDataCenterName(String dataCenterName) {
    this.DataCenterName = dataCenterName;
  }
}
