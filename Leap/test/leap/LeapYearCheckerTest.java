package leap;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LeapYearCheckerTest {
	

	@Test
	void testIsLeapYear_WhenInputisDivisibleBy400_ShouldReturnTrue() {
		LeapYearChecker a = new LeapYearChecker(2000);
		assertEquals(true, a.isLeapYear());
	}
	
	@Test 
	void testIsLeapYear_WhenInputisDivisibleBy100ButNot400_ShouldReturnFalse() {
		LeapYearChecker b = new LeapYearChecker(1900);
		assertEquals(false, b.isLeapYear());
	}
	
	@Test
	void testIsLeapYear_WhenInputisDivisibleBy4ButNot100_ShouldReturnTrue() {
		LeapYearChecker c = new LeapYearChecker(2016);
		assertEquals(true, c.isLeapYear());
	}
	
	@Test 
	void testIsLeapYear_WhenInputisNotDivisibleBy4_ShouldReturnFalse() {
		LeapYearChecker d = new LeapYearChecker(2017);
		assertEquals(false, d.isLeapYear());		
	}
	
	@Test
	void testIsLeapYear_WhenInputisARandomLeapYear_ShouldReturnTrue() {
		LeapYearChecker e = new LeapYearChecker(1984);
		assertEquals(true, e.isLeapYear());
	}
	
	@Test
	void testIsLeapYear_WhenInputisARandomNonLeapYear_ShouldReturnFalse() {
		LeapYearChecker f = new LeapYearChecker(2015);
		assertEquals(false, f.isLeapYear());
	}
	
	@Test
	void dummyMain() {
		String[] params = {"Hello", "World"};
		LeapYear.main(params);
	}
}
