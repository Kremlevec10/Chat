package database;

import org.hibernate.SessionFactory;

public class InstanceSessionFactory {
	
	private static SessionFactory sessionFactory;
	
	private static void initSessionFactory() {
		if (sessionFactory == null) {
			sessionFactory = InstanceConfiguration.getConfiguration().buildSessionFactory();
		}
	}
	
	public static SessionFactory getSessionFactory() {
		initSessionFactory();
		return sessionFactory;
	}

}
