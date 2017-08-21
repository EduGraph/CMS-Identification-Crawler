package write.UniversityCrawler.Data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import crosscutting.data.BaseWriteDatabase;
import write.UniversityCrawler.Business.Models.Semester;

public class UniversityAccessor extends BaseWriteDatabase implements IUniversityAccessor {

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

	@Override
	public Semester GetLastSemester() {
		String sql = "SELECT id, name, createtime FROM semester ORDER BY CreateTime DESC Limit 1";
		return (Semester) this.JdbcTemplate.query(sql, new ResultSetExtractor<Semester>() {

			@Override
			public Semester extractData(ResultSet rs) throws SQLException, DataAccessException {
				if (rs.next()) {
					return new Semester(rs.getInt("id"), rs.getString("name"), rs.getDate("createtime"));
				}
				return null;
			}
			
		});
	}
}
