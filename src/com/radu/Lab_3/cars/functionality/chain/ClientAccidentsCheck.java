package com.radu.Lab_3.cars.functionality.chain;

import com.radu.Lab_3.cars.data.clients.Client;

public class ClientAccidentsCheck extends ClientAuthorisationProcessor {
  public ClientAccidentsCheck(ClientAuthorisationProcessor nextProcessor) {
    super(nextProcessor);
  }

  @Override
  public boolean isAuthorized(Client client) {
    if (client.getNrOfAccidents() > 3) {
      System.out.println(
          client.getSurname() + " " + client.getLastName() + " has more than 3 accidents!");
      return false;
    } else if (nextProcessor != null) {
      return nextProcessor.isAuthorized(client);
    }
    return true;
  }
}
