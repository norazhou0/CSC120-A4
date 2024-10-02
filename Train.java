import java.util.ArrayList;

public class Train {
  /* Engine */
  private Engine engine;
  /* Car */
  private ArrayList < Car > cars;

  /**
   * Constructor
   * @param fuelType
   * @param fuelCapacity
   * @param nCars
   * @param passengerCapacity
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

  /* Getters */
  public Engine getEngine() {
    return this.engine;
  }
  public Car getCar(int i) {
    return cars.get(i);
  }

  /* Sum of all car capacity */
  public int getMaxCapacity() {
    // initialize the max capacity 
    int maxCapacity = 0;
    for (Car c: cars) {
      maxCapacity += c.getCapacity();
    }
    return maxCapacity;
  }

  /* Sum of all seats remaining */
  public int seatsRemaining() {
    // initialize the remaining seats 
    int seatsLeft = 0;
    for (Car c: cars) {
      seatsLeft += c.seatsRemaining();
    }
    return seatsLeft;
  }

  /* Print out the car and passenger information */
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