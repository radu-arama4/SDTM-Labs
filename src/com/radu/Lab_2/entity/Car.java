package com.radu.Lab_2.entity;

public class Car implements CarPlan {
  private String engine;
  private String wheels;
  private String roof;
  private String body;

  @Override
  public void setEngine(String engine) {
    this.engine = engine;
  }

  @Override
  public void setWheels(String wheels) {
    this.wheels = wheels;
  }

  @Override
  public void setRoof(String roof) {
    this.roof = roof;
  }

  @Override
  public void setBody(String body) {
    this.body = body;
  }

  public String getEngine() {
    return engine;
  }

  public String getWheels() {
    return wheels;
  }

  public String getRoof() {
    return roof;
  }

  public String getBody() {
    return body;
  }
}
