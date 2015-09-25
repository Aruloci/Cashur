package ch.cashur.ejb;

import java.util.List;
import java.util.TreeMap;

import javax.ejb.Local;

import ch.cashur.model.Expense;
import ch.cashur.model.User;

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
	
	/**
	 * Gibt eine Liste der Ausgaben des Benutzers zurück
	 * @param user
	 * @return
	 */
	public List<Expense> getAllExpenses(User user);
	
	/**
	 * Gibt eine Liste aller Ausgaben zurück
	 * @return
	 */
	public List<Expense> getAllExpenses();
	
	/**
	 * Gibt die letzten Ausgaben zurück
	 * @return
	 */
	public List<Expense> showLatestExpenses(User user, int amount);
	
	/**
	 * Gibt eine Liste aller Ausgaben des
	 * aktuellen Monates zurück
	 * @return
	 */
	public List<Expense> getAllExpensesOfCurrentMonth();
	
	
	public TreeMap<Integer, TreeMap<String, TreeMap<Integer, List<Expense>>>> getAllExpensesOfYear();
}