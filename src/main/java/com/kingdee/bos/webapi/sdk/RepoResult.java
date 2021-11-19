package com.kingdee.bos.webapi.sdk;

public class RepoResult {
  String Id;
  RepoStatus ResponseStatus;

  public String getId() {
    return this.Id;
  }

  public void setId(String id) {
    this.Id = id;
  }

  public RepoStatus getResponseStatus() {
    return this.ResponseStatus;
  }

  public void setResponseStatus(RepoStatus responseStatus) {
    this.ResponseStatus = responseStatus;
  }
}
