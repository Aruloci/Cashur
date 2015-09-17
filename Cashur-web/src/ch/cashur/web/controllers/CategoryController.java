package ch.cashur.web.controllers;
import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;

import ch.cashur.ejb.CategoryBeanLocal;
import ch.cashur.model.Category;

@ManagedBean
@RequestScoped
public class CategoryController implements Serializable {
	private static final long serialVersionUID = 1L;

	private String category;
	
	@EJB
	private CategoryBeanLocal categoryBeanLocal;
	
	public void addCategory() {
		Category cat = new Category();
		cat.setCategory(category);
		
		categoryBeanLocal.addCategory(cat);
		System.out.println("Category '" + cat.getCategory() + "' added!");
	}

	/* GETTERS and SETTERS */
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
}