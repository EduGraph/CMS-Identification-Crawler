package write.cmsidentifier.business.commands;

import crosscutting.command.ICommand;
import write.cmsidentifier.business.models.CMSIdentifierResult;

public class IdentifiedCMSForWebsite implements ICommand {
	private CMSIdentifierResult result;

	public CMSIdentifierResult getResult() {
		return result;
	}

	public IdentifiedCMSForWebsite(CMSIdentifierResult result) {
		this.result = result;
	}
}
