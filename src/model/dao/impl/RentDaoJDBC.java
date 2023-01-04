package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.RentDao;
import model.entities.DepartmentStore;
import model.entities.Mall;
import model.entities.Rent;

public class RentDaoJDBC implements RentDao {
	private Connection conn;
	
	public RentDaoJDBC(Connection conn) {
		this.conn = conn;
	}
	@Override
	public void insertRent(Rent rent) {
		// TODO Auto-generated method stub
		PreparedStatement st = null;
		try{
			st = conn.prepareStatement("INSERT INTO rent "
					+ "(CurrentMonth, MallId, DepartmentStoreId, CurrentRent, CurrentPayedRent,payed) "
					+ "VALUES "
					+ "(?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
			st.setDate(1,new java.sql.Date(rent.getCurrentMonth().getTime()));
			st.setInt(2, rent.getMallId());
			st.setInt(3, rent.getdepartmentStoreId());
			st.setDouble(4, rent.getCurrentRent());
			st.setDouble(5, rent.getCurrentPayedRent());
			st.setBoolean(6, rent.isPayed());
			st.executeUpdate();
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}
	}

	@Override
	public void updateRent(Rent rent) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteByIdRent(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Rent findByIdRent(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Rent> findAllRent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Rent findByIdOfDepartmentStore(DepartmentStore dep) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Rent findByIdOfMall(Mall mall) {
		// TODO Auto-generated method stub
		return null;
	}

}
