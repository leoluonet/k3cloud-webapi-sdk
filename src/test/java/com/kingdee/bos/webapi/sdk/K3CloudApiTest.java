package com.kingdee.bos.webapi.sdk;

/**
 * @author leo.luo.net@gmail.com
 * @date 2021-10-18
 */
public class K3CloudApiTest {
  public static void main(String[] args) {
    System.setProperty("http.proxyHost", "127.0.0.1");
    System.setProperty("https.proxyHost", "127.0.0.1");
    System.setProperty("http.proxyPort", "8899");
    System.setProperty("https.proxyPort", "8899");
//    AppCfg cfg = new AppCfg();
//    CfgUtil.setAppCfg(cfg);
    testViewCustomer();
//    testViewCommonContact();
//    testForbidMaterial();
//    testEnableMaterial();
  }

  public static void testViewCustomer() {
    K3CloudApi api = new K3CloudApi();
    String fromId = "BD_Customer";
    String jsonData = "{\"CreateOrgId\":0,\"Number\":\"k21100001\",\"Id\":\"\"}";
    try {
      String view = api.view(fromId, jsonData);
      System.out.println(view);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void testViewCommonContact() {
    K3CloudApi api = new K3CloudApi();
    String fromId = "BD_CommonContact";
    String jsonData = "{\"CreateOrgId\":0,\"Number\":\"CXR000003\",\"Id\":\"\"}";
    try {
      String view = api.view(fromId, jsonData);
      System.out.println(view);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void testForbidMaterial() {
    K3CloudApi api = new K3CloudApi();
    String fromId = "BD_MATERIAL";
    String jsonData = "{\"numbers\":[\"Z.Z.04.Z.04.03.00001\"]}";
    try {
      String forbid = api.excuteOperation(fromId,"Forbid", jsonData);
      System.out.println(forbid);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void testEnableMaterial() {
    K3CloudApi api = new K3CloudApi();
    String fromId = "BD_MATERIAL";
    String jsonData = "{\"numbers\":[\"Z.Z.04.Z.04.03.00001\"]}";
    try {
      String forbid = api.excuteOperation(fromId,"Enable", jsonData);
      System.out.println(forbid);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
