package com.radu.Lab_3.cars.functionality.builder;

import com.radu.Lab_3.cars.entity.Car;

public interface CarBuilder {
  void buildEngine();

  void buildWheels();

  void buildRoofs();

  void buildBody();

  Car getCar();
}
