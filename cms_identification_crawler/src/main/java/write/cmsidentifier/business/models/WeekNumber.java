package write.cmsidentifier.business.models;

import crosscutting.query.IResult;

public class WeekNumber implements IResult{
	private int number;

	public WeekNumber(int number) {
		this.number = number;
	}

	public int getNumber() {
		return number;
	}
}
