package com.radu.Lab_2.builder;

import com.radu.Lab_2.entity.Car;

public interface CarBuilder {
  void buildEngine();

  void buildWheels();

  void buildRoofs();

  void buildBody();

  Car getCar();
}
