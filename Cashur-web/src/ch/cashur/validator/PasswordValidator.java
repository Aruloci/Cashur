package ch.cashur.validator;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.inject.Named;

@Named
@RequestScoped
@FacesValidator("confirmPasswordValidator")
public class PasswordValidator implements Validator {

	boolean validate;

	@Override
	public void validate(FacesContext context, UIComponent component, Object value) {
		String password = (String) value;
		String confirm = (String) component.getAttributes().get("confirm");

		if (password == null || confirm == null) {
			return; // Just ignore and let required="true" do its job.
		}

		if (password.length() > 16) {
			FacesContext.getCurrentInstance().addMessage("hallowelt",new FacesMessage("test:password", "please"));
		} else if (password.length() < 4 || password.equals(null)) {
			validate = true;
			new FacesMessage("Passwort zu kurz.");

		} else if (!password.equals(confirm)) {
			new FacesMessage("Passwörter sind nicht gleich.");
		} 

	}

	public boolean isValidate() {
		return validate;
	}

	public void setValidate(boolean validate) {
		this.validate = validate;
	}

}