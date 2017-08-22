package write.UniversityCrawler.Business.Commands;

import crosscutting.command.ICommandHandler;
import write.UniversityCrawler.Data.IUniversityAccessor;
import write.UniversityCrawler.Data.UniversityAccessor;

public class MatriculateUniversityToSemesterHandler implements ICommandHandler<MatriculateUniversityToSemester>{
	private IUniversityAccessor universityAccessor;

	public MatriculateUniversityToSemesterHandler() {
		this.universityAccessor = new UniversityAccessor();
	}

	@Override
	public void handler(MatriculateUniversityToSemester command) {
		this.universityAccessor.MatriculateUniversityToSemester(command.getUniversity(), command.getSemester());
	}
	
	
}
