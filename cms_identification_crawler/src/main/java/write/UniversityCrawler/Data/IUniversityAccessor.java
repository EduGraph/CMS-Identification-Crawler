package write.UniversityCrawler.Data;

import write.UniversityCrawler.Business.Models.Semester;
import write.UniversityCrawler.Business.Models.University;

public interface IUniversityAccessor {
	void CreateSemester(Semester semester);
	void MatriculateUniversityToSemester(University university, Semester semester);
	Semester GetLastSemester();
}
