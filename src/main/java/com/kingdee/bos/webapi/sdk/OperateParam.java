package com.kingdee.bos.webapi.sdk;

import java.util.List;

public class OperateParam
  extends JsonBase {
  String Ids;
  String CreateOrgId;
  List<String> Numbers;

  public String getIds() {
    return this.Ids;
  }

  public void setIds(String ids) {
    this.Ids = ids;
  }

  public String getCreateOrgId() {
    return this.CreateOrgId;
  }

  public void setCreateOrgId(String createOrgId) {
    this.CreateOrgId = createOrgId;
  }

  public List<String> getNumbers() {
    return this.Numbers;
  }

  public void setNumbers(List<String> numbers) {
    this.Numbers = numbers;
  }
}
