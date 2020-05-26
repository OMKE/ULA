package com.ula.configuration;

import javax.sql.DataSource;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

/*
 * Flyway - Custom configuration
 * Ensures that our flyway migrations are run after hibernate creates tables
 * We use Flyway for insertion only, this solution might not be the best when we want to alter the table, but we will only ever insert initial data 
 * that is required for authentication (ROLES, ADMIN USERS) and nothing elese
 */

@Configuration
public class FlywayConfiguration {

	@Autowired
	public FlywayConfiguration(DataSource dataSource) {
		Flyway.configure().baselineOnMigrate(true).dataSource(dataSource).load().migrate();
	}
}
