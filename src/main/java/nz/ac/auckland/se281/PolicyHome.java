package nz.ac.auckland.se281;

public class PolicyHome extends Policy {
  private String address;
  private boolean isRental;

  public PolicyHome(int sumInsured, int policyCount, String address, boolean isRental) {
    super(sumInsured, policyCount);
    this.address = address;
    this.isRental = isRental;
  }

  public String getAddress() {
    return address;
  }

  public int basePremium() {
    if (isRental == true) {
      return (2 * super.getSumInsured())/100;
    } else {
      return super.getSumInsured()/100 ;
    }
  }

  @Override
  public void printPolicy() {

    MessageCli.PRINT_DB_HOME_POLICY.printMessage(
        address, Integer.toString(super.getSumInsured()), 
        Integer.toString(basePremium()), 
        Integer.toString(super.policyDiscount()));
  }
}
