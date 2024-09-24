package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;
//essa classe servira para realizar operações no banco de dados para os objetos Seller(vendedores)
public class SellerDaoJDBC implements SellerDao {
	
	private Connection conn;
	
	public SellerDaoJDBC(Connection conn) {
		this.conn = conn;
	}
	
	
	@Override
	public void insert(Seller sel) {
		// TODO Auto-generated method stub

	}
	@Override
	public void update(Seller sel) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(Integer id) {
		
		

	}
	//buscando por id
	@Override
	public Seller findById(Integer id) {
		//nossa statement dinamica que recebera a query e incremento no nosso programa
		PreparedStatement st = null;
		//nosso resultado sera guardado nesse resultset
		ResultSet rs = null;
		//try - catch para capiturar possiveis exeções
		try{
			//nossa query de findby
			st = conn.prepareStatement(
					"select sel.*, dep.Name as DepName "
					+ "from seller sel inner join department dep "
					+ "on sel.departmentId = dep.Id "
					+ "where sel.id = ?");
			//setando nosso valor que sera filtrado no WHERE
			st.setInt(1, id);
			//rs recebe a execução da nossa query
			rs = st.executeQuery();
			//se ouver uma proxima linha ele 
			if(rs.next()) {
				Department dep = new Department();
				dep.setId(rs.getInt("DepartmentId"));
				dep.setName(rs.getString("DepName"));
				Seller sel = new Seller();
				sel.setName(rs.getString("Name"));
				sel.setId(rs.getInt("Id"));
				sel.setEmail(rs.getString("email"));
				sel.setBaseSalary(rs.getDouble("BaseSalary"));
				sel.setBirthDate(rs.getDate("BirthDate"));
				sel.setDepartment(dep);
				return sel;
			}
			return null;
		}catch (SQLException e) {
			throw new DbException(e.getMessage());
		}finally {
			DB.closeStatement(st);
			DB.closeSResultSet(rs);
		}
	}
	@Override
	public List<Seller> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
