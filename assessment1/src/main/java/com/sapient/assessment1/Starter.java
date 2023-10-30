package com.sapient.assessment1;

import java.util.List;
import java.util.Scanner;

import com.sapient.assessment1.crud.DBCrud;
import com.sapient.assessment1.model.Employee;
import com.sapient.assessment1.util.DBUtil;

/**
 * Hello world!
 *
 */
public class Starter {
	public void displayMenu() {
		System.out.println("***********************************************************************************");
		System.out.println("***********************************************************************************");
		System.out.println("**  \t\t\t \t\t\t\t \t\t\t ** ");
		System.out.println("**  \t\t\t \t\t\t\t \t\t\t ** ");
		System.out.println("**  \t\t\t Welcome to DB CRUD CLI APP \t\t\t\t **");
		System.out.println("**  \t\t\t \t\t\t\t \t\t\t ** ");
		System.out.println("**  \t\t\t \t\t\t\t \t\t\t ** ");
		System.out.println("***********************************************************************************");
		System.out.println("***********************************************************************************");
		System.out.println("** \t\t\t Select any one Available Options to Proceed \t\t **");
		System.out.println("***********************************************************************************");
		System.out.println("***********************************************************************************");
		System.out.println("** \t\t\t 1. Display Table Contents. \t\t\t\t **");
		System.out.println("** \t\t\t 2. Add a Record to Table.  \t\t\t\t **");
		System.out.println("** \t\t\t 3. Edit a Record in Table. \t\t\t\t **");
		System.out.println("** \t\t\t 4. Delete Record from Table. \t\t\t\t **");
		System.out.println("** \t\t\t 5. Display Unique Records. \t\t\t\t **");
		System.out.println("** \t\t\t 6. Exit from DB CRUD App.  \t\t\t\t **");
		System.out.println("***********************************************************************************");
		System.out.println("***********************************************************************************");
		System.out.print(" Enter your Choice [1-6] : ");
	}

	public void displayTableHeading() {
		System.out.println("------------------------------------------------------------------------------------");
		System.out.println("|| ID   || Name  \t|| Gender ||   DOB   || Email \t\t  || Mobile \t ||");
		System.out.println("------------------------------------------------------------------------------------");
	}

	public void displayTableContents(List<Employee> employees) {
		displayTableHeading();
		for (Employee employee : employees) {
			System.out.print("|| " + employee.getId() + "  |");
			System.out.print("|" + employee.getName() + "  |");
			System.out.print("|  " + employee.getGender() + "  |");
			System.out.print("|  " + employee.getDob() + " |");
			System.out.print("|" + employee.getEmail() + " |");
			System.out.println("|  " + employee.getMobile() + "  ||");
		}
		System.out.println("------------------------------------------------------------------------------------");

	}

	public static void main(String[] args) {
		Starter starter = new Starter();
		int choice = 1;
		Scanner input = new Scanner(System.in);
		DBCrud dBCrud = new DBCrud();
		List<Employee> employees =null;
		while (choice != 0) {
			starter.displayMenu();
			choice = input.nextInt();
			switch (choice) {
			case 1:
				employees = dBCrud.getAll();
				starter.displayTableContents(employees);
				break;
			case 2:
				System.out.println("Yet to Implement");
				break;
			case 3:
				System.out.println("Yet to Implement");
				break;
			case 4:
				System.out.print("Enter ID of Employee to Delete :");
				int id = input.nextInt();
				int status = 0;
				status = dBCrud.delete(id);
				if (status != 0)
					System.out.println("One Record Deleted Successfully");
				else
					System.out.println("Error While deleting Record ");
				break;
			case 5:
				employees = dBCrud.getUniqueRecord();
				starter.displayTableContents(employees);
				break;
			case 6:
				System.out.println("Thanks for using our Application");
				DBUtil.closeResources();
				input.close();
				System.exit(0);
				break;
			default:
				System.out.println("Please enter any number between 1 to 6 only");
				break;
			}
		}
		if (input != null)
			input.close();
	}
}
