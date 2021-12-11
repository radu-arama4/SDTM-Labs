package com.radu.Lab_3.cars.functionality.chain;

import com.radu.Lab_3.cars.data.clients.Client;

public abstract class ClientAuthorisationProcessor {
  public ClientAuthorisationProcessor nextProcessor;

  public ClientAuthorisationProcessor(ClientAuthorisationProcessor nextProcessor) {
    this.nextProcessor = nextProcessor;
  }

  public abstract boolean isAuthorized(Client client);
}
