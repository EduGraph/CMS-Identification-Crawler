package write.cmsidentifier.business.CMSIdentifierAlgorithmn;

import crosscutting.ValueObjects.CMS;
import write.cmsidentifier.business.helper.IdentifierHelper;
import write.cmsidentifier.business.models.Site;

public class IcoyaIdentifier implements ICMSIdentifier {
	private Site site;
		
	public IcoyaIdentifier(Site site) {
		this.site = site;
	}

	@Override
	public CMS identify() {
		if (this.isMetaGeneratorTagFound()) {
			return CMS.Icoya;
		}
		return CMS.UnbekanntesCMS;
	}
	
	private boolean isMetaGeneratorTagFound() {
		String metaContent = IdentifierHelper.GetMetaGeneratorContent(this.site);
		return metaContent != null && metaContent.contains("icoya");
	}

}
