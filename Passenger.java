public class Passenger {

    private String name;

    /**
     * Constructor of Passenger
     * @param name of the passenger
     */
    public Passenger(String name) {
      this.name = name;
    }
  
    public String getName() {
      return this.name;
    }
  
    /**
     * Method for passengers to board the car
     * @param c the Car
     */
    public void boardCar(Car c) {
      try {
        c.addPassenger(this);
      } catch (RuntimeException e) {
        // print out the error message implemented in the car
        System.err.println(e.getMessage());
      }
    }
  
    /**
     * Method for passengers to get off the car
     * @param c the Car
     */
    public void getOffCar(Car c) {
      try {
        c.removePassenger(this);
      } catch (RuntimeException e) {
        // print out the error message implemented in the car
        System.err.println(e.getMessage());
      }
    }

    public static void main(String[] args) {
      Passenger myPassenger = new Passenger("Nora");
      Passenger passenger_2 = new Passenger("Emma");
      Car myCar = new Car(1);
      myPassenger.boardCar(myCar);
      myCar.printManifest();
      passenger_2.boardCar(myCar);
      myCar.printManifest();
    }
  
  }