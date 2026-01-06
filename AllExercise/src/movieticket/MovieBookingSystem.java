package movieticket;

import java.util.HashMap;
import java.util.Map;

public class MovieBookingSystem extends BookingSystem {
    /**
     * Hash map for time slot.
     */
    private static Map<String, Integer> slot = new HashMap<String, Integer>();

    /**
    * Default total room seats.
    */
    private static final int TOTALROOMSEATS = 30;
    static {
        slot.put("10:00 AM", TOTALROOMSEATS);
        slot.put("1:00 PM", TOTALROOMSEATS);
        slot.put("4:00 PM", TOTALROOMSEATS);
        slot.put("7:00 PM", TOTALROOMSEATS);
        slot.put("10:00 PM", TOTALROOMSEATS);
    }

    /**
    * @param args
    * Main function
    */
    public static void main(final String[] args) {
        MovieBookingSystem cinema = new MovieBookingSystem();

        System.out.println("TEST CASE 1 ==========================");
        final String showTime1 = "10:00 AM";
        final int tickets1 = 5;
        cinema.bookTicket(showTime1, tickets1);

        System.out.println("\n\nTEST CASE 2 ==========================");
        final String showTime2 = "10:00 AM";
        final int tickets2 = 100;
        cinema.bookTicket(showTime2, tickets2);

        System.out.println("\n\nTEST CASE 3 ==========================");
        final String showTime3 = "10:00 AM";
        final int tickets3 = 3;
        cinema.cancelReservation(showTime3, tickets3);

        System.out.println("\n\nTEST CASE 4 ==========================");
        final String showTime4 = "1:00 PM";
        final int tickets4 = 2;
        cinema.bookTicket(showTime4, tickets4);

        System.out.println("\n\nTEST CASE 5 ==========================");
        final String showTime5 = "1:00 PM";
        final int tickets5 = 5;
        cinema.cancelReservation(showTime5, tickets5);
    }

    /**
    * @param showTime
    * Prints amount of available seat if it exists.
    */
    public void checkAvailability(final String showTime) {
        if (slot.containsKey(showTime)) {
            System.out.print("Available seats for " + showTime + " : ");
            System.out.println(slot.get(showTime));
        } else {
            System.out.println("This showtime is not available");
        }
    }

    /**
    * @param showTime
    * @param tickets
    *
    *
    * Book tickets.
    */
    public void bookTicket(final String showTime, final int tickets) {
        if (slot.containsKey(showTime)) {
            if (tickets <= 0) {
                System.out.println("Must enter positive ticket value.");
            } else if (slot.get(showTime) < tickets) {
                System.out.println("Not enough tickets available "
                + "for this showtime.");
            } else {
                slot.replace(showTime, slot.get(showTime) - tickets);
                System.out.println(tickets
                + " tickets successfully booked for " + showTime);
            }
        } else {
            System.out.println("This timeslot is not available.");
        }
    }

    /**
    * @param showTime
    * @param tickets
    *
    * Cancel reservation.
    */
    public void cancelReservation(final String showTime, final int tickets) {
        if (slot.containsKey(showTime)) {
            int numberOfReservedSeats = TOTALROOMSEATS - slot.get(showTime);
            if (tickets <= 0) {
                System.out.println("Must enter positive ticket value.");
            } else if (numberOfReservedSeats < tickets) {
                System.out.println("Invalid operation "
                + "(Attempt to cancel more tickets than booked)");
            } else {
                slot.replace(showTime, slot.get(showTime) + tickets);
                System.out.println(tickets
                + " tickets successfully cancelled for " + showTime);
            }
        } else {
            System.out.println("This timeslot is not available.");
        }
    }

    /**
     * Returns every available seat for each time slot.
     */
    public void checkAllShowTime() {
        slot.forEach((key, value) -> {
            System.out.println(key + " : " + value + " available seats");
        });
    }

    /**
     * Reset all available seats for each time slot to default.
     */
    public void resetBookingSystem() {
        slot.replaceAll((key, value) -> TOTALROOMSEATS);
    }
}

