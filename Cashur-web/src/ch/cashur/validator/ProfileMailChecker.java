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
@FacesValidator("profileMailValidator")
public class ProfileMailChecker implements Validator {

	@Override
	public void validate(FacesContext context, UIComponent component, Object value) {
		String email = (String) value;		
		
		if(!email.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")) {
			FacesContext.getCurrentInstance().addMessage("mailForm:email", new FacesMessage("Please enter a valid email"));
		}
	}
}