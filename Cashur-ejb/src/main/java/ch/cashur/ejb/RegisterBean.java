package ch.cashur.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class RegisterBean implements RegisterBeanLocal {

	@PersistenceContext
	EntityManager em;
	
    /**
     * Default constructor. 
     */
    public RegisterBean() {
    	super();
    }

	@Override
	public String registerCustomer(String firstname, String surname, String username, String password) {
		return null;		
	}
}
