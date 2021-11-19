package com.kingdee.bos.webapi.sdk;

import java.net.*;
import java.io.*;

public class HttpUtils {
  static int proxyRunning;

  static {
    HttpUtils.proxyRunning = -1;
  }

  static Proxy getProxy() {
    final AppCfg cfg = CfgUtil.getAppDefaultCfg();
    if (cfg != null && cfg.getProxy() != null) {
      try {
        final URL url = new URL(cfg.getProxy());
        if (isHostConnectable(url.getHost(), url.getPort())) {
          System.out.println(String.format("Used proxy,Host:%s,port:%s", url.getHost(), url.getPort()));
          return new Proxy(Proxy.Type.HTTP, new InetSocketAddress(url.getHost(), url.getPort()));
        }
        System.out.println(String.format("is not host %s", url.toString()));
        return null;
      } catch (MalformedURLException e) {
        e.printStackTrace();
        return null;
      }
    }
    return null;
  }

  static boolean proxyIsRunning() {
    if (HttpUtils.proxyRunning > -1) {
      return HttpUtils.proxyRunning != 0;
    }
    if (isHostConnectable("127.0.0.1", 8888)) {
      HttpUtils.proxyRunning = 1;
      return true;
    }
    HttpUtils.proxyRunning = 0;
    return false;
  }

  static boolean isHostConnectable(final String host, final int port) {
    final Socket socket = new Socket();
    try {
      socket.connect(new InetSocketAddress(host, port));
    } catch (IOException e) {
      return false;
    } finally {
      try {
        socket.close();
      } catch (IOException ex) {
      }
    }
    try {
      socket.close();
    } catch (IOException ex2) {
    }
    return true;
  }
}
