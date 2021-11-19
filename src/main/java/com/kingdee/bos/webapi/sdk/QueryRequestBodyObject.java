package com.kingdee.bos.webapi.sdk;

public class QueryRequestBodyObject
  extends RequestBodyObject {
  String beginmethod;
  String querymethod;

  QueryRequestBodyObject(Object[] parameters) {
    super(parameters);
    this.beginmethod = "BeginQueryImpl";
    this.querymethod = "QueryAsyncResult";
  }

  public String getBeginmethod() {
    return this.beginmethod;
  }

  public void setBeginmethod(String beginmethod) {
    this.beginmethod = beginmethod;
  }

  public String getQuerymethod() {
    return this.querymethod;
  }

  public void setQuerymethod(String querymethod) {
    this.querymethod = querymethod;
  }
}
