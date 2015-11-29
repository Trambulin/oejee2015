package hu.tram.ejbservice.domain;

import java.util.List;

public class CustomerStub {
	private String name;
	private String login_name;
	private String passwd;
	private List<CustomerContactStub> contacts;
	
	public CustomerStub() {
		this(null, null, null);
	}
	
	public CustomerStub(String name, String login_name, String passwd) {
		super();
		this.setName(name);
		this.setLogin_name(login_name);
		this.setPasswd(passwd);
	}
	
	public CustomerStub(String name, String login_name, String passwd, List<CustomerContactStub> contacts) {
		super();
		this.setName(name);
		this.setLogin_name(login_name);
		this.setPasswd(passwd);
		this.setContacts(contacts);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLogin_name() {
		return login_name;
	}

	public void setLogin_name(String login_name) {
		this.login_name = login_name;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	
	public List<CustomerContactStub> getContacts() {
		return contacts;
	}

	public void setContacts(List<CustomerContactStub> contacts) {
		this.contacts = contacts;
	}
	
	@Override
    public String toString() {
        return "CustomerStub [name=" + name + ", login name=" + login_name + ", passwd=" + passwd + "]";
    }
}
