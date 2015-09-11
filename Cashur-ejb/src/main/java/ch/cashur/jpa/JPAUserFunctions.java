package ch.cashur.jpa;

import javax.persistence.EntityManager;

public class JPAUserFunctions {

	EntityManager em;
	
	public void findAllUsers() {
		em.createQuery("SELECT * FROM user");
	}

	public void findUser(String email) {
		em.createQuery("SELECT * FROM user where email = " + email);
	}

	public void findUser(int id) {
		em.createQuery("SELECT ID_User FROM user WHERE ID_User = " + id);
	}

	public void deleteUser(String email) {
		em.createQuery("DELETE * FROM user WHERE email = " + email);
	}

	public void deleteUser(int id) {
		em.createQuery("DELETE * FROM user WHERE ID_User = " + id);
	}
	
	public void updateUser(String table, String email) {
		em.createQuery("UPDATE " + table + " FROM user WHERE email = " + email);
	}
	
	public void updateUser(String table, int id) {
		em.createQuery("UPDATE " + table + " FROM user WHERE ID_User = " + id);
	}
}
