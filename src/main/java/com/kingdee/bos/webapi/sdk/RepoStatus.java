package com.kingdee.bos.webapi.sdk;

import java.util.ArrayList;

public class RepoStatus {
  String ErrorCode;
  boolean IsSuccess;
  ArrayList<RepoError> Errors;
  ArrayList<SuccessEntity> SuccessEntitys;

  public String getErrorCode() {
    return this.ErrorCode;
  }

  public void setErrorCode(String errorCode) {
    this.ErrorCode = errorCode;
  }

  public boolean isIsSuccess() {
    return this.IsSuccess;
  }

  public void setIsSuccess(boolean isSuccess) {
    this.IsSuccess = isSuccess;
  }

  public ArrayList<RepoError> getErrors() {
    return this.Errors;
  }

  public void setErrors(ArrayList<RepoError> errors) {
    this.Errors = errors;
  }

  public ArrayList<SuccessEntity> getSuccessEntitys() {
    return this.SuccessEntitys;
  }

  public void setSuccessEntitys(ArrayList<SuccessEntity> successEntitys) {
    this.SuccessEntitys = successEntitys;
  }
}
