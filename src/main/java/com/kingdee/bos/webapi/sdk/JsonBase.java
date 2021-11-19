package com.kingdee.bos.webapi.sdk;

import com.google.gson.Gson;

public class JsonBase {
  public String toJson() {
    Gson gson = new Gson();
    return gson.toJson(this);
  }
}
