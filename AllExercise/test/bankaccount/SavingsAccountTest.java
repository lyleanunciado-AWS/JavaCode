package bankaccount;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SavingsAccountTest {
	
	private static ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	
	static String custName = "John";
	static SavingsAccount savings;
	static BankAccountManager bam;
	@Test
	@BeforeEach
	void setupBeforeEach() {
		savings.resetAccount();
		savings.unfreezeAccount();
		outContent.reset();
        System.setOut(new PrintStream(outContent));
        savings.resetTransactionHistory();
	}
	
	@Test
	@BeforeAll
	static void testSavingsAccount_CreateInstanceOfSavingsAccount_DisplayOwnerName() {
		savings = new SavingsAccount(custName);
		assertEquals(custName,savings.getOwnerName());
		bam = new BankAccountManager();
		bam.addAccount(savings);
	}
	
	@Test
	void testDeposit_DepositWithValidAmount1000_MustReturn1000() {
		int num = 1000;
		try {
			savings.deposit(num);
		}catch(Exception ex) {}
		
		String output = outContent.toString().trim();
		assertEquals("Deposited: Php " + (double) num + ".", output );
		assertEquals(savings.getBalance(), num);
	}
	
	@Test
	void testDeposit_DepositWithZeroOrNegative_MustDisplayErrorBalanceMustbe0() {
		int num = 0;
		String err = "";
		try {
			savings.deposit(num);
		}catch(Exception ex) {
			err = ex.getMessage();
		}
		

		assertEquals("Input Amount must be positive.", err);
		assertEquals(savings.getBalance(),num);
		
		num = -500;
		
		try {
			savings.deposit(num);
		}catch(Exception ex) {
			err = ex.getMessage();
		}
		

		assertEquals("Input Amount must be positive.", err);
		assertEquals(0, savings.getBalance());
	}

	
	@Test
	void testWithdraw_Withdraw500WithSufficientFunds1000_MustReturn500() {
		int deposit = 1000;
		int withdraw = 500;
		

		try {
			savings.deposit(deposit);
		}catch(Exception ex) {}
		outContent.reset();
		try {
			savings.withdraw(withdraw);
		}catch(Exception ex) {}

		
		String output2 = outContent.toString().trim();
		assertEquals("Withdrawn: Php "+ (double) withdraw+".", output2 );
		assertEquals(savings.getBalance(), 500);
	}
	
	@Test
	void testWithdraw_Withdraw1500withInsufficientFunds1000_MustReturn1000() {
		int deposit = 1000;
		int withdraw = 1500;
		String err = "";
//		
		try {
			savings.deposit(deposit);
			savings.withdraw(withdraw);
		}catch(Exception ex) {
			err = ex.getMessage();
		}
		
		assertEquals("Insufficient funds.",err);
		assertEquals(savings.getBalance(), deposit);
	}
	
	@Test
	void testWithdraw_WithdrawNeg100WithFunds1000_MustReturnError() {
		int deposit = 1000;
		int withdraw = -100;
		String err = "";
	
		try {
			savings.deposit(deposit);
			savings.withdraw(withdraw);
		}catch(Exception ex) {
			err = ex.getMessage();
		}
		
		assertEquals("Input Amount must be positive.",err);
		assertEquals(savings.getBalance(), deposit);      
	}
	
	@Test
	void testDeposit_DepositWithFrozenAccount_MustReturnMessage() {
		savings.freezeAccount();
		outContent.reset();
		String err = "";
		int deposit = 1000;
		try {
			savings.deposit(deposit);
		}catch(Exception ex) {
			err = ex.getMessage();
		}
		assertEquals("Account is Frozen, Cannot Deposit.",err);
		assertEquals(savings.getBalance(),0);

	}
	
	@Test
	void testWithdraw_WithdrawWithFrozenAccount_MustReturnMessage() {
		int deposit = 1000;
		int withdraw = 500;
		String err = "";
		try {
			savings.deposit(deposit);
		}catch(Exception ex) {}
		
		outContent.reset();
		savings.freezeAccount();
		assertEquals("Account has been frozen.",outContent.toString().trim());
		outContent.reset();
		
		try {
			savings.withdraw(withdraw);
		}catch(Exception ex) {
			err = ex.getMessage();
		}
		
		assertEquals("Account is Frozen, Cannot Withdraw.",err);
		assertEquals(savings.getBalance(), deposit);
	}
	
	@Test
	void testWithdraw_UnfreezeAccountAndWithdraw_ActualAndExpectedMustBeEqual() {
		int deposit = 1000;
		int withdraw = 500;
		try {
			savings.deposit(deposit);
		}catch(Exception ex) {}
		
		savings.freezeAccount();
		outContent.reset();
		savings.unfreezeAccount();
		assertEquals("Account has been unfrozen.",outContent.toString().trim());
		outContent.reset();
		try {
			savings.withdraw(withdraw);
		}catch(Exception ex) {}
		assertEquals("Withdrawn: Php "+(double)500 +".",outContent.toString().trim());
		assertEquals(savings.getBalance(),500);
	}

	@Test
	void testIsFrozen_CallIsFrozen_MustBeFalse() {
		assertEquals(false, savings.isFrozen());
	}
	
	@Test
	void testGetBalance_CallGetBalanceAfterMultipleTransactions_ActualAndExpectedMustBeEqual() {
		int dep1 = 100;
		int dep2 = 200;
		int dep3 = 300;
		int sum = dep1+dep2+dep3;
		
		try {
			savings.deposit(dep1);
			savings.deposit(dep2);
			savings.deposit(dep3);
		}catch(Exception ex) {}
		

		assertEquals(sum, savings.getBalance());
	}
	
	
	@Test
	void testResetAccount_AddMultipleDepositThenResetAccount_MustBeZero() {
		int dep1 = 100;
		int dep2 = 200;
		int dep3 = 300;
		
		try {
			savings.deposit(dep1);
			savings.deposit(dep2);
			savings.deposit(dep3);
		}catch (Exception ex) {
			
		}
		savings.resetAccount();
		assertEquals(0, savings.getBalance());
	}
	
	@Test
	void testMain_RunMain_MustNotReturnError(){
		Main.main(null);
	}
	
	@Test
	void testListAccounts_GetAllAccountsAdded_ListMustReturnEqualToExpected() {
		bam.listAccounts();
		
		assertTrue( outContent.toString().trim().contains("1 : 0.0"));
	}
	
	@Test
	void testSortTransactionsByAmount_AddMultipleTransactions_ListMustBeEqualToExpected() {
		
		try {
			savings.deposit(1000);
			savings.deposit(50);
			savings.deposit(4000);
		} catch (Exception ex) {
			
		}
		outContent.reset();
		bam.sortTransactionsByAmount(savings.getTransactionHistory())
        .forEach(tsx -> System.out.println(tsx));
 
		assertEquals("Deposit : 50.0\r\nDeposit : 1000.0\r\nDeposit : 4000.0", outContent.toString().trim());
	}
	
	@Test
	void testFilterTransactionsAbove_AddMultipleTransactions_ListMustBeEqualToExpected() {
		
		try {
			savings.deposit(1000);
			savings.deposit(50);
			savings.deposit(4000);
		} catch (Exception ex) {}
		outContent.reset();
		try {
			bam.filterTransactionsAbove(100, savings.getTransactionHistory())
			.forEach(tsx -> System.out.println(tsx));
		} catch (Exception ex) {
			
		}
		assertEquals("Deposit : 1000.0\r\nDeposit : 4000.0", outContent.toString().trim());
	}
	
	@Test
	void testGetAccount_GetAValidAccount_MustReturnExpected() {
		
		assertEquals(savings,bam.getAccount(1));
	}
	
	@Test
	void testGetAccount_GetAnInvalidAccount_MustDisplayErrorMessage() {
		try {
			bam.getAccount(30);
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		assertEquals("This account does not exist.",outContent.toString().trim());
	}
	
}
