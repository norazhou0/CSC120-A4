import java.util.ArrayList;

public class Car {
    /* ArrayList to store passenger information */
    private ArrayList<Passenger> passengers;
    /* Integer to store the maximun capacity */
    private int maxCapaciy; 

  /**
   * Constructor
   * Initialize an empty array list for passgeners
   * @param max
   */
  public Car(int maxCapaciy) {
    passengers = new ArrayList<>();
    this.maxCapaciy = maxCapaciy;
  }

  /* Get the maximun capacity of the car */
  public int getCapacity() {
    return this.maxCapaciy; 
}
  
  /* An accessor-like method that returns remaining seats */
  public int seatsRemaining() {
    return this.maxCapaciy - passengers.size(); 
}

  /* Add passengers */
  public boolean addPassenger(Passenger p) {
    // check if seats are available 
    if (seatsRemaining() > 0) {
    // add the passenger
      passengers.add(p);
      return true;
    }
    else {
      // throw an error message
      throw new RuntimeException("The car is full, can't add more passengers!");
    }
  }

  /* Remove passengers */
  public boolean removePassenger(Passenger p) {
    // confirm that the passenger is actually onboard
    if (passengers.contains(p)) {
    // remove the passenger
      passengers.remove(p);
      return true;
    }
    else {
      // throw an error message
      throw new RuntimeException("The passenger isn't actually onboard this car.");
    }
  }

  /* A method that prints out passengers aboard */
  public void printManifest() {
    if (passengers.size() > 0) {
      System.out.println("Current onbard: ");
      for (Passenger p : passengers) {
        System.out.println("- " + p.getName());
      }
  }
    else {
      System.out.println("This car is EMPTY.");
  }
}
}