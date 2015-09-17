package ch.cashur.ejb;

import javax.ejb.Local;

import ch.cashur.model.Category;
import ch.cashur.model.Expense;

@Local
public interface ExpenseBeanLocal {

	/**
	 * Adds a new expense entry to the database
	 * @param category
	 * @param value
	 */
	public void addExpense(String category, String value);
	
	/**
	 * Adds a new expense entry to the database
	 * @param expense
	 */
	public void addExpense(Expense expense);
}
