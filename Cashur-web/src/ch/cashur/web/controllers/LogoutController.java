package ch.cashur.web.controllers;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

@ManagedBean
@RequestScoped
public class LogoutController implements Serializable{
	private static final long serialVersionUID = 1L;
	private FacesContext facesContext = FacesContext.getCurrentInstance();
    private HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);
	
	public void logoutCustomer() {
		session.setAttribute("isLoggedIn", false);
		session.setAttribute("User", null);
		
		System.out.println(session.getAttribute("isLoggedIn"));
	}
}