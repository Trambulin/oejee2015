package hu.nik.condominium.ejbservice.domain;

public class UserStub {

	private String login;
	private String pass;
	private String email;
	private String fullName;
	
	public UserStub(String login,String pass,String email,String fullName)
	{
		this.login = login;
		this.pass = pass;
		this.email = email;
		this.fullName = fullName;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	@Override
	public String toString() {
		return "Login: "+ this.login+", Password: "+this.pass+", Email: "+this.email+", Name: "+this.fullName;
	}
}
