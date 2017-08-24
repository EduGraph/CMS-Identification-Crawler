package write.cmsidentifier.data;

import write.cmsidentifier.business.models.CMSIdentifierResultsWithWeekNumber;
import write.cmsidentifier.business.models.Seeds;

public interface ICMSIdentifierAccessor {
	Seeds GetSeeds();
	void SaveResults(CMSIdentifierResultsWithWeekNumber results);
}
