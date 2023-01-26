package database;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import chatapplication.database.pojo.User;

public class ListRegistrationUser {

	private static List<User> listUsers;
	private static List<String> eMails;
	private static List<String> passwords;
	private static List<String> logins;

	public static void initListUsers() {
		if (listUsers == null) {
			SessionFactory sessionFactory = InstanceSessionFactory.getSessionFactory();
			Session session = sessionFactory.openSession();
			session.getTransaction().begin();
			listUsers = session.createQuery("FROM User", User.class).getResultList();
			session.getTransaction().commit();
			session.close();
		}
	}

	public static List<User> getListUsers() {
		return listUsers;
	}
	
	public static List<String> getEmails() {
		initListUsers();
		if (eMails == null) {
			eMails = new ArrayList<>();
			for (User user : listUsers) {
				eMails.add(user.geteMail());
			}
		}
		return eMails;
	}
	
	public static List<String> getPasswords() {
		initListUsers();
		if (passwords == null) {
			passwords = new ArrayList<>();
			for (User user : listUsers) {
				passwords.add(user.getPassword());
			}
		}
		return passwords;
	}
	
	public static List<String> getLogins() {
		initListUsers();
		if (logins == null) {
			logins = new ArrayList<>();
			for (User user : listUsers) {
				logins.add(user.getLogin());
			}
		}
		return logins;
	}
	
}
