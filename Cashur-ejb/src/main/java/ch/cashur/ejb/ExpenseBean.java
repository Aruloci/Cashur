package ch.cashur.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpSession;

import ch.cashur.model.Category;
import ch.cashur.model.Expense;
import ch.cashur.model.User;

@Stateless
public class ExpenseBean implements ExpenseBeanLocal {

	FacesContext facesContext = FacesContext.getCurrentInstance();
    HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);
	
	@PersistenceContext
	EntityManager em;

	@Override
	public void addExpense(String categoryName, String value) {
		List<Category> categoryList = new ArrayList<Category>();
		categoryList = em.createNamedQuery("Category.findAll", Category.class).getResultList();
		
		Category cat = new Category();
		Expense expense = new Expense();
		User user = (User) session.getAttribute("user");
		
		for(Category c : categoryList) {
			System.out.println("Categories: " + c.getCategory());
			if(c.getCategory().equals(categoryName)) {
				cat.setCategory(categoryName);
				cat.setId(c.getId());
				cat.setUser(user);
				System.out.println("Kategorie gefunden");
			} else {
				System.out.println("Kategorie nicht gefunden");
			}
		}
		expense.setWert(value);
		expense.setCategory(cat);
		expense.setDate("Jetzt");
		
		System.out.println("Wert: " + expense.getWert());
		System.out.println("Category: " + expense.getCategory().getCategory());
		System.out.println("Date: " + expense.getDate());
		System.out.println("Email: " + user.getEmail());
	
		
		System.out.println("ExpenseBean >> Persist expense");
		em.persist(expense);
	}

	@Override
	public void addExpense(Expense expense) {
		em.persist(expense);
	}

}