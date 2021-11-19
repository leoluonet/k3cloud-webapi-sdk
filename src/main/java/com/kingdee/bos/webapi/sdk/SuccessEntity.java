package com.kingdee.bos.webapi.sdk;

public class SuccessEntity {
  String Id;
  String Number;
  int DIndex;
  String BillNo;

  public String getId() {
    return this.Id;
  }

  public void setId(String id) {
    this.Id = id;
  }

  public String getNumber() {
    return this.Number;
  }

  public void setNumber(String number) {
    this.Number = number;
  }

  public int getDIndex() {
    return this.DIndex;
  }

  public void setDIndex(int dIndex) {
    this.DIndex = dIndex;
  }

  public String getBillNo() {
    return this.BillNo;
  }

  public void setBillNo(String billNo) {
    this.BillNo = billNo;
  }
}
