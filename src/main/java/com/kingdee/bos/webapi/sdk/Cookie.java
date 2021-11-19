package com.kingdee.bos.webapi.sdk;

import java.util.*;

public class Cookie {
  String name;
  String value;
  Date expires;
  String path;
  String domain;
  boolean secure;

  public Cookie(final String cookie) {
    final String[] array = cookie.split(";");
    for (int i = 0; i < array.length; ++i) {
      final String s = array[i].trim();
      if (s.length() > 2) {
        final String[] sarr = s.split("=");
        Label_0178:
        {
          if (sarr.length == 2) {
            Label_0158:
            {
              final String lowerCase;
              switch (lowerCase = sarr[0].toLowerCase()) {
                case "domain": {
                  break;
                }
                case "expires": {
                  break Label_0178;
                }
                case "path": {
                  this.path = sarr[1];
                  break;
                }
                default:
                  break Label_0158;
              }
              this.domain = sarr[1];
              break Label_0178;
            }
            if (i == 0) {
              this.name = sarr[0];
              this.value = sarr[1];
            }
          }
        }
        if (s.equals("SECURE")) {
          this.secure = true;
        }
      }
    }
  }

  public static Cookie parse(final String ck) {
    final Cookie c = new Cookie(ck);
    if (c.getName() == null || c.getName() == "") {
      return null;
    }
    return c;
  }

  @Override
  public String toString() {
    return String.format("%s=%s", this.name, this.value);
  }

  public String getName() {
    return this.name;
  }

  public void setName(final String name) {
    this.name = name;
  }

  public String getValue() {
    return this.value;
  }

  public void setValue(final String value) {
    this.value = value;
  }

  public Date getExpires() {
    return this.expires;
  }

  public void setExpires(final Date expires) {
    this.expires = expires;
  }

  public String getPath() {
    return this.path;
  }

  public void setPath(final String path) {
    this.path = path;
  }

  public String getDomain() {
    return this.domain;
  }

  public void setDomain(final String domain) {
    this.domain = domain;
  }

  public boolean isSecure() {
    return this.secure;
  }

  public void setSecure(final boolean secure) {
    this.secure = secure;
  }
}
