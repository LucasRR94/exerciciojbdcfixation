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
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("UPDATE department_store "
					+ "SET CNPJ = ?, Name = ?, Email = ?, CreationDate = ?, StartedDateAtMall = ?, CurrentSizeOccupy = ?, MallId = ? " 
					+ "WHERE Id = ? ");
			st.setString(1,dep.getCnpj());
			st.setString(2, dep.getName());
			st.setString(3, dep.getEmail());
			st.setDate(4, new java.sql.Date(dep.getCreationDate().getTime()));
			st.setDate(5, new java.sql.Date(dep.getStartedDateAtMall().getTime()));
			st.setInt(6, dep.getCurrentSizeOccupied());
			st.setInt(7, dep.getMall().getId());
			st.setInt(8, dep.getId());
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
	public void deleteByIdOfDepartmentStore(Integer id) {
		// TODO Auto-generated method stub
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("DELETE FROM department_store WHERE Id = ? ");
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
	public DepartmentStore findByIdOfDepartmentStore(Integer id) {
		// TODO Auto-generated method stub
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("SELECT department_store.*,department_store.Id as Id,mall.Id as mallId FROM department_store "
						+ "INNER JOIN mall ON department_store.MallId = mallId WHERE department_store.Id = ?"
					);
			st.setInt(1, id);
			rs = st.executeQuery();
			if(rs.next()) {
				Mall mall = new Mall(rs.getInt("mallId"));
				DepartmentStore dep = new DepartmentStore(
						rs.getInt("department_store.Id"),
						rs.getString("department_store.CNPJ"),
						rs.getString("department_store.Name"),
						rs.getString("department_store.Email"),
						rs.getDate("department_store.CreationDate"),
						rs.getDate("department_store.StartedDateAtMall"),
						rs.getInt("department_store.CurrentSizeOccupy"),
						mall
						);
				return dep;
			}
			return null;
			
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}
	}

	@Override
	public List<DepartmentStore> findAllDepartmentStore() {
		// TODO Auto-generated method stub
		PreparedStatement st = null;
		ResultSet rs = null;
		List<DepartmentStore> allDeps = null;
		try {
			st = conn.prepareStatement("SELECT department_store.*,mall.Id as mallId FROM department_store "
					+ "INNER JOIN mall ON department_store.MallId = mall.Id ");
			rs = st.executeQuery();
			Map <Integer,Mall> malls = new HashMap<>();
			allDeps =  new ArrayList<DepartmentStore>();
			while(rs.next()) {
				int mallId = rs.getInt("mallId");
				if(malls.get(mallId) == null) {
					malls.put(mallId, new Mall(mallId));
				}
				allDeps.add(new DepartmentStore(
						rs.getInt("department_store.Id"),
						rs.getString("department_store.CNPJ"),
						rs.getString("department_store.Name"),
						rs.getString("department_store.Email"),
						rs.getDate("department_store.CreationDate"),
						rs.getDate("department_store.StartedDateAtMall"),
						rs.getInt("department_store.CurrentSizeOccupy"),
						malls.get(mallId)
						));
			}
			return allDeps;
		}catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}
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
