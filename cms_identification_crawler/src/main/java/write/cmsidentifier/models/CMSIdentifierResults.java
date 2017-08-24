package write.cmsidentifier.models;

import crosscutting.ValueObjects.CMS;

public class CMSIdentifierResults {
	private int identifier;
	private CMS cms;

	public CMSIdentifierResults(int identifier, CMS cms) {
		super();
		this.identifier = identifier;
		this.cms = cms;
	}

	public int getIdentifier() {
		return identifier;
	}

	public CMS getCms() {
		return cms;
	}

}
