package model.dao;

import db.DB;
import model.dao.impl.RentDaoJDBC;

public class DaoFactory {
	public static MallDao createMallDao() {
		return null;
	}
	public static RentDao createRentDao() {
		return new RentDaoJDBC(DB.getConnection()); 
	}
}
