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
@FacesValidator("categoryValidator")
public class CategoryValidator implements Validator {

	@Override
	public void validate(FacesContext context, UIComponent component, Object value) {
		String category = (String) value;

		if (category == null || category.equals("") ) {
			FacesContext.getCurrentInstance().addMessage("categoryForm:category", new FacesMessage("Category cannot be empty"));
		}
		
		if (category.length() > 16) {
			FacesContext.getCurrentInstance().addMessage("categoryForm:category", new FacesMessage("Category is too long"));
		}
		
		if(!category.matches("^[a-zA-Z0-9]+")) {
			FacesContext.getCurrentInstance().addMessage("categoryForm:category", new FacesMessage("Please enter letters from a-z only"));
		}
	}
}