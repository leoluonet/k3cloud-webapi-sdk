package com.kingdee.bos.webapi.sdk;

public class KDContext {
  int UserId;

  public int getUserId() {
    return this.UserId;
  }

  public KDContext setUserId(int userId) {
    this.UserId = userId;
    return this;
  }
}
