package write.UniversityCrawler.Business.Commands;

import crosscutting.command.ICommandHandler;
import write.UniversityCrawler.Business.Models.Semester;
import write.UniversityCrawler.Data.IUniversityAccessor;
import write.UniversityCrawler.Data.UniversityAccessor;

public class StartNewSemesterHandler implements ICommandHandler<StartNewSemester>{
	private IUniversityAccessor universityAccessor;
	
	
	
	public StartNewSemesterHandler() {
		this.universityAccessor = new UniversityAccessor();
	}

	@Override
	public void handler(StartNewSemester command) {
		this.universityAccessor.CreateSemester(new Semester(0, command.getName(), command.getCreateTime()));
	}

}
