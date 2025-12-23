package bankaccount;

public abstract class AbstractBankAccount implements BankAccount {
    /**
    *
    */
    private double balance;
    /**
    *
    */
    private boolean isFrozen;

    AbstractBankAccount() {
        balance = 0;
        isFrozen = false;
    }
    /**
     * @param amount
     */
    public void deposit(final double amount) {
        if (isFrozen) {
            System.out.println("Account is frozen. Cannot deposit.");
            return;
        }
        if (amount <= 0) {
            System.out.println("The deposit amount must be positive.");
            return;
        }

        balance += amount;
        System.out.println("Deposited: Php " + amount);
    }
    /**
     * @param amount
     */
    public void withdraw(final double amount) {
        if (isFrozen) {
            System.out.println("Account is frozen. Cannot withdraw.");
            return;
        }
        if (amount > balance) {
            System.out.println("Insufficient balance.");
            return;
        }
        if (amount < 0) {
            System.out.println("The withdrawn amount must be positive.");
            return;
        }

        balance -= amount;
        System.out.println("Withdrawn: Php " + amount + ".");
    }
    /**
     * @return balance
     */
    public double getBalance() {
        return balance;
    }
    /**
     * @return isFrozen
     */
    public boolean isFrozen() {
        return isFrozen;
    }
    /**
     *
     */
    void freezeAccount() {
        isFrozen = true;
        System.out.println("Account has been frozen.");
    }
    /**
     *
     */
    void unfreezeAccount() {
        isFrozen = false;
        System.out.println("Account has been unfrozen.");
    }
    /**
    *
    */
    void resetAccount() {
        balance = 0.0;
    }
}
