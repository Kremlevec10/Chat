package database;

import org.hibernate.cfg.Configuration;

import chatapplication.database.pojo.User;

public class InstanceConfiguration {
	
	private static Configuration configuration;
	
	private static void initConfiguration() {
		if (configuration == null) {
			configuration = new Configuration().configure();
			configuration.addAnnotatedClass(User.class);
		}
	}
	
	public static Configuration getConfiguration() {
		initConfiguration();
		return configuration;
	}

}
