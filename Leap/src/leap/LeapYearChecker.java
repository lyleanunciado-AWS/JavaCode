package leap;

public class LeapYearChecker {
    /**
    *
    */
    private int year;
    /**
    *    @param yearInput
    */
    public LeapYearChecker(final int yearInput) {
        year = yearInput;
    }
    /**
     *
     */
    public boolean isLeapYear() {
        final int first = 400;
        final int second = 100;
        final int third = 4;
        if (year % first == 0) {
//            System.out.println("true");
            return true;
        } else if (year % second == 0) {
//            System.out.println("false");
            return false;
        } else if (year % third == 0) {
//            System.out.println("true");
            return true;
        } 
        return false;
    }
}
