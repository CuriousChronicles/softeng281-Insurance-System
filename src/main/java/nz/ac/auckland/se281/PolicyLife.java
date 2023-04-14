package nz.ac.auckland.se281;

public class PolicyLife extends Policy{
    int age;

    public PolicyLife(int age, int sumInsured) {
        super(sumInsured);
        this.age = age;
    }

    int basePremium() {
        int amount = (1 + age/100);
        return amount;
    }
}
