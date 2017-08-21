package write.UniversityCrawler.Business.Commands;

import java.util.Calendar;
import java.util.Date;

import crosscutting.DataValues.Semester;
import crosscutting.command.ICommand;

public class StartNewSemester implements ICommand{
	private String name;
	private Date createTime;

	public StartNewSemester(Calendar calendar) {
		Semester newSemester = new Semester(calendar);
		this.setName(newSemester.name());
		this.setCreateTime(newSemester.getCreateTime());
	}

	public String getName() {
		return name;
	}
	
	public Date getCreateTime() {
		return this.createTime;
	}
	
	private void setName(String name) {
		this.name = name;
	}
	
	private void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}	
}
