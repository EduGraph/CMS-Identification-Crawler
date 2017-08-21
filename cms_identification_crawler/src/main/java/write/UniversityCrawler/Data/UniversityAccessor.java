package write.UniversityCrawler.Data;

import crosscussting.data.BaseWriteDatabase;
import write.UniversityCrawler.Business.Models.Semester;

public class UniversityAccessor extends BaseWriteDatabase implements IUniversityAccessor{

	@Override
	public void CreateSemester(Semester semester) {
		if (semester == null) {
			return;
		}
		
		String sql = "INSERT INTO semester(name) VALUES(?)";
		this.JdbcTemplate.update(sql, semester.getName());
	}

}
