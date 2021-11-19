package com.kingdee.bos.webapi.sdk;

import java.util.ArrayList;

public class SaveParamBase
  extends JsonBase {
  int Creator;
  ArrayList<String> NeedReturnFields;
  ArrayList<String> NeedUpDateFields;

  public SaveParamBase() {
    this.NeedReturnFields = new ArrayList();
    this.NeedUpDateFields = new ArrayList();
  }

  public int getCreator() {
    return this.Creator;
  }

  public void setCreator(int creator) {
    this.Creator = creator;
  }

  public ArrayList<String> getNeedReturnFields() {
    return this.NeedReturnFields;
  }

  public void setNeedReturnFields(ArrayList<String> needReturnFields) {
    this.NeedReturnFields = needReturnFields;
  }

  public ArrayList<String> getNeedUpDateFields() {
    return this.NeedUpDateFields;
  }

  public void setNeedUpDateFields(ArrayList<String> needUpDateFields) {
    this.NeedUpDateFields = needUpDateFields;
  }
}
