package p02BankAccount;

public class BankAccount {
    
    private final static double DEFAULT_INTEREST_RATE = 0.02;
    private static double interestRate = DEFAULT_INTEREST_RATE;
    private static int bankAccountCount = 1;

    private int id;
    private double balance;

    static void  setInterestRate(double interestRate) {
        BankAccount.interestRate = interestRate;
    }

    double getInterest(int years) {
        return BankAccount.interestRate * years * this.balance;
    }

    void deposit(double amount) {
        this.balance += amount;
    }

    public int createAccount() {
        this.id = bankAccountCount;
        bankAccountCount++;

        return this.id;
    }

}
