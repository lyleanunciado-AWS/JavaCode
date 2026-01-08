package bankaccount;

public class Transaction {
    /**
    *
    */
    private String type;
    /**
    *
    */
    private double amount;
    /**
    * @param inputType
    * @param inputAmount
    */
    public Transaction(final String inputType, final double inputAmount) {
        type = inputType;
        amount = inputAmount;
    }
    /**
    *@return type
    */
    public String getType() {
        return type;
    }
    /**
    *@return amount
    */
    public double getAmount() {
        return amount;
    }
    /**
    *@return string
    */
    public String toString() {
        return type + " : " + amount;
    }
}
