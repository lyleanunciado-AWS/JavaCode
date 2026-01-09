package bankaccount;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import bankaccount.CustomException.InvalidAmountException;

public class BankAccountManager {
    /**
    * Mapper for all accounts managed by the Manager.
    */
    private Map<Integer, BankAccount> accounts;
    /**
    * The Counter for ID.
    */
    private int nextAccountId;

    // Documentation missing for the constructor.
    /**
     * Constructor for creating new bank account manager.
     * Assigns a new Hashmap to variable accounts, and set the counter to 1.
     */
    BankAccountManager() {
        accounts = new HashMap<Integer, BankAccount>();
        nextAccountId = 1;
    }
    /**
    *@param account
    * Method to add account.
    */
    void addAccount(final BankAccount account) {
        accounts.put(nextAccountId, account);
        System.out.println(nextAccountId + " : " + account.getBalance());
        nextAccountId++;
    }
    /**
    *@param accountId
    *@return account
    * Method to get Account using index.
    */
    BankAccount getAccount(final int accountId) throws NullPointerException {
        BankAccount acc = accounts.get(accountId);
        if (acc == null) {
            throw new NullPointerException("This account does not exist.");
        }
        return accounts.get(accountId);
    }
    /**
    * Prints the list of accounts handled by the Manager.
    */
    void listAccounts() {
        accounts.forEach((key, value) -> {
            System.out.println(key + " : " + value.getBalance());
        });
    }
    /**
    * @param amount
    * @param txList
    * @return List
    *
    * Method to filter transactions above a certain amount.
    */
    List<Transaction> filterTransactionsAbove(final double amount,
        final List<Transaction> txList) throws InvalidAmountException {
        if (amount < 0) {
            throw new InvalidAmountException("Invalid Amount.");
        }

        return txList.stream()
                     .filter(tx -> tx.getAmount() >= amount)
                     .collect(Collectors.toList());
    }
    /**
    * @param txList
    * @return List
    *
    * Method to return a list of transactions sorted in ascending order.
    */
    List<Transaction> sortTransactionsByAmount(final List<Transaction> txList) {
        return txList.stream()
                     .sorted(Comparator.comparing(Transaction::getAmount))
                     .collect(Collectors.toList());
    }
}
