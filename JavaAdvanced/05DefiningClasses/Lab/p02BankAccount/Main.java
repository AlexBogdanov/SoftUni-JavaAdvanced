package p02BankAccount;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        Map<Integer, BankAccount> bankAccounts = new HashMap<>();

        for (String command = scanner.nextLine(); !"End".equals(command); command = scanner.nextLine()) {
            String[] tokens = command.split("\\s+");

            switch (tokens[0]) {
                case "Create":
                    StringBuilder sbCreate = create(bankAccounts);
                    System.out.println(sbCreate);
                    break;
                case "Deposit":
                    StringBuilder sbDeposit = deposit(tokens[1], tokens[2], bankAccounts);
                    System.out.println(sbDeposit);
                    break;
                case "SetInterest":
                    setInterest(tokens[1]);
                    break;
                case "GetInterest":
                    StringBuilder sbGetInterest = getInterest(tokens[1], tokens[2], bankAccounts);
                    System.out.println(sbGetInterest);
                    break;
            }
        }

        scanner.close();

    }

    private static StringBuilder create(Map<Integer, BankAccount> bankAccounts) {
        BankAccount bankAccount = new BankAccount();
        int id = bankAccount.createAccount();
        bankAccounts.put(id, bankAccount);

        StringBuilder sb = new StringBuilder();
        sb.append("Account ID" + id + " created");
        return sb;
    }

    private static StringBuilder deposit(String idStr, String amountStr, Map<Integer, BankAccount> bankAccounts) {
        int id = Integer.parseInt(idStr);
        double amount = Double.parseDouble(amountStr);
        StringBuilder sb = new StringBuilder();

        if (bankAccounts.containsKey(id)) {
            BankAccount bankAccont = bankAccounts.get(id);
            bankAccont.deposit(amount);
            sb.append(String.format(
                "Deposited %.0f to ID%d", 
                amount, id));
        } else {
            sb.append("Account does not exist");
        }
        
        return sb;
    }

    private static void setInterest(String interestStr) {
        double interest = Double.parseDouble(interestStr);
        BankAccount.setInterestRate(interest);
    }

    private static StringBuilder getInterest(String idStr, String yearsStr, Map<Integer, BankAccount> bankAccounts) {
        int id = Integer.parseInt(idStr);
        int years = Integer.parseInt(yearsStr);
        StringBuilder sb = new StringBuilder();

        if (bankAccounts.containsKey(id)) {
            BankAccount bankAccount = bankAccounts.get(id);
            double interest = bankAccount.getInterest(years);
            sb.append(String.format("%.2f", interest));
        } else {
            sb.append("Account does not exist");
        }

        return sb;
    }

}
