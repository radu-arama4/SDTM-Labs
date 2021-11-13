package com.radu.Lab_2.client;

import com.radu.Lab_2.client.singleton.CarEngineeringManager;

public class Main {

  public static void main(String[] args) {
    CarEngineeringManager.getInstance().startProducingCar();
  }
}
