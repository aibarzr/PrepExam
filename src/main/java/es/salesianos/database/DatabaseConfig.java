package es.salesianos.database;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class DatabaseConfig {

	@Bean
	@Profile(value = "h2")
	public DriverManagerDataSource h2DataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:file:./src/main/resources/carbrands;INIT=RUNSCRIPT FROM 'classpath:scripts/create.sql'");
		dataSource.setUsername("sa");
		dataSource.setPassword("");
		return dataSource;
	}
	
	/*@Bean
	public DataSource dataSource() {

		// no need shutdown, EmbeddedDatabaseFactoryBean will take care of this
		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
		EmbeddedDatabase db = builder
			.setType(EmbeddedDatabaseType.H2)
			.build();
		return db;
	}*/
}
