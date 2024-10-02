public class Passenger {

    private String name;
  
    public Passenger(String name) {
      this.name = name;
    }
  
    /* Get passenger name */
    public String getName() {
      return this.name;
    }
  
    /* A method for passengers to board */
    public void boardCar(Car c) {
      try {
        c.addPassenger(this);
      } catch (RuntimeException e) {
        // print out the error message implemented in the car
        System.err.println(e.getMessage());
      }
    }
  
    /* A method for passengers to get off */
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
      Passenger Passenger_2 = new Passenger("Emma");
      Car myCar = new Car(1);
      myPassenger.boardCar(myCar);
      myCar.printManifest();
      Passenger_2.boardCar(myCar);
      myCar.printManifest();
    }
  
  }