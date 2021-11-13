package com.radu.Lab_2.cars.functionality.builder;

import com.radu.Lab_2.cars.entity.Car;

public interface CarBuilder {
  void buildEngine();

  void buildWheels();

  void buildRoofs();

  void buildBody();

  Car getCar();
}
