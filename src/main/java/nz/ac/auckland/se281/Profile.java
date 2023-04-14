package nz.ac.auckland.se281;

public class Profile {
  private String userName;
  private String age;
  private int policyCount = 0;
  private int lifePolicyCount = 0;
  private int totalPremium = 0;

  public Profile(String userName, String age) {
    this.userName = userName.substring(0, 1).toUpperCase() + userName.substring(1).toLowerCase();
    this.age = age;
  }

  // Create methods to access username and age
  public String getUserName() {
    return userName;
  }

  public int getAgeAsInt() {
    return Integer.parseInt(age);
  }

  // Create method to check validity of age
  public boolean checkAgeValid() {
    try {
      if (getAgeAsInt() <= 0) {
        return false;
      } else {
        return true;
      }
    } catch (NumberFormatException nfe) {
      return false;
    }
  }

  // Create method to check validity of userName
  public boolean checkUserNameLength(String userName) {
    if (userName.length() < 3) {
      return false;
    } else {
      return true;
    }
  }

  // Create home policy method
  public void createHomePolicy(int sumInsured, String address, boolean isRental) {
    PolicyHome homePolicy = new PolicyHome(sumInsured, address, isRental);
    policyCount += 1;
    MessageCli.NEW_POLICY_CREATED.printMessage("home", userName);
    
    totalPremium += homePolicy.getBasePremium();
  }

  // Create car policy method
  public void createCarPolicy(
      int age, int sumInsured, String makeAndModel, String licensePlate, boolean mechBreakdown) {
    PolicyCar carPolicy = new PolicyCar(age, sumInsured, makeAndModel, licensePlate, mechBreakdown);
    policyCount += 1;
    MessageCli.NEW_POLICY_CREATED.printMessage("car", userName);

    totalPremium += carPolicy.getBasePremium();
  }

  // Create life policy method
  public void createLifePolicy(int age, int sumInsured) {
    if ((getAgeAsInt() > 100)) {
      MessageCli.OVER_AGE_LIMIT_LIFE_POLICY.printMessage(userName);
    } else if (lifePolicyCount == 1) {
      MessageCli.ALREADY_HAS_LIFE_POLICY.printMessage(userName);
    } else {
      PolicyLife lifePolicy = new PolicyLife(age, sumInsured);
      policyCount += 1;
      lifePolicyCount = 1;
      MessageCli.NEW_POLICY_CREATED.printMessage("life", userName);

      totalPremium += lifePolicy.getBasePremium();
    }
  }

  public int getTotalPremium() {
    return totalPremium;
  }

  public int getPolicyCount() {
    return policyCount;
  }

  public int getDiscountPremium() {
    if (getPolicyCount() == 2) {
      // MessageCli.DISCOUNT_TWO.printMessage();
      return (90/100) * getTotalPremium();
    } else if (getPolicyCount() >= 3) {
      // MessageCli.DISCOUNT_MULTIPLE.printMessage();
      return (80/100) * getTotalPremium();
    } else {
      return getTotalPremium();
    }
  }
}
