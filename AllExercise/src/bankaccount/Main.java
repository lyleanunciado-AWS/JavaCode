package bankaccount;

import java.util.List;

public class Main {
	public static void main (String[] args) {

		System.out.println("\nTest Case 1 -------------------------------------");

		BankAccountManager bam = new BankAccountManager();
		SavingsAccount luke = new SavingsAccount("Luke");
		bam.addAccount(luke);
	
		System.out.println("\nTest Case 2 -------------------------------------");
		
		try {
			luke.deposit(1000);	
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		
		System.out.println("\nTest Case 3 -------------------------------------");
		
		try {
			luke.deposit(0);	
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		
		System.out.println("\nTest Case 4 -------------------------------------");
		
		try {
			luke.deposit(-500);	
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		
		System.out.println("\nTest Case 5 -------------------------------------");
		
		try {
			luke.withdraw(500);	
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		
		System.out.println("\nTest Case 6 -------------------------------------");
		
		try {
			luke.withdraw(1500);	
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		
		System.out.println("\nTest Case 7 -------------------------------------");
		
		try {
			luke.withdraw(-100);	
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		
		System.out.println("\nTest Case 8 -------------------------------------");
		
		try {
			luke.freezeAccount();
			luke.deposit(500);
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		
		System.out.println("\nTest Case 9 -------------------------------------");
		
		try {
			luke.withdraw(500);
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		
		System.out.println("\nTest Case 10 -------------------------------------");
		
		try {
			luke.unfreezeAccount();
			luke.withdraw(100);
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		
		System.out.println("\nTest Case 11 -------------------------------------");
				
		luke.getBalance();
		
		System.out.println("\nTest Case 12 -------------------------------------");
		
		List<Transaction> history = luke.getTransactionHistory();
		bam.filterTransactionsAbove(500, history)
		.forEach(tsx -> System.out.println(tsx));
		
		System.out.println("\nTest Case 13 -------------------------------------");
		
		bam.sortTransactionsByAmount(history)
		.forEach(tsx -> System.out.println(tsx));
		
		System.out.println("\nTest Case 14 -------------------------------------");
		
		try {
			bam.getAccount(5);
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
}
