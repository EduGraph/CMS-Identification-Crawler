package crosscutting.ValueObjects;

import java.util.Calendar;
import java.util.Date;

public class SemesterValueObject {
	private static final int april = 3;
	private static final int january = 0;
	private static final int october = 10;
	private static final int march = 2;
	private String prefix;
	private String suffix;
	private Date createTime;
	
	public SemesterValueObject(Calendar calendar) {
		this.setPrefix(calendar);
		this.setSuffix(calendar);		
		this.setCreateTime(calendar.getTime());
	}

	public Date getCreateTime() {
		return createTime;
	}
	
	public String getPrefix() {
		return prefix;
	}
	
	public String getSuffix() {
		return suffix;
	}
	
	public String name() {
		return this.prefix + " " + this.suffix;
	}

	private void setSuffix(Calendar calendar) {
		int month = calendar.get(Calendar.MONTH);
		
		this.suffix = IsSommerSemester(month) 
			? Integer.toString(calendar.get(Calendar.YEAR))
			: this.calculateWinterSuffix(calendar);		
	}

	private String calculateWinterSuffix(Calendar calendar) {
		String first = "";
		String secound = "";
		
		int month = calendar.get(Calendar.MONTH);
		if (IsJanuaryFebruaryOrMarch(month)) {
			first = Integer.toString((calendar.get(Calendar.YEAR)) - 1);
			secound = Integer.toString(calendar.get(Calendar.YEAR));
		}
		else {
			first = Integer.toString(calendar.get(Calendar.YEAR));
			secound = Integer.toString((calendar.get(Calendar.YEAR) + 1));
		}
		
		return first + "/" + secound;
	}

	private void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	private boolean IsJanuaryFebruaryOrMarch(int month) {
		return month >= january && month < april;
	}

	public void setPrefix(Calendar calendar) {
		this.prefix = this.IsSommerSemester(calendar.get(Calendar.MONTH))
				? "Sommersemester"
				: "Wintersemester";
	}
	
	private boolean IsSommerSemester(int month) {
		return month > march && month < october;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((prefix == null) ? 0 : prefix.hashCode());
		result = prime * result + ((suffix == null) ? 0 : suffix.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
			
		SemesterValueObject other = (SemesterValueObject)obj;
		
		if (this.getPrefix().equals(other.getPrefix()) && 
			this.getSuffix().equals(other.getSuffix())) {
			return true;
		}		
		
		return false;
	}
}
