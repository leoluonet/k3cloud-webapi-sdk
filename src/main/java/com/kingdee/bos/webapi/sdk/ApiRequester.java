package com.kingdee.bos.webapi.sdk;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ApiRequester {
  K3CloudCookieStore cookieStore;
  IdentifyInfo identify;

  ApiRequester(String uri) {
    this.uri = uri;
  }

  public K3CloudCookieStore getCookieStore() {
    return this.cookieStore;
  }

  public void setCookieStore(K3CloudCookieStore cookieStore) {
    this.cookieStore = cookieStore;
  }

  public IdentifyInfo getIdentify() {
    return this.identify;
  }

  public void setIdentify(IdentifyInfo identify) {
    this.identify = identify;
  }

  protected int connectTimeout = 120;

  public int getConnectTimeout() {
    return this.connectTimeout;
  }

  public void setConnectTimeout(int connectTimeout) {
    this.connectTimeout = connectTimeout;
  }

  protected int connectionRequrestTimeout = 120;

  public int getConnectionRequrestTimeout() {
    return this.connectionRequrestTimeout;
  }

  public void setConnectionRequrestTimeout(int connectionRequrestTimeout) {
    this.connectionRequrestTimeout = connectionRequrestTimeout;
  }

  public int getSocketTimeout() {
    return this.socketTimeout;
  }

  public void setSocketTimeout(int socketTimeout) {
    this.socketTimeout = socketTimeout;
  }

  protected int socketTimeout = 180;
  protected String uri;

  public String postJson(RequestBodyObject requestBody)
    throws Exception {
    try {
      return postJson(this.uri, requestBody, this.connectTimeout, this.connectionRequrestTimeout, this.socketTimeout);
    } catch (IOException e) {
      throw e;
    }
  }

  protected String postJson(String uri, RequestBodyObject json, int connectTimeout, int connectionRequestTimeout, int socketTimeout)
    throws Exception {
    HttpRequester req = new HttpRequester(uri, buildHeader(getUrlPath(uri)), json, connectTimeout, connectionRequestTimeout);
    String body = req.post();
    getCookieFromReq(req);
    return body;
  }

  protected void getCookieFromReq(HttpRequester req) {
    if ((req.getRepoCookies() != null) && (this.cookieStore != null)) {
      for (Cookie c : req.getRepoCookies()) {
        this.cookieStore.getCookies().put(c.getName(), c);
        if (c.getName().equals("kdservice-sessionid")) {
          this.cookieStore.setSID(c.getValue());
        }
      }
    }
  }

  String getUrlPath(String url) {
    if (url.startsWith("http")) {
      int index = url.indexOf("/", 10);
      if (index > -1) {
        return url.substring(index);
      }
      return url;
    }
    return url;
  }

  protected HashMap<String, String> buildHeader(String path) {
    HashMap<String, String> header = new HashMap();
    try {
      String[] arr;
      if (this.identify != null) {
        String apigwId = "";
        String apigwSec = "";
        arr = this.identify.getAppId().split("_");
        if (arr.length == 2) {
          apigwId = arr[0];
          apigwSec = decodeSec(arr[1]);
        }
        header.put("X-Api-ClientID", apigwId);
        header.put("X-Api-Auth-Version", "2.0");
        Date date = new Date();
        Timestamp ts = new Timestamp(date.getTime());
        String tsVal = new Long(ts.getTime()).toString();
        header.put("x-api-timestamp", tsVal);
        String nonceVal = new Long(ts.getTime()).toString();
        header.put("x-api-nonce", nonceVal);
        header.put("x-api-signheaders", "X-Api-TimeStamp,X-Api-Nonce");
        String urlPath = URLEncoder.encode(path, "UTF-8");
        String context = String.format("POST\n%s\n\nx-api-nonce:%s\nx-api-timestamp:%s\n", new Object[]{urlPath, nonceVal, tsVal});
        header.put("X-Api-Signature", MD5Utils.hashMAC(context, apigwSec));

        header.put("X-Kd-Appkey", this.identify.getAppId());
        String data = String.format("%s,%s,%s,%s", new Object[]{this.identify.getdCID(), this.identify.getUserName(), Integer.valueOf(this.identify.getlCID()), this.identify.getOrgNum()});
        header.put("X-Kd-Appdata", Base64Utils.encodingToBase64(data.getBytes("UTF-8")));

        header.put("X-Kd-Signature", MD5Utils.hashMAC(this.identify.getAppId() + data, this.identify.getAppSecret()));
      }
      if (this.cookieStore != null) {
        if (this.cookieStore.getSID() != null) {
          header.put("SID", this.cookieStore.getSID());
        }
        if (this.cookieStore.getCookies().size() > 0) {
          String cookieHD = String.format("Theme=standard", new Object[0]);
          for (Map.Entry<String, Cookie> cookie : this.cookieStore.getCookies().entrySet()) {
            cookieHD = cookieHD + "; " + ((Cookie) cookie.getValue()).toString();
          }
          header.put("Cookie", cookieHD);
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    System.out.println(new Gson().toJson(header));
    return header;
  }

  String decodeSec(String sec) {
    if (sec.length() != 32) {
      System.out.print(String.format("sec:%s is not 32 char", new Object[]{sec}));
      return sec;
    }
    byte[] buffer = Base64Utils.decodingFromBase64(sec);
    buffer = xOrSec(buffer);
    return Base64Utils.encodingToBase64(buffer);
  }

  byte[] xOrSec(byte[] buffer) {
    String seckey = "0054f397c6234378b09ca7d3e5debce7";

    byte[] pwd = null;
    try {
      pwd = seckey.getBytes("UTF-8");
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }
    for (int i = 0; i < buffer.length; i++) {
      buffer[i] = ((byte) (buffer[i] ^ pwd[i]));
    }
    return buffer;
  }
}
