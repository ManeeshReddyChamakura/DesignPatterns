package com.structuralpatterns.bridge;

public class Example {
    public static void main(String[] args) {
        SimpleAccount account = new SimpleAccount(100);
        account.withdraw(75);

        if (account.isBalanceLow()) {
            // you can also change the Logger implementation at runtime
            account.setLogger(Logger.warning());
        }

        account.withdraw(10);
        account.withdraw(100);
    }
}


/**
 * implementor interface
 */
interface Logger {
    public void log(String message);
    static Logger info() {
        return message -> System.out.println("Info:"+message);
    }
    static Logger warning() {
        return message -> System.out.println("Warning:"+ message);
    }
}

/**
 * we can have concrete implementations of the above interface
 */

abstract class AbstractAccount {
    private Logger logger = Logger.info();

    public void setLogger(Logger logger) {
        this.logger = logger;
    }

    // the logging part is delegated to the Logger implementation
    protected void operate(String message, boolean result) {
        logger.log(message + " result " + result);
    }
}

class SimpleAccount extends AbstractAccount {
    private int balance;

    public SimpleAccount(int balance) {
        this.balance = balance;
    }

    public boolean isBalanceLow() {
        return balance < 50;
    }

    public void withdraw(int amount) {
        boolean shouldPerform = balance >= amount;
        if (shouldPerform) {
            balance -= amount;
        }
        operate("withdraw " + amount, shouldPerform);
    }
}


