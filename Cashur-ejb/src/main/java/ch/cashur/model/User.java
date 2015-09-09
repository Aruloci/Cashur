package ch.cashur.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
	
	@Id
	@Column(name = "ID_User")
	private int idUser;
	
	@Column(name = "firstname")
	private String firstname;

	@Column(name = "surname")
	private String surname;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "currency")
	private String currency;
	
	// Getters and setters
	
	public int getIdUser() {
		return idUser;
	}
	
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	
	public String getFirstname() {
		return firstname;
	}
	
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	public String getSurname() {
		return surname;
	}
	
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getCurrency() {
		return currency;
	}
	
	public void setCurrency(String currency) {
		this.currency = currency;
	}
}
