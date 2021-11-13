package com.radu.Lab_2.cars.functionality.builder.factory;

import com.radu.Lab_2.cars.functionality.builder.CarBuilder;
import com.radu.Lab_2.cars.functionality.builder.CarTypes;
import com.radu.Lab_2.cars.functionality.builder.implementation.NewCarBuilder;
import com.radu.Lab_2.cars.functionality.builder.implementation.OldCarBuilder;

public class CarBuilderFactory {
  public static CarBuilder generateCarBuilder(CarTypes carType) {
    switch (carType) {
      case NEW:
        return new NewCarBuilder();
      case OLD:
        return new OldCarBuilder();
      default:
        System.out.println("No such type!");
        return null;
    }
  }
}
