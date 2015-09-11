package ch.cashur.web.controllers;
import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;

import ch.cashur.ejb.SigninBeanLocal;

@ManagedBean
@RequestScoped
public class SigninController implements Serializable {
	private static final long serialVersionUID = 1L;
	private String email;
	private String password;

	@EJB
	private SigninBeanLocal signinBeanLocal;

	public void signinCustomer() {
		System.out.println("SigninController >> singinCustomer");
		signinBeanLocal.signinCustomer(email, password);
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
}