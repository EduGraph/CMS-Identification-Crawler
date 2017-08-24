package write.cmsidentifier.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import crosscutting.data.BaseWriteDatabase;
import write.cmsidentifier.models.CMSIdentifierResults;
import write.cmsidentifier.models.CMSIdentifierResultsWithWeekNumber;
import write.cmsidentifier.models.Seed;
import write.cmsidentifier.models.Seeds;

public class CMSIdentifierAccessor extends BaseWriteDatabase implements ICMSIdentifierAccessor {
	
	@Override
	public Seeds GetSeeds() {
		String sql = "SELECT ID, Website_URL FROM hochschule where Semester_ID = (SELECT ID FROM `semester` ORDER BY CreateTime DESC Limit 1)";
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
		String sql = "INSERT INTO `woche`(`Kalenderwoche`, `CMS`, `ID_Semester`, `ID_Hochschule`) VALUES (?, ?,(SELECT ID FROM `semester` ORDER BY CreateTime DESC Limit 1),?)";
		this.JdbcTemplate.update(sql, 
				results.getWeekNumber(),
				results.getCMS(),
				results.getIdentifier());
	}

}