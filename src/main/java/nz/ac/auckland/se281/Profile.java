package nz.ac.auckland.se281;

import java.util.ArrayList;

public class Profile {

  ArrayList<Policy> policies = new ArrayList<Policy>();

  private String userName;
  private String age;
  private int policyCount = 0;
  private int lifePolicyCount = 0;

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

  public void incrementPolicyCount() {
    policyCount += 1;
  }

  public int getPolicyCount() {
    return policyCount;
  }

  // Create home policy method
  public void createHomePolicy( int sumInsured, String address, boolean isRental) {
    incrementPolicyCount();
    PolicyHome homePolicy = new PolicyHome(sumInsured, getPolicyCount(), address, isRental);
    policies.add(homePolicy);

    MessageCli.NEW_POLICY_CREATED.printMessage("home", userName);
  }

  public void createCarPolicy(
      int age, int sumInsured, String makeAndModel, String licensePlate, boolean mechBreakdown) {
    incrementPolicyCount();
      PolicyCar carPolicy =
        new PolicyCar(age, sumInsured, getPolicyCount(), makeAndModel, licensePlate, mechBreakdown);
    policies.add(carPolicy);


    MessageCli.NEW_POLICY_CREATED.printMessage("car", userName);
  }

  public void createLifePolicy(int age, int sumInsured) {
    if (age > 100) {
      MessageCli.OVER_AGE_LIMIT_LIFE_POLICY.printMessage(userName);
    } else if (lifePolicyCount == 1) {
      MessageCli.ALREADY_HAS_LIFE_POLICY.printMessage(userName);
    } else {
      incrementPolicyCount();
      PolicyLife lifePolicy = new PolicyLife(age, sumInsured, getPolicyCount());
      policies.add(lifePolicy);
      lifePolicyCount = 1;

      MessageCli.NEW_POLICY_CREATED.printMessage("life", userName);
    }
  }

  public void printProfPolicies() {
    for (Policy policy : policies) {
      policy.printPolicy();
    }
  }
}
