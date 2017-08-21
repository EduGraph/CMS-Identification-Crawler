package write.UniversityCrawler.Business.Queries;

import crosscutting.query.IQueryHandler;
import write.UniversityCrawler.Business.Models.Semester;
import write.UniversityCrawler.Data.IUniversityAccessor;
import write.UniversityCrawler.Data.UniversityAccessor;

public class GetLastSemesterHandler implements IQueryHandler<GetLastSemester, Semester> {
	private IUniversityAccessor universityAccessor;
	
	public GetLastSemesterHandler() {
		this.universityAccessor = new UniversityAccessor();
	}

	@Override
	public Semester handle(GetLastSemester query) {
		return universityAccessor.GetLastSemester();
	}

}
