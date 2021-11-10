package com.radu.Lab_2.adapter;

import com.radu.Lab_2.entity.Car;

public class RedCarAdapter implements CarAdapter {
  private final Car car;

  private final String redColor = " of red color.";

  public RedCarAdapter(Car car) {
    this.car = car;
    car.setEngine(car.getEngine() + redColor);
    car.setBody(car.getBody() + redColor);
    car.setRoof(car.getRoof() + redColor);
    car.setWheels(car.getWheels() + redColor);
  }

  @Override
  public Car getCar() {
    return car;
  }
}
