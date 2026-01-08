package bankaccount;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BankAccountManager {
    /**
    *
    */
    private Map<Integer, BankAccount> accounts;
    /**
    *
    */
    private int nextAccountId;

    BankAccountManager() {
        accounts = new HashMap<Integer, BankAccount>();
        nextAccountId = 1;
    }
    /**
    *@param account
    */
    void addAccount(final BankAccount account) {
        accounts.put(nextAccountId, account);
        System.out.println(nextAccountId + " : " + account.getBalance());
        nextAccountId++;
    }
    /**
    *@param accountId
    *@return account
    */
    BankAccount getAccount(final int accountId) throws NullPointerException {
        BankAccount acc = accounts.get(accountId);
        if (acc == null) {
            throw new NullPointerException("This account does not exist.");
        }
        return accounts.get(accountId);
    }
    /**
    *
    */
    void listAccounts() {
        accounts.forEach((key, value) -> {
            System.out.println(key + " : " + value.getBalance());
        });
    }
    /**
    * @param
    */
    List<Transaction> filterTransactionsAbove(double amount, List<Transaction> txList){
        return txList.stream()
                     .filter(tx -> tx.getAmount() >= amount)
                     .collect(Collectors.toList());
	}
	
	List<Transaction> sortTransactionsByAmount(List<Transaction> txList){
		return txList.stream()
				     .sorted(Comparator.comparing(Transaction::getAmount))
				     .collect(Collectors.toList());
	}
}
