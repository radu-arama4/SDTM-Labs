package com.radu.Lab_3.cars.functionality.chain;

import com.radu.Lab_3.cars.data.clients.Client;
import com.radu.Lab_3.cars.data.DataSource;

public class ClientSearcher extends ClientAuthorisationProcessor {
  public ClientSearcher(ClientAuthorisationProcessor nextProcessor) {
    super(nextProcessor);
  }

  @Override
  public boolean isAuthorized(Client client) {
    Client foundClient = DataSource.getInstance().searchById(client.getID());
    if (foundClient == null) {
      System.out.println("There is no such user with ID " + client.getID() + " stored!");
      return false;
    } else if (nextProcessor!=null){
      return nextProcessor.isAuthorized(foundClient);
    }
    return true;
  }
}
