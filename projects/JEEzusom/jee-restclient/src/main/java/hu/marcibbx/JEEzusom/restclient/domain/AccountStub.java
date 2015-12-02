package hu.marcibbx.JEEzusom.restclient.domain;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "account")
public class AccountStub {


	public AccountStub() {

	}
/*
	@XmlElement(name = "subject")
	public SubjectStub getSubject() {
		return this.subject;
	}

	@XmlElement(name = "grade")
	public int getGrade() {
		return this.grade;
	}

	@XmlElement(name = "note")
	public String getNote() {
		return this.note;
	}

	@XmlElement(name = "date")
	public Date getDate() {
		return this.date;
	}

	public void setSubject(SubjectStub subject) {
		this.subject = subject;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public void setDate(Date date) {
		this.date = date;
	}
*/
	@Override
	public String toString() {
		return "AccountStub]";
	}

}
