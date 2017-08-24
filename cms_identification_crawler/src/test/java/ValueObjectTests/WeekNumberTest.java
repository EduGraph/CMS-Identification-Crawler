package ValueObjectTests;

import java.util.Calendar;
import java.util.GregorianCalendar;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import crosscutting.ValueObjects.WeekNumberValueObject;

public class WeekNumberTest {
	@Test
	public void shouldReturnCorrectWeekNumber() {
		// Arrange
		Calendar calendar = new GregorianCalendar(2017, Calendar.AUGUST, 22);
		
		// Act
		WeekNumberValueObject weeknumber = new WeekNumberValueObject(calendar);
		
		// Assert
		assertEquals(34, weeknumber.get());
	}
}
