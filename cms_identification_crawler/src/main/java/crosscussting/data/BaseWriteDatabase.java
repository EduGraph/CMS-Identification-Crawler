package crosscussting.data;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class BaseWriteDatabase {
	protected JdbcTemplate JdbcTemplate;
	
	public BaseWriteDatabase() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/cmsidentifier_write");
		dataSource.setUsername("root");
		dataSource.setPassword("");
		
		this.JdbcTemplate = new JdbcTemplate(dataSource);
	}
}
