package com.datascience.service;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Map;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.datascience.core.JobsManager;
import com.datascience.serialization.ISerializer;
import org.apache.log4j.Logger;
import org.joda.time.DateTime;

import com.datascience.core.storages.IJobStorage;
import com.datascience.executor.CommandStatusesContainer;
import com.datascience.executor.ProjectCommandExecutor;

/**
 * @author Konrad
 *
 * this initializing commands shouldn't use ServletContext or even be here
 * TODO: ^^^^
 *
 */
public class InitializationSupport implements ServletContextListener {

	private static Logger logger = Logger.getLogger(InitializationSupport.class);
	private ServletContext scontext;

	@Override
	public void contextInitialized(ServletContextEvent event) {
		try {
			logger.info("Initialization support started");

			scontext = event.getServletContext();
			Properties props = new Properties();
			props.load(scontext.getResourceAsStream("/WEB-INF/classes/troia.properties"));
			scontext.setAttribute(Constants.PROPERTIES, props);

			scontext.setAttribute(Constants.DEPLOY_TIME, DateTime.now());

			logger.info("Initialization support ended without complications");
		}
		catch (Exception e) {
			logger.fatal("In context initialization support", e);
		}
	}

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		logger.info("STARTED Cleaning service");
		ServletContext scontext = event.getServletContext();
		IJobStorage jobStorage =
			(IJobStorage) scontext.getAttribute(Constants.JOBS_STORAGE);
		ProjectCommandExecutor executor =
			(ProjectCommandExecutor) scontext.getAttribute(Constants.COMMAND_EXECUTOR);
		try {
			jobStorage.stop();
		} catch (Exception ex) {
			logger.error("FAILED Cleaning service - jobStorage", ex);
		}
		// executor might be already closed - if jobStorage was using it
		try {
			executor.stop();
		} catch (Exception ex) {
			logger.error("FAILED Cleaning service - executor", ex);
		}
		deregisterDrivers();
		logger.info("DONE Cleaning service");
	}

		
	/**
	 * This manually deregisters JDBC driver, which prevents
	 * Tomcat 7 from complaining about memory leaks wrto this class
	 * @see: http://stackoverflow.com/a/5315467/1585082
	 */
	public void deregisterDrivers() {
		Enumeration<Driver> drivers = DriverManager.getDrivers();
		while (drivers.hasMoreElements()) {
			Driver driver = drivers.nextElement();
			try {
				DriverManager.deregisterDriver(driver);
				logger.info(String.format("deregistering jdbc driver: %s", driver));
			} catch (SQLException e) {
				logger.fatal(String.format("Error deregistering driver %s", driver), e);
			}
		}
	}
}
