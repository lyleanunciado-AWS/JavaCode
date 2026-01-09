package bankaccount;

public class CustomException {
    // Add suppress warnings
    public static class InsufficientFundsException extends Exception {
        /**
         *
         * @param message
         */
        public InsufficientFundsException(final String message) {
            super(message);
        }
    }
    public static class InvalidAmountException extends Exception {
        /**
        *
        * @param message
        */
        public InvalidAmountException(final String message) {
            super(message);
        }
    }
    public static class AccountFrozenException extends Exception {
        /**
        *
        * @param message
        */
        public AccountFrozenException(final String message) {
            super(message);
        }
    }

}
