package ch.cashur.web.controllers;
import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import ch.cashur.ejb.CategoryBeanLocal;
import ch.cashur.model.Category;
import ch.cashur.model.User;

@ManagedBean
@RequestScoped
public class CategoryController implements Serializable {
	private static final long serialVersionUID = 1L;

	private String category;

	private FacesContext facesContext = FacesContext.getCurrentInstance();
    private HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);
    
	@EJB
	private CategoryBeanLocal categoryBeanLocal;
	
	public void addCategory() {
		Category cat = new Category();
		cat.setCategory(category);
		
		categoryBeanLocal.addCategory(cat);
	}
	
	public void getAllCategories() {
		categoryBeanLocal.getAllCategories((User) session.getAttribute("user"));
	}

	/* GETTERS and SETTERS */
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
}