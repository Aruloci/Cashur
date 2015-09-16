package ch.cashur.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the category database table.
 * 
 */
@Embeddable
public class CategoryPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private int ID_Category;

	@Column(name="USER_ID", insertable=false, updatable=false)
	private int userId;

	public CategoryPK() {
	}
	public int getID_Category() {
		return this.ID_Category;
	}
	public void setID_Category(int ID_Category) {
		this.ID_Category = ID_Category;
	}
	public int getUserId() {
		return this.userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof CategoryPK)) {
			return false;
		}
		CategoryPK castOther = (CategoryPK)other;
		return 
			(this.ID_Category == castOther.ID_Category)
			&& (this.userId == castOther.userId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.ID_Category;
		hash = hash * prime + this.userId;
		
		return hash;
	}
}