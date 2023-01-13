package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.DepartmentStoreDao;
import model.entities.DepartmentStore;
import model.entities.Mall;
import model.entities.Rent;

public class DepartmentStoreDaoJDBC implements DepartmentStoreDao {
	private Connection conn;

	public DepartmentStoreDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insertDepartmentStore(DepartmentStore dep) {
		// TODO Auto-generated method stub
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("INSERT INTO department_store "
					+ "(CNPJ, Name, Email, CreationDate, StartedDateAtMall, CurrentSizeOccupy, MallId) "
					+ "VALUES "
					+ "(?, ?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
			st.setString(1, dep.getCnpj());
			st.setString(2, dep.getName());
			st.setString(3, dep.getEmail());
			st.setDate(4, new java.sql.Date(dep.getCreationDate().getTime()));
			st.setDate(5, new java.sql.Date(dep.getStartedDateAtMall().getTime()));
			st.setInt(6, dep.getCurrentSizeOccupied());
			st.setInt(7, dep.getMall().getId());
			int rowsAffected = st.executeUpdate();
			if (rowsAffected > 0) {
				ResultSet rs = st.getGeneratedKeys();
				if (rs.next()) {
					int id = rs.getInt(1);
					dep.setId(id);
				}
				DB.closeResultSet(rs);
			}
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
		}
	}

	@Override
	public void updateDepartmentStore(DepartmentStore dep) {
		// TODO Auto-generated method stub
	}

	@Override
	public void deleteByIdOfDepartmentStore(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public DepartmentStore findByIdOfDepartmentStore(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DepartmentStore> findAllDepartmentStore() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DepartmentStore> findByMall(Mall mall) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DepartmentStore findByIdOfRent(Rent rent) {
		// TODO Auto-generated method stub
		return null;
	}

}
