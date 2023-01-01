package model.entities;

import java.io.Serializable;
import java.util.Objects;

public class Mall implements Serializable{

	private static final long serialVersionUID = 1L;
	private int id;
	private String Name;
	private String cityName;
	private String stateOfCountry;
	private String country;
	
	public Mall(int id, String name, String cityName, String stateOfCountry, String country) {
		super();
		this.id = id;
		Name = name;
		this.cityName = cityName;
		this.stateOfCountry = stateOfCountry;
		this.country = country;
	}
	@Override
	public String toString() {
		return "Mall [id=" + id + ", Name=" + Name + ", cityName=" + cityName + ", stateOfCountry=" + stateOfCountry
				+ ", country=" + country + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(country);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mall other = (Mall) obj;
		return Objects.equals(country, other.country);
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getStateOfCountry() {
		return stateOfCountry;
	}
	public void setStateOfCountry(String stateOfCountry) {
		this.stateOfCountry = stateOfCountry;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
