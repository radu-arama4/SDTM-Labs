package com.radu.Lab_2;

import com.radu.Lab_2.builder.CarBuilder;
import com.radu.Lab_2.builder.CarBuilderFactory;
import com.radu.Lab_2.builder.CarTypes;
import com.radu.Lab_2.entity.Car;
import com.radu.Lab_2.proxy.CarEngineerProxy;

public class CarEngineeringManager {
  private static CarEngineeringManager carEngineeringManager;

  private CarEngineeringManager() {}

  public static CarEngineeringManager getInstance() {
    if (carEngineeringManager == null) {
      carEngineeringManager = new CarEngineeringManager();
    }
    return carEngineeringManager;
  }

  public void startProducingCar() {
    CarBuilder carBuilder = CarBuilderFactory.generateCarBuilder(CarTypes.OLD);

    int yearsOfExperience = 9;

    CarEngineerFacade carEngineer = new CarEngineerFacade(carBuilder, yearsOfExperience);

    CarEngineerProxy engineerProxy = new CarEngineerProxy(carEngineer);

    engineerProxy.buildCar();

    Car car = carEngineer.getCar();

    System.out.println(car.getBody());
    System.out.println(car.getEngine());
    System.out.println(car.getRoof());
    System.out.println(car.getWheels());
  }
}
