package crosscutting.data;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public abstract class BaseReadDatabase {
	protected JdbcTemplate JdbcTemplate;
	
	public BaseReadDatabase() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/cmsidentifier_read");
		dataSource.setUsername("root");
		dataSource.setPassword("");
		
		this.JdbcTemplate = new JdbcTemplate(dataSource);
	}
}
