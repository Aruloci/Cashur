package ch.cashur.web.controllers;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.eclipse.persistence.internal.oxm.record.deferred.EndEntityEvent;

import ch.cashur.ejb.ExpenseBeanLocal;
import ch.cashur.model.Expense;
import ch.cashur.model.User;

@ManagedBean
@RequestScoped
public class ExpenseController implements Serializable {
	private static final long serialVersionUID = 7352375610517201651L;
	private FacesContext facesContext = FacesContext.getCurrentInstance();
    private HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);	    
    
	@EJB
	ExpenseBeanLocal expense;
	
	private String category = "";
	private String value = "";
	private Double total = 0.0;
	
	public void addExpense() {
		expense.addExpense(category, value);
	}
		
	public Double getTotal(String category) {
		User user = (User) session.getAttribute("user");
		List<Expense> expenses = expense.getAllExpenses(user);
		total = 0.0;
		System.out.println(category);
		
		for (Expense e : expenses) {
			System.out.println(e.getCategory().getCategory() + ": " + e.getWert());
			if ( e.getWert() != null 
				 && !e.getWert().equals("") 
				 && e.getCategory().getCategory().equals(category)
			) {
				total += Double.parseDouble(e.getWert());
			}
		}

		return total;
	}
	
	public List<Expense> showLatestExpenses() {
		User user = (User) session.getAttribute("user");
		int size = expense.getAllExpenses().size();
		
		if(size < 5) {
			return expense.showLatestExpenses(user, size);
		}
		
		return expense.showLatestExpenses(user, 5);
	}
	
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}