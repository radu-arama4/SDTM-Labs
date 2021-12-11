package com.radu.Lab_2.client.singleton;

import com.radu.Lab_2.cars.functionality.builder.CarBuilder;
import com.radu.Lab_2.cars.functionality.builder.factory.CarBuilderFactory;
import com.radu.Lab_2.cars.functionality.builder.CarTypes;
import com.radu.Lab_2.cars.entity.Car;
import com.radu.Lab_2.cars.functionality.facade.CarEngineerFacade;
import com.radu.Lab_2.cars.functionality.proxy.CarEngineerProxy;

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
    CarBuilder carBuilder = CarBuilderFactory.generateCarBuilder(CarTypes.NEW);

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
