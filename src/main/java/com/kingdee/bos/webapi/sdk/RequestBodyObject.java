package com.kingdee.bos.webapi.sdk;

public class RequestBodyObject
  extends JsonBase {
  protected Object[] parameters;

  RequestBodyObject(Object[] parameters) {
    this.parameters = parameters;
  }

  public Object[] getParameters() {
    return this.parameters;
  }

  public void setParameters(Object[] parameters) {
    this.parameters = parameters;
  }
}
