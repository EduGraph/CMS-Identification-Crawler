package write.cmsidentifier.queries;

import crosscutting.query.IQueryHandler;
import write.cmsidentifier.data.CMSIdentifierAccessor;
import write.cmsidentifier.data.ICMSIdentifierAccessor;
import write.cmsidentifier.models.Seeds;

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
