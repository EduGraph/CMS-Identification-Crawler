package read.frontend.Data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import crosscutting.data.BaseReadDatabase;
import read.frontend.presentation.Models.AnzahlDerVerwendetenCMS;
import read.frontend.presentation.Models.CMS;
import read.frontend.presentation.Models.CMSAnzahl;
import read.frontend.presentation.Models.CMSDerHochschulen;
import read.frontend.presentation.Models.HochschuleCMS;
import read.frontend.presentation.Models.VeraenderungAktuelleWoche;
import read.frontend.presentation.Models.VeraenderungWoche;

public class ReadDomainDataAccessor extends BaseReadDatabase implements IReadDomainDataAccessor{
	@Override
	public AnzahlDerVerwendetenCMS GetAnzahlDerVerwendetenCMS() {
		String sql = "SELECT CMS, Anzahl FROM anzahlderverwendetencms";
		List<CMSAnzahl> cmsVerbreitung = this.JdbcTemplate.query(sql, new CMSAnzahlCMSMapper());
		return new AnzahlDerVerwendetenCMS(cmsVerbreitung);
	}

	@Override
	public CMSDerHochschulen GetCMSDerHochschulen() {
		String sql = "SELECT Hochschule, CMS FROM cmsderhochschulen";
		List<HochschuleCMS> cmsDerHochschulen = this.JdbcTemplate.query(sql, new HochschuleCMSMapper());
		return new CMSDerHochschulen(cmsDerHochschulen);
	}
	
	@Override
	public VeraenderungAktuelleWoche GetVeraenderungAktulleWoche() {
		String sql = "SELECT CMS, Veraenderung FROM veraenderungaktuellewoche";
		List<VeraenderungWoche> veraenderungWoche = this.JdbcTemplate.query(sql, new VeraenderungWocheMapper());
		return new VeraenderungAktuelleWoche(veraenderungWoche);
	}

	private static final class VeraenderungWocheMapper implements RowMapper<VeraenderungWoche>{

		@Override
		public VeraenderungWoche mapRow(ResultSet rs, int rowNum) throws SQLException {
			String cms = rs.getString("CMS");
			int veraenderung = rs.getInt("Veraenderung");
			return new VeraenderungWoche(CMS.valueOf(cms), veraenderung);
		}
		
	}
	
	private static final class CMSAnzahlCMSMapper implements RowMapper<CMSAnzahl>{

		@Override
		public CMSAnzahl mapRow(ResultSet rs, int rowNum) throws SQLException {
			String cms = rs.getString("CMS");
			int anzahl = rs.getInt("Anzahl");
			return new CMSAnzahl(CMS.valueOf(cms), anzahl);
		}
		
	}
	
	private static final class HochschuleCMSMapper implements RowMapper<HochschuleCMS>{

		@Override
		public HochschuleCMS mapRow(ResultSet rs, int rowNum) throws SQLException {
			String cms = rs.getString("CMS");
			String hochschule = rs.getString("Hochschule");
			return new HochschuleCMS(hochschule, CMS.valueOf(cms));
		}
		
	}
}
