package model.dao;

import java.util.List;

import model.entities.DepartmentStore;
import model.entities.Mall;
import model.entities.Rent;

public interface DepartmentStoreDao {
	void insertDepartmentStore(DepartmentStore dep);
	void updateDepartmentStore(DepartmentStore dep);
	void deleteByIdOfDepartmentStore(Integer id);
	DepartmentStore findByIdOfDepartmentStore(Integer id);
	List <DepartmentStore> findAllDepartmentStore();
	List <DepartmentStore> findByMall(Mall mall);
	DepartmentStore findByIdOfRent(Rent rent);
}
