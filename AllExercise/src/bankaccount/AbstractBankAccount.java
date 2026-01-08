package bankaccount;

import java.util.ArrayList;
import java.util.List;

import bankaccount.CustomException.AccountFrozenException;
import bankaccount.CustomException.InsufficientFundsException;
import bankaccount.CustomException.InvalidAmountException;

public abstract class AbstractBankAccount implements BankAccount {
    /**
    *
    */
    private double balance;
    /**
    *
    */
    private boolean isFrozen;
    /**
    *
    */
    private List<Transaction> transactionHistory;

    AbstractBankAccount() {
        balance = 0;
        isFrozen = false;
        transactionHistory = new ArrayList<Transaction>();
    }
    /**
     * @param amount
     */
    public void deposit(final double amount) throws AccountFrozenException,
    InvalidAmountException {
        if (isFrozen) {
            throw new AccountFrozenException("Account is Frozen,"
                + " Cannot Deposit.");
        }
        if (amount <= 0) {
            throw new InvalidAmountException("Invalid Amount.");
        }

        balance += amount;
        transactionHistory.add(new Transaction("Deposit", amount));
        System.out.println("Deposited: Php " + amount + ".");
    }
    /**
     * @param amount
     *
     */
    public void depositToAccount(final double amount) {
        try {
            deposit(amount);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    /**
     * @param amount
     * @throws AccountFrozenException
     */
    public void withdraw(final double amount) throws AccountFrozenException,
        InvalidAmountException, InsufficientFundsException {
        if (isFrozen) {
            throw new AccountFrozenException("Account is Frozen,"
                    + " Cannot Withdraw.");
        }
        if (amount > balance) {
            throw new InsufficientFundsException("Insufficient funds.");
        }
        if (amount < 0) {
            throw new InvalidAmountException("Invalid Amount.");
        }

        balance -= amount;
        transactionHistory.add(new Transaction("Withdrawal", amount));
        System.out.println("Withdrawn: Php " + amount + ".");
    }
    /**
     * @param amount
     *
     */
    public void withdrawToAccount(final double amount) {
        try {
            withdraw(amount);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    /**
     * @return balance
     */
    public double getBalance() {
        System.out.println("Balance: " + balance);
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
    public void freezeAccount() {
        isFrozen = true;
        System.out.println("Account has been frozen.");
    }
    /**
     *
     */
    public void unfreezeAccount() {
        isFrozen = false;
        System.out.println("Account has been unfrozen.");
    }
    /**
    * @return transactionHistory
    */
    public List<Transaction> getTransactionHistory() {
        return transactionHistory;
    }
}
