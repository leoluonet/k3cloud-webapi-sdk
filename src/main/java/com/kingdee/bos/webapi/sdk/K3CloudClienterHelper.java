package com.kingdee.bos.webapi.sdk;

class K3CloudClienterHelper {
  static K3CloudClienter clienter;
  static String serverUrl;
  static String dcID;
  static String userName;
  static String appId;
  static String appSecret;

  static K3CloudClienter privateGetClienter() {
    if (clienter == null) {
      if (serverUrl == null) {
        AppCfg cfg = CfgUtil.getAppDefaultCfg();
        if (cfg != null) {
          serverUrl = cfg.getServerUrl();
          dcID = cfg.getdCID();
          userName = cfg.getUserName();
          appId = cfg.getAppId();
          appSecret = cfg.getAppSecret();
        }
      }
      clienter = new K3CloudClienter(serverUrl);
    }
    return clienter;
  }

  public static void initClienter(String serverUrl, String dcID, String userName, String appId, String appSecret) {
    serverUrl = serverUrl;
    dcID = dcID;
    userName = userName;
    appId = appId;
    appSecret = appSecret;
    clienter = null;
  }

  static K3CloudClienter getClienter() {
    K3CloudClienter clienter = privateGetClienter();
    return clienter;
  }
}
