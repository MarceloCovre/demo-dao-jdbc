package application;

import model.dao.DaoFactory;
import model.dao.DepartementDao;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        DepartementDao departementDao = DaoFactory.createDepartmentDao();

        System.out.println("=== TEST 1: department insert ===");
        Department newDepartment = new Department(null, "Teste");
        departementDao.insert(newDepartment);
        System.out.println("Inserted! New id = " + newDepartment.getId());

        System.out.println("\n=== TEST 1: department findById ===");
        Department department = departementDao.findById(3);
        System.out.println(department);

        System.out.println("\n=== TEST 3: department update ===");
        Department dep = departementDao.findById(5);
        department.setName("Test");
        departementDao.update(dep);
        System.out.println("Update completed");

        System.out.println("\n=== TEST 4: department findAll ===");
        List<Department> list = departementDao.findAll();
        for (Department obj : list) {
            System.out.println(obj);
        }

        System.out.println("\n=== TEST 5: department delete ===");
        System.out.println("Enter id for delete test: ");
        int id = sc.nextInt();
        departementDao.deleteById(id);
        System.out.println("Delete completed!");
    }
}
