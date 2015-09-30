package ch.cashur.ejb;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpSession;

import ch.cashur.model.Category;
import ch.cashur.model.User;

@Stateless
public class CategoryBean implements CategoryBeanLocal {
	private static final Logger LOG = Logger.getLogger(CategoryBean.class.getName());
	
	@PersistenceContext
	EntityManager em;
	
	private FacesContext facesContext = FacesContext.getCurrentInstance();
    private HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);

    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	Calendar calendar = Calendar.getInstance();
    
	@Override
	public void addCategory(Category category, User user) {
		category.setUser(user);
		category.setCreationDate(dateFormat.format(calendar.getTime()));

		if (!isAlreadyExisting(this.getAllCategories(user), category, user)) {
			em.persist(category);
			LOG.log(Level.INFO, "Kategorie '" + category.getCategory() + "' von '" + user.getEmail() + "' erstellt", category.getCategory());
		} else {
			//TODO Feedback geben
			LOG.log(Level.INFO, "Kategorie '" + category.getCategory() + "' vorhanden", category.getCategory());
		}
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

	@Override
	public List<Category> getAllCategories(User user) {
		List<Category> categories = new ArrayList<Category>();
		List<Category> result = new ArrayList<Category>();
		categories = em.createNamedQuery("Category.findAll", Category.class).getResultList();
		
		for (Category cat : categories) {
			if (cat.getUser().getID_User() == user.getID_User()) {
				result.add(cat);
			}
		}
		return result;
	}
	
	private boolean isAlreadyExisting(List<Category> categories, Category newCat, User user) {
		for (Category cat : categories) {
			if (cat.getCategory().toLowerCase().equals(newCat.getCategory().toLowerCase())) {
				if (cat.getUser().getID_User() == user.getID_User()) {
					return true;
				}
			}
		}
		return false;
	}
}