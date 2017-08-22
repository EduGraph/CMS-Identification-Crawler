package ValueObjectTests;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Test;

import crosscutting.ValueObjects.SemesterValueObject;

public class SemesterTest {
	@Test
	public void shouldReturnSommersemesterFromAprilTillSeptembre() {
		// Arrange
		Calendar calendar = new GregorianCalendar(2017, Calendar.AUGUST, 19);
		
		// Act
		SemesterValueObject semester = new SemesterValueObject(calendar);
		
		// Assert
		assertEquals("Sommersemester", semester.getPrefix());
	}
	
	@Test
	public void shouldReturnWintersemesterFromOctoberTillMarch() {
		// Arrange
		Calendar calendar = new GregorianCalendar(2017, Calendar.DECEMBER, 19);
		
		// Act
		SemesterValueObject semester = new SemesterValueObject(calendar);
		
		// Assert
		assertEquals("Wintersemester", semester.getPrefix());
	}
	
	@Test
	public void shouldReturn2017WhenYearIs2017AndItIsASommersemester() {
		// Arrange
		Calendar calendar = new GregorianCalendar(2017, Calendar.APRIL, 27);
		
		// Act
		SemesterValueObject semester = new SemesterValueObject(calendar);
		
		// Assert
		assertEquals("2017", semester.getSuffix());
	}
	
	@Test
	public void shouldReturn20172018WhenYearIs2017AndItIsAWintersemester() {
		// Arrange
		Calendar calendar = new GregorianCalendar(2017, Calendar.NOVEMBER, 27);
		
		// Act
		SemesterValueObject semester = new SemesterValueObject(calendar);
		
		// Assert
		assertEquals("2017/2018", semester.getSuffix());
	}
	
	@Test
	public void shouldReturnSommersemester2017WhenYearIs2017AndItIsASommersemester() {
		// Arrange
		Calendar calendar = new GregorianCalendar(2017, Calendar.MAY, 1);
		
		// Act
		SemesterValueObject semester = new SemesterValueObject(calendar);
		
		// Assert
		assertEquals("Sommersemester 2017", semester.name());
	}
	
	@Test
	public void shouldReturnWintersemester20172018WhenYearIs2017AndItIsWintersemester() {
		// Arrange
		Calendar calendar = new GregorianCalendar(2017, Calendar.NOVEMBER, 15);
		
		// Act
		SemesterValueObject semester = new SemesterValueObject(calendar);
		
		// Assert
		assertEquals("Wintersemester 2017/2018", semester.name());
	}
	
	@Test
	public void shouldBeTrueWhenTwoEqualSemesterAreGiven() {
		// Arrange
		Calendar calendar1 = new GregorianCalendar(2017, Calendar.NOVEMBER, 15);
		Calendar calendar2 = new GregorianCalendar(2018, Calendar.FEBRUARY, 28);
		
		SemesterValueObject semester1 = new SemesterValueObject(calendar1);
		SemesterValueObject semester2 = new SemesterValueObject(calendar2);
			
		// Act
		boolean result = semester1.equals(semester2);
		
		// Assert
		assertEquals(result, true);
	}
	
	@Test
	public void shouldBeFalseWhenTwoUnEqualSemesterAreGiven() {
		// Arrange
		Calendar calendar1 = new GregorianCalendar(2017, Calendar.NOVEMBER, 15);
		Calendar calendar2 = new GregorianCalendar(2019, Calendar.FEBRUARY, 28);
		
		SemesterValueObject semester1 = new SemesterValueObject(calendar1);
		SemesterValueObject semester2 = new SemesterValueObject(calendar2);
			
		// Act
		boolean result = semester1.equals(semester2);
		
		// Assert
		assertEquals(result, false);
	}
}
