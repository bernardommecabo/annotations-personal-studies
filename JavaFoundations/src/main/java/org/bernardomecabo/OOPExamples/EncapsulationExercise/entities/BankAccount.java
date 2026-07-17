package org.bernardomecabo.OOPExamples.EncapsulationExercise.entities;

public class BankAccount {
    private int accountNumber;
    private String accountHolderName;
    private double balance;
    private boolean isAnyDeposit;

    public  BankAccount(int accountNumber, String accountHolderName, double deposit, boolean initialDeposit) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        if (initialDeposit) {
            this.balance = deposit;
        }
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public void withdraw(double amount) {
        this.balance -= amount;
    }

    @Override
    public String toString() {
        return "\nAccount Data: \n" +
                "Account: " + accountNumber +
                ", Holder: " + accountHolderName +
                ", Balance: $ " + balance;
    }
}
