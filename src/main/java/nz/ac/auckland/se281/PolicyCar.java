package nz.ac.auckland.se281;

public class PolicyCar extends Policy{
    int age;
    String makeAndModel;
    String licensePlate;
    boolean mechBreakdown;

    public PolicyCar(int age, int sumInsured, String makeAndModel, String licensePlate, boolean mechBreakdown) {
        super(sumInsured);
        this.age = age;
        this.makeAndModel = makeAndModel;
        this.licensePlate = licensePlate;
        this.mechBreakdown = mechBreakdown;
    }

    int basePremium() {
        if (mechBreakdown == true) {
            if (age < 25) {
                int amount = (15/100) * sumInsured + 80;
                return amount;
            } else {
                int amount = (10/100) * sumInsured + 80;
                return amount;
            }
        } else {
            if (age < 25) {
                int amount = (15/100) * sumInsured + 80;
                return amount;
            } else {
                int amount = (10/100) * sumInsured + 80;
                return amount;
            }
        }
    }

    public int getBasePremium() {
        return basePremium();
    }
    
}
