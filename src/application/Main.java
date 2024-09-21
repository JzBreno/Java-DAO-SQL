package application;

import java.util.Date;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Main {

    public static void main(String[] args) {
        Department obj = new Department(1, "Books");
        Seller seller = new Seller(21, "Bob", "bob@gmail.com", new Date(), 3000.0, obj);
        //instanciando desta forma, o programa nao conhece a implementação e apenas conhece a interface
        SellerDao sellerdao = DaoFactory.createSellerDao();
       
        
    }
    
   
}
