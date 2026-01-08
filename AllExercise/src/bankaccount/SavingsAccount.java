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
}
