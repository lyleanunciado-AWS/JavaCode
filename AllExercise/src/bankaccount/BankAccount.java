package bankaccount;

import java.util.List;

import bankaccount.CustomException.AccountFrozenException;
import bankaccount.CustomException.InsufficientFundsException;
import bankaccount.CustomException.InvalidAmountException;

public interface BankAccount {
    /**
    *
    * @param amount
    */
    void deposit(double amount) throws AccountFrozenException,
        InvalidAmountException;
    /**
    *
    * @param amount
    */
    void withdraw(double amount) throws AccountFrozenException,
        InvalidAmountException, InsufficientFundsException;
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
    /**
     *
     */
    void freezeAccount();
    /**
    *
    */
    void unfreezeAccount();
    /**
    * @return List of Transaction
    */
    List<Transaction> getTransactionHistory();
}

