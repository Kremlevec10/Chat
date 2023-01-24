package chatapplication.database.pojo;

public class User {
	
	private String login;
	private String eMail;
	private String password;
	
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
	
	public void saveIntoUser(String login, String eMail, String password) {
		this.login = login;
		this.eMail = eMail;
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [login=" + login + ", eMail=" + eMail + ", password=" + password + "]";
	}
	
	
	

}
