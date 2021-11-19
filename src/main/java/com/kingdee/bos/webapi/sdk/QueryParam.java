package com.kingdee.bos.webapi.sdk;

public class QueryParam
  extends JsonBase {
  String FormId;
  String FieldKeys;
  String FilterString;
  String OrderString;
  int StartRow;
  int Limit;
  int TopRowCount;

  public String getFormId() {
    return this.FormId;
  }

  public QueryParam setFormId(String formId) {
    this.FormId = formId;
    return this;
  }

  public String getFieldKeys() {
    return this.FieldKeys;
  }

  public QueryParam setFieldKeys(String fieldKeys) {
    this.FieldKeys = fieldKeys;
    return this;
  }

  public String getFilterString() {
    return this.FilterString;
  }

  public QueryParam setFilterString(String filterString) {
    this.FilterString = filterString;
    return this;
  }

  public String getOrderString() {
    return this.OrderString;
  }

  public QueryParam setOrderString(String orderString) {
    this.OrderString = orderString;
    return this;
  }

  public int getStartRow() {
    return this.StartRow;
  }

  public QueryParam setStartRow(int startRow) {
    this.StartRow = startRow;
    return this;
  }

  public int getLimit() {
    return this.Limit;
  }

  public QueryParam setLimit(int limit) {
    this.Limit = limit;
    return this;
  }

  public int getTopRowCount() {
    return this.TopRowCount;
  }

  public QueryParam setTopRowCount(int topRowCount) {
    this.TopRowCount = topRowCount;
    return this;
  }
}
