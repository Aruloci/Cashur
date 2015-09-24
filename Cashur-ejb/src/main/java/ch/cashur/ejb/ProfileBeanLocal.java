package ch.cashur.ejb;

import javax.ejb.Local;

@Local
public interface ProfileBeanLocal {

	/**
	 * Changes the existing email
	 * @param email
	 */
	public void changeMail(String email);
	
	/**
	 * Changes the existing password
	 * @param password
	 * @param confirmPassword
	 */
	public void changePassword(String password, String confirmPassword);
}
