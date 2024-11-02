import java.util.ArrayList;

public class Train {
  private Engine engine;
  private ArrayList < Car > cars;

  /**
   * Constructor for Train
   * @param fuelType of the train
   * @param fuelCapacity of the train
   * @param nCars of the train
   * @param passengerCapacity of the train
   */
  public Train(FuelType fuelType, double fuelCapacity, int nCars, int passengerCapacity) {
    // set the current fuel to be full
    this.engine = new Engine(fuelType, fuelCapacity, fuelCapacity);
    this.cars = new ArrayList < Car > ();
    // store the cars one at a time
    for (int i = 0; i < nCars; i++) {
      // add cars to the train
      this.cars.add(new Car(passengerCapacity));
    }
  }

  public Engine getEngine() {
    return this.engine;
  }

  /**
   * Method that gets the specific Car
   * @param i the index of the Car
   * @return the Car
   */
  public Car getCar(int i) {
    return cars.get(i);
  }

  /**
   * Method for getting the maximum capacity
   * @return the maximum capacity of the train
   */
  public int getMaxCapacity() {
    // initialize the max capacity 
    int maxCapacity = 0;
    for (Car c: cars) {
      maxCapacity += c.getCapacity();
    }
    return maxCapacity;
  }

  /**
   * Method for getting the remaining seats
   * @return seats left on the train
   */
  public int seatsRemaining() {
    // initialize the remaining seats 
    int seatsLeft = 0;
    for (Car c: cars) {
      seatsLeft += c.seatsRemaining();
    }
    return seatsLeft;
  }

  /**
   * Method that prints the car and passenger information
   */
  public void printManifest() {
    System.out.println("Current onbard in the train: ");
    for (Car c: cars) {
      c.printManifest();
    }
  }

  public static void main(String[] args) {
    Train myTrain = new Train(FuelType.STEAM, 100, 5, 10);
    myTrain.printManifest();
    Passenger myPassenger = new Passenger("Nora");
    // Use getter to access the car
    myPassenger.boardCar(myTrain.getCar(3));
    myTrain.printManifest();
    myPassenger.getOffCar(myTrain.getCar(2));
    myTrain.printManifest();
  }
}