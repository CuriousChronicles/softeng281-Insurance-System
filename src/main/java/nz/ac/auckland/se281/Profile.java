package nz.ac.auckland.se281;

import java.util.ArrayList;

import nz.ac.auckland.se281.Main.PolicyType;

public class Profile {
  private String userName;
  private String age;
  private int lifePolicyCount = 0;

  ArrayList<Policy> policies = new ArrayList<Policy>();

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
    policies.add(homePolicy);
    homePolicy.incrementPolicyCount();

    MessageCli.NEW_POLICY_CREATED.printMessage("home", userName);
  }

  // // Create life policy method
  // public void createLifePolicy(int age, int sumInsured) {
  //   if ((getAgeAsInt() > 100)) {
  //     MessageCli.OVER_AGE_LIMIT_LIFE_POLICY.printMessage(userName);
  //   } else if (lifePolicyCount == 1) {
  //     MessageCli.ALREADY_HAS_LIFE_POLICY.printMessage(userName);
  //   } else {
  //     PolicyLife lifePolicy = new PolicyLife(age, sumInsured);
  //     lifePolicyCount = 1;
  //     MessageCli.NEW_POLICY_CREATED.printMessage("life", userName);
  //   }
  // }

  public void printProfPolicies() {
    for (Policy policy : policies) {
      policy.printPolicy(); 
    }
  }

  public void createCarPolicy(int age, int sumInsured, String makeAndModel, String licensePlate, boolean mechBreakdown) {
    PolicyCar carPolicy = new PolicyCar(age, sumInsured, makeAndModel, licensePlate, mechBreakdown);
    policies.add(carPolicy);
    carPolicy.incrementPolicyCount();

    MessageCli.NEW_POLICY_CREATED.printMessage("car", userName);
  }
}
