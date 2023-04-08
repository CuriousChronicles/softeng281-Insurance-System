package nz.ac.auckland.se281;

import java.util.ArrayList;
import nz.ac.auckland.se281.Main.PolicyType;

public class InsuranceSystem {

  // Create database called profiles using arraylists
  ArrayList<Profile> database = new ArrayList<Profile>();
  private String loadedProfileUserName = null;

  public InsuranceSystem() {
    // Only this constructor can be used (if you need to initialise fields).
  }

  public void printDatabase() {
    // Print the number of people in database
    int lengthDatabase = database.size();
    if (lengthDatabase == 0) {
      MessageCli.PRINT_DB_POLICY_COUNT.printMessage(Integer.toString(lengthDatabase), "s", ".");
    } else if (lengthDatabase == 1) {
      MessageCli.PRINT_DB_POLICY_COUNT.printMessage(Integer.toString(lengthDatabase), "", ":");
    } else {
      MessageCli.PRINT_DB_POLICY_COUNT.printMessage(Integer.toString(lengthDatabase), "s", ":");
    }

    // Print the database
    for (int i = 0; i < lengthDatabase; i++) {
      String userName = database.get(i).getUserName();
      int age = database.get(i).getAgeAsInt();
      if (userName.equals(loadedProfileUserName)) {
        MessageCli.PRINT_DB_PROFILE_HEADER_SHORT.printMessage(
            "*** ", Integer.toString(i + 1), userName, Integer.toString(age));
      } else {
        MessageCli.PRINT_DB_PROFILE_HEADER_MINIMAL.printMessage(
            Integer.toString(i + 1), userName, Integer.toString(age));
      }
    }
  }

  public void createNewProfile(String userName, String age) {
    if (loadedProfileUserName == null) {
      // Create profile
      Profile p = new Profile(userName, age);
      userName = p.getUserName();
      // Check if userName is unique

      if (p.checkAgeValid() && p.checkUserNameLength(userName)) {
        boolean isUserNameValid = true;
        for (int j = 0; j < database.size(); j++) {
          if (database.get(j).getUserName().equals(p.getUserName())) {
            isUserNameValid = false;
          }
        }

        if (isUserNameValid == false) {
          MessageCli.INVALID_USERNAME_NOT_UNIQUE.printMessage(userName);
        } else {
          database.add(p);
          MessageCli.PROFILE_CREATED.printMessage(userName, age);
        }

      } else if (p.checkUserNameLength(userName) == false) {
        MessageCli.INVALID_USERNAME_TOO_SHORT.printMessage(userName);
      } else if (p.checkAgeValid() == false) {
        MessageCli.INVALID_AGE.printMessage(age, userName);
      }
    } else {
      MessageCli.CANNOT_CREATE_WHILE_LOADED.printMessage(userName);
    }
  }

  public void loadProfile(String userName) {
    // Description: command loads a profile into the system
    userName = userName.substring(0, 1).toUpperCase() + userName.substring(1).toLowerCase();
    // if profile is loaded successfully, print success message
    boolean inDatabase = false;
    for (int i = 0; i < database.size(); i++) {
      if (database.get(i).getUserName().equals(userName)) {
        inDatabase = true;
      }
    }
    if (inDatabase == true) {
      MessageCli.PROFILE_LOADED.printMessage(userName);
      loadedProfileUserName = userName;
    } else {
      MessageCli.NO_PROFILE_FOUND_TO_LOAD.printMessage(userName);
    }
  }

  public void unloadProfile() {
    // Description: This unloads the currently-loaded profile
    if (loadedProfileUserName == null) {
      MessageCli.NO_PROFILE_LOADED.printMessage();
    } else {
      MessageCli.PROFILE_UNLOADED.printMessage(loadedProfileUserName);
      loadedProfileUserName = null;
    }
  }

  public void deleteProfile(String userName) {
    // Description: This deletes a profile from the database
    userName = userName.substring(0, 1).toUpperCase() + userName.substring(1).toLowerCase();
    boolean inDatabase = false;
    int index = 0;

    for (int i = 0; i < database.size(); i++) {
      if (database.get(i).getUserName().equals(userName)) {
        inDatabase = true;
        index = i;
      }
    }

    if (inDatabase == true) {
      // delete only if the profile is not currently loaded
      if (loadedProfileUserName == null) {
        database.remove(index);
        MessageCli.PROFILE_DELETED.printMessage(userName);
      } else if (loadedProfileUserName.equals(userName)) {
        MessageCli.CANNOT_DELETE_PROFILE_WHILE_LOADED.printMessage(userName);
      } else {
        database.remove(index);
        MessageCli.PROFILE_DELETED.printMessage(userName);
      }
    } else {
      MessageCli.NO_PROFILE_FOUND_TO_DELETE.printMessage(userName);
    }
  }

  public void createPolicy(PolicyType type, String[] options) {
    // TODO: Complete this method.
  }
}
