package model.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Rent implements Serializable{

	private static final long serialVersionUID = 1L;
	private int id;
	private Date currentMonth;
	private int mallId;
	private int departmentStoreId;
	private Double currentRent;
	private Double currentPayedRent;
	private boolean payed;
	
	public Rent(int id, Date currentMonth, int mallId, int departmentStoreId, Double currentRent, Double currentPayedRent,
			boolean payed) {
		super();
		this.id = id;
		this.currentMonth = currentMonth;
		this.mallId = mallId;
		this.departmentStoreId = departmentStoreId;
		this.currentRent = currentRent;
		this.currentPayedRent = currentPayedRent;
		this.payed = payed;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getCurrentMonth() {
		return currentMonth;
	}
	public void setCurrentMonth(Date currentMonth) {
		this.currentMonth = currentMonth;
	}
	public int getMallId() {
		return mallId;
	}
	public void setMallId(int mallId) {
		this.mallId = mallId;
	}
	public int getdepartmentStoreId() {
		return departmentStoreId;
	}
	public void setdepartmentStoreId(int departmentStoreId) {
		this.departmentStoreId = departmentStoreId;
	}
	public Double getCurrentRent() {
		return currentRent;
	}
	public void setCurrentRent(Double currentRent) {
		this.currentRent = currentRent;
	}
	public Double getCurrentPayedRent() {
		return currentPayedRent;
	}
	public void setCurrentPayedRent(Double currentPayedRent) {
		this.currentPayedRent = currentPayedRent;
	}
	public boolean isPayed() {
		return payed;
	}
	public void setPayed(boolean payed) {
		this.payed = payed;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rent other = (Rent) obj;
		return id == other.id;
	}
	@Override
	public String toString() {
		return "Rent [id=" + id + ", currentMonth=" + currentMonth + ", mallId=" + mallId + ", departmentStoreId="
				+ departmentStoreId + ", currentRent=" + currentRent + ", currentPayedRent=" + currentPayedRent + ", payed="
				+ payed + "]";
	}
	
}
