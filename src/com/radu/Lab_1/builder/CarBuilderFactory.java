package com.radu.Lab_1.builder;

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
