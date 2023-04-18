package nz.ac.auckland.se281;

public class PolicyLife extends Policy{
    int age;
    public PolicyLife(int age, int sumInsured, int policyCount) {
        super(sumInsured, policyCount);
        this.age = age;
    }

    public int basePremium() {
        int percentage = 1 + age/100;
        return percentage * super.getSumInsured();
    }
}
