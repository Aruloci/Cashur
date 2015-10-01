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
@FacesValidator("nameValidator")
public class NameValidator implements Validator {

	@Override
	public void validate(FacesContext context, UIComponent component, Object value) {
		String name = (String) value;

		if (name == null || name.equals("") ) {
			FacesContext.getCurrentInstance().addMessage("registerForm:name", new FacesMessage("Name cannot be empty"));
		}
		
		if (name.length() > 45) {
			FacesContext.getCurrentInstance().addMessage("registerForm:name", new FacesMessage("Name is too long"));
		}
		
		if(!name.matches("^[a-zA-Z]+")) {
			FacesContext.getCurrentInstance().addMessage("registerForm:name", new FacesMessage("Please enter letters from a-z only"));
		}
	}
}