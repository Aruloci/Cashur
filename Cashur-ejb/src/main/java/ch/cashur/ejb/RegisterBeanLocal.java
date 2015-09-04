package ch.cashur.ejb;

import javax.ejb.Local;

@Local
public interface RegisterBeanLocal {

	public String registerCustomer(String firstname, String surname,String username, String password);
}
