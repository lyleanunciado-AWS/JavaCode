package bankaccount;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SavingsAccountTest {
	
	private static ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	
	static String custName = "John";
	static SavingsAccount savings;
	
	@Test
	@BeforeEach
	void setupBeforeEach() {
		savings.resetAccount();
		savings.unfreezeAccount();
		outContent.reset();
        System.setOut(new PrintStream(outContent));
	}
	
	@Test
	@BeforeAll
	static void testSavingsAccount_CreateInstanceOfSavingsAccount_DisplayOwnerName() {
		savings = new SavingsAccount(custName);
		assertEquals(custName,savings.getOwnerName());
	}
	
	@Test
	void testDeposit_DepositWithValidAmount1000_MustReturn1000() {
		int num = 1000;
		savings.deposit(num);
		assertEquals(savings.getBalance(), num);
		String output = outContent.toString().trim();
		assertEquals("Deposited: Php " + (double) num + ".", output );
	}
	
	@Test
	void testDeposit_DepositWithZeroAmount_MustReturn0() {
		int num = 0;
		savings.deposit(num);
		assertEquals(savings.getBalance(),num);
		String output = outContent.toString().trim();
		assertEquals("The deposit amount must be positive.", output );
	}
	
	@Test
	void testDeposit_DepositWithNegativeAmountNeg500_MustReturnErrorMessage() {
		int num = -500;
		savings.deposit(num);
		assertNotEquals(-500, savings.getBalance());
		String output = outContent.toString().trim();
		assertEquals("The deposit amount must be positive.", output );
	}
	
	@Test
	void testWithdraw_Withdraw500WithSufficientFunds1000_MustReturn500() {
		int deposit = 1000;
		int withdraw = 500;
		
		savings.deposit(deposit);
		outContent.reset();
		savings.withdraw(withdraw);
		assertEquals(savings.getBalance(), 500);
		
		String output2 = outContent.toString().trim();
		assertEquals("Withdrawn: Php "+ (double) withdraw+".", output2 );
	}
	
	@Test
	void testWithdraw_Withdraw1500withInsufficientFunds1000_MustReturn1000() {
		int deposit = 1000;
		int withdraw = 1500;
		
		savings.deposit(deposit);
		outContent.reset();
		savings.withdraw(withdraw);
		
		assertEquals(savings.getBalance(), deposit);
		assertEquals("Insufficient balance.",outContent.toString().trim());
	}
	
	@Test
	void testWithdraw_WithdrawNeg100WithFunds1000_MustReturnError() {
		int deposit = 1000;
		int withdraw = -100;
		
		savings.deposit(deposit);
		outContent.reset();
		savings.withdraw(withdraw);
		
		assertEquals(savings.getBalance(), deposit);
		assertEquals("The withdrawn amount must be positive.",outContent.toString().trim());
	}
	
	@Test
	void testDeposit_DepositWithFrozenAccount_MustReturnMessage() {
		savings.freezeAccount();
		outContent.reset();
		int deposit = 1000;
		savings.deposit(deposit);
		assertEquals(savings.getBalance(),0);
		assertEquals("Account is frozen. Cannot deposit.",outContent.toString().trim());
		
	}
	
	@Test
	void testWithdraw_WithdrawWithFrozenAccount_MustReturnMessage() {
		int deposit = 1000;
		int withdraw = 500;
		savings.deposit(deposit);
		outContent.reset();
		savings.freezeAccount();
		assertEquals("Account has been frozen.",outContent.toString().trim());
		outContent.reset();
		savings.withdraw(withdraw);
		
		assertEquals(savings.getBalance(), deposit);
		assertEquals("Account is frozen. Cannot withdraw.",outContent.toString().trim());
	}
	
	@Test
	void testWithdraw_UnfreezeAccountAndWithdraw_ActualAndExpectedMustBeEqual() {
		int deposit = 1000;
		int withdraw = 500;
		savings.deposit(deposit);
		savings.freezeAccount();
		outContent.reset();
		savings.unfreezeAccount();
		assertEquals("Account has been unfrozen.",outContent.toString().trim());
		outContent.reset();
		savings.withdraw(withdraw);
		assertEquals(savings.getBalance(),500);
		assertEquals("Withdrawn: Php "+(double)500 +".",outContent.toString().trim());
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
		
		savings.deposit(dep1);
		savings.deposit(dep2);
		savings.deposit(dep3);
		assertEquals(sum, savings.getBalance());
	}
	
	@Test
	void testMain_DummyTest_MustReturnVoid() {
		savings.main(null);
	}
	
	@Test
	void testResetAccount_AddMultipleDepositThenResetAccount_MustBeZero() {
		int dep1 = 100;
		int dep2 = 200;
		int dep3 = 300;
		
		savings.deposit(dep1);
		savings.deposit(dep2);
		savings.deposit(dep3);
		savings.resetAccount();
		assertEquals(0, savings.getBalance());
	}
}
