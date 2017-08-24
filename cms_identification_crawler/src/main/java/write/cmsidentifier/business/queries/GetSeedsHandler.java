package write.cmsidentifier.business.queries;

import crosscutting.query.IQueryHandler;
import write.cmsidentifier.business.models.Seeds;
import write.cmsidentifier.data.CMSIdentifierAccessor;
import write.cmsidentifier.data.ICMSIdentifierAccessor;

public class GetSeedsHandler implements IQueryHandler<GetSeeds, Seeds>{
	ICMSIdentifierAccessor cmsidentifierAccessor;
	
	public GetSeedsHandler() {
		this.cmsidentifierAccessor = new CMSIdentifierAccessor();
	}

	@Override
	public Seeds handle(GetSeeds query) {
		return this.cmsidentifierAccessor.GetSeeds();
	}

}
