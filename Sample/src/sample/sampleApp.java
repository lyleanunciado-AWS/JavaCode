package sample;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Random;

public class sampleApp {
	public static void main (String ... args) {
		LocalDate date = LocalDate.of(2020, Month.JANUARY, 20);
		LocalTime time = LocalTime.of(11, 12, 34);

		DateTimeFormatter f = DateTimeFormatter.ofPattern("MM dd yyyy");
		System.out.println(LocalDate.now().format(f));
	}
	
}
