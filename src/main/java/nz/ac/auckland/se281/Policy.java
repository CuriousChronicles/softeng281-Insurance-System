package nz.ac.auckland.se281;

abstract class Policy {
  protected int sumInsured;

  public Policy(int sumInsured) {
    this.sumInsured = sumInsured;
  }

  abstract int basePremium();

  public int getBasePremium() {
    return basePremium();
  }

  // Method to apply discount to base premium of policies
  public int policyDiscount(int policyCount) {
    // If there are 2 policies in a profile, apply a 10% discount
    // If there are more than 2 policies in a profile, apply a 20% discount
    // Otherwise return the base premium without a discount
    
    if (policyCount == 2) {
      MessageCli.DISCOUNT_TWO.printMessage();
      return (90 * basePremium()) / 100;
    } else if (policyCount >= 3) {
      MessageCli.DISCOUNT_MULTIPLE.printMessage();
      return (80 * basePremium()) / 100;
    } else {
      return basePremium();
    }
  }

  abstract void printPolicy(int policyCount);
}
