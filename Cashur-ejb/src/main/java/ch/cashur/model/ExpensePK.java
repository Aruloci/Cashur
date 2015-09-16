package ch.cashur.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the expense database table.
 * 
 */
@Embeddable
public class ExpensePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private int ID_Expense;

	@Column(insertable=false, updatable=false)
	private int CATEGORY_ID_Category;

	@Column(name="CATEGORY_USER_ID", insertable=false, updatable=false)
	private int categoryUserId;

	public ExpensePK() {
	}
	public int getID_Expense() {
		return this.ID_Expense;
	}
	public void setID_Expense(int ID_Expense) {
		this.ID_Expense = ID_Expense;
	}
	public int getCATEGORY_ID_Category() {
		return this.CATEGORY_ID_Category;
	}
	public void setCATEGORY_ID_Category(int CATEGORY_ID_Category) {
		this.CATEGORY_ID_Category = CATEGORY_ID_Category;
	}
	public int getCategoryUserId() {
		return this.categoryUserId;
	}
	public void setCategoryUserId(int categoryUserId) {
		this.categoryUserId = categoryUserId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ExpensePK)) {
			return false;
		}
		ExpensePK castOther = (ExpensePK)other;
		return 
			(this.ID_Expense == castOther.ID_Expense)
			&& (this.CATEGORY_ID_Category == castOther.CATEGORY_ID_Category)
			&& (this.categoryUserId == castOther.categoryUserId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.ID_Expense;
		hash = hash * prime + this.CATEGORY_ID_Category;
		hash = hash * prime + this.categoryUserId;
		
		return hash;
	}
}