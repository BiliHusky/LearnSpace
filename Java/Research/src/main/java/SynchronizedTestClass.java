/**
 * Created by yjw on 18-6-6.
 */
public class SynchronizedTestClass {
    public static void main(String[] args) {
        Account account = new Account("husky", 10000.0f);
        AccountOperator accountOperator = new AccountOperator(account);

        final int THREAD_NUM = 5;
        Thread[] threads = new Thread[THREAD_NUM];
        for (int i=0; i<THREAD_NUM; i++) {
            threads[i] = new Thread(accountOperator, "Thread" + i);
            threads[i].start();
        }
    }
}

class Account{
    String name;
    float amount;

    public Account(String name, float amount) {
        this.name = name;
        this.amount = amount;
    }

    public void deposit(float amt) {
        amount += amt;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void withdraw(float amt) {
        amount -= amt;
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public float getBalance() {
        return amount;
    }
}

class AccountOperator implements Runnable {
    private Account account;

    public AccountOperator(Account account) {
        this.account = account;
    }

    public void run() {
        synchronized (account) {
            account.deposit(500);
            account.withdraw(500);
            System.out.println(Thread.currentThread().getName() + ":" + account.getBalance());
        }
    }
}
