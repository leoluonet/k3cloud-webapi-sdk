package com.kingdee.bos.webapi.sdk;

import java.net.*;
import java.util.*;
import java.io.*;

public class HttpRequester {
  int connectTimeout;
  RequestBodyObject reqJson;
  int requestTimeout;
  String url;
  Map<String, String> header;
  int statusCode;
  Set<Cookie> repoCookies;

  public HttpRequester(final String url, final Map<String, String> header, final RequestBodyObject reqJson) {
    this.connectTimeout = 120;
    this.requestTimeout = 120;
    this.url = url;
    this.header = header;
    this.reqJson = reqJson;
  }

  public HttpRequester(final String url, final Map<String, String> header, final RequestBodyObject reqJson, final int connectTimeout, final int requestTimeout) {
    this.connectTimeout = 120;
    this.requestTimeout = 120;
    this.url = url;
    this.header = header;
    this.reqJson = reqJson;
    this.connectTimeout = connectTimeout;
    this.requestTimeout = requestTimeout;
  }

  public String post() throws Exception {
    PrintWriter out = null;
    String result = "";
    final URL realUrl = new URL(this.url);
    HttpURLConnection conn = null;
    final Proxy proxy = HttpUtils.getProxy();
    if (proxy != null) {
      conn = (HttpURLConnection) realUrl.openConnection(proxy);
    } else {
      conn = (HttpURLConnection) realUrl.openConnection();
    }
    conn.setConnectTimeout(this.getConnectTimeout() * 1000);
    conn.setReadTimeout(this.getRequestTimeout() * 1000);
    if (this.header != null) {
      for (final Map.Entry<String, String> entry : this.header.entrySet()) {
        conn.setRequestProperty(entry.getKey(), entry.getValue());
      }
    }
    conn.setRequestProperty("Content-type", "applicatin/json");
    conn.setRequestProperty("User-Agent", "Kingdee/Java WebApi SDK 7.3 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
    conn.setDoOutput(true);
    conn.setDoInput(true);
    try {
      if (this.reqJson != null) {
        out = new PrintWriter(new OutputStreamWriter(conn.getOutputStream(), "utf8"));
        out.print(this.reqJson.toJson());
        out.flush();
      }
      final int statusCode = conn.getResponseCode();
      if (statusCode != 200 && statusCode != 206) {
        result = this.readRepoBody(conn);
        throw new Exception(String.format("StatusCode:%s,\tDesc:%s", statusCode, result));
      }
      for (final Map.Entry<String, List<String>> cookie : conn.getHeaderFields().entrySet()) {
        if (cookie.getKey() == null) {
          continue;
        }
        if (!cookie.getKey().equals("Set-Cookie")) {
          continue;
        }
        this.repoCookies = new HashSet<Cookie>();
        for (final String c : cookie.getValue()) {
          final Cookie ck = Cookie.parse(c);
          if (ck != null) {
            this.repoCookies.add(new Cookie(c));
          }
        }
      }
      result = this.readRepoBody(conn);
    } catch (Exception er) {
      throw er;
    } finally {
      if (out != null) {
        out.close();
      }
    }
    if (out != null) {
      out.close();
    }
    return result;
  }

  String readRepoBody(final HttpURLConnection conn) throws UnsupportedEncodingException, IOException {
    final BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf8"));
    final StringBuilder sb = new StringBuilder();
    String line;
    while ((line = in.readLine()) != null) {
      sb.append(line);
    }
    in.close();
    return sb.toString();
  }

  public int getConnectTimeout() {
    return this.connectTimeout;
  }

  public void setConnectTimeout(final int connectTimeout) {
    this.connectTimeout = connectTimeout;
  }

  public int getRequestTimeout() {
    return this.requestTimeout;
  }

  public void setRequestTimeout(final int requestTimeout) {
    this.requestTimeout = requestTimeout;
  }

  public String getUrl() {
    return this.url;
  }

  public void setUrl(final String url) {
    this.url = url;
  }

  public Map<String, String> getHeader() {
    return this.header;
  }

  public void setHeader(final Map<String, String> header) {
    this.header = header;
  }

  public RequestBodyObject getReqJson() {
    return this.reqJson;
  }

  public void setReqJson(final RequestBodyObject reqJson) {
    this.reqJson = reqJson;
  }

  public int getStatusCode() {
    return this.statusCode;
  }

  public void setStatusCode(final int statusCode) {
    this.statusCode = statusCode;
  }

  public Set<Cookie> getRepoCookies() {
    return this.repoCookies;
  }

  public void setRepoCookies(final Set<Cookie> repoCookies) {
    this.repoCookies = repoCookies;
  }
}
