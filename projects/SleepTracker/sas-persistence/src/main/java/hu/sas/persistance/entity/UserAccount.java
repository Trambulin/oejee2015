package hu.sas.persistance.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.Table;

@Entity
@Table(name="User_account")
@NamedQueries(value = {//
		@NamedQuery(name = SleepQuery.GET_BY_ISBN, query = "SELECT b FROM Book b WHERE b.isbn=:" + BookParameter.ISBN),
})

public class UserAccount {

}
