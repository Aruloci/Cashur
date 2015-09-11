package ch.cashur.ejb;

import javax.ejb.Local;

import ch.cashur.model.User;

@Local
public interface SigninBeanLocal {

	/**
	 * Login a user with the the given email and password
	 * @param user
	 */
	public void signinCustomer(String email, String password);
}
