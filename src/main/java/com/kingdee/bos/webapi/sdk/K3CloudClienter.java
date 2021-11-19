package com.kingdee.bos.webapi.sdk;

import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

class K3CloudClienter
  extends WebApiClient {
  boolean inited = false;
  Context ctx;

  K3CloudClienter() {
  }

  K3CloudClienter(String serverUrl) {
    super(serverUrl);
  }

  @Override
  protected void onPreExecute(String serviceMethod) {
  }

  CommonConfig getCommonConfig() {
    return (CommonConfig) execute("Kingdee.BOS.ServiceFacade.ServicesStub.ClienterService.GetServerCommonConfig", null, CommonConfig.class);
  }

  List<DataCenter> getDataCenters() {
    Type tp = new TypeToken() {
    }.getType();
    return execute("Kingdee.BOS.ServiceFacade.ServicesStub.Account.AccountService.GetDataCenterList", null, tp);
  }

  public boolean loginByAppSecret() {
    Object[] loginInfo = {this.identify.getdCID(), this.identify.getUserName(), this.identify.getAppId(), this.identify.getAppSecret(), Integer.valueOf(this.identify.getlCID())};
    LoginResult ret = (LoginResult) execute("Kingdee.BOS.WebApi.ServicesStub.AuthService.LoginByAppSecret", loginInfo, LoginResult.class);
    this.ctx = ret.getContext();
    if (ret.getIsSuccessByAPI()) {
      System.out.println("Login successfully!");
      return ret.getIsSuccessByAPI();
    }
    System.out.println(ret.getMessage());
    return false;
  }
}
