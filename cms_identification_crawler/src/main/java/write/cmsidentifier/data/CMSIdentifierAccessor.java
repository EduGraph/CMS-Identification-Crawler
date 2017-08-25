package write.cmsidentifier.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import crosscutting.data.BaseDatabase;
import write.cmsidentifier.business.models.CMSIdentifierResult;
import write.cmsidentifier.business.models.CMSIdentifierResultsWithWeekNumber;
import write.cmsidentifier.business.models.Seed;
import write.cmsidentifier.business.models.Seeds;
import write.cmsidentifier.business.models.WeekNumber;

public class CMSIdentifierAccessor extends BaseDatabase implements ICMSIdentifierAccessor {
	
	@Override
	public Seeds GetSeeds() {
		String sql = "SELECT ID, Website_URL FROM write_hochschule where Semester_ID = (SELECT ID FROM `write_semester` ORDER BY CreateTime DESC Limit 1)";
		List<Seed> seeds = this.JdbcTemplate.query(sql, new SeedMapper());
		return new Seeds(seeds);
	}
	
	private static final class SeedMapper implements RowMapper<Seed>{

		@Override
		public Seed mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new Seed(rs.getInt("ID"), rs.getString("Website_URL"));
		}		
	}

	@Override
	public void SaveResults(CMSIdentifierResultsWithWeekNumber results) {
		String sql = "INSERT INTO `write_woche`(`Kalenderwoche`, `CMS`, `ID_Semester`, `ID_Hochschule`) VALUES (?, ?,(SELECT ID FROM `write_semester` ORDER BY CreateTime DESC Limit 1),?)";
		this.JdbcTemplate.update(sql, 
				results.getWeekNumber(),
				results.getCMS(),
				results.getIdentifier());
	}

	@Override
	public WeekNumber GetLastWeekNumber() {
		String sql = "select Kalenderwoche from write_woche where ID_Semester = (SELECT id FROM write_semester ORDER BY CreateTime DESC Limit 1) ORDER BY Kalenderwoche DESC LIMIT 1";
		return this.JdbcTemplate.query(sql, new ResultSetExtractor<WeekNumber>(){
			@Override
			public WeekNumber extractData(ResultSet rs) throws SQLException, DataAccessException {
				if (rs.next()) {
					return new WeekNumber(rs.getInt("Kalenderwoche"));
				}
				return null;
			}
		});
	}

}
