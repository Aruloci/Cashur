package ch.cashur.ejb;

import javax.ejb.Stateless;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpSession;

import ch.cashur.model.User;

@Stateless
// @NamedQuery(name="JPAUserFunctions.findUser", query="SELECT f FROM f where
// email = f")
public class ProfileBean implements ProfileBeanLocal {

	@PersistenceContext
	EntityManager em;

	private FacesContext facesContext = FacesContext.getCurrentInstance();
    private HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);
	User user = (User) session.getAttribute("user");  
   
    @Override
	public void changeMail(String email) {
		em.createQuery("UPDATE User SET email = '" + email + "' WHERE ID_User =" + user.getID_User()).executeUpdate();
		user.setEmail(email);
		session.setAttribute("user", user);
    }
	@Override
	public void changePassword(String password, String confirmPassword) {
		if(password.equals(confirmPassword)) {
			//change the password
			em.createQuery("UPDATE User SET password = '" + password + "' WHERE ID_User =" + user.getID_User()).executeUpdate();
			user.setPassword(password);
			session.setAttribute("user", user);
			System.out.println("JAAAAA");
		} else {
			System.out.println("Passwort inkorrekt");
		}
	}
	
    
}