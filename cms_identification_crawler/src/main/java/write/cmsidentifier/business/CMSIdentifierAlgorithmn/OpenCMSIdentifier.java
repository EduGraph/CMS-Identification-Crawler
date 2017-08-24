package write.cmsidentifier.business.CMSIdentifierAlgorithmn;

import crosscutting.ValueObjects.CMS;
import write.cmsidentifier.business.helper.IdentifierHelper;
import write.cmsidentifier.business.models.Site;

public class OpenCMSIdentifier implements ICMSIdentifier {
	private Site site;
	
	public OpenCMSIdentifier(Site site) {
		this.site = site;
	}

	@Override
	public CMS identify() {
		if (this.isMetaGeneratorTagFound()) {
			return CMS.OpenCMS;
		}
		return CMS.UnbekanntesCMS;
	}
	
	private boolean isMetaGeneratorTagFound() {
		String metaContent = IdentifierHelper.GetMetaSystemContent(this.site);
		return metaContent != null && metaContent.contains("OPENCMS");
	}
}
