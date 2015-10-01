package ch.cashur.validator;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.inject.Named;

@Named
@RequestScoped
@FacesValidator("firstNameValidator")
public class FirstNameValidator implements Validator {

	@Override
	public void validate(FacesContext context, UIComponent component, Object value) {
		String firstName = (String) value;

		if (firstName == null || firstName.equals("") ) {
			FacesContext.getCurrentInstance().addMessage("registerForm:firstName", new FacesMessage("Firstname cannot be empty"));
		}
		
		if (firstName.length() > 45) {
			FacesContext.getCurrentInstance().addMessage("registerForm:firstName", new FacesMessage("Firstname is too long"));
		}
		
		if(!firstName.matches("^[a-zA-Z]+")) {
			FacesContext.getCurrentInstance().addMessage("registerForm:firstName", new FacesMessage("Please enter letters from a-z only"));
		}
	}
}