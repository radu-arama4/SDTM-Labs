package com.radu.Lab_3.cars.functionality.proxy;

import com.radu.Lab_3.cars.entity.CarEngineer;
import com.radu.Lab_3.cars.functionality.facade.CarEngineerFacade;

public class CarEngineerProxy implements CarEngineer {
  private final CarEngineerFacade carEngineer;
  private final int yearsOfExperience;

  public CarEngineerProxy(CarEngineerFacade carEngineer) {
    this.carEngineer = carEngineer;
    yearsOfExperience = carEngineer.getYearsOfExperience();
  }

  @Override
  public void buildCar() {
    System.out.println("Car engineer working...");
    if (yearsOfExperience < 10) {
      try {
        Thread.sleep(3000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    } else {
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    carEngineer.buildCar();
  }
}
