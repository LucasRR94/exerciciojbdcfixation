package model.dao;

import java.util.List;

import model.entities.DepartmentStore;
import model.entities.Mall;
import model.entities.Rent;

public interface RentDao {
	void insertRent(Rent rent);
	void updateRent(Rent rent);
	void deleteByIdRent(Integer id);
	Rent findByIdRent(Integer id);
	List <Rent> findAllRent();
	Rent findByIdOfDepartmentStore(DepartmentStore dep);
	Rent findByIdOfMall(Mall mall);
}
