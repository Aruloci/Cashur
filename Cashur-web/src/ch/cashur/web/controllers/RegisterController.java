package ch.cashur.web.controllers;
import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;

import ch.cashur.ejb.RegisterBeanLocal;

@ManagedBean
@RequestScoped
public class RegisterController implements Serializable {
	private static final long serialVersionUID = 1L;
	private String firstName;
	private String surName;
	private String email;
	private String password;
	private String confirm;
	boolean registered = false;

	@EJB
	private RegisterBeanLocal registerBeanLocal;

	public boolean registerCustomer() {
		if(registerBeanLocal.checkPassword(password, confirm)) {
			registerBeanLocal.registerCustomer(firstName, surName, email, password);
		} else {
			System.out.println("RegisterController >> Password does not match");
			registered = false;
		}
		return registered;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSurName() {
		return surName;
	}

	public void setSurName(String surName) {
		this.surName = surName;
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

	public String getConfirm() {
		return confirm;
	}

	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}

	public boolean isRegistered() {
		return registered;
	}

	public void setRegistered(boolean registered) {
		this.registered = registered;
	}
}