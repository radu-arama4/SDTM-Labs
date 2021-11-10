package com.radu.Lab_2;

import com.radu.Lab_2.builder.CarBuilder;
import com.radu.Lab_2.builder.CarBuilderFactory;
import com.radu.Lab_2.builder.CarTypes;
import com.radu.Lab_2.entity.Car;

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

    CarEngineer carEngineer = new CarEngineer(carBuilder);

    carEngineer.buildCar();

    Car car = carEngineer.getCar();

    System.out.println(car.getBody());
    System.out.println(car.getEngine());
    System.out.println(car.getRoof());
    System.out.println(car.getWheels());
  }
}
