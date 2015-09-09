package ch.cashur.ejb;

import javax.ejb.Local;

import ch.cashur.model.User;

@Local
public interface RegisterBeanLocal {

	public String registerCustomer(User user);
}
