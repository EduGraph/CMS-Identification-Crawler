package write.cmsidentifier.data;

import write.cmsidentifier.business.models.CMSIdentifierResultsWithWeekNumber;
import write.cmsidentifier.business.models.Seeds;
import write.cmsidentifier.business.models.WeekNumber;

public interface ICMSIdentifierAccessor {
	Seeds GetSeeds();
	void SaveResults(CMSIdentifierResultsWithWeekNumber results);
	WeekNumber GetLastWeekNumber();
}
