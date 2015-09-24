package ch.cashur.web.controllers;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
	private String color;
	
	private FacesContext facesContext = FacesContext.getCurrentInstance();
    private HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);
    
	@EJB
	private CategoryBeanLocal categoryBeanLocal;
	
	public void addCategory() {
		Category cat = new Category();
		cat.setCategory(category);
		cat.setColor(color);
		
		categoryBeanLocal.addCategory(cat);
	}

	public List<Category> getAllCategories() {
		List<Category> categories = new ArrayList<Category>();
		for(Category c : categoryBeanLocal.getAllCategories((User) session.getAttribute("user"))) {
			categories.add(c);
		}
		return categories;
	}
	
	/* GETTERS and SETTERS */
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
}