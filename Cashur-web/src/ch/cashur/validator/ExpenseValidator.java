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
@FacesValidator("expenseValidator")
public class ExpenseValidator implements Validator {

	@Override
	public void validate(FacesContext context, UIComponent component, Object value) {
		String price = (String) value;

		if (price == null || price.equals("")) {
			FacesContext.getCurrentInstance().addMessage("expenseForm:price", new FacesMessage("Enter an expense"));
		}
		
		if (price.length() > 45) {
			FacesContext.getCurrentInstance().addMessage("expenseForm:price", new FacesMessage("Number is too big"));
			System.out.println("Expense zu lang");
		}
	}
}