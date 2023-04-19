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

  public int policyDiscount(int policyCount) {
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
