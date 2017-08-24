package write.cmsidentifier.business.CMSIdentifierAlgorithmn;

import crosscutting.ValueObjects.CMS;
import write.cmsidentifier.business.helper.IdentifierHelper;
import write.cmsidentifier.business.models.Site;

public class WordPressIdentifier implements ICMSIdentifier {
	private Site site;

	public WordPressIdentifier(Site site) {
		this.site = site;
	}

	@Override
	public CMS identify() {
		if (this.isWp_contentFoundInHref()) {
			return CMS.WordPress;
		}
		return CMS.UnbekanntesCMS;
	}

	private boolean isWp_contentFoundInHref() {
		return IdentifierHelper.FindSometingInHref(this.site, "wp-content");
	}
	
	private boolean isMetaGeneratorTagFound() {
		String metaContent = IdentifierHelper.GetMetaGeneratorContent(this.site);
		return metaContent != null && metaContent.contains("WordPress");
	}
}
