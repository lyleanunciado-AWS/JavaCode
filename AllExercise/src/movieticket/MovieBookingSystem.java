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

        final String showTimeA = "10:00 AM";
        final String showTimeB = "1:00 PM";
        final String showTimeC = "4:00 PM";

        final int ticketsA = 5;
        final int ticketsB = 100;
        final int ticketsC = 3;
        final int ticketsD = 2;
        final int ticketsE = -5;

        System.out.println("TEST CASE 1 ==========================");

        cinema.bookTicket(showTimeA, ticketsA); //10:00 AM : 5 tickets

        System.out.println("\n\nTEST CASE 2 ==========================");

        cinema.bookTicket(showTimeA, ticketsB); //10:00 AM : 100 tickets

        System.out.println("\n\nTEST CASE 3 ==========================");

        cinema.cancelReservation(showTimeA, ticketsC); //10:00 AM : 3 tickets

        System.out.println("\n\nTEST CASE 4 ==========================");

        cinema.bookTicket(showTimeB, ticketsD); //1:00 PM : 2 tickets

        System.out.println("\n\nTEST CASE 5 ==========================");

        cinema.cancelReservation(showTimeB, ticketsA); //1:00 PM : 5 tickets

        System.out.println("\n\nTEST CASE 6 ==========================");

        cinema.bookTicket(showTimeC, ticketsE); //4:00 PM : -5 tickets
        cinema.checkAllShowTime();
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
            if (slot.get(showTime) < tickets) {
                System.out.println("Not enough tickets available "
                + "for this showtime.");
            } else {
                slot.replace(showTime, slot.get(showTime) - tickets);
                if (tickets <= 0) {
                    slot.replace(showTime, slot.get(showTime) + tickets);
                    System.out.println("Must enter positive ticket value.");
                    return;
                }
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
            if (numberOfReservedSeats < tickets) {
                System.out.println("Invalid operation "
                + "(Attempt to cancel more tickets than booked)");
            } else {
                slot.replace(showTime, slot.get(showTime) + tickets);
                if (tickets <= 0) {
                    slot.replace(showTime, slot.get(showTime) + tickets);
                    System.out.println("Must enter positive ticket value.");
                    return;
                }
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
        slot.replaceAll((_, _) -> TOTALROOMSEATS);
    }
}
