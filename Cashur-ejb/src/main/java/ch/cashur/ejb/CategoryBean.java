package ch.cashur.ejb;

import javax.ejb.Stateless;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpSession;

import ch.cashur.model.Category;
import ch.cashur.model.User;

@Stateless
public class CategoryBean implements CategoryBeanLocal {
	
	@PersistenceContext
	EntityManager em;
	
	private FacesContext facesContext = FacesContext.getCurrentInstance();
    private HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);

	@Override
	public void addCategory(Category category, User user) {
		category.setUser(user);
		em.persist(category);
	}

	@Override
	public void addCategory(String category, String email) {
		Category cat = new Category();
		User user = new User();
		
		cat.setCategory(category);
		user.setEmail(email);
		this.addCategory(cat, user);
	}

	@Override
	public void addCategory(Category category) {
		User user = (User) session.getAttribute("user");
		this.addCategory(category, user);
	}
}