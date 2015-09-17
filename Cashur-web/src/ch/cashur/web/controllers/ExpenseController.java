package ch.cashur.web.controllers;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;

import ch.cashur.ejb.ExpenseBeanLocal;

@ManagedBean
@RequestScoped
public class ExpenseController implements Serializable {
	private static final long serialVersionUID = 7352375610517201651L;

	@EJB
	ExpenseBeanLocal expense;
	
	private String category = "";
	private String value = "";
	
	public void addExpense() {
		expense.addExpense(category, value);
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}