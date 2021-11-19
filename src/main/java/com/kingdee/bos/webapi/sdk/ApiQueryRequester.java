package com.kingdee.bos.webapi.sdk;

import java.util.HashMap;

public class ApiQueryRequester
  extends ApiRequester {
  ApiQueryRequester(String uri) {
    super(uri);
  }

  @Override
  protected HashMap<String, String> buildHeader(String path) {
    HashMap<String, String> headers = super.buildHeader(path);
    headers.put("beginmethod", "BeginQueryImpl");
    headers.put("querymethod", "QueryAsyncResult");
    return headers;
  }
}
