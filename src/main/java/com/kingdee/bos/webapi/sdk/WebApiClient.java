package com.kingdee.bos.webapi.sdk;

import com.google.gson.*;

import java.lang.reflect.*;
import java.math.*;
import java.util.*;
import java.text.*;

public class WebApiClient {
  protected IdentifyInfo identify;
  K3CloudCookieStore cookier;
  int connectTimeout;
  int requestTimeout;
  int stockTimeout;

  public WebApiClient() {
    this("");
  }

  public WebApiClient(final String serverUrl) {
    this(new IdentifyInfo().setServerUrl(serverUrl));
  }

  public WebApiClient(final String serverUrl, final int timeout) {
    this(new IdentifyInfo().setServerUrl(serverUrl));
    this.requestTimeout = timeout;
  }

  public WebApiClient(final IdentifyInfo identify) {
    this.connectTimeout = 120;
    this.requestTimeout = 120;
    this.stockTimeout = 180;
    if (identify.appId != null && identify.appId.length() > 0 && identify.appSecret != null && identify.appSecret.length() > 0) {
      this.identify = identify;
    } else {
      this.identify = new IdentifyInfo();
      final AppCfg cfg = CfgUtil.getAppDefaultCfg();
      System.out.println("appCfg: " + new Gson().toJson(cfg));
      if (cfg != null) {
        this.identify.setAppId(cfg.getAppId());
        this.identify.setAppSecret(cfg.getAppSecret());
        this.identify.setdCID(cfg.getdCID());
        this.identify.setLcid(cfg.getlCID());
        this.identify.setOrgNum(cfg.getOrgNum());
        this.identify.setUserName(cfg.getUserName());
        if (this.identify.getServerUrl() == null || this.identify.getServerUrl().length() == 0) {
          this.identify.setServerUrl(cfg.getServerUrl());
          if (this.identify.getServerUrl() == null || this.identify.getServerUrl().length() == 0) {
            this.identify.setServerUrl("https://api.kingdee.com/galaxyapi/");
          }
        }
        if (cfg.getConnectTimeout() > 0) {
          this.connectTimeout = cfg.getConnectTimeout();
        }
        if (cfg.getRequestTimeout() > 0) {
          this.requestTimeout = cfg.getRequestTimeout();
        }
        if (cfg.getStockTimeout() > 0) {
          this.stockTimeout = cfg.getStockTimeout();
        }
      }
    }
  }

  protected void onPreExecute(final String serviceMethod) {
  }

  protected void preExecute() {
    if (this.cookier == null) {
      this.cookier = new K3CloudCookieStore();
    }
  }

  protected void afterExecute(final String json, final K3CloudCookieStore cookier) {
    if (cookier != null) {
      this.cookier = cookier;
    }
  }

  Gson builderGson() {
    final GsonBuilder builder = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss");
    return builder.create();
  }

  RequestBodyObject genrateBody(final Object[] parameters, final InvokeMode type) {
    RequestBodyObject json = null;
    if (type == InvokeMode.Query) {
      json = new QueryRequestBodyObject(parameters);
    } else {
      json = new RequestBodyObject(parameters);
    }
    return json;
  }

  public String execute(final String serviceName, final Object[] parameters) {
    try {
      final String json = this.executeJson(serviceName, parameters, InvokeMode.Syn);
      if (!json.startsWith("response_error:")) {
        return json;
      }
      final KDException ex = KDException.parse(json);
      if (ex == null) {
        throw new Exception(json);
      }
      throw new Exception(ex.getMessage());
    } catch (Exception e) {
      e.getStackTrace();
      return "User authentication information is wrong, please check again!";
    }
  }

  public <T> List<T> execute(final String serviceName, final Object[] parameters, final Type type) {
    try {
      final String json = this.executeJson(serviceName, parameters, InvokeMode.Syn);
      final Gson gson = this.builderGson();
      return (List<T>) gson.fromJson(json, type);
    } catch (Exception e) {
      e.getStackTrace();
      return null;
    }
  }

  public <T> T execute(final String serviceName, final Object[] parameters, final Class<T> cls) {
    try {
      final String json = this.executeJson(serviceName, parameters, InvokeMode.Syn);
      if (!json.startsWith("response_error:")) {
        final Gson gson = new Gson();
        return (T) gson.fromJson(json, (Class) cls);
      }
      final KDException ex = KDException.parse(json);
      if (ex == null) {
        throw new Exception(json);
      }
      throw new Exception(ex.getMessage());
    } catch (Exception e) {
      e.getStackTrace();
      return null;
    }
  }

  String executeByQuery(final String serviceName, final Object[] parameters) throws Exception {
    try {
      final String json = this.doExecuteJson(serviceName, parameters, InvokeMode.Query);
      if (json.startsWith("response_error:")) {
        final KDException ex = KDException.parse(json);
        if (ex == null) {
          throw new Exception(json);
        }
        throw new Exception(ex.getMessage());
      } else {
        final Gson gson = new Gson();
        final QueryResultInfo taskInfo = (QueryResultInfo) gson.fromJson(json, (Class) QueryResultInfo.class);
        if (taskInfo.getStatus() == 2) {
          return gson.toJson(taskInfo.getResult());
        }
        return gson.toJson(this.queryTaskResult(serviceName, new QueryTaskParam(taskInfo.getTaskId(), false), 5));
      }
    } catch (Exception e) {
      e.getStackTrace();
      throw e;
    }
  }

