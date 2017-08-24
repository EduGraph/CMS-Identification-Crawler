package write.cmsidentifier.data;

import write.cmsidentifier.models.CMSIdentifierResultsWithWeekNumber;
import write.cmsidentifier.models.Seeds;

public interface ICMSIdentifierAccessor {
	Seeds GetSeeds();
	void SaveResults(CMSIdentifierResultsWithWeekNumber results);
}
