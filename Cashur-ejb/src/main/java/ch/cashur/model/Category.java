package ch.cashur.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the category database table.
 * 
 */
@Entity
@NamedQuery(name="Category.findAll", query="SELECT c FROM Category c")
public class Category implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CategoryPK id;

	private String category;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="USER_ID")
	private User user;

	//bi-directional many-to-one association to Expense
	@OneToMany(mappedBy="category")
	private List<Expense> expenses;

	public Category() {
	}

	public CategoryPK getId() {
		return this.id;
	}

	public void setId(CategoryPK id) {
		this.id = id;
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Expense> getExpenses() {
		return this.expenses;
	}

	public void setExpenses(List<Expense> expenses) {
		this.expenses = expenses;
	}

	public Expense addExpens(Expense expens) {
		getExpenses().add(expens);
		expens.setCategory(this);

		return expens;
	}

	public Expense removeExpens(Expense expens) {
		getExpenses().remove(expens);
		expens.setCategory(null);

		return expens;
	}

}