  Object queryTaskResult(final String serviceName, final QueryTaskParam param, final int failTime) throws Exception {
    try {
      Thread.sleep(1000L);
      final int index = serviceName.lastIndexOf(".");
      final String qService = String.valueOf(serviceName.substring(0, index)) + "." + "QueryAsyncResult";
      final String json = this.doExecuteJson(qService, new Object[]{param}, InvokeMode.Syn);
      if (json.startsWith("response_error:")) {
        if (failTime > 0) {
          return this.queryTaskResult(serviceName, param, failTime - 1);
        }
        final KDException ex = KDException.parse(json);
        if (ex == null) {
          throw new Exception(json);
        }
        throw new Exception(ex.getMessage());
      } else {
        final Gson gson = new Gson();
        final QueryResultInfo taskInfo = (QueryResultInfo) gson.fromJson(json, (Class) QueryResultInfo.class);
        if (taskInfo.getStatus() == 2) {
          return taskInfo.getResult();
        }
        return this.queryTaskResult(serviceName, param, 5);
      }
    } catch (Exception e) {
      if (failTime > 0) {
        return this.queryTaskResult(serviceName, param, failTime - 1);
      }
      throw e;
    }
  }

  String executeJson(final String serviceName, final Object[] parameters, final InvokeMode type) throws Exception {
    if (type == InvokeMode.Query) {
      return this.executeByQuery(serviceName, parameters);
    }
    if (type == InvokeMode.Syn) {
      return this.doExecuteJson(serviceName, parameters, type);
    }
    throw new Exception("Not suppoer yet,for InvokeMode:" + type.toString());
  }

  String doExecuteJson(final String serviceName, final Object[] parameters, final InvokeMode type) throws Exception {
    this.preExecute();
    this.onPreExecute(serviceName);
    String url = this.identify.getServerUrl();
    if (!url.endsWith("/")) {
      url = String.valueOf(url) + "/";
    }
    url = String.valueOf(url) + serviceName + ".common.kdsvc";
    System.out.println("url: " + url);
    System.out.println("parameters: " + new Gson().toJson(parameters));
    ApiRequester req = null;
    if (type == InvokeMode.Query) {
      req = new ApiQueryRequester(url);
    } else {
      req = new ApiRequester(url);
    }
    req.setConnectTimeout(this.connectTimeout);
    req.setConnectionRequrestTimeout(this.requestTimeout);
    req.setSocketTimeout(this.stockTimeout);
    req.setIdentify(this.identify);
    req.setCookieStore(this.cookier);
    try {
      final String json = req.postJson(this.genrateBody(parameters, type));
      System.out.println("result: " + json);
      this.afterExecute(json, req.getCookieStore());
      return json;
    } catch (Exception e) {
      this.afterExecute(null, req.getCookieStore());
      e.getStackTrace();
      throw e;
    }
  }

  protected <T> List<T> loadDataList(final String fieldKeys, final Class type, final String json) throws InstantiationException, IllegalAccessException, InvocationTargetException {
    final List<T> rets = new ArrayList<T>();
    final Gson gson = new Gson();
    final List<ArrayList<Object>> rows = (List<ArrayList<Object>>) gson.fromJson(json, (Class) rets.getClass());
    final Method[] pes = type.getMethods();
    final String[] fields = fieldKeys.split(",");
    final Method[] setPes = this.getMethodsByFields(pes, "set", fields);
    final Method[] getPes = this.getMethodsByFields(pes, "get", fields);
    for (final List<Object> darray : rows) {
      final T ret = (T) type.newInstance();
      for (int i = 0; i < fields.length; ++i) {
        if (setPes[i] != null && getPes[i] != null) {
          final Object v = this.convertToDest(getPes[i].getReturnType(), darray.get(i));
          if (v != null) {
            setPes[i].invoke(ret, v);
          }
        }
      }
      rets.add(ret);
    }
    return rets;
  }

  String loadErrorMsg(final String json) {
    if (json.startsWith("[[") && json.endsWith("]]")) {
      final Gson gson = new Gson();
      return ((RepoRet) gson.fromJson(json.substring(2, json.length() - 2), (Class) RepoRet.class)).getResult().getResponseStatus().getErrors().get(0).getMessage();
    }
    return String.format("fail for ExecuteBillQuery:%s", json);
  }

  Method[] getMethodsByFields(final Method[] pes, final String pre, final String[] fields) {
    final Method[] rets = new Method[fields.length];
    for (int i = 0; i < fields.length; ++i) {
      for (int j = 0; j < pes.length; ++j) {
        if (pes[j].getName().toLowerCase().equals(String.valueOf(pre) + fields[i].toLowerCase())) {
          rets[i] = pes[j];
        }
      }
    }
    return rets;
  }

  Method getMethodFromT(final Method[] pes, final String pname) {
    for (int i = 0; i < pes.length; ++i) {
      if (pes[i].getName().toLowerCase().equals(pname.toLowerCase())) {
        return pes[i];
      }
    }
    return null;
  }

  Object convertToDest(final Type type, final Object val) {
    if (val == null) {
      return null;
    }
    if (type.getTypeName().equals(String.class.getTypeName())) {
      return val.toString();
    }
    if (type.getTypeName().equals(Integer.TYPE.getTypeName()) || type.getTypeName().equals(Short.TYPE.getTypeName()) || type.getTypeName().equals(Long.TYPE.getTypeName())) {
      String v = val.toString();
      if (v.toString().indexOf(".") > -1) {
        v = v.substring(0, v.toString().indexOf("."));
      }
      return new Integer(v.toString());
    }
    if (type.getTypeName().equals(BigDecimal.class.getTypeName())) {
      return new BigDecimal(val.toString());
    }
    if (type.getTypeName().equals(Date.class.getTypeName())) {
      final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
      try {
        return sdf.parse(val.toString());
      } catch (ParseException e) {
        e.printStackTrace();
        return null;
      }
    }
    return val;
  }
}
