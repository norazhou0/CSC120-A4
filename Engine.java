
public class Engine {
  private FuelType fuelType;
  private double currentFuel;
  private double maxFuel;

  /**
   * Constructor for Engine
   * @param fuelType of the engine
   * @param currentFuel of the engine
   * @param maxFuel of the engine
   */
  public Engine(FuelType fuelType, double currentFuel, double maxFuel) {
    this.fuelType = fuelType;
    this.currentFuel = currentFuel;
    this.maxFuel = maxFuel;
  }

  public FuelType getFuelType() {
    return this.fuelType;
  }
  public double getCurrentFuel() {
    return this.currentFuel;
  }
  public double getMaxFuel() {
    return this.maxFuel;
  }

  /**
   * Method that resets the Engine's current fuel level to the maximumn 
   */
  public void refuel() {
    this.currentFuel = this.maxFuel;
  }

  /**
   * Method for train to go
   * @return if there's fuel left
   */
  public boolean go() {
    if (this.currentFuel > 0) {
      // Decrase the current fuel by 1 when there's fuel
      this.currentFuel -= 1;
      // Check if there's still fuel after the decrease
      if (this.currentFuel > 0) {
        System.out.println("Remaining fuel value is " + this.currentFuel + ".");
        return true;
      } else {
        System.out.println("Not enough fuel!");
        return false;
      }
    } else {
      // Print out the message and return false when there's no fuel
      System.out.println("No fuel to go!");
      return false;
    }
  }

  public static void main(String[] args) {
    Engine myEngine = new Engine(FuelType.ELECTRIC, 100.0, 105.0);
    while (myEngine.go()) {
      System.out.println("Choo choo!");
    }
    System.out.println("Out of fuel.");
    myEngine.refuel();
    System.out.println("Now Refuel!");
    System.out.println("The current fuel is now " + myEngine.currentFuel + ".");
  }
}