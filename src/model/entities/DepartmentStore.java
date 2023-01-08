package model.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class DepartmentStore implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private String cnpj;
	private String name;
	private String email;
	private Date creationDate;
	private Date StartedDateAtMall;
	private int currentSizeOccupied;
	private Mall mall;
	
	public DepartmentStore(int id, String cnpj, String name, String email, Date creationDate, Date startedDateAtMall,
			int currentSizeOccupied, Mall mall) {
		super();
		this.id = id;
		this.cnpj = cnpj;
		this.name = name;
		this.email = email;
		this.creationDate = creationDate;
		StartedDateAtMall = startedDateAtMall;
		this.currentSizeOccupied = currentSizeOccupied;
		this.mall = mall;
	}
	public DepartmentStore(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getStartedDateAtMall() {
		return StartedDateAtMall;
	}

	public void setStartedDateAtMall(Date startedDateAtMall) {
		StartedDateAtMall = startedDateAtMall;
	}

	public int getCurrentSizeOccupied() {
		return currentSizeOccupied;
	}

	public void setCurrentSizeOccupied(int currentSizeOccupied) {
		this.currentSizeOccupied = currentSizeOccupied;
	}

	public Mall getMall() {
		return this.mall;
	}

	public void setMall(Mall mall) {
		this.mall = mall;
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
		DepartmentStore other = (DepartmentStore) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "DepartmentStore [id=" + id + ", cnpj=" + cnpj + ", name=" + name + ", email=" + email
				+ ", creationDate=" + creationDate + ", StartedDateAtMall=" + StartedDateAtMall
				+ ", currentSizeOccupied=" + currentSizeOccupied + ", mall=" + mall + "]";
	}

	
	
}
