package model.dao;

import java.util.List;

import model.entities.DepartmentStore;
import model.entities.Mall;
import model.entities.Rent;

public interface MallDao {
	void insertMall(Mall mall);
	void updateMall(Mall mall);
	void deleteByIdMall(Integer id);
	Mall findByIdMall(Integer id);
	List <Mall> findAllMall();
	Mall findByIdOfRent(Rent rent);
	Mall findByIdOfDepartmentStore(DepartmentStore dep);
}
