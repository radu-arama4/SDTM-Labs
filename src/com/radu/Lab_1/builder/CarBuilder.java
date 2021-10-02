package com.radu.Lab_1.builder;

import com.radu.Lab_1.entity.Car;

public interface CarBuilder {
  void buildEngine();

  void buildWheels();

  void buildRoofs();

  void buildBody();

  Car getCar();
}
