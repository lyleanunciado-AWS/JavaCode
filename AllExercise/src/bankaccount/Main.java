package bankaccount;

import java.util.List;

public final class Main {
    private Main() {
        super();
    }
    /**
     *
     * @param args
     */
    public static void main(final String[] args) {

        System.out.println("\nTest Case 1 ------------------------");

        BankAccountManager bam = new BankAccountManager();
        SavingsAccount luke = new SavingsAccount("Luke");
        bam.addAccount(luke);

        System.out.println("\nTest Case 2 ------------------------");
        final int t2 = 1000;

        try {
            luke.deposit(t2);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        System.out.println("\nTest Case 3 ------------------------");

        try {
            luke.deposit(0);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        System.out.println("\nTest Case 4 ------------------------");
        final int t4 = -500;
        try {
            luke.deposit(t4);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        System.out.println("\nTest Case 5 ------------------------");
        final int t5 = 500;
        try {
           luke.withdraw(t5);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        System.out.println("\nTest Case 6 ------------------------");
        final int t6 = 1500;
        try {
            luke.withdraw(t6);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        System.out.println("\nTest Case 7 ------------------------");
        final int t7 = -100;
        try {
            luke.withdraw(t7);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        System.out.println("\nTest Case 8 ------------------------");

        try {
            luke.freezeAccount();
            luke.deposit(t5);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        /* Try recycling your variables especially since t8 and
         * t9 have the same value. Do the same for other variables. - Ken
         * Duplicate values, now reused. -Lyle
         */
        System.out.println("\nTest Case 9 ------------------------");

        try {
            luke.withdraw(t5);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        System.out.println("\nTest Case 10 ------------------------");
        final int t10 = 100;
        try {
            luke.unfreezeAccount();
            luke.withdraw(t10);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        System.out.println("\nTest Case 11 ------------------------");

        luke.getBalance();

        System.out.println("\nTest Case 12 ------------------------");

        List<Transaction> history = luke.getTransactionHistory();

        try {
            bam.filterTransactionsAbove(t5, history)
            .forEach(tsx -> System.out.println(tsx));
        } catch (Exception ex) { }


        System.out.println("\nTest Case 12 Additional ------------");

        try {
            bam.filterTransactionsAbove(t7, history)
            .forEach(tsx -> System.out.println(tsx));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        System.out.println("\nTest Case 13 ------------------------");

        bam.sortTransactionsByAmount(history)
        .forEach(tsx -> System.out.println(tsx));

        System.out.println("\nTest Case 14 ------------------------");
        final int t14 = 5;
        try {
            bam.getAccount(t14);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
