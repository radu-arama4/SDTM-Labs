package com.radu.Lab_3.cars.functionality.facade;

import com.radu.Lab_3.cars.entity.Car;
import com.radu.Lab_3.cars.entity.CarEngineer;
import com.radu.Lab_3.cars.functionality.builder.CarBuilder;

public class CarEngineerFacade implements CarEngineer {
  private final CarBuilder carBuilder;
  private int yearsOfExperience;

  public CarEngineerFacade(CarBuilder carBuilder, int yearsOfExperience) {
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
