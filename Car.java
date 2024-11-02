import java.util.ArrayList;

public class Car {
  private ArrayList < Passenger > passengers;
  private int maxCapaciy;

  /**
   * Constructor for Car
   * @param maxCapacity of the car
   */
  public Car(int maxCapaciy) {
    passengers = new ArrayList < > ();
    this.maxCapaciy = maxCapaciy;
  }

  public int getCapacity() {
    return this.maxCapaciy;
  }

  /**
   * Method for getting the number of remaining seats
   * @return the number of remaining seats
   */
  public int seatsRemaining() {
    return this.maxCapaciy - passengers.size();
  }

  /**
   * Method for adding passengers
   * @param p passenger
   * @return if the passenger is onboard
   */
  public boolean addPassenger(Passenger p) {
    // check if there's seat available and the passenger isn't already onboard
    if (seatsRemaining() > 0 && !passengers.contains(p)){
      // add the passenger
      passengers.add(p);
      return true;
    } else {
      // throw an error message
      throw new RuntimeException("The car is full, can't add more passengers!");
    }
  }

  /**
   * Method for removing passengers
   * @param p passenger
   * @return if the passenger is deboard
   */
  public boolean removePassenger(Passenger p) {
    // confirm that the passenger is actually onboard
    if (passengers.contains(p)) {
      // remove the passenger
      passengers.remove(p);
      return true;
    } else {
      // throw an error message
      throw new RuntimeException("The passenger isn't actually onboard this car.");
    }
  }

  /**
   * Method that prints a nicely-formatted roster of all Passengers currently aboard the car
   */
  public void printManifest() {
    if (passengers.size() > 0) {
      System.out.println("Current onbard: ");
      for (Passenger p: passengers) {
        System.out.println("- " + p.getName());
      }
    } else {
      System.out.println("This car is EMPTY.");
    }
  }
}