package com.deloitte;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CRUD_Starter {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("**************Welcome to Generic CRUD Application**************");
		System.out.println("Available Tables in Delo Database");
		List<String> tables = new ArrayList<String>();
		// get all table names from DAO
		CRUDDAO crudDAO = new CRUDDAO();
		tables = crudDAO.getTableNames();
		for (String t : tables) {
			System.out.println("\t\t\t" + t);
		}
		int choice = 0;
		int id = 0;
		String table = null;
		Scanner input = new Scanner(System.in);
		int option = 0;
		while (choice == 0) {

			System.out.print("Enter the Table name to Interact :");
			table = input.next();
			crudDAO.displayTableData(table);

			System.out.println("\t\t 1. Add a Record");
			System.out.println("\t\t 2. Update a Record");
			System.out.println("\t\t 3. Delete a Record");
			System.out.println("\t\t 4. next Table");
			System.out.print("Enter the Operation Number (1-3) :");
			option = input.nextInt();
			switch (option) {
			case 1:
				crudDAO.addRecord(table);
				break;
			case 2:
				System.out.print("Enter id to update: ");
				id = input.nextInt();
				crudDAO.updateRecord(table, id);
				break;
			case 3:
				System.out.print("Enter id to delete: ");
				id = input.nextInt();
				crudDAO.deleteRecord(table,id);
				break;
			case 4:
				break;
			}

			System.out.print("Enter any number to exit or 0 to continue.");
			choice = input.nextInt();
		}
	}

}
