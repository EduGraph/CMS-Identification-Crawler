package write.cmsidentifier.business.queries;

import crosscutting.query.IQueryHandler;
import write.cmsidentifier.business.models.WeekNumber;
import write.cmsidentifier.data.CMSIdentifierAccessor;
import write.cmsidentifier.data.ICMSIdentifierAccessor;

public class GetLastWeekNumberHandler implements IQueryHandler<GetLastWeekNumber, WeekNumber>{
	ICMSIdentifierAccessor cmsIdentifierAccessor;
	
	public GetLastWeekNumberHandler() {
		this.cmsIdentifierAccessor = new CMSIdentifierAccessor();
	}

	@Override
	public WeekNumber handle(GetLastWeekNumber query) {
		return cmsIdentifierAccessor.GetLastWeekNumber();
	}
}
