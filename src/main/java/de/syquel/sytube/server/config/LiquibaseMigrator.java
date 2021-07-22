package de.syquel.sytube.server.config;

import io.quarkus.mongodb.reactive.ReactiveMongoClient;
import io.quarkus.runtime.Startup;
import liquibase.Contexts;
import liquibase.LabelExpression;
import liquibase.Liquibase;
import liquibase.database.DatabaseConnection;
import liquibase.database.DatabaseFactory;
import liquibase.exception.LiquibaseException;
import liquibase.resource.ClassLoaderResourceAccessor;
import liquibase.resource.ResourceAccessor;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.interceptor.Interceptor;

@ApplicationScoped
@Startup(Interceptor.Priority.LIBRARY_BEFORE)
public class LiquibaseMigrator {

	private static final Logger LOGGER = LoggerFactory.getLogger(LiquibaseMigrator.class);

	private ReactiveMongoClient reactiveMongoClient;
	@ConfigProperty(name = "quarkus.liquibase.change-log")
	String changeLogLocation;
	@ConfigProperty(name = "quarkus.mongodb.connection-string")
	String connectionString;

	@Inject
	public LiquibaseMigrator(final ReactiveMongoClient reactiveMongoClient) {
		this.reactiveMongoClient = reactiveMongoClient;
	}

	@PostConstruct
	public void runLiquibaseMigration() throws LiquibaseException {
		LOGGER.info("Starting Liquibase migration");

		final ResourceAccessor resourceAccessor = new ClassLoaderResourceAccessor(Thread.currentThread().getContextClassLoader());
		final DatabaseConnection conn = DatabaseFactory.getInstance().openConnection(connectionString, null, null, null, resourceAccessor);

		try (Liquibase liquibase = new Liquibase(changeLogLocation, resourceAccessor, conn)) {
			liquibase.update(new Contexts(), new LabelExpression());
		}

		LOGGER.info("Finished Liquibase migration");
	}

}
