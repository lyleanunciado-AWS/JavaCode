package leap;

public final class LeapYear {
/**
 *
 */
    private LeapYear() {
        super();
    }
/**
 * @param args
 */
public static void main(final String[] args) {
    final int year = 2017;
    LeapYearChecker year1 = new LeapYearChecker(year);
    year1.isLeapYear();
}
}
