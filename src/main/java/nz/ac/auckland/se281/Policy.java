package nz.ac.auckland.se281;

abstract class Policy {
  private int sumInsured;
  private int policyCount;

  public Policy(int sumInsured, int policyCount) {
    this.sumInsured = sumInsured;
    this.policyCount = policyCount;
  }

  public int getSumInsured() {
    return sumInsured;
  }

  public int getPolicyCount() {
    return policyCount;
  }

  abstract int basePremium();

  public int policyDiscount() {
    // System.out.println(policyCount);
    if (policyCount == 2) {
      MessageCli.DISCOUNT_TWO.printMessage();
      return (90 * basePremium()) / 100;
    } else if (policyCount >= 3) {
      MessageCli.DISCOUNT_MULTIPLE.printMessage();
      return (80 * basePremium()) / 100;
    } else {
      System.out.println("no discount applied");
      return basePremium();
    }
  }

  public void printPolicy() {
    MessageCli.PRINT_DB_LIFE_POLICY.printMessage(
        Integer.toString(sumInsured),
        Integer.toString(basePremium()),
        Integer.toString(policyDiscount()));
  }
}
