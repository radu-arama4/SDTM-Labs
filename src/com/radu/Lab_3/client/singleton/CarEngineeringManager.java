package com.radu.Lab_3.client.singleton;

import com.radu.Lab_3.cars.data.clients.Client;
import com.radu.Lab_3.cars.entity.Car;
import com.radu.Lab_3.cars.functionality.builder.CarBuilder;
import com.radu.Lab_3.cars.functionality.builder.CarTypes;
import com.radu.Lab_3.cars.functionality.builder.factory.CarBuilderFactory;
import com.radu.Lab_3.cars.functionality.chain.ChainGenerator;
import com.radu.Lab_3.cars.functionality.facade.CarEngineerFacade;
import com.radu.Lab_3.cars.functionality.proxy.CarEngineerProxy;

public class CarEngineeringManager {
  private static CarEngineeringManager carEngineeringManager;

  private CarEngineeringManager() {}

  public static CarEngineeringManager getInstance() {
    if (carEngineeringManager == null) {
      carEngineeringManager = new CarEngineeringManager();
    }
    return carEngineeringManager;
  }

  public void startProducingCar(String userId) {
    System.out.println("*******************************************************************");
    if (!isTheClientAccepted(userId)) {
      System.out.println("The client with ID " + userId + " does not satisfy the requirements!");
      return;
    } else {
      System.out.println("The client with ID " + userId + " satisfies the requirements!");
    }

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

  public boolean isTheClientAccepted(String userId) {
    return ChainGenerator.generateChain().isAuthorized(new Client(userId));
  }
}
