package model.dao;

import java.util.List;

import model.entities.Seller;

public interface SellerDao {
	//inserindo metodos abstratos para serem Herdadas em Seller
	void insert(Seller sel);
	void update(Seller sel);
	void deleteById(Integer id);
	Seller findById(Integer id);
	List<Seller> findAll();
	
}