package com.kingdee.bos.webapi.sdk;

public class Organization {
  int FOrgID;
  String FNumber;
  String FName;
  int FOrgFormID;
  String FParentNumber;
  String FDescription;
  boolean FIsAccountOrg;
  boolean FIsProfileCenter;
  boolean FIsCorp;
  String FAcctOrgType;
  String FADDRESS;
  String FTel;
  String FPostCode;
  String FContact;
  boolean FIsBusinessOrg;
  boolean FSaleBox;
  boolean FPurchaseBox;
  boolean FStockBox;
  boolean FQualityBox;
  boolean FCapitalBox;
  boolean FShareCenter;
  boolean FService;
  boolean FMarketing;
  boolean FIsSynCERPOwer;
  String FOrgFunctions;

  public int getFOrgID() {
    return this.FOrgID;
  }

  public Organization setFOrgID(int fOrgID) {
    this.FOrgID = fOrgID;
    return this;
  }

  public String getFNumber() {
    return this.FNumber;
  }

  public Organization setFNumber(String fNumber) {
    this.FNumber = fNumber;
    return this;
  }

  public String getFName() {
    return this.FName;
  }

  public Organization setFName(String fName) {
    this.FName = fName;
    return this;
  }

  public int getFOrgFormID() {
    return this.FOrgFormID;
  }

  public Organization setFOrgFormID(int fOrgFormID) {
    this.FOrgFormID = fOrgFormID;
    return this;
  }

  public String getFParentNumber() {
    return this.FParentNumber;
  }

  public void setFParentNumber(String fParentNumber) {
    this.FParentNumber = fParentNumber;
  }

  public String getFDescription() {
    return this.FDescription;
  }

  public void setFDescription(String fDescription) {
    this.FDescription = fDescription;
  }

  public boolean getFIsAccountOrg() {
    return this.FIsAccountOrg;
  }

  public void setFIsAccountOrg(boolean fIs) {
    this.FIsAccountOrg = fIs;
  }

  public boolean isFIsProfileCenter() {
    return this.FIsProfileCenter;
  }

  public void setFIsProfileCenter(boolean fIsProfileCenter) {
    this.FIsProfileCenter = fIsProfileCenter;
  }

  public boolean isFIsCorp() {
    return this.FIsCorp;
  }

  public void setFIsCorp(boolean fIsCorp) {
    this.FIsCorp = fIsCorp;
  }

  public String getFAcctOrgType() {
    return this.FAcctOrgType;
  }

  public void setFAcctOrgType(String fAcctOrgType) {
    this.FAcctOrgType = fAcctOrgType;
  }

  public String getFADDRESS() {
    return this.FADDRESS;
  }

  public void setFADDRESS(String fADDRESS) {
    this.FADDRESS = fADDRESS;
  }

  public String getFTel() {
    return this.FTel;
  }

  public void setFTel(String fTel) {
    this.FTel = fTel;
  }

  public String getFPostCode() {
    return this.FPostCode;
  }

  public void setFPostCode(String fPostCode) {
    this.FPostCode = fPostCode;
  }

  public String getFContact() {
    return this.FContact;
  }

  public void setFContact(String fContact) {
    this.FContact = fContact;
  }

  public boolean isFIsBusinessOrg() {
    return this.FIsBusinessOrg;
  }

  public void setFIsBusinessOrg(boolean fIsBusinessOrg) {
    this.FIsBusinessOrg = fIsBusinessOrg;
  }

  public boolean isFSaleBox() {
    return this.FSaleBox;
  }

  public void setFSaleBox(boolean fSaleBox) {
    this.FSaleBox = fSaleBox;
  }

  public boolean isFPurchaseBox() {
    return this.FPurchaseBox;
  }

  public void setFPurchaseBox(boolean fPurchaseBox) {
    this.FPurchaseBox = fPurchaseBox;
  }

  public boolean isFStockBox() {
    return this.FStockBox;
  }

  public void setFStockBox(boolean fStockBox) {
    this.FStockBox = fStockBox;
  }

  public boolean isFQualityBox() {
    return this.FQualityBox;
  }

  public void setFQualityBox(boolean fQualityBox) {
    this.FQualityBox = fQualityBox;
  }

  public boolean isFCapitalBox() {
    return this.FCapitalBox;
  }

  public void setFCapitalBox(boolean fCapitalBox) {
    this.FCapitalBox = fCapitalBox;
  }

  public boolean isFShareCenter() {
    return this.FShareCenter;
  }

  public void setFShareCenter(boolean fShareCenter) {
    this.FShareCenter = fShareCenter;
  }

  public boolean isFService() {
    return this.FService;
  }

  public void setFService(boolean fService) {
    this.FService = fService;
  }

  public boolean isFMarketing() {
    return this.FMarketing;
  }

  public void setFMarketing(boolean fMarketing) {
    this.FMarketing = fMarketing;
  }

  public boolean isFIsSynCERPOwer() {
    return this.FIsSynCERPOwer;
  }

  public void setFIsSynCERPOwer(boolean fIsSynCERPOwer) {
    this.FIsSynCERPOwer = fIsSynCERPOwer;
  }

  public String getFOrgFunctions() {
    return this.FOrgFunctions;
  }

  public void setFOrgFunctions(String fOrgFunctions) {
    this.FOrgFunctions = fOrgFunctions;
  }
}
