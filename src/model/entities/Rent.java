package model.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Rent implements Serializable{

	private static final long serialVersionUID = 1L;
	private int id;
	private Date currentMonth;
	private Mall mall;
	private DepartmentStore departmentStore;
	private Double currentRent;
	private Double currentPayedRent;
	private boolean payed;
	
	public Rent(int id, Date currentMonth, Mall mall, DepartmentStore departmentStore, Double currentRent, Double currentPayedRent,
			boolean payed) {
		super();
		this.id = id;
		this.currentMonth = currentMonth;
		this.mall = mall;
		this.departmentStore = departmentStore;
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
	public Mall getMall() {
		return mall;
	}
	public void setMall(Mall mallId) {
		this.mall = mallId;
	}
	public DepartmentStore getdepartmentStore() {
		return departmentStore;
	}
	public void setdepartmentStore(DepartmentStore departmentStore) {
		this.departmentStore = departmentStore;
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
		return "Rent [id=" + id + ", currentMonth=" + currentMonth + ", mall=" + mall + ", departmentStore="
				+ departmentStore + ", currentRent=" + currentRent + ", currentPayedRent=" + currentPayedRent
				+ ", payed=" + payed + "]";
	}
	
	
}
