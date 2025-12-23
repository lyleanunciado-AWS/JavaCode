package bankaccount;

public class SavingsAccount extends AbstractBankAccount {
    /**
    *
    */
    private String ownerName;

    SavingsAccount(final String newName) {
        this.ownerName = newName;
        System.out.println("Account Created: " + newName);
    }
    /**
    *
    * @return ownerName
    */
    String getOwnerName() {
        return ownerName;
    }
    /**
    * @param args
    *
    */
    public static void main(final String[] args) {
        String customer = "John";

        SavingsAccount savings = new SavingsAccount(customer);
        final int dep = 10000;
        final int wd = 100;
        final int wd2 = 5000;

        savings.deposit(dep);
        savings.withdraw(wd);

        savings.freezeAccount();

        savings.withdraw(wd2);

        savings.unfreezeAccount();

        savings.withdraw(wd2);

        System.out.println("Balance: " + savings.getBalance());
    }
}
