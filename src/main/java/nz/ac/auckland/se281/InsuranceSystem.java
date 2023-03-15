package nz.ac.auckland.se281;

import java.util.ArrayList;

import org.eclipse.jgit.transport.CredentialItem.Username;

// import java.util.ArrayList;
import nz.ac.auckland.se281.Main.PolicyType;

public class InsuranceSystem {
  ArrayList<String> databaseUserName = new ArrayList<String>();
  ArrayList<Integer> databaseAge = new ArrayList<Integer>();

  public InsuranceSystem() {
    // Only this constructor can be used (if you need to initialise fields).
  }

  public void printDatabase() {
    // Don't forget case sensitive
    // Print the number of people in database

  }

  public void createNewProfile(String userName, String age) {
    // The username should be unique, and the age should be a positive number
    // If these conditions are not met, an error message should be printed
    if (databaseUserName.contains(userName) == false && Integer.valueOf(age) >= 0 && userName.length() > 3) {
      // If the userName and age are both valid, then add it to the database using the correct format
      // Change userName to all lowercase except first letter
      userName = userName.substring(0, 1).toUpperCase() + userName.substring(1).toLowerCase();
      
      databaseUserName.add(userName);
      databaseAge.add(Integer.parseInt(age));
    } else if (databaseUserName.contains(userName) == true) {
      //Print not unique error
      MessageCli.INVALID_USERNAME_NOT_UNIQUE.printMessage(userName);
    } else if (Integer.valueOf(age) < 0) {
      //Print invalid age error message
      MessageCli.INVALID_AGE.printMessage(age, userName);
    } else if (userName.length() <= 3) {
      //Print userName too short error message
      MessageCli.INVALID_USERNAME_TOO_SHORT.printMessage(userName);
    }
    
  //  System.out.println(databaseUserName);
  //  System.out.println(databaseAge);
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
