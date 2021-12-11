package com.radu.Lab_3.cars.data;

import com.radu.Lab_3.cars.data.clients.Client;

import java.util.LinkedList;
import java.util.List;

public class DataSource {
  private static DataSource instance;
  private List<Client> clients = new LinkedList<>();

  private DataSource() {}

  public static DataSource getInstance() {
    if (instance == null) {
      instance = new DataSource();
    }
    return instance;
  }

  public List<Client> getClients() {
    return clients;
  }

  public void setClients(List<Client> clients) {
    this.clients = clients;
  }

  public Client searchById(String ID) {
    return clients.stream().filter(client -> client.getID().equals(ID)).findAny().orElse(null);
  }
}
