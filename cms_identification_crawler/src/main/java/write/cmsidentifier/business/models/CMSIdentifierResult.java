package write.cmsidentifier.business.models;

import crosscutting.ValueObjects.CMS;

public class CMSIdentifierResult {
	private int identifier;
	private CMS cms;

	public CMSIdentifierResult(int identifier, CMS cms) {
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
