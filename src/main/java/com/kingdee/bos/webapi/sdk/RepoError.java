package com.kingdee.bos.webapi.sdk;

public class RepoError {
  String FieldName;
  String Message;
  int DIndex;

  public String getFieldName() {
    return this.FieldName;
  }

  public void setFieldName(String fieldName) {
    this.FieldName = fieldName;
  }

  public String getMessage() {
    return this.Message;
  }

  public void setMessage(String message) {
    this.Message = message;
  }

  public int getDIndex() {
    return this.DIndex;
  }

  public void setDIndex(int dIndex) {
    this.DIndex = dIndex;
  }
}
