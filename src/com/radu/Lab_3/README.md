# Topic: *Behavioral Design Patterns*
## Author: *Arama Radu-Vasile*
------
## Introduction
In this laboratory work I have extended the implementation of the first and second laboratory work by adding a behavioral
design pattern. The behavioral design patterns identify common communication patterns between objects and realize these patterns. 
By doing so, these patterns increase flexibility in carrying out this communication.
I remind that my application simulates the production of cars. 
## Implementation & Explanation
In this laboratory work I have implemented the behavioral design pattern: **Chain of Responsibility**

------

First of all, I decided to add a new feature to this application, which is the storing of clients which can use the service of
 car production. In thins laboratory I am using the Chain of Responsibility in order to check if a given client satisfies
 some criteria in order to use this service. For example, not more than 3 accidents or no more than 3 traffic violations.
 The chain is invoked in the method *startProducingCar* from CarEngineeringManager. If the conditions are satisifed, the
 process of car building starts and works as usual. In contrary, the building process doesn't start and a message is displayed.
 ```
public void startProducingCar(String userId) {
    System.out.println("*******************************************************************");
    if (!isTheClientAccepted(userId)) {
      System.out.println("The client with ID " + userId + " does not satisfy the requirements!");
      return;
    } else {
      System.out.println("The client with ID " + userId + " satisfies the requirements!");
    }
    ...
  }
public boolean isTheClientAccepted(String userId) {
    return ChainGenerator.generateChain().isAuthorized(new Client(userId));
  }
```
For this pattern I have created an abstract class ClientAuthorisationProcessor:
```
public abstract class ClientAuthorisationProcessor {
  public ClientAuthorisationProcessor nextProcessor;

  public ClientAuthorisationProcessor(ClientAuthorisationProcessor nextProcessor) {
    this.nextProcessor = nextProcessor;
  }

  public abstract boolean isAuthorized(Client client);
}
```
Every processor will have the reference to the next processor in the chain, and a method which will perform the checking and
call the next processor in the chain if the current conditions are satisfied.
ClientAuthorisationProcessor is the abstract class which will be inherited by the actual processors that will perform the verification. There are
3 classes of such type. First is ClientSearcher:

```
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
```
ClientSearcher checks if there is such an user stored in the DataSource. If the user doesn't exist, a false value is 
returned. If the user exists, the next processor is called. In our case it's ClientTrafficViolationsCheck.

```
public class ClientTrafficViolationsCheck extends ClientAuthorisationProcessor {
  public ClientTrafficViolationsCheck(ClientAuthorisationProcessor nextProcessor) {
    super(nextProcessor);
  }

  @Override
  public boolean isAuthorized(Client client) {
    if (client.getNrOfTrafficViolations() > 3) {
      System.out.println(
          client.getSurname()
              + " "
              + client.getLastName()
              + " has more than 3 traffic violations!");
      return false;
    } else if (nextProcessor != null) {
      return nextProcessor.isAuthorized(client);
    }
    return true;
  }
}
```
ClientTrafficViolationsCheck checks if the user has the required number of traffic violations. The flow is the same, 
if the condition is satisifed, the next processor is called, which is ClientAccidentsCheck.

```
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
```
ClientAuthorisationProcessor checks if the required number of accidents is satisfied.

The chain is generated in ChainGenerator class.

```
public class ChainGenerator {
  public static ClientAuthorisationProcessor generateChain() {
    ClientAuthorisationProcessor accidentProcessor = new ClientAccidentsCheck(null);
    ClientAuthorisationProcessor violationProcessor =
        new ClientTrafficViolationsCheck(accidentProcessor);
    return new ClientSearcher(violationProcessor);
  }
}
```
You can see that the *generateChain* method is called in the *isTheClientAccepted* method which was shown previously.
The application is started by populating the DataSource with some clients. I have created clients in order to
cover all the cases. The client ID is given as an argument for the *startProducingCar* method.

```
public class Main {
  public static void main(String[] args) {
    DataSource.getInstance()
        .setClients(
            new LinkedList<>(
                Arrays.asList(
                    new Client("123", "Radu", "Arama", 21, 0, 0),
                    new Client("124", "Vanea", "Vanea", 23, 5, 5),
                    new Client("125", "Jora", "Jora", 25, 4, 2))));

    CarEngineeringManager.getInstance().startProducingCar("123");
    CarEngineeringManager.getInstance().startProducingCar("124");
    CarEngineeringManager.getInstance().startProducingCar("125");
    CarEngineeringManager.getInstance().startProducingCar("126");
  }
}
```

------
## Results
The results are as expected. For each client there is a specific case. For the client with ID 123 all the conditions
are satisfied. Client with ID 124 has a number of accidents and traffic violations more than 5. The client with ID
125 has a number of accidents bigger than 5. Also, I have given in the 4th case the ID of a non-existent client. The results
can be viewed in the image:
