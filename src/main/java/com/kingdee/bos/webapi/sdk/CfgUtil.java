package com.kingdee.bos.webapi.sdk;

import java.util.*;
import java.io.*;

public class CfgUtil {
  static String cfgFilePath;
  static AppCfg instance;

  static {
    CfgUtil.cfgFilePath = null;
  }

  static void setCfgFilePath(final String cfgPath) {
    CfgUtil.cfgFilePath = cfgPath;
  }

  public static void setAppCfg(final AppCfg cfg) {
    CfgUtil.instance = cfg;
  }

  public static AppCfg getAppDefaultCfg() {
    if (CfgUtil.instance != null) {
      return CfgUtil.instance;
    }
    AppCfg cfg = null;
    final Properties properties = new Properties();
    File file = null;
    boolean isLoad = false;
    try {
      if (CfgUtil.cfgFilePath != null) {
        file = new File(CfgUtil.cfgFilePath);
        System.out.println(file.getPath());
      } else {
        file = new File(String.valueOf(new File(".").getCanonicalPath()) + "/kdwebapi.properties");
        System.out.println(file.getPath());
      }
      if (file != null && file.exists()) {
        final InputStream inputStream = new FileInputStream(file.getPath());
        System.out.println("配置文件路径：" + file.getPath());
        properties.load(new InputStreamReader(inputStream, "utf-8"));
        inputStream.close();
        isLoad = true;
      } else {
        InputStream inputStream = CfgUtil.class.getResourceAsStream("/kdwebapi.properties");
        if (inputStream == null) {
          inputStream = CfgUtil.class.getResourceAsStream("/resource/kdwebapi.properties");
        }
        if (inputStream != null) {
          properties.load(new InputStreamReader(inputStream, "utf-8"));
          inputStream.close();
          isLoad = true;
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    if (isLoad) {
      final AppCfg scfg = new AppCfg();
      final String svr = properties.getProperty("X-KDApi-ServerUrl");
      if (svr != null) {
        scfg.setServerUrl(svr);
      }
      scfg.setdCID(properties.getProperty("X-KDApi-AcctID"));
      scfg.setUserName(properties.getProperty("X-KDApi-UserName"));
      scfg.setAppId(properties.getProperty("X-KDApi-AppID"));
      scfg.setAppSecret(properties.getProperty("X-KDApi-AppSec"));
      final String lcid = properties.getProperty("X-KDApi-LCID");
      if (lcid != null) {
        scfg.setlCID(new Integer(lcid));
      }
      scfg.setOrgNum(properties.getProperty("X-KDApi-OrgNum"));
      String timeout = properties.getProperty("X-KDApi-ConnectTimeout");
      if (timeout != null) {
        scfg.setConnectTimeout(new Integer(timeout));
      }
      timeout = properties.getProperty("X-KDApi-RequestTimeout");
      if (timeout != null) {
        scfg.setRequestTimeout(new Integer(timeout));
      }
      timeout = properties.getProperty("X-KDApi-StockTimeout");
      if (timeout != null) {
        scfg.setStockTimeout(new Integer(timeout));
      }
      scfg.setProxy(properties.getProperty("X-KDApi-Proxy"));
      cfg = scfg;
    }
    return CfgUtil.instance = cfg;
  }
}
