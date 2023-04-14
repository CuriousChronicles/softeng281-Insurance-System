package nz.ac.auckland.se281;

abstract class Policy {
    int sumInsured;

    public Policy(int sumInsured) {
        this.sumInsured = sumInsured;
    }
    
    abstract int basePremium();
}
