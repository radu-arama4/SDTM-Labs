# Topic: *Structural Design Patterns*
## Author: *Arama Radu-Vasile*
------
## Introduction
In this laboratory work I have extended the implementation of the first laboratory work by adding structural
design patterns. Structural design patterns explain how to assemble objects and classes into larger structures while 
keeping these structures flexible and efficient.
I remind that my application simulates the production of cars. 
## Implementation & Explanation
In this laboratory work I have implemented 3 structural design patterns:
* Adapter
* Proxy
* Facade

------

In order to implement an Adapter I have created the interface CarAdapter and the class RedCarAdapter. Basically 
I use it in order to "adapt" the Car to some standards by applying the red color to all its components. The RedCarAdapter
receives the created Car as a constructor argument.
```
public class RedCarAdapter implements CarAdapter {
  private final Car car;

  private final String redColor = " of red color.";

  public RedCarAdapter(Car car) {
    this.car = car;
    car.setEngine(car.getEngine() + redColor);
    car.setBody(car.getBody() + redColor);
    car.setRoof(car.getRoof() + redColor);
    car.setWheels(car.getWheels() + redColor);
  }

  @Override
  public Car getCar() {
    return car;
  }
}
```
I have added the adaption functional in the constructor, but I could add it in the getCar() method as well.
Now, in my application, each time an old car is built, it is "painted" in red.

```
public class OldCarBuilder implements CarBuilder {
  private final Car car;

  public OldCarBuilder() {
    this.car = new Car();
  }

  public Car getCar() {
    CarAdapter redCarAdapter = new RedCarAdapter(car);
    return redCarAdapter.getCar();
  }
  ...
}
```

------

For the Proxy implementation I have created the class called CarEngineerProxy. I am using it in order to differentiate 
the way different engineers work by their experience. For example if an engineer has less than 10 years of experience, he will
make the car slower. The engineer with more or equal than 10 years of experience, will create the car faster.

```
public class CarEngineerProxy implements CarEngineer {
  private final CarEngineerFacade carEngineer;
  private final int yearsOfExperience;

  public CarEngineerProxy(CarEngineerFacade carEngineer) {
    this.carEngineer = carEngineer;
    yearsOfExperience = carEngineer.getYearsOfExperience();
  }

  @Override
  public void buildCar() {
    System.out.println("Car engineer working...");
    if (yearsOfExperience < 10) {
      try {
        Thread.sleep(3000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    } else {
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    carEngineer.buildCar();
  }
}
```
As shown, the CarEngineerProxy implements the CarEngineer interface, and it acts as a middleware between the builder manager and
the functional of building the car.

```
CarEngineerFacade carEngineer = new CarEngineerFacade(carBuilder, yearsOfExperience);
CarEngineerProxy engineerProxy = new CarEngineerProxy(carEngineer);
engineerProxy.buildCar();
```
------
For the Facade I have used a simple implementation. The Facade patterns represents a way of abstracting complex functionalities
in simpler methods. In my case, I use this in the CarEngineerFacade class with the buildCar() method. The "client" doesn't know
about the specific steps of building a car, it just calls the method.
```
  @Override
  public void buildCar() {
    carBuilder.buildBody();
    carBuilder.buildEngine();
    carBuilder.buildRoofs();
    carBuilder.buildWheels();
  }
```
------
## Results
The actual results of the application are pretty much the same. The main difference is that the car engineers will create the cars
at different speeds based on their experience. Also, each old car will automatically be created will all components of red color,
also the difference can be seen in the code structure. 
