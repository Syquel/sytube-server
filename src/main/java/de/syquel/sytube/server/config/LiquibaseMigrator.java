package de.syquel.sytube.server.config;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.interceptor.Interceptor;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.quarkus.runtime.Startup;
import liquibase.Contexts;
import liquibase.LabelExpression;
import liquibase.Liquibase;
import liquibase.database.DatabaseConnection;
import liquibase.database.DatabaseFactory;
import liquibase.exception.LiquibaseException;
import liquibase.resource.ClassLoaderResourceAccessor;
import liquibase.resource.ResourceAccessor;

@ApplicationScoped
@Startup(Interceptor.Priority.LIBRARY_BEFORE)
public class LiquibaseMigrator {

	private static final Logger LOGGER = LoggerFactory.getLogger(LiquibaseMigrator.class);

	@ConfigProperty(name = "quarkus.datasource.jdbc.url")
	String datasourceUrl;
	@ConfigProperty(name = "quarkus.datasource.username")
	String datasourceUsername;
	@ConfigProperty(name = "quarkus.datasource.password")
	String datasourcePassword;
	@ConfigProperty(name = "quarkus.liquibase.change-log")
	String changeLogLocation;

	@PostConstruct
	public void runLiquibaseMigration() throws LiquibaseException {
		LOGGER.info("Starting Liquibase migration");

		ResourceAccessor resourceAccessor = new ClassLoaderResourceAccessor(Thread.currentThread().getContextClassLoader());
		DatabaseConnection conn = DatabaseFactory.getInstance().openConnection(datasourceUrl, datasourceUsername, datasourcePassword, null, resourceAccessor);

		try (Liquibase liquibase = new Liquibase(changeLogLocation, resourceAccessor, conn)) {
			liquibase.update(new Contexts(), new LabelExpression());
		}

		LOGGER.info("Finished Liquibase migration");
	}

}
