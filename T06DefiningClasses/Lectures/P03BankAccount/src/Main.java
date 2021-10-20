import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<BankAccount> bankAccounts = new ArrayList<>();

        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String[] commandParameters = input.split("\\s+");
            String command = commandParameters[0];
            switch (command) {
                case "Create":
                    BankAccount newBankAccount = new BankAccount();
                    bankAccounts.add(newBankAccount);
                    System.out.printf("Account ID%d created%n", newBankAccount.getId());
                    break;
                case "Deposit":
                    int id = Integer.parseInt(commandParameters[1]);
                    double amount = Double.parseDouble(commandParameters[2]);

                    BankAccount bankAccount = findBankAccount( bankAccounts, id);
                    if (bankAccount == null) {
                        System.out.println("Account does not exist");
                    } else {
                        bankAccount.deposit(amount);
                        System.out.printf("Deposited %.0f to ID%d%n", amount, bankAccount.getId());
                    }
                    break;
                case "SetInterest":
                    double interestRate = Double.parseDouble(commandParameters[1]);
                    BankAccount.setInterestRate(interestRate);
                    break;
                case "GetInterest":
                    int idToSearch = Integer.parseInt(commandParameters[1]);
                    int years = Integer.parseInt(commandParameters[2]);
                    BankAccount foundBankAccount = findBankAccount( bankAccounts, idToSearch);
                    if (foundBankAccount == null) {
                        System.out.println("Account does not exist");
                    } else {
                        System.out.printf("%.2f%n", foundBankAccount.getInterest(years));
                    }
                    break;
            }
            input = scanner.nextLine();
        }
    }

    public static BankAccount findBankAccount(List<BankAccount> bankAccounts, int idToSearch) {
        for (BankAccount bankAccount : bankAccounts) {
            if (bankAccount.getId() == idToSearch) {
                return bankAccount;
            }
        }
        return null;
    }
}
