package aplication;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

import java.util.List;
import java.util.Scanner;

public class Program2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

        System.out.println("=== TEST 1: department findById =====");
        Department department = departmentDao.findById(1);
        System.out.println(department);

        System.out.println();

        System.out.println("=== TEST 3: department findAll =====");
        List<Department> departmentList = departmentDao.findAll();
        for (Department dep : departmentList) {
            System.out.println(dep);
        }

        System.out.println();

        System.out.println("=== TEST 4: department Insert =====");
        Department newDepartment = new Department(null, "Design");
        departmentDao.insert(newDepartment);
        System.out.println("Inserted new department! Its id: " + newDepartment.getId());

        System.out.println();

        System.out.println("=== TEST 5: department update =====");
        department = departmentDao.findById(8);
        department.setName("Design");
        departmentDao.update(department);
        System.out.println("========== UPDATE COMPLETED ==========");

        System.out.println();

        System.out.println("=== TEST 6: department delete =====");
        System.out.print("Enter id for delete test: ");
        departmentDao.deleteById(sc.nextInt());
        System.out.println("========== DELETE COMPLETED ==========");

        sc.close();
    }
}
