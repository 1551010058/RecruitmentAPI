package com.recruitment.api.config;

public interface ILogWriter {
  //////////////////////////////////////////////
  public void error(String error, String detail);

  public void warn(String warn);

  public void info(String info);

}
