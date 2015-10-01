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
@FacesValidator("confirmPasswordValidator")
public class PasswordValidator implements Validator {

	@Override
	public void validate(FacesContext context, UIComponent component, Object value) {
		String password = (String) value;
		String confirm = (String) component.getAttributes().get("confirm");

		if (password == null || password.equals("")) {
			FacesContext.getCurrentInstance().addMessage("registerForm:password", new FacesMessage("Password cannot be empty"));
		}
		
		if (confirm == null || confirm.equals("")) {
			FacesContext.getCurrentInstance().addMessage("registerForm:confirm", new FacesMessage("Confirm cannot be empty"));
		}

		if (password.length() > 45) {
			FacesContext.getCurrentInstance().addMessage("registerForm:password", new FacesMessage("Password is too long"));
		} else if (password.length() < 4 || password.equals(null)) {
			FacesContext.getCurrentInstance().addMessage("registerForm:password", new FacesMessage("Password is too short"));

		} else if (!password.equals(confirm)) {
			FacesContext.getCurrentInstance().addMessage("registerForm:confirm", new FacesMessage("Passwords don't match"));
		} 

	}
}