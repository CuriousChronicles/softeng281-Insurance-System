package nz.ac.auckland.se281;

public class PolicyHome extends Policy{
    private String address;
    private boolean isRental;

    public PolicyHome(int sumInsured, String address, boolean isRental) {
        super(sumInsured);
        this.address = address;
        this.isRental = isRental;
    }

    int basePremium() {
        if (isRental == true) {
            return (2/100) * sumInsured;
        } else {
            return (1/100) * sumInsured;
        }
    }

    public int getBasePremium() {
        return basePremium();
    }
}
