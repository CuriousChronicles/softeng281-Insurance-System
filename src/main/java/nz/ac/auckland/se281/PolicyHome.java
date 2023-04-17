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
      return (2 * super.getSumInsured())/100;
    } else {
      return super.getSumInsured()/100 ;
    }
  }

  //   public int getBasePremium() {
  //     return basePremium();
  //   }

  @Override
  public void printPolicy() {
    // System.out.println(Integer.toString(basePremium()));
    // MessageCli.PRINT_DB_HOME_POLICY.printMessage(
    //     address,
    //     Integer.toString(super.getSumInsured()),
    //     Integer.toString(basePremium()),
    //     Integer.toString(super.policyDiscount()));

    MessageCli.PRINT_DB_HOME_POLICY.printMessage(
        address, Integer.toString(super.getSumInsured()), Integer.toString(basePremium()), Integer.toString(super.policyDiscount()));
  }
}
