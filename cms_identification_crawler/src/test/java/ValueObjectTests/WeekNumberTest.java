package ValueObjectTests;

import java.util.Calendar;
import java.util.GregorianCalendar;
import static org.junit.Assert.assertEquals;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Test;

import crosscutting.DataValues.Semester;


import crosscutting.DataValues.WeekNumber;

public class WeekNumberTest {
	@Test
	public void shouldReturnCorrectWeekNumber() {
		// Arrange
		Calendar calendar = new GregorianCalendar(2017, Calendar.AUGUST, 22);
		
		// Act
		WeekNumber weeknumber = new WeekNumber(calendar);
		
		// Assert
		assertEquals(34, weeknumber.get());
	}
}
