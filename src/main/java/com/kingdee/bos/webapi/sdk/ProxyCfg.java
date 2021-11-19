package com.kingdee.bos.webapi.sdk;

public class ProxyCfg {
  public ProxyCfg(String host, int port) {
    this.host = host;
    this.port = port;
  }

  String scheme = "http";

  public String getScheme() {
    return this.scheme;
  }

  public void setScheme(String scheme) {
    this.scheme = scheme;
  }

  public String getHost() {
    return this.host;
  }

  public void setHost(String host) {
    this.host = host;
  }

  public int getPort() {
    return this.port;
  }

  public void setPort(int port) {
    this.port = port;
  }

  String host = "127.0.0.1";
  int port = 8888;
}
