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
@FacesValidator("profilePasswordValidator")
public class ProfilePasswordValidator implements Validator {

	@Override
	public void validate(FacesContext context, UIComponent component, Object value) {
		String password = (String) value;
		String newPassword = (String) component.getAttributes().get("newPassword");
		String confirm = (String) component.getAttributes().get("confirm");


		if (password == null || password.equals("")) {
			FacesContext.getCurrentInstance().addMessage("passwordForm:password", new FacesMessage("Password cannot be empty"));
		}
		
		if (confirm == null || confirm.equals("")) {
			FacesContext.getCurrentInstance().addMessage("passwordForm:confirm", new FacesMessage("Confirm cannot be empty"));
		}

		if (password.length() > 45) {
			FacesContext.getCurrentInstance().addMessage("passwordForm:password", new FacesMessage("New password is too long"));
		}
		
		if (password.length() < 4 || password.equals(null)) {
			FacesContext.getCurrentInstance().addMessage("passwordForm:password", new FacesMessage("New password is too short"));
		}
		
		if (!newPassword.equals(confirm)) {
			FacesContext.getCurrentInstance().addMessage("passwordForm:confirm", new FacesMessage("New passwords don't match"));
		} 
	}
}