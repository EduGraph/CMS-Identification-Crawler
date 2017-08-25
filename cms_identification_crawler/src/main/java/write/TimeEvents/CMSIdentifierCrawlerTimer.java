package write.TimeEvents;

import java.util.Calendar;

import crosscutting.ValueObjects.WeekNumberValueObject;
import crosscutting.query.IQueryResolver;
import crosscutting.query.QueryResolver;
import write.cmsidentifier.business.models.WeekNumber;
import write.cmsidentifier.business.queries.GetLastWeekNumber;

public class CMSIdentifierCrawlerTimer implements ICMSIdentifierCrawlerTimer {
	private IQueryResolver queryResolver;
	
	public CMSIdentifierCrawlerTimer() {
		this.queryResolver = new QueryResolver();
	}

	@Override
	public boolean start() {
		if (actualWeekNumberIsSystemWeekNumber()) {
			return false; // In dieser Woche wurde bereits ein Durchlauf gemacht
		}
		
		return true; // In dieser Woche wurde noch kein Durchlauf gemacht
	}
	
	private boolean actualWeekNumberIsSystemWeekNumber() {
		WeekNumber currentSystemWeekNumber = (WeekNumber)queryResolver.Resolve(new GetLastWeekNumber());
		if (currentSystemWeekNumber == null) {
			return false;
		}
		WeekNumberValueObject actualWeekNumber = new WeekNumberValueObject(Calendar.getInstance());
		return currentSystemWeekNumber.getNumber() == actualWeekNumber.get();
	}

}
