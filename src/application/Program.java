package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		Seller seller = sellerDao.findById(2);
		
		System.out.println("=== Test 1: Seller findById ===");
		System.out.println(seller);
		
		System.out.println("\n=== Test 2: Seller findByDepartment ===");
		 
		Department department = new Department(2, null);
		List<Seller> sellerList = sellerDao.findByDeparment(department);
		
		sellerList.forEach(System.out::println);
		
		System.out.println("\n=== Test 3: Seller findAll ===");
		 
		sellerList = sellerDao.findAll();
		
		sellerList.forEach(System.out::println);
		
		System.out.println("\n=== Test 4: insert Seller ===");
		Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, department);
		sellerDao.insert(newSeller);
		System.out.println("Inserted! New Seller Id: " + newSeller.getId());

		System.out.println("\n=== Test 5: update Seller ===");
		seller = sellerDao.findById(1);
		seller.setName("Martha Wayne");
		seller.setEmail("martha@wayne.com");
		sellerDao.update(seller);
		System.out.println("Update Completed!\n" + seller);

		System.out.println("\n=== Test 6: delete Seller ===");
		System.out.print("Enter id for deletion: ");
		Scanner sc = new Scanner(System.in);
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		System.out.println("Delete completed!");
		
		sc.close();

	}

}
