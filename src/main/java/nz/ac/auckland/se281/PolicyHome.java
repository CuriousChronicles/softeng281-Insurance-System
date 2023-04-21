package nz.ac.auckland.se281;

public class PolicyHome extends Policy {
  private String address;
  private boolean isRental;

  public PolicyHome(int sumInsured, String address, boolean isRental) {
    super(sumInsured);
    this.address = address;
    this.isRental = isRental;
  }

  public String getAddress() {
    return address;
  }

  public int basePremium() {
    if (isRental == true) {
      return (2 * sumInsured) / 100;
    } else {
      return sumInsured / 100;
    }
  }

  @Override
  public void printPolicy(int policyCount) {

    MessageCli.PRINT_DB_HOME_POLICY.printMessage(
        address,
        Integer.toString(sumInsured),
        Integer.toString(basePremium()),
        Integer.toString(super.policyDiscount(policyCount)));
  }
}
