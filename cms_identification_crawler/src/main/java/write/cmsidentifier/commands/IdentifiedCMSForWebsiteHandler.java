package write.cmsidentifier.commands;

import java.util.Calendar;

import crosscutting.ValueObjects.WeekNumberValueObject;
import crosscutting.command.ICommandHandler;
import write.cmsidentifier.data.CMSIdentifierAccessor;
import write.cmsidentifier.data.ICMSIdentifierAccessor;
import write.cmsidentifier.models.CMSIdentifierResultsWithWeekNumber;

public class IdentifiedCMSForWebsiteHandler implements ICommandHandler<IdentifiedCMSForWebsite>{
	private ICMSIdentifierAccessor cmsIdentifierAccessor;
	
	public IdentifiedCMSForWebsiteHandler() {
		this.cmsIdentifierAccessor = new CMSIdentifierAccessor();
	}

	@Override
	public void handler(IdentifiedCMSForWebsite command) {
		WeekNumberValueObject weekNumber = new WeekNumberValueObject(Calendar.getInstance());
		CMSIdentifierResultsWithWeekNumber result = new CMSIdentifierResultsWithWeekNumber(command.getResult(), weekNumber);
		this.cmsIdentifierAccessor.SaveResults(result);
	}

}
