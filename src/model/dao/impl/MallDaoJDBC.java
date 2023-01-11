package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.MallDao;
import model.entities.DepartmentStore;
import model.entities.Mall;
import model.entities.Rent;

public class MallDaoJDBC implements MallDao {
	private Connection conn;
	
	public MallDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insertMall(Mall mall) {
		// TODO Auto-generated method stub
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("INSERT INTO mall "
					+ "(Name, CityName, StateOfCountry, Country) "
					+ "VALUES "
					+ "(?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
			st.setString(1, mall.getName());
			st.setString(2, mall.getCityName());
			st.setString(3,mall.getStateOfCountry());
			st.setString(4, mall.getCountry());
			int rowsAffected = st.executeUpdate();
			if(rowsAffected > 0) {
				ResultSet rs = st.getGeneratedKeys();
				if(rs.next()) {
					int id = rs.getInt(1);
					mall.setId(id);
				}
			}
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}
	}

	@Override
	public void updateMall(Mall mall) {
		// TODO Auto-generated method stub
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("UPDATE mall "
					+ "SET Name = ?, CityName = ?, StateOfCountry = ?, Country = ? "
					+ "WHERE Id = ? ");
			st.setString(1, mall.getName());
			st.setString(2, mall.getCityName());
			st.setString(3, mall.getStateOfCountry());
			st.setString(4, mall.getCountry());
			st.setInt(5, mall.getId());
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
	public void deleteByIdMall(Integer id) {
		// TODO Auto-generated method stub
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("DELETE FROM mall where Id = ?");
			st.setInt(1, id);
			st.executeUpdate();
		}
		catch (SQLException e){
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}
	}

	@Override
	public Mall findByIdMall(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Mall> findAllMall() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mall findByIdOfRent(Rent rent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mall findByIdOfDepartmentStore(DepartmentStore dep) {
		// TODO Auto-generated method stub
		return null;
	}

}
