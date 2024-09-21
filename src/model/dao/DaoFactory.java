package model.dao;

import model.dao.impl.SellerDaoJDBC;

public class DaoFactory {
	//Sera onde instanciaremos nossos Daos
	public static SellerDao createSellerDao() {
		return new SellerDaoJDBC();
	}
}
