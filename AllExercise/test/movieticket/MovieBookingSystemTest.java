package movieticket;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MovieBookingSystemTest {
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	MovieBookingSystem MBS = new MovieBookingSystem();
	
	@BeforeEach
	void setupBeforeEach() {
		MBS.resetBookingSystem();
		outContent.reset();
        System.setOut(new PrintStream(outContent));
	}
	
	@Test
	void testCheckAvailability_ValidShowTime_MustReturn30SeatsAvailable() {
		String time = "10:00 AM";
		MBS.checkAvailability(time);
		assertEquals("Available seats for " + time + " : 30", outContent.toString().trim());
	}
	
	@Test
	void testCheckAvailability_InvalidShowTime_MustReturnInvalidMessage() {
		String time = "11:00 AM";
		MBS.checkAvailability(time);
		assertEquals("This showtime is not available", outContent.toString().trim());
	}
	
	@Test
	void testBookTicket_ZeroAndNegativeTicketValue_MustReturnInvalidMessage() {
		String time = "10:00 AM";
		MBS.bookTicket(time, 0);
		assertEquals("Must enter positive ticket value.", outContent.toString().trim());
		outContent.reset();
		MBS.bookTicket(time, -2);
		assertEquals("Must enter positive ticket value.", outContent.toString().trim());
	}
	
	@Test
	void testBookTicket_PositiveTicketValueAndValidTimeSlot_MustEqualExpected() {
		String time = "10:00 AM";
		int tickets = 3;
		int freeSeats = 30 - 3;
		MBS.bookTicket(time, tickets);
		assertEquals(tickets + " tickets successfully booked for " + time, outContent.toString().trim());
		outContent.reset();
		MBS.checkAvailability(time);
		assertEquals("Available seats for " + time + " : " + freeSeats, outContent.toString().trim());
	}
	
	@Test 
	void testBookTicket_InvalidTimeSlot_MustDisplayErrorMessage() {
		String time = "11:00 AM";
		int tickets = 3;
		MBS.bookTicket(time, tickets);
		assertEquals("This timeslot is not available.", outContent.toString().trim());
	}
	
	@Test
	void testBookTicket_CorrectTimeSlotButNotEnoughAvailable_MustDisplayErrorMessage() {
		String time = "10:00 AM";
		int tickets = 31;
		MBS.bookTicket(time, tickets);
		assertEquals("Not enough tickets available for this showtime.", outContent.toString().trim());
	}
	
	@Test
	void testCancelReservation_InvalidTimeSlot_MustDisplayErrorMessage() {
		String time = "11:00 AM";
		int tickets = 3;
		MBS.cancelReservation(time, tickets);
		assertEquals("This timeslot is not available.", outContent.toString().trim());
	}
	
	@Test
	void testCancelReservation_ValidTimeSlotButNegativeORZeroTicketValue_MustDisplayErrorMessage() {
		String time = "10:00 AM";
		int tickets = -5;
		MBS.cancelReservation(time,tickets);
		assertEquals("Must enter positive ticket value.", outContent.toString().trim());
		outContent.reset();
		MBS.cancelReservation(time, 0);
		assertEquals("Must enter positive ticket value.", outContent.toString().trim());
	}
	
	@Test
	void testCancelReservation_ValidTimeSlotAndValidTicketValueandValidBookingsAmount_ValueMustReturnToOriginal() {
		String time = "10:00 AM";
		int tickets = 10;
		MBS.bookTicket(time, tickets);
		assertEquals(tickets + " tickets successfully booked for " + time, outContent.toString().trim());
		outContent.reset();
		MBS.cancelReservation(time, tickets);
		assertEquals(tickets + " tickets successfully cancelled for " + time, outContent.toString().trim());
		outContent.reset();
		MBS.checkAvailability(time);
		assertEquals("Available seats for " + time + " : 30", outContent.toString().trim());
	}
	
	@Test
	void testCancelReservation_NumberofBookedSeatsNotEqualToNumberOfCancellation_MustDisplayErrorValue() {
		String time = "10:00 AM";
		int tickets = 10;
		int cancelled = 15;
		MBS.bookTicket(time, tickets);
		outContent.reset();
		
		MBS.cancelReservation(time, cancelled);
		assertEquals("Invalid operation (Attempt to cancel more tickets than booked)", outContent.toString().trim());
	}
	
	@Test
	void testMain_RunMain_MustNotReturnError() {
		MovieBookingSystem.main(null);
	}
	
	@Test
	void testCheckAllShowTime__ActualSeatsMustMatchExpected() {
		MBS.checkAllShowTime();
		
		assertTrue(outContent.toString().trim().contains("10:00 AM : 30 available seats"));
		assertTrue(outContent.toString().trim().contains("1:00 PM : 30 available seats"));
		assertTrue(outContent.toString().trim().contains("4:00 PM : 30 available seats"));
		assertTrue(outContent.toString().trim().contains("7:00 PM : 30 available seats"));
		assertTrue(outContent.toString().trim().contains("10:00 PM : 30 available seats"));
	}
}
