package write.cmsidentifier.business.CMSIdentifierAlgorithmn;

import crosscutting.ValueObjects.CMS;
import write.cmsidentifier.business.helper.IdentifierHelper;
import write.cmsidentifier.business.models.Site;

public class DrupalIdentifier implements ICMSIdentifier{
	private Site site;
	
	public DrupalIdentifier(Site site) {
		this.site = site;
	}

	@Override
	public CMS identify() {
		if (this.isDrupalInJavaScriptInlineScript()) {
			return CMS.Drupal;
		}
		
		if (this.isDrupalFoundInJavaScriptSrc()) {
			return CMS.Drupal;
		}
		return CMS.UnbekanntesCMS;
	}

	private boolean isDrupalFoundInJavaScriptSrc() {
		return IdentifierHelper.FindSomethingInJavaScriptSrc(site, "drupal");
	}

	private boolean isDrupalInJavaScriptInlineScript() {
		return IdentifierHelper.FindSomethingInInlineJavaScript(site, "Drupal");
	}
}
