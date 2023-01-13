package model.dao;

import db.DB;
import model.dao.impl.DepartmentStoreDaoJDBC;
import model.dao.impl.MallDaoJDBC;
import model.dao.impl.RentDaoJDBC;

public class DaoFactory {
	public static MallDao createMallDao() {
		return new MallDaoJDBC(DB.getConnection());
	}
	public static RentDao createRentDao() {
		return new RentDaoJDBC(DB.getConnection()); 
	}
	public static DepartmentStoreDao createDepartmentStoreDao() {
		return new DepartmentStoreDaoJDBC(DB.getConnection());
	}
}
