package com.kingdee.bos.webapi.sdk;

public class QueryTaskParam {
  String TaskId;
  boolean Cancelled;

  public QueryTaskParam(String taskId, boolean isCancelled) {
    this.TaskId = taskId;
    this.Cancelled = isCancelled;
  }

  public String getTaskId() {
    return this.TaskId;
  }

  public void setTaskId(String taskId) {
    this.TaskId = taskId;
  }

  public boolean isCancelled() {
    return this.Cancelled;
  }

  public void setCancelled(boolean cancelled) {
    this.Cancelled = cancelled;
  }
}
