package ch.cashur.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the expense database table.
 * 
 */
@Entity
@NamedQuery(name = "Expense.findAll", query = "SELECT e FROM Expense e")
public class Expense implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ExpensePK id;

	private String date;

	private String wert;

	// bi-directional many-to-one association to Category
	@ManyToOne
	@JoinColumns({ @JoinColumn(name = "CATEGORY_ID_Category", referencedColumnName = "ID_Category"),
			@JoinColumn(name = "CATEGORY_USER_ID", referencedColumnName = "USER_ID") })
	private Category category;

	public Expense() {
	}

	public ExpensePK getId() {
		return this.id;
	}

	public void setId(ExpensePK id) {
		this.id = id;
	}

	public String getDate() {
		return this.date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getWert() {
		return this.wert;
	}

	public void setWert(String wert) {
		this.wert = wert;
	}

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

}