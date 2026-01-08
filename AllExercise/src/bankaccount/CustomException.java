package bankaccount;

public class CustomException {
	public static class InsufficientFundsException extends Exception {
		public InsufficientFundsException(String message) {
			super(message);
		}
	}
	public static class InvalidAmountException extends Exception {
		public InvalidAmountException(String message) {
			super(message);
		}
	}
	public static class AccountFrozenException extends Exception {
		public AccountFrozenException(String message) {
			super(message);
		}
	}
	
}
