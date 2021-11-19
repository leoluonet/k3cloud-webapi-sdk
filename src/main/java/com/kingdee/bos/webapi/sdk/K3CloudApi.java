package com.kingdee.bos.webapi.sdk;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class K3CloudApi extends WebApiClient {
  public K3CloudApi() {
  }

  public K3CloudApi(IdentifyInfo identify) {
    super(identify);
  }

  public K3CloudApi(String serverUrl) {
    this(serverUrl, 120);
  }

  public K3CloudApi(String serverUrl, int timeout) {
    super(serverUrl, timeout);
  }

  public List<DataCenter> getDataCenters() {
    Type tp = new TypeToken() {
    }.getType();
    return execute("Kingdee.BOS.ServiceFacade.ServicesStub.Account.AccountService.GetDataCenterList", null, tp);
  }

  public <T> SaveResult save(String formId, SaveParam<T> param)
    throws Exception {
    return save(formId, param, InvokeMode.Syn);
  }

  public <T> SaveResult save(String formId, SaveParam<T> param, InvokeMode mode)
    throws Exception {
    String json = executeJson("Kingdee.BOS.WebApi.ServicesStub.DynamicFormService.Save", new Object[]{formId, param.toJson()}, mode);
    Gson gson = new Gson();
    return (SaveResult) gson.fromJson(json, SaveResult.class);
  }

  public <T> SaveResult batchSave(String formId, BatchSave<T> param)
    throws Exception {
    return batchSave(formId, param, InvokeMode.Syn);
  }

  public <T> SaveResult batchSave(String formId, BatchSave<T> param, InvokeMode mode)
    throws Exception {
    String json = executeJson("Kingdee.BOS.WebApi.ServicesStub.DynamicFormService.BatchSave", new Object[]{formId, param.toJson()}, mode);
    Gson gson = new Gson();
    return (SaveResult) gson.fromJson(json, SaveResult.class);
  }

  public OperatorResult submit(String formId, OperateParam param)
    throws Exception {
    return (OperatorResult) execute("Kingdee.BOS.WebApi.ServicesStub.DynamicFormService.Submit", new Object[]{formId, param.toJson()}, OperatorResult.class);
  }

  public OperatorResult delete(String formId, OperateParam param)
    throws Exception {
    return (OperatorResult) execute("Kingdee.BOS.WebApi.ServicesStub.DynamicFormService.Delete", new Object[]{formId, param.toJson()}, OperatorResult.class);
  }

  public OperatorResult audit(String formId, OperateParam param)
    throws Exception {
    return (OperatorResult) execute("Kingdee.BOS.WebApi.ServicesStub.DynamicFormService.Audit", new Object[]{formId, param.toJson()}, OperatorResult.class);
  }

  public OperatorResult unAudit(String formId, OperateParam param)
    throws Exception {
    return (OperatorResult) execute("Kingdee.BOS.WebApi.ServicesStub.DynamicFormService.UnAudit", new Object[]{formId, param.toJson()}, OperatorResult.class);
  }

  public OperatorResult view(String formId, OperateParam param)
    throws Exception {
    return (OperatorResult) execute("Kingdee.BOS.WebApi.ServicesStub.DynamicFormService.View", new Object[]{formId, param.toJson()}, OperatorResult.class);
  }

  public <T> List<T> executeBillQuery(QueryParam data, Class type)
    throws Exception {
    String json = executeJson("Kingdee.BOS.WebApi.ServicesStub.DynamicFormService.ExecuteBillQuery", new Object[]{data.toJson()}, InvokeMode.Syn);
    if (json.indexOf(",\"IsSuccess\":false,") > -1) {
      throw new Exception(loadErrorMsg(json));
    }
    return loadDataList(data.FieldKeys, type, json);
  }

  public String excuteOperation(String formid, String opNumber, String data)
    throws Exception {
    return execute("Kingdee.BOS.WebApi.ServicesStub.DynamicFormService.ExcuteOperation", new Object[]{formid, opNumber, data});
  }

  public String save(String formid, String data)
    throws Exception {
    return execute("Kingdee.BOS.WebApi.ServicesStub.DynamicFormService.Save", new Object[]{formid, data});
  }

  public String batchSave(String formid, String data)
    throws Exception {
    return execute("Kingdee.BOS.WebApi.ServicesStub.DynamicFormService.BatchSave", new Object[]{formid, data});
  }

  public String audit(String formid, String data)
    throws Exception {
    return execute("Kingdee.BOS.WebApi.ServicesStub.DynamicFormService.Audit", new Object[]{formid, data});
  }

  public String delete(String formid, String data)
    throws Exception {
    return execute("Kingdee.BOS.WebApi.ServicesStub.DynamicFormService.Delete", new Object[]{formid, data});
  }

  public String unAudit(String formid, String data)
    throws Exception {
    return execute("Kingdee.BOS.WebApi.ServicesStub.DynamicFormService.UnAudit", new Object[]{formid, data});
  }

  public String submit(String formid, String data)
    throws Exception {
    return execute("Kingdee.BOS.WebApi.ServicesStub.DynamicFormService.Submit", new Object[]{formid, data});
  }

  public String view(String formid, String data)
    throws Exception {
    return execute("Kingdee.BOS.WebApi.ServicesStub.DynamicFormService.View", new Object[]{formid, data});
  }

  public List<List<Object>> executeBillQuery(String data)
    throws Exception {
    return (List) execute("Kingdee.BOS.WebApi.ServicesStub.DynamicFormService.ExecuteBillQuery", new Object[]{data}, new ArrayList().getClass());
  }

  public String draft(String formid, String data)
    throws Exception {
    return execute("Kingdee.BOS.WebApi.ServicesStub.DynamicFormService.Draft", new Object[]{formid, data});
  }

  public String allocate(String formid, String data)
    throws Exception {
    return execute("Kingdee.BOS.WebApi.ServicesStub.DynamicFormService.Allocate", new Object[]{formid, data});
  }

  public String flexSave(String formid, String data) {
    return execute("Kingdee.BOS.WebApi.ServicesStub.DynamicFormService.FlexSave", new Object[]{formid, data});
  }

  public String sendMsg(String data) {
    return execute("Kingdee.BOS.WebApi.ServicesStub.DynamicFormService.SendMsg", new Object[]{data});
  }

  public String push(String formid, String data) {
    return execute("Kingdee.BOS.WebApi.ServicesStub.DynamicFormService.Push", new Object[]{formid, data});
  }

  public String groupSave(String formid, String data) {
    return execute("Kingdee.BOS.WebApi.ServicesStub.DynamicFormService.GroupSave", new Object[]{formid, data});
  }

  public String disassembly(String formid, String data)
    throws Exception {
    return execute("Kingdee.BOS.WebApi.ServicesStub.DynamicFormService.Disassembly", new Object[]{formid, data});
  }

  public String queryBusinessInfo(String data) {
    return execute("Kingdee.BOS.WebApi.ServicesStub.DynamicFormService.QueryBusinessInfo", new Object[]{data});
  }

  public String queryGroupInfo(String data)
    throws Exception {
    return execute("Kingdee.BOS.WebApi.ServicesStub.DynamicFormService.QueryGroupInfo", new Object[]{data});
  }

  public String workflowAudit(String data)
    throws Exception {
    return execute("Kingdee.BOS.WebApi.ServicesStub.DynamicFormService.WorkflowAudit", new Object[]{data});
  }

  public String groupDelete(String data)
    throws Exception {
    return execute("Kingdee.BOS.WebApi.ServicesStub.DynamicFormService.GroupDelete", new Object[]{data});
  }
}
