package bankaccount;

public class SavingsAccount extends AbstractBankAccount {
    /**
    * Contains the name of the owner of the bank account.
    */
    private String ownerName;

    // Documentation missing for the constructor. -Ken
    // Documentation added. - Lyle
    /**
     * Constructs a new Savings Account and assigns owner name.
     * @param newName
     */
    SavingsAccount(final String newName) {
        this.ownerName = newName;
        System.out.println("Account Created: " + newName);
    }
    /**
    *
    * @return ownerName
    * Method to get owner name.
    */
    String getOwnerName() {
        return ownerName;
    }
}
