package com.main;

import java.util.List;
import java.util.Scanner;

import com.conn.DBConnect;
import com.dao.ContactDAO;
import com.entity.Employee;

public class mainClass {

	public static void main(String[] args) {

		boolean flag = true;

		while (flag) {
			System.out.println("----------------------");
			System.out.println("1. Create Employee");
			System.out.println("2. Edit Employee");
			System.out.println("3. Delete Employee");
			System.out.println("4. View Employee");
			System.out.println("5. Exit");
			System.out.println("----------------------");
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter No");
			int no = sc.nextInt();
			ContactDAO dao = new ContactDAO(DBConnect.getConn());
			switch (no) {
			case 1:
				System.out.println("Enter Name");
				String name = sc.next();
				System.out.println("Enter desg");
				String desg = sc.next();
				System.out.println("Enter Ph No");
				String phno = sc.next();
				System.out.println("Enter sal");
				int salary = sc.nextInt();

				Employee c = new Employee();
				c.setName(name);
				c.setDesg(desg);
				c.setPhno(phno);
				c.setSalary(salary);
				boolean s1 = dao.saveEmployee(c);
				if (s1) {
					System.out.println("Employee No Saved..");
				} else {
					System.out.println("Something wrong on server..");
				}
				break;
			case 2:
				System.out.println("Enter Id");
				int id = sc.nextInt();
				System.out.println("Enter Name");
				String name2 = sc.next();
				System.out.println("Enter desg");
				String desg2 = sc.next();
				System.out.println("Enter Ph no");
				String phno2 = sc.next();
				System.out.println("Enter salary");
				int  salary2 = sc.nextInt();

				Employee c2 = new Employee();
				c2.setId(id);
				c2.setName(name2);
				c2.setName(desg2);
				c2.setPhno(phno2);
				c2.setSalary(salary2);
				boolean s2 = dao.editEmployee(c2);
				if (s2) {
					System.out.println("Employee Edit Sucessfully..");
				} else {
					System.out.println("User Is not Available");
				}
				break;
			case 3:
				System.out.println("Enter Id");
				int id3 = sc.nextInt();
				boolean s3 = dao.deleteEmployee(id3);
				if (s3) {
					System.out.println("Employee Delete Sucessfully..");
				} else {
					System.out.println("User Is not Available");
				}
				break;
			case 4:
				List<Employee> list = dao.getAllEmployee();
				if (list.isEmpty()) {
					System.out.println("Employee is Not Available");
				} else {
					for (Employee con : list) {
						System.out.println("Id :" + con.getId());
						System.out.println("Name :" + con.getName());
						System.out.println("designation :"+ con.getDesg());
						System.out.println("Phno :" + con.getPhno());
						System.out.println("Salary :"+con.getSalary());
						System.out.println("---------------------");
					}
				}
				break;
			case 5:
				flag = false;
				System.out.println("Thank u..Visit Again..");
				break;

			default:
				System.out.println("Please Enter Correct No..");
				break;
			}

		}

	}

}
