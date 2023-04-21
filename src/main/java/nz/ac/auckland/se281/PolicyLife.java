package nz.ac.auckland.se281;

public class PolicyLife extends Policy {
  int age;

  public PolicyLife(int age, int sumInsured) {
    super(sumInsured);
    this.age = age;
  }

  public int basePremium() {
    double percentage = (1.0 + age / 100.0) / 100;
    return (int) (percentage * sumInsured);
  }

  @Override
  public void printPolicy(int policyCount) {
    MessageCli.PRINT_DB_LIFE_POLICY.printMessage(
        Integer.toString(sumInsured),
        Integer.toString(basePremium()),
        Integer.toString(policyDiscount(policyCount)));
  }
}
