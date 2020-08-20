package com.company;

// RACING CONDITION

public class BankAccount {

    /**
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        Account myAccount = new Account(22222222);

        // Expected deposit: 50
        for (int i = 0; i < 10; i++) {
            Transaction t = new Transaction(myAccount,
                    Transaction.TransactionType.DEPOSIT, 5.00);
            t.start();
        }

        // Expected withdrawal: 10
        for (int i = 0; i < 10; i++) {
            Transaction t = new Transaction(myAccount,
                    Transaction.TransactionType.WITHDRAW, 1.00);
            t.start();

        }

        // Temporary sleep to ensure all threads are completed.
        Thread.sleep(1000);
        // Expected account balance is 200
        System.out.println("Final Account Balance: "
                + myAccount.getAccountBalance());

    }

}

class Transaction extends Thread {

    public static enum TransactionType {
        DEPOSIT(1), WITHDRAW(2);

        private int value;

        private TransactionType(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    };

    private TransactionType transactionType;
    private Account account;
    private double amount;

    /*
     * If transactionType == 1, deposit else if transactionType == 2 withdraw
     */
    public Transaction(Account account, TransactionType transactionType,
                       double amount) {
        this.transactionType = transactionType;
        this.account = account;
        this.amount = amount;
    }

    public void run() {
        switch (this.transactionType) {
            case DEPOSIT:
                deposit();
                printBalance();
                break;
            case WITHDRAW:
                withdraw();
                printBalance();
                break;
            default:
                System.out.println("NOT A VALID TRANSACTION");
        }
        ;
    }

    public void deposit() {
        this.account.deposit(this.amount);
    }

    public void withdraw() {
        this.account.withdraw(amount);
    }

    public void printBalance() {
        System.out.println(Thread.currentThread().getName() + " : TransactionType: " + this.transactionType + ", Amount: " + this.amount);
        System.out.println("Account Balance: " + this.account.getAccountBalance());
    }
}

class Account {
    private int accountNumber;
    private double accountBalance;

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public Account(int accountNumber) {
        this.accountNumber = accountNumber;
    }


    public boolean deposit(double amount) {
        if (amount < 0) {
            return false;
        } else {
            accountBalance = accountBalance + amount;
            return true;
        }
    }


    public boolean withdraw(double amount) {
        if (amount > accountBalance) {
            return false;
        } else {
            accountBalance = accountBalance - amount;
            return true;
        }
    }
}