package nz.ac.auckland.se281;

public class Profile {
  private String userName;
  private String age;

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
      // int number = Integer.parseInt(age);
      if (getAgeAsInt() <= 0) {
        return false;
      } else {
        return true;
      }
    } catch (NumberFormatException nfe) {
      // MessageCli.INVALID_AGE.printMessage(age, userName);
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
}
