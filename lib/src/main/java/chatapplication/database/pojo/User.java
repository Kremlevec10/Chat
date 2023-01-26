package chatapplication.database.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {
	
	@Id
	private String eMail;
	private String login;
	private String password;
	private boolean isAdministrator;
	
	public boolean isAdministrator() {
		return isAdministrator;
	}

	public void setAdministrator(boolean isAdministrator) {
		this.isAdministrator = isAdministrator;
	}

	public User() {}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	public void saveIntoUser(String login, String eMail, String password, boolean isAdministrator) {
		this.login = login;
		this.eMail = eMail;
		this.password = password;
		this.isAdministrator = isAdministrator;
	}

	@Override
	public String toString() {
		return "User [login=" + login + ", eMail=" + eMail + ", password=" + password + "]";
	}
	
	
	

}
