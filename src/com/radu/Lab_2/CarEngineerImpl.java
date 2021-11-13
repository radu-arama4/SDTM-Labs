package com.radu.Lab_2;

import com.radu.Lab_2.builder.CarBuilder;
import com.radu.Lab_2.entity.Car;

public class CarEngineerImpl implements CarEngineer {
  private final CarBuilder carBuilder;
  private int yearsOfExperience;

  public CarEngineerImpl(CarBuilder carBuilder) {
    this.carBuilder = carBuilder;
  }

  public CarEngineerImpl(CarBuilder carBuilder, int yearsOfExperience) {
    this.carBuilder = carBuilder;
    this.yearsOfExperience = yearsOfExperience;
  }

  public Car getCar() {
    return carBuilder.getCar();
  }

  public int getYearsOfExperience() {
    return yearsOfExperience;
  }

  @Override
  public void buildCar() {
    carBuilder.buildBody();
    carBuilder.buildEngine();
    carBuilder.buildRoofs();
    carBuilder.buildWheels();
  }
}
