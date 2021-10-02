# Topic: *Creational Design Patterns*
## Author: *Arama Radu-Vasile*
------
## Introduction :

This is a project that simulates the building of a car using Creational Design Patterns. 

## Some Theory :

The main entity is the Car. In order to simulate the process of car creation I have used the Builder pattern, the
Factory pattern and the Singleton.  
The flow of the application consists of defining a Car Builder (there are 2 types: old and new) using the Car Builder 
Factory, defining a Car Engineer which takes as an argument the defined Car Builder and creates the Car by using the 
implementation defined in the chosen Car Builder.

## Implementation and explanation :

First of all I have defined an app manager - CarEngineeringManager, which is a singleton.
```
public class CarEngineeringManager {
  private static CarEngineeringManager carEngineeringManager;

  private CarEngineeringManager() {}

  public static CarEngineeringManager getInstance() {
    if (carEngineeringManager == null) {
      carEngineeringManager = new CarEngineeringManager();
    }
    return carEngineeringManager;
  }
    ...
```
It includes the main functionality of the app, defined in the method ``` startProducingCar() ```

The CarBuilder is created using the Factory Method. It gives the client the possibility to not be dependent on
the implementations of CarBuilder.
```
CarBuilder carBuilder = CarBuilderFactory.generateCarBuilder(CarTypes.OLD);
```

CarBuilderFactory has just one static method for creating the required type of CarBuilder:
```
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
```

The main process of creating the Car is done using the Builder pattern. It allows creating different car representations
using the same creation process. In my case, the Car Engineer can create different types of Car, using different implementations
of Car Builder (CarBuilder interface).

```
public class CarEngineer {
  private final CarBuilder carBuilder;

  public CarEngineer(CarBuilder carBuilder) {
    this.carBuilder = carBuilder;
  }

  public Car getCar() {
    return carBuilder.getCar();
  }

  public void buildCar() {
    carBuilder.buildBody();
    carBuilder.buildEngine();
    carBuilder.buildRoofs();
    carBuilder.buildWheels();
  }
}
```
One important part is that the Car Engineer is not dependent on specific implementations of Car Builder.

## Results and conclusion :

For now, I have provided a simple result - a simple print of the fields from the created Car.
Example:

![Capture](https://user-images.githubusercontent.com/59333010/135715491-beab01e6-fc4d-470d-8b30-fab8b74996a9.JPG)

![Capture](https://user-images.githubusercontent.com/59333010/135715549-14c973f1-5a58-4c38-94e0-e11654c53d6e.JPG)

As a conclusion, I can say that in this project can be seen how the design patterns offer more abstraction and that offers
more flexibility of the code. For example, in my case, I can easily add more implementations of CarBuilder. 
Also, the code is better structured and more readable.
