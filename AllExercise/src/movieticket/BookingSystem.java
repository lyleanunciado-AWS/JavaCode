package movieticket;

public abstract class BookingSystem {
    /**
     *
     * @param showTime
     */
    public abstract void checkAvailability(String showTime);
    /**
     *
     * @param showTime
     * @param tickets
     */
    public abstract void bookTicket(String showTime, int tickets);
    /**
     *
     * @param showTime
     * @param tickets
     */
    public abstract void cancelReservation(String showTime, int tickets);
}
