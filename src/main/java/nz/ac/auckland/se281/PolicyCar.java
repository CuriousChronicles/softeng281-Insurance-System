package nz.ac.auckland.se281;

public class PolicyCar extends Policy {
  int age;
  String makeAndModel;
  String licensePlate;
  boolean mechBreakdown;

  public PolicyCar(
      int age, int sumInsured, String makeAndModel, String licensePlate, boolean mechBreakdown) {
    super(sumInsured);
    this.age = age;
    this.makeAndModel = makeAndModel;
    this.licensePlate = licensePlate;
    this.mechBreakdown = mechBreakdown;
  }

  public String getMakeAndModel() {
    return makeAndModel;
  }

  public String getLicensePlate() {
    return licensePlate;
  }

  int basePremium() {
    if (mechBreakdown == true) {
      if (age < 25) {
        int amount = (15 * super.getSumInsured()) / 100;
        return amount + 80;
      } else {
        int amount = (10 * super.getSumInsured()) / 100;
        return amount + 80;
      }
    } else {
      if (age < 25) {
        return (15 * super.getSumInsured()) / 100;
      } else {
        return (10 * super.getSumInsured()) / 100;
      }
    }
  }

  @Override
  public void printPolicy() {
    MessageCli.PRINT_DB_CAR_POLICY.printMessage(
        getMakeAndModel(),
        Integer.toString(super.getSumInsured()),
        Integer.toString(basePremium()),
        Integer.toString(super.policyDiscount()));
  }
}
