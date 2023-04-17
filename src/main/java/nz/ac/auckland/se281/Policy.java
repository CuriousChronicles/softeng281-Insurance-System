package nz.ac.auckland.se281;

abstract class Policy {
  private int sumInsured;
  private int policyCount = 0;

  public Policy(int sumInsured) {
    this.sumInsured = sumInsured;
  }

  public int getSumInsured() {
    return sumInsured;
  }

  public void incrementPolicyCount() {
    policyCount += 1;
  }

  abstract int basePremium();

  public int policyDiscount() {

    if (policyCount == 2) {
      //   MessageCli.DISCOUNT_TWO.printMessage();
      return (90 * basePremium()) / 100;
    } else if (policyCount >= 3) {
      //   MessageCli.DISCOUNT_MULTIPLE.printMessage();
      return (80 * basePremium()) / 100;
    } else {
      return basePremium();
    }
  }

  public void printPolicy() {
    // MessageCli.PRINT_DB_LIFE_POLICY.printMessage(
    //     Integer.toString(sumInsured),
    //     Integer.toString(basePremiumAmount),
    //     Integer.toString(policyDiscount()));
    System.out.println("oh what is going on here?");
  }
}
