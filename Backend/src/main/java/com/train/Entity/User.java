package com.train.Entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User extends Person {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "UserId")
	private int id;

	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private List<Ticket> ticket;

	public User() {

	}

	public User(String firstName, String lastName, String email, String phone, String password, Date createdOn,
			String address, Role role, int id, List<Ticket> ticket) {
		super(firstName, lastName, email, phone, password, createdOn, address, role);
		this.id = id;
		this.ticket = ticket;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
