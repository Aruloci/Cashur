package ch.cashur.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ch.cashur.model.User;

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
	public String registerCustomer(User user) {
		em.persist(user);
		return null;
	}
}
