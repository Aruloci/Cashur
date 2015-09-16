package ch.cashur.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ch.cashur.model.User;

@Stateless
public class RegisterBean implements RegisterBeanLocal {

	@PersistenceContext
	EntityManager em;
	
	private String firstName;
	private String surName;
	private String email;
	private String password;
	private String confirm;
	
	private User user = new User();

	/**
	 * Default constructor.
	 */
	public RegisterBean() {
	}

	@Override
	public void registerCustomer(String firstname, String surname, String email, String password) {

		user.setCurrency("CHF");
		user.setFirstname(firstname);
		user.setSurname(surname);
		user.setEmail(email);
		user.setPassword(password);

		System.out.println("RegisterBean >> registerCustomer");
		
		em.persist(user);
	}
	
	@Override
	public void registerCustomer(User user) {
		em.persist(user);
	}
	
	@Override
	public boolean checkPassword(String password, String confirm) {
		boolean equal = true;
		System.out.println("RegisterBean >> checkPassword");
		if(password.equals(confirm)) {
			System.out.println("RegisterBean >> Password is equal");
			equal = true;
		} else {
			System.out.println("RegisterBean >> Password is unequal");
			equal = false;
		}
		return equal;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSurName() {
		return surName;
	}

	public void setSurName(String surName) {
		this.surName = surName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirm() {
		return confirm;
	}

	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}	
}
