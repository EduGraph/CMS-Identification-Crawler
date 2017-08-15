package read.frontend.Data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import read.frontend.presentation.Models.AnzahlDerVerwendetenCMS;
import read.frontend.presentation.Models.CMS;
import read.frontend.presentation.Models.CMSAnzahl;

public class ReadDomainDataAccessor implements IReadDomainDataAccessor{
	private JdbcTemplate JdbcTemplate;
	
	public ReadDomainDataAccessor() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/cmsidentifier_read");
		dataSource.setUsername("root");
		dataSource.setPassword("");
		
		this.JdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public AnzahlDerVerwendetenCMS GetAnzahlDerVerwendetenCMS() {

		String sql = "SELECT CMS, Anzahl FROM anzahlderverwendetencms";
		List<CMSAnzahl> cmsVerbreitung = this.JdbcTemplate.query(sql, new CMSAnzahlCMSMapper());
		return new AnzahlDerVerwendetenCMS(cmsVerbreitung);
	}
	
	private static final class CMSAnzahlCMSMapper implements RowMapper<CMSAnzahl>{

		@Override
		public CMSAnzahl mapRow(ResultSet rs, int rowNum) throws SQLException {
			String cms = rs.getString("CMS");
			int anzahl = rs.getInt("Anzahl");
			return new CMSAnzahl(CMS.valueOf(cms), anzahl);
		}
		
	}

}
