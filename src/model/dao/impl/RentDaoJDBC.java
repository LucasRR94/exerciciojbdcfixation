package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
			st.setInt(2, rent.getMall().getId());
			st.setInt(3, rent.getdepartmentStore().getId());
			st.setDouble(4, rent.getCurrentRent());
			st.setDouble(5, rent.getCurrentPayedRent());
			st.setBoolean(6, rent.isPayed());
			int rowsAffected = st.executeUpdate();
			if(rowsAffected > 0) {
				ResultSet rs = st.getGeneratedKeys();
				if(rs.next()) {
					int id = rs.getInt(1);
					rent.setId(id);
				}
				DB.closeResultSet(rs);
			}
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
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("UPDATE rent "
				+ "SET CurrentMonth = ?, MallId = ?, DepartmentStoreId = ?, CurrentRent = ?, CurrentPayedRent = ?,payed = ? "
				+ "WHERE Id = ? ");
			st.setDate(1, new java.sql.Date(rent.getCurrentMonth().getTime()));
			st.setInt(2, rent.getMall().getId());
			st.setInt(3, rent.getdepartmentStore().getId());
			st.setDouble(4,rent.getCurrentRent());
			st.setDouble(5, rent.getCurrentPayedRent());
			st.setBoolean(6, rent.isPayed());
			st.setInt(7,rent.getId());
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
	public void deleteByIdRent(Integer id) {
		// TODO Auto-generated method stub
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("DELETE FROM rent WHERE Id = ?");
			st.setInt(1, id);
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
	public Rent findByIdRent(Integer id) {
		// TODO Auto-generated method stub
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
					"SELECT rent.*,rent.Id as Id, mall.Id as mallId, department_store.Id as departmentStoreId "
					+ "FROM rent INNER JOIN mall "
					+ "ON rent.MallId = mall.Id "
					+ "INNER JOIN department_store "
					+ "ON rent.DepartmentStoreId = department_store.Id "
					+ "WHERE rent.Id = ? "
					);
			st.setInt(1, id);
			rs = st.executeQuery();
			if(rs.next()) {
				Mall mall = new Mall(rs.getInt("departmentStoreId"));
				DepartmentStore dep = new DepartmentStore(rs.getInt("mallId"));
				return new Rent(rs.getInt("rent.Id"),rs.getDate("rent.CurrentMonth"),mall,dep,rs.getDouble("rent.CurrentRent"),rs.getDouble("rent.currentPayedRent"),rs.getBoolean("rent.Payed"));
			}
			return null;

		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}
	}

	@Override
	public List<Rent> findAllRent() {
		// TODO Auto-generated method stub
		PreparedStatement st = null;
		ResultSet rs = null;
		List<Rent> allRents = new ArrayList<>();
		try {
			st = conn.prepareStatement(
					"SELECT rent.*,rent.Id as Id, mall.Id as mallId, department_store.Id as departmentStoreId "
							+ "FROM rent INNER JOIN mall "
							+ "ON rent.MallId = mall.Id "
							+ "INNER JOIN department_store "
							+ "ON rent.DepartmentStoreId = department_store.Id "
					);
			rs = st.executeQuery();
			Map <Integer, DepartmentStore> mapDep = new HashMap<>();
			Map <Integer, Mall> mapMall = new HashMap<>();
			while(rs.next()) {
				DepartmentStore dep = mapDep.get(rs.getInt("departmentStoreId"));
				Mall mall = mapMall.get(rs.getInt("mallId"));
				if(dep == null) {
					mapDep.put(rs.getInt("departmentStoreId"),new DepartmentStore(rs.getInt("departmentStoreId")));
					dep = mapDep.get(rs.getInt("departmentStoreId"));
				}
				if(mall == null) {
					mapMall.put(rs.getInt("mallId"),new Mall(rs.getInt("mallId")));
					mall = mapMall.get(rs.getInt("mallId"));
				}
				allRents.add(new Rent(rs.getInt("rent.Id"),rs.getDate("rent.CurrentMonth"), mall, dep,rs.getDouble("rent.CurrentRent"),rs.getDouble("rent.currentPayedRent"),rs.getBoolean("rent.Payed")));
			}
			return allRents;

		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}
	}

	@Override
	public List<Rent> findAllByIdOfDepartmentStore(DepartmentStore dep) {
		// TODO Auto-generated method stub
		PreparedStatement st = null;
		ResultSet rs = null;
		List<Rent> allRents = new ArrayList<>();
		try {
			st = conn.prepareStatement(
					"SELECT rent.*,rent.Id as Id, mall.Id as mallId, department_store.Id as departmentStoreId "
							+ "FROM rent INNER JOIN mall "
							+ "ON rent.MallId = mall.Id "
							+ "INNER JOIN department_store "
							+ "ON rent.DepartmentStoreId = department_store.Id "
							+ "WHERE departmentStoreId = ? "
					);
			st.setInt(1, dep.getId());
			rs = st.executeQuery();
			Map <Integer, Mall> mapMall = new HashMap<>();
			while(rs.next()) {
				Mall mall = mapMall.get(rs.getInt("mallId"));
				if(mall == null) mall = new Mall(rs.getInt("mallId"));
				allRents.add(new Rent(rs.getInt("rent.Id"),rs.getDate("rent.CurrentMonth"), mall, dep,rs.getDouble("rent.CurrentRent"),rs.getDouble("rent.currentPayedRent"),rs.getBoolean("rent.Payed")));
			}
			return allRents;

		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}
	}

	@Override
	public List<Rent> findAllByIdOfMall(Mall mall) {
		// TODO Auto-generated method stub
		PreparedStatement st = null;
		ResultSet rs = null;
		List<Rent> allRents = new ArrayList<>();
		try {
			st = conn.prepareStatement(
					"SELECT rent.*,rent.Id as Id, mall.Id as mallId, department_store.Id as departmentStoreId "
							+ "FROM rent INNER JOIN mall "
							+ "ON rent.MallId = mall.Id "
							+ "INNER JOIN department_store "
							+ "ON rent.DepartmentStoreId = department_store.Id "
							+ "WHERE mall.Id= ? "
					);
			st.setInt(1, mall.getId());
			rs = st.executeQuery();
			Map <Integer, DepartmentStore> mapDep = new HashMap<>();
			while(rs.next()) {
				DepartmentStore dep = mapDep.get(rs.getInt("departmentStoreId"));
				if(dep == null) dep = new DepartmentStore(rs.getInt("departmentStoreId"));
				allRents.add(new Rent(rs.getInt("rent.Id"),rs.getDate("rent.CurrentMonth"), mall, dep,rs.getDouble("rent.CurrentRent"),rs.getDouble("rent.currentPayedRent"),rs.getBoolean("rent.Payed")));
			}
			return allRents;

		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}
	}

}
