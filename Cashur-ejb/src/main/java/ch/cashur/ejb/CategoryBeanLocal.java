package ch.cashur.ejb;

import java.util.List;

import javax.ejb.Local;

import ch.cashur.model.Category;
import ch.cashur.model.User;

@Local
public interface CategoryBeanLocal {

	/**
	 * Fügt eine neue Kategorie für den angebenen Benutzer hinzu
	 * @param category
	 * @param user
	 */
	public void addCategory(Category category, User user);
	
	/**
	 * Fügt eine neue Kategorie für den angebenen Benutzer hinzu
	 * @param category
	 * @param email
	 */
	public void addCategory(String category, String email);
	
	/**
	 * Fügt eine neue Kategorie hinzu.
	 * @param category
	 */
	public void addCategory(Category category);
	
	public List<Category> getAllCategories(User user);
}