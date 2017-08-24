package write.cmsidentifier.commands;

import crosscutting.command.ICommand;
import write.cmsidentifier.models.CMSIdentifierResults;

public class IdentifiedCMSForWebsite implements ICommand {
	private CMSIdentifierResults result;

	public CMSIdentifierResults getResult() {
		return result;
	}

	public IdentifiedCMSForWebsite(CMSIdentifierResults result) {
		this.result = result;
	}
}
