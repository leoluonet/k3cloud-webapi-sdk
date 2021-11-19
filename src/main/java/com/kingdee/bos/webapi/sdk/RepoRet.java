package com.kingdee.bos.webapi.sdk;

public class RepoRet {
  RepoResult Result;

  public boolean isSuccessfully() {
    if (this.Result == null) {
      return false;
    }
    if (this.Result.getResponseStatus() == null) {
      return false;
    }
    return this.Result.getResponseStatus().isIsSuccess();
  }

  public RepoResult getResult() {
    return this.Result;
  }

  public void setResult(RepoResult result) {
    this.Result = result;
  }
}
