package write.cmsidentifier.business.CMSIdentifierAlgorithmn;

import crosscutting.ValueObjects.CMS;
import write.cmsidentifier.business.helper.IdentifierHelper;
import write.cmsidentifier.business.models.Site;

public class ProcessWireIdentifier implements ICMSIdentifier {
	private Site site;
	
	public ProcessWireIdentifier(Site site) {
		this.site = site;
	}

	@Override
	public CMS identify() {
		if (this.isProcessWireInJavaScriptInlineScript()) {
			return CMS.ProcessWire;
		}
		return CMS.UnbekanntesCMS;
	}

	private boolean isProcessWireInJavaScriptInlineScript() {
		return IdentifierHelper.FindSomethingInInlineJavaScript(site, "ProcessWire");
	}
}
