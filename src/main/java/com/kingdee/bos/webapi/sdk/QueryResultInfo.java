package com.kingdee.bos.webapi.sdk;

public class QueryResultInfo {
  String TaskId;
  int Status;
  Object Result;
  boolean Cancelled;
  boolean IsFaulted;
  ServiceException FaultedException;
  boolean Successful;
  String Message;
  int Progress;
  String ProgressDesc;

  public String getTaskId() {
    return this.TaskId;
  }

  public void setTaskId(String taskId) {
    this.TaskId = taskId;
  }

  public int getStatus() {
    return this.Status;
  }

  public void setStatus(int status) {
    this.Status = status;
  }

  public Object getResult() {
    return this.Result;
  }

  public void setResult(Object result) {
    this.Result = result;
  }

  public boolean isCancelled() {
    return this.Cancelled;
  }

  public void setCancelled(boolean cancelled) {
    this.Cancelled = cancelled;
  }

  public boolean isIsFaulted() {
    return this.IsFaulted;
  }

  public void setIsFaulted(boolean isFaulted) {
    this.IsFaulted = isFaulted;
  }

  public ServiceException getFaultedException() {
    return this.FaultedException;
  }

  public void setFaultedException(ServiceException faultedException) {
    this.FaultedException = faultedException;
  }

  public boolean isSuccessful() {
    return this.Successful;
  }

  public void setSuccessful(boolean successful) {
    this.Successful = successful;
  }

  public String getMessage() {
    return this.Message;
  }

  public void setMessage(String message) {
    this.Message = message;
  }

  public int getProgress() {
    return this.Progress;
  }

  public void setProgress(int progress) {
    this.Progress = progress;
  }

  public String getProgressDesc() {
    return this.ProgressDesc;
  }

  public void setProgressDesc(String progressDesc) {
    this.ProgressDesc = progressDesc;
  }
}
