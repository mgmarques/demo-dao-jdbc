package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		Department dep = departmentDao.findById(2);
		
		System.out.println("=== Test 1: Department findById ===");
		System.out.println(dep);

		System.out.println("\n=== Test 2: Department findAll ===");
		 
		List<Department> depList = new ArrayList<>();
		depList = departmentDao.findAll();
		
		depList.forEach(System.out::println);
		
		System.out.println("\n=== Test 3: insert Department ===");
		Department newDepartment = new Department(null, "Music");
		departmentDao.insert(newDepartment);
		System.out.println("Inserted! New Department Id: " + newDepartment.getId());

		System.out.println("\n=== Test 4: update Department ===");
		dep = departmentDao.findById(1);
		dep.setName("Food");
		departmentDao.update(dep);
		System.out.println("Update Completed!\n" + dep);

		System.out.println("\n=== Test 5: delete Department ===");
		System.out.print("Enter id for deletion: ");
		Scanner sc = new Scanner(System.in);
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Delete completed!");
		
		sc.close();
	}

}
