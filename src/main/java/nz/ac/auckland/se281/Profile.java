package nz.ac.auckland.se281;

public class Profile {
  private String userName;
  private int age;

  public Profile(String userName, int age) {
    this.userName = userName.substring(0, 1).toUpperCase() + userName.substring(1).toLowerCase();
    this.age = age;
  }

  // Create methods to access username and age
  public String getUserName() {
    return userName;
  }

  public int getAge() {
    return age;
  }

  // Create method to check validity of age
  public boolean checkAgeValid() {
    if (age <= 0) {
      return false;
    } else {
      return true;
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
