package com.recruitment.api.config;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;


public class ApplicationService {

  private static ApplicationService ins = null;
  
  private DBConnPool dbConnPool = null;

  private ILogWriter logWriter = null;

  private static String hostname = null;

  public synchronized void startup() throws Exception {
    if (ins == null) {
      this.initServ();
      ins = this;
    }
  }

  public synchronized void shutdown() {
    ins = null;
    destroy();
  }

  private void initServ() throws Exception {
    if (logWriter == null) {
      logWriter = new ConsoleLogWiter();
    }
    Thread.sleep(2000L);
  }

  private void destroy() {
    unregisterJdbcDriver();
  }

  private void unregisterJdbcDriver() {
    Enumeration<Driver> drivers = DriverManager.getDrivers();
    while (drivers.hasMoreElements()) {
      Driver driver = drivers.nextElement();
      try {
        DriverManager.deregisterDriver(driver);
      } catch (SQLException e) {
      }
    }
  }

  public DBConnPool getDbConnPool() {
    return this.dbConnPool;
  }

  public void setDbConnPool(DBConnPool dbConnPool) {
    this.dbConnPool = dbConnPool;
  }

  public ILogWriter getLogWriter() {
    return this.logWriter;
  }

  public void setLogWriter(ILogWriter logWriter) {
    this.logWriter = logWriter;
  }

  public static ApplicationService ins() throws Exception {
    if (ins != null) {
      return ins;
    }
    throw new Exception("APPLICATION SERVICE IS NOT READY YET.");
  }
  public static String getHostname() {
    if (hostname == null) {
      try {
        return (hostname = InetAddress.getLocalHost().getHostName());
      } catch (UnknownHostException ex) {
        return (hostname = "UNKNOWN");
      }
    }
    return hostname;
  }

}
