package write.cmsidentifier.business.models;

import crosscutting.ValueObjects.CMS;
import crosscutting.ValueObjects.WeekNumberValueObject;

public class CMSIdentifierResultsWithWeekNumber {
	private CMSIdentifierResult cmsIdentifierResults;
	private WeekNumberValueObject weekNumber;
	
	public CMSIdentifierResultsWithWeekNumber(CMSIdentifierResult cmsIdentifierResults, WeekNumberValueObject weekNumber) {
		super();
		this.cmsIdentifierResults = cmsIdentifierResults;
		this.weekNumber = weekNumber;
	}

	public int getIdentifier() {
		return cmsIdentifierResults.getIdentifier();
	}
	
	public String getCMS() {
		CMS cms = cmsIdentifierResults.getCms(); 
		if (cms == null) {
			return "";
		}
		return cmsIdentifierResults.getCms().toString();
	}
	
	public int getWeekNumber() {
		return weekNumber.get();
	}
}
