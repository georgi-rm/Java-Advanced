public class BankAccount {
    private final static double DEFAULT_INTEREST_RATE = 0.02;
    private static double interestRate = DEFAULT_INTEREST_RATE;
    private static int nextId = 1;
    private final int id;
    private double balance;

    public BankAccount() {
        this.balance = 0;
        this.id = nextId;
        nextId++;
    }

    public int getId() {
        return id;
    }

    public static double getInterestRate() {
        return BankAccount.interestRate;
    }

    public static void setInterestRate(double interestRate) {
        BankAccount.interestRate = interestRate;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public double getInterest(int years) {
        return BankAccount.interestRate * years * this.balance;
    }
}
