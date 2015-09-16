package ch.cashur.ejb;

import javax.ejb.Local;

import ch.cashur.model.User;

@Local
public interface RegisterBeanLocal {

	/**
	 * Registers a user with the given User-object
	 * @param user
	 * @return String
	 */
	public void registerCustomer(User user);
	
	/**
	 * Registers a user with the given values of the register field
	 * @param firstname
	 * @param surname
	 * @param email
	 * @param password
	 * @return String
	 */
	public void registerCustomer(String firstname, String surname, String email, String password);
	
	/**
	 * Checks if the two passwords are equal
	 * @param password
	 * @param confirm
	 * @return boolean
	 */
	public boolean checkPassword(String password, String confirm);
}
