package write.cmsidentifier.models;

import crosscutting.ValueObjects.WeekNumberValueObject;

public class CMSIdentifierResultsWithWeekNumber {
	private CMSIdentifierResults cmsIdentifierResults;
	private WeekNumberValueObject weekNumber;
	
	public CMSIdentifierResultsWithWeekNumber(CMSIdentifierResults cmsIdentifierResults, WeekNumberValueObject weekNumber) {
		super();
		this.cmsIdentifierResults = cmsIdentifierResults;
		this.weekNumber = weekNumber;
	}

	public int getIdentifier() {
		return cmsIdentifierResults.getIdentifier();
	}
	
	public String getCMS() {
		return cmsIdentifierResults.getCms().toString();
	}
	
	public int getWeekNumber() {
		return weekNumber.get();
	}
}
