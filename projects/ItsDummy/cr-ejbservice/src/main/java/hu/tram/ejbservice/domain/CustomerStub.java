package hu.ejbservice.domain;

public class CustomerStub {
	private String name;
	private String login_name;
	private String passwd;
	//addresses, emails...
	
	public CustomerStub() {
		this(null, null, null);
	}
	
	public CustomerStub(String name, String login_name, String passwd) {
		super();
		this.setName(name);
		this.setLogin_name(login_name);
		this.setPasswd(passwd);
	}

	String getName() {
		return name;
	}

	void setName(String name) {
		this.name = name;
	}

	String getLogin_name() {
		return login_name;
	}

	void setLogin_name(String login_name) {
		this.login_name = login_name;
	}

	String getPasswd() {
		return passwd;
	}

	void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	
	@Override
    public String toString() {
        return "CustomerStub [name=" + name + ", login name=" + login_name + ", passwd=" + passwd + "]";
    }
}
