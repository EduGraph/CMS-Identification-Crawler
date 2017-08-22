package write.UniversityCrawler.Helper;

import java.util.Calendar;
import java.util.Date;

import crosscutting.ValueObjects.SemesterValueObject;
import crosscutting.query.IQueryResolver;
import crosscutting.query.QueryResolver;
import write.UniversityCrawler.Business.Models.Semester;
import write.UniversityCrawler.Business.Queries.GetLastSemester;

public class SemesterHelper implements ISemesterHelper{
	private IQueryResolver queryResolver;
	
	public SemesterHelper() {
		this.queryResolver = new QueryResolver();
	}
	
	// Prüfen ob das im System als aktuelle Semester auch noch das tatsächlich aktuelle Semester ist
	public boolean IsLastSemesterCurrentSemester() {
		Semester semester = (Semester)queryResolver.Resolve(new GetLastSemester());
		if (semester == null) {
			return false;
		}
		
		Calendar lastSemesterCalendar = this.ConvertDateToCalendar(semester.getCreateDate());
		Calendar currentSemesterCalendar = Calendar.getInstance();
		
		SemesterValueObject lastSemester = new SemesterValueObject(lastSemesterCalendar);
		SemesterValueObject currentSemester = new SemesterValueObject(currentSemesterCalendar);
		
		return lastSemester.equals(currentSemester);
	}
	
	private Calendar ConvertDateToCalendar(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar;
	}
}
