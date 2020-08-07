package com.recruitment.api.entities;

public class AuthUser {
  private String username = "";
  private String password = "";
  private String roles = "USER";

  public AuthUser() {
  }

  public String getUsername() {
    return this.username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return this.password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getRoles() {
    return this.roles;
  }

  public void setRoles(String roles) {
    this.roles = roles;
  }

  public String[] getRoleAsArray() {
    return (roles != null) ? this.roles.split(",") : new String[] {};
  }

}
