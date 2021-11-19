package com.kingdee.bos.webapi.sdk;

import java.util.ArrayList;
import java.util.List;

public class DataCenter {
  String Id;
  String Number;
  String Name;
  String Version;
  String GDCID;
  ArrayList<AuthenticationMethod> AuthenticationMethods;

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

  public String getName() {
    return this.Name;
  }

  public void setName(String name) {
    this.Name = name;
  }

  public String getVersion() {
    return this.Version;
  }

  public void setVersion(String version) {
    this.Version = version;
  }

  public String getGDCID() {
    return this.GDCID;
  }

  public void setGDCID(String gDCID) {
    this.GDCID = gDCID;
  }

  public List<AuthenticationMethod> getAuthenticationMethods() {
    return this.AuthenticationMethods;
  }

  public void setAuthenticationMethods(List<AuthenticationMethod> authenticationMethods) {
    this.AuthenticationMethods = ((ArrayList) authenticationMethods);
  }
}
