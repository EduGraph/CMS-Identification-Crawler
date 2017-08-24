package write.TimeEvents;

import java.util.Calendar;
import java.util.Date;

import crosscutting.ValueObjects.SemesterValueObject;
import crosscutting.query.IQueryResolver;
import crosscutting.query.QueryResolver;
import write.UniversityCrawler.Business.Models.Semester;
import write.UniversityCrawler.Business.Queries.GetLastSemester;

public class UniversityCrawlerTimer implements IUniversityCrawlerTimer {
	private IQueryResolver queryResolver;

	public UniversityCrawlerTimer() {
		this.queryResolver = new QueryResolver();
	}

	@Override
	public boolean start() {
		if (this.IsLastSemesterCurrentSemester()) {
			return false; // Das aktuelle Semester wurde bereits erfasst
		}
		
		return true; // Das aktuelle Semester wurde noch nicht erfasst
	}

	// Prüfen ob das im System aktuelle Semester auch noch das tatsächlich aktuelle Semester ist
	private boolean IsLastSemesterCurrentSemester() {
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
