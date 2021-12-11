package com.radu.Lab_3.cars.data.clients;

public class Client {
  private String ID;
  private String surname;
  private String lastName;
  private int age;
  private int nrOfAccidents;
  private int nrOfTrafficViolations;

  public Client(String ID) {
    this.ID = ID;
  }

  public Client(
      String ID,
      String surname,
      String lastName,
      int age,
      int nrOfAccidents,
      int nrOfTrafficViolations) {
    this.ID = ID;
    this.surname = surname;
    this.lastName = lastName;
    this.age = age;
    this.nrOfAccidents = nrOfAccidents;
    this.nrOfTrafficViolations = nrOfTrafficViolations;
  }

  public String getID() {
    return ID;
  }

  public void setID(String ID) {
    this.ID = ID;
  }

  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public int getNrOfAccidents() {
    return nrOfAccidents;
  }

  public void setNrOfAccidents(int nrOfAccidents) {
    this.nrOfAccidents = nrOfAccidents;
  }

  public int getNrOfTrafficViolations() {
    return nrOfTrafficViolations;
  }

  public void setNrOfTrafficViolations(int nrOfTrafficViolations) {
    this.nrOfTrafficViolations = nrOfTrafficViolations;
  }
}
