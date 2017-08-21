package write.UniversityCrawler.Data;

import write.UniversityCrawler.Business.Models.Semester;

public interface IUniversityAccessor {
	void CreateSemester(Semester semester);
	Semester GetLastSemester();
}
