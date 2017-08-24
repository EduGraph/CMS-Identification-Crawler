package crosscutting.ValueObjects;

import java.util.Calendar;

public class WeekNumberValueObject {
	private int weeknumber;
	
	public WeekNumberValueObject(Calendar calendar) {
		this.setWeekNumber(calendar);
	}

	public int get() {
		return weeknumber;
	}

	private void setWeekNumber(Calendar calender) {
		this.weeknumber = calender.get(Calendar.WEEK_OF_YEAR);
	}
	
	
}
