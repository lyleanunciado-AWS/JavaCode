package bankaccount;

public interface BankAccount {
    /**
    *
    * @param amount
    */
    void deposit(double amount);
    /**
    *
    * @param amount
    */
    void withdraw(double amount);
    /**
    *
    * @return balance
    */
    double getBalance();
    /**
    *
    * @return status
    */
    boolean isFrozen();
}

