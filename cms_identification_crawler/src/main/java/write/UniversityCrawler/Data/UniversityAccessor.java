package write.UniversityCrawler.Data;

import java.text.SimpleDateFormat;

import crosscutting.data.BaseWriteDatabase;
import write.UniversityCrawler.Business.Models.Semester;

public class UniversityAccessor extends BaseWriteDatabase implements IUniversityAccessor{

	@Override
	public void CreateSemester(Semester semester) {
		if (semester == null) {
			return;
		}
		
		String sql = "INSERT INTO semester(Name, CreateTime) VALUES(?, ?)";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String createTime = sdf.format(semester.getCreateDate());
		this.JdbcTemplate.update(sql, semester.getName(), createTime);
	}

}
