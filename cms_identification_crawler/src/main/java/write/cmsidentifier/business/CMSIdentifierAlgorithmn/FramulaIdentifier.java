package write.cmsidentifier.business.CMSIdentifierAlgorithmn;

import crosscutting.ValueObjects.CMS;
import write.cmsidentifier.business.helper.IdentifierHelper;
import write.cmsidentifier.business.models.Site;

public class FramulaIdentifier implements ICMSIdentifier {
	private Site site;
		
	public FramulaIdentifier(Site site) {
		this.site = site;
	}

	@Override
	public CMS identify() {
		if (this.isMetaGeneratorTagFound()) {
			return CMS.Framula;
		}
		return CMS.UnbekanntesCMS;
	}
	
	private boolean isMetaGeneratorTagFound() {
		String metaContent = IdentifierHelper.GetMetaGeneratorContent(this.site);
		return metaContent != null && metaContent.contains("Framula");
	}

}
