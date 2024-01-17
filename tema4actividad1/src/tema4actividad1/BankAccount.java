package tema4actividad1;

public class BankAccount {
    private int balance = 100;

    public synchronized void deposit(int amount) {
        balance += amount;
        System.out.println("Depositado: " + amount + ", Saldo actual: " + balance);
    }

    public synchronized void withdraw(int amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Retirado: " + amount + ", Saldo actual: " + balance);
        } else {
            System.out.println("Fondos insuficientes. Saldo actual: " + balance);
        }
    }

    // Hilo para depositar
    static class DepositThread extends Thread {
        BankAccount account;

        DepositThread(BankAccount account) {
            this.account = account;
        }

        public void run() {
            account.deposit(50);
        }
    }

    // Hilo para retirar
    static class WithdrawThread extends Thread {
        BankAccount account;

        WithdrawThread(BankAccount account) {
            this.account = account;
        }

        public void run() {
            account.withdraw(30);
        }
    }

    public static void main(String[] args) {
        BankAccount account = new BankAccount();
        DepositThread t1 = new DepositThread(account);
        WithdrawThread t2 = new WithdrawThread(account);

        t1.start();
        t2.start();
    }
}