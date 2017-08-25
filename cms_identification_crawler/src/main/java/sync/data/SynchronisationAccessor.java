package sync.data;

import crosscutting.data.BaseDatabase;

public class SynchronisationAccessor extends BaseDatabase implements ISyncronisationAccessor{

	@Override
	public void UpdateCMSDerHochschulen() {
		String clearTableSql = "DELETE FROM read_cmsderhochschulen";
		this.JdbcTemplate.update(clearTableSql);
		
		String syncSql = 
				"INSERT INTO read_cmsderhochschulen (Hochschule, CMS) " + 
				"SELECT DISTINCT write_hochschule.Name, write_woche.CMS " + 
				"FROM write_woche " + 
				"INNER JOIN write_hochschule ON write_woche.ID_Hochschule = write_hochschule.ID " + 
				"WHERE write_woche.CMS <> '' " + 
				"ORDER BY write_hochschule.Name ASC";
		
		this.JdbcTemplate.update(syncSql);
	}

	@Override
	public void UpdateAnzahlDerVerwendetenCMS() {
		String clearTableSql = "DELETE FROM read_anzahlderverwendetencms";
		this.JdbcTemplate.update(clearTableSql);
		
		String syncSql = 
				"INSERT INTO read_anzahlderverwendetencms (CMS, Anzahl) " + 
				"SELECT CMS, COUNT(CMS) AS Anzahl " + 
				"FROM `write_woche` " + 
				"WHERE " + 
				"  CMS <> '' AND " + 
				"  ID_Semester = (SELECT ID FROM `write_semester` ORDER BY CreateTime DESC LIMIT 1) AND " + 
				"  Kalenderwoche = (SELECT Kalenderwoche FROM write_woche ORDER BY Kalenderwoche DESC LIMIT 1) " + 
				"GROUP BY CMS " + 
				"ORDER BY COUNT(CMS) DESC ";
		
		this.JdbcTemplate.update(syncSql);
	}

	@Override
	public void UpdateVeraenderungAktuelleWoche() {
		String clearTableSql = "DELETE FROM read_veraenderungaktuellewoche";
		this.JdbcTemplate.update(clearTableSql);
		
		String syncSql = 
				"INSERT INTO read_veraenderungaktuellewoche (CMS, Veraenderung) " +
				"SELECT previous_week.cms, cms_current_week_total - coalesce(cms_previous_week_total , 0) " + 
				"FROM " + 
				"	(SELECT cms, count(CMS) AS cms_previous_week_total " + 
				"     FROM write_woche " + 
				"     WHERE write_woche.Kalenderwoche = ((SELECT Kalenderwoche FROM write_woche ORDER BY Kalenderwoche DESC LIMIT 1)) - 1 " + 
				"     GROUP BY CMS) previous_week " + 
				"LEFT OUTER JOIN " + 
				"	(SELECT cms, count(CMS) AS cms_current_week_total " + 
				"     FROM write_woche " + 
				"     WHERE write_woche.Kalenderwoche = ((SELECT Kalenderwoche FROM write_woche ORDER BY Kalenderwoche DESC LIMIT 1)) " + 
				"     GROUP BY CMS) current_week " + 
				"ON (previous_week.cms = current_week.cms)";
				
		this.JdbcTemplate.update(syncSql);
	}

}
