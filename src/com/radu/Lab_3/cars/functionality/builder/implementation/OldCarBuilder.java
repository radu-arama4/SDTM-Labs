package com.radu.Lab_3.cars.functionality.builder.implementation;

import com.radu.Lab_3.cars.entity.Car;
import com.radu.Lab_3.cars.functionality.adapter.CarAdapter;
import com.radu.Lab_3.cars.functionality.adapter.RedCarAdapter;
import com.radu.Lab_3.cars.functionality.builder.CarBuilder;

public class OldCarBuilder implements CarBuilder {
  private final Car car;

  public OldCarBuilder() {
    this.car = new Car();
  }

  public Car getCar() {
    CarAdapter redCarAdapter = new RedCarAdapter(car);
    return redCarAdapter.getCar();
  }

  @Override
  public void buildEngine() {
    car.setEngine("Old Engine");
  }

  @Override
  public void buildWheels() {
    car.setWheels("Old Wheels");
  }

  @Override
  public void buildRoofs() {
    car.setRoof("Old Roof");
  }

  @Override
  public void buildBody() {
    car.setBody("Old Body");
  }
}
