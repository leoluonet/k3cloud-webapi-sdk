package com.kingdee.bos.webapi.sdk;

import java.util.List;

public class BatchSave<T>
  extends SaveParamBase {
  List<T> Model;

  public BatchSave(List<T> data) {
    setModel(data);
  }

  public List<T> getModel() {
    return this.Model;
  }

  public void setModel(List<T> models) {
    this.Model = models;
  }
}
