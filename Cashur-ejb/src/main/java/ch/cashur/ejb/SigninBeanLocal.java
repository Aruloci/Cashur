package ch.cashur.ejb;

import javax.ejb.Local;

@Local
public interface SigninBeanLocal {

	/**
	 * Login a user with the the given email and password
	 * @param user
	 */
	public void signinCustomer(String email, String password);
}
