package com.kingdee.bos.webapi.sdk;

public class SaveParam<T>
  extends SaveParamBase {
  T Model;

  public SaveParam(T data) {
    setModel(data);
  }

  public T getModel() {
    return (T) this.Model;
  }

  public void setModel(T model) {
    this.Model = model;
  }
}
