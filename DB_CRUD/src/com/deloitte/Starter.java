package com.deloitte;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.deloitte.dao.TraineeDAO;
import com.deloitte.entity.Trainee;
import com.deloitte.util.DBUtil;

public class Starter {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		int choice = 0;
		int id = 0;
		Scanner input = new Scanner(System.in);
		TraineeDAO traineeDAO = new TraineeDAO();
		Trainee t = new Trainee();
		String name = "";
		String email = "";
		long mobile = 0;
		int status = 0;
		List<Trainee> trainees = new ArrayList<Trainee>();
		while (choice != 6) {
			System.out.println("**********************Welcome to Trainee CRUD Program**********************");
			System.out.println("\t\t\t\t 1. View All Trainees");
			System.out.println("\t\t\t\t 2. View One Trainee");
			System.out.println("\t\t\t\t 3. Add New Trainee");
			System.out.println("\t\t\t\t 4. Update A Trainee");
			System.out.println("\t\t\t\t 5. Delete A Trainee");
			System.out.println("\t\t\t\t 6. Exit");
			System.out.print("Enter your choice (1-6) :");
			choice = input.nextInt();
			switch (choice) {
			case 1:
				trainees = traineeDAO.readAll();
				for (Trainee trainee : trainees) {
					System.out.println(trainee);
				}
				break;
			case 2:
				System.out.print("Enter the ID of Trainee to View :");
				id = input.nextInt();
				System.out.println(traineeDAO.readById(id));
				break;
			case 3:
				System.out.print("Enter name of Trainee :");
				name = input.nextLine();
				t.setName(name);
				input.nextLine();
				System.out.print("Enter Email of Trainee :");
				email = input.nextLine();
				t.setEmail(email);
				System.out.print("Enter mobile No of Trainee :");
				mobile = input.nextLong();
				t.setMobile(mobile);
				status = traineeDAO.insertTrainee(t);
				if (status != 0)
					System.out.println("Record Insertted Successfully!!!");
				break;
			case 4:
				System.out.print("Enter id of Trainee to Update :");
				id = input.nextInt();
				t = traineeDAO.readById(id);
				System.out.print("Enter name of Trainee :");
				name = input.nextLine();
				t.setName(name);
				input.next();
				System.out.print("Enter Email of Trainee :");
				email = input.nextLine();
				t.setEmail(email);
				System.out.print("Enter mobile No of Trainee :");
				mobile = input.nextLong();
				t.setMobile(mobile);
				status = traineeDAO.updateTrainee(id, t);
				if (status != 0)
					System.out.println("Record Updatted Successfully!!!");
				break;
			case 5:
				System.out.print("Enter id of Trainee to Delete :");
				id = input.nextInt();
				status = traineeDAO.deleteTrainee(id);
				if (status != 0)
					System.out.println("Record Deletted Successfully!!!");
				break;

			case 6:
				break;
			}
		}
		System.out.println("Thanks for using Trainee CRUD Program");
		input.close();
		DBUtil.closeResource();
	}

}
