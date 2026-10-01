class BankAccount {
    int balance = 1000;

    synchronized void withdraw(int amount) {

        if (balance >= amount) {
            System.out.println(Thread.currentThread().getName()
                    + " is withdrawing " + amount);

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            balance = balance - amount;

            System.out.println(Thread.currentThread().getName()
                    + " completed withdrawal. Balance: " + balance);
        } else {
            System.out.println(Thread.currentThread().getName()
                    + " - Insufficient balance");
        }
    }
}

class WithdrawThread extends Thread {
    BankAccount account;

    WithdrawThread(BankAccount account, String name) {
        super(name);
        this.account = account;
    }

    public void run() {
        account.withdraw(700);
    }
}

public class SynchronizationExample {
    public static void main(String[] args) {

        BankAccount account = new BankAccount();

        WithdrawThread t1 = new WithdrawThread(account, "Thread 1");
        WithdrawThread t2 = new WithdrawThread(account, "Thread 2");

        t1.start();
        t2.start();
    }
}