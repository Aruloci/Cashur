package ch.cashur.web.controllers;
import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import ch.cashur.ejb.ProfileBeanLocal;
import ch.cashur.model.User;

@ManagedBean
@RequestScoped
public class ProfileController implements Serializable {
	private static final long serialVersionUID = 1L;
	private String oldPassword;
	private String password;
	private String confirmPassword;
	private String email;
	
	private FacesContext facesContext = FacesContext.getCurrentInstance();
    private HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);	
	
	@EJB
	private ProfileBeanLocal profileBeanLocal;
	
	public void changePassword() {
		User user = (User) session.getAttribute("user");
		if(oldPassword.equals(user.getPassword())) {
			profileBeanLocal.changePassword(password, confirmPassword);
		} else {
			System.out.println("Old Password incorrect");
		}
	}
	
	public void changeEmail() {
		profileBeanLocal.changeMail(email);
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}