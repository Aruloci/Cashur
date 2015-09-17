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
		
		for(Category c : categoryList) {
			if(c.getCategory().equals(categoryName)) {
				cat = c;
			}
		}
		expense.setWert(value);
		expense.setCategory(cat);
		expense.setDate("Jetzt");
		
		System.out.println("ExpenseBean >> Persist expense");
		this.addExpense(expense);
	}

	@Override
	public void addExpense(Expense expense) {
		em.persist(expense);
	}

}