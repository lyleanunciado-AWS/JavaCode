package bankaccount;

import java.util.ArrayList;
import java.util.List;

import bankaccount.CustomException.AccountFrozenException;
import bankaccount.CustomException.InsufficientFundsException;
import bankaccount.CustomException.InvalidAmountException;

public abstract class AbstractBankAccount implements BankAccount {
    /**
    * Contains the current balance of the user.
    */
    private double balance;
    /**
    * Contains the state of the account.
    */
    private boolean isFrozen;
    /**
    * Transaction History of the user.
    */
    private List<Transaction> transactionHistory;

    // Documentation missing for the constructor. - ken
    // Documentation added - Lyle

    /**
     * Constructs a new bank account, balance is initialized to 0,
     *  and state of the account to UnFrozen.
     */
    AbstractBankAccount() {
        balance = 0;
        isFrozen = false;
        transactionHistory = new ArrayList<Transaction>();
    }
    /**
     * @param amount
     * Deposit money from the account.
     */
    public void deposit(final double amount) throws AccountFrozenException,
    InvalidAmountException {
        if (isFrozen) {
            throw new AccountFrozenException("Account is Frozen,"
                + " Cannot Deposit.");
        }
        if (amount <= 0) {
            throw new InvalidAmountException("Input Amount must be positive.");
        }

        balance += amount;
        transactionHistory.add(new Transaction("Deposit", amount));
        System.out.println("Deposited: Php " + amount + ".");
    }

    /**
     * @param amount
     * @throws AccountFrozenException
     * Withdraw money from the account.
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
            throw new InvalidAmountException("Input Amount must be positive.");
        }

        balance -= amount;
        transactionHistory.add(new Transaction("Withdrawal", amount));
        System.out.println("Withdrawn: Php " + amount + ".");
    }

    /**
     * @return balance
     * Get the Current Balance of the Account.
     */
    public double getBalance() {
        System.out.println("Balance: " + balance);
        return balance;
    }
    /**
     * @return isFrozen
     * Method to get the Bank's state.
     */
    public boolean isFrozen() {
        return isFrozen;
    }
    /**
     * Method to freeze Account.
     */
    public void freezeAccount() {
        isFrozen = true;
        System.out.println("Account has been frozen.");
    }
    /**
     * Method to unfreeze Account.
     */
    public void unfreezeAccount() {
        isFrozen = false;
        System.out.println("Account has been unfrozen.");
    }
    /**
    * @return transactionHistory
    * Get the transaction history of the bank account.
    */
    public List<Transaction> getTransactionHistory() {
        return transactionHistory;
    }
    /**
    * Reset balance to Zero.
    */
    void resetAccount() {
        balance = 0.0;
    }
    /**
    * Reset Transaction History to empty.
    */
    void resetTransactionHistory() {
        transactionHistory = new ArrayList<Transaction>();
    }
}
