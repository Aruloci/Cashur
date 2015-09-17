package ch.cashur.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ch.cashur.model.Category;
import ch.cashur.model.Expense;
import ch.cashur.model.User;

@Stateless
public class ExpenseBean implements ExpenseBeanLocal {

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

	@Override
	public List<Expense> getAllExpenses(User user) {
		List<Expense> expenseList = this.getAllExpenses();
		List<Expense> result = new ArrayList<Expense>();
		
		for (Expense existingExp : expenseList) {
			if (existingExp.getCategory().getUser().getID_User() == user.getID_User()) {
				result.add(existingExp);
			}
		}
		return result;
	}

	@Override
	public List<Expense> getAllExpenses() {
		List<Expense> expenseList = new ArrayList<Expense>();
		expenseList = em.createNamedQuery("Expense.findAll", Expense.class).getResultList();
		
		return expenseList;
	}
}