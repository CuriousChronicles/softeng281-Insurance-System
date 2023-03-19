package nz.ac.auckland.se281;

import java.util.ArrayList;
import nz.ac.auckland.se281.Main.PolicyType;

public class InsuranceSystem {

  // Create database called profiles using arraylists
  ArrayList<Profile> database = new ArrayList<Profile>();

  public InsuranceSystem() {
    // Only this constructor can be used (if you need to initialise fields).
  }

  public void printDatabase() {
    // Don't forget case sensitive
    // Print the number of people in database

  }

  public void createNewProfile(String userName, String age) {
    // Create profile
    Profile p = new Profile(userName, Integer.valueOf(age));
    userName = p.formatUserName(userName);

    // Check if userName is unique

    if (p.checkAgeValid() && p.checkUserNameLength(userName) && database.contains(p) == false) {

      database.add(p);
      System.out.println(p);
      MessageCli.PROFILE_CREATED.printMessage(userName, age);
    } else if (p.checkUserNameLength(userName) == false) {
      MessageCli.INVALID_USERNAME_TOO_SHORT.printMessage(userName);
    } else if (p.checkAgeValid() == false) {
      MessageCli.INVALID_AGE.printMessage(age, userName);
    } else if (database.contains(p)) {
      MessageCli.INVALID_USERNAME_NOT_UNIQUE.printMessage(userName);
    }
  }

  public void loadProfile(String userName) {
    // TODO: Complete this method.
  }

  public void unloadProfile() {
    // TODO: Complete this method.
  }

  public void deleteProfile(String userName) {
    // TODO: Complete this method.
  }

  public void createPolicy(PolicyType type, String[] options) {
    // TODO: Complete this method.
  }
}
