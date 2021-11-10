package com.radu.Lab_2.builder;

import com.radu.Lab_2.adapter.CarAdapter;
import com.radu.Lab_2.adapter.RedCarAdapter;
import com.radu.Lab_2.entity.Car;

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
