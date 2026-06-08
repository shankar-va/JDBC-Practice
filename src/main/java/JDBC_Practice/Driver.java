package JDBC_Practice;

import java.util.Scanner;

public class Driver {
	 
	public static void main(String[] args) {
		System.out.println("This is sample JDBC connectivity program");
		Scanner  scn =new  Scanner(System.in);
		while(true) {
			System.out.println("Enter options to perfrom CRUD operations : ");
			System.out.println("1)SELECT    2)INSERT    3)UPDATE    4)DELETE    5)CLOSE");
			int option=scn.nextInt();
			String name="";
			int age=0;
			int oldId=0;
			int newId=0;
			if(option==2) {
				System.out.println("Enter Student details to add : ");
				System.out.println("Enter Student name");
				scn.nextLine();
				name=scn.nextLine();
				System.out.println("Enter Student age : ");
				age=scn.nextInt();
			}else if(option==3) {
				System.out.println("Enter the id of Student to be updated : ");
				oldId=scn.nextInt();
				System.out.println("Enter new id of the Student : ");
				newId=scn.nextInt();
				System.out.println("Enter new name of the Student :");
				scn.nextLine();
				name=scn.nextLine();
				System.out.println("Enter new age of the  Student : ");
				age=scn.nextInt();
			}
			switch(option) {
			case 1:
				Service.selectAll();
				break;
			case 2:
				int id=Service.getMaxId();
				if(Service.add(new Student(id++, name, age))==1) {
					System.out.println("Student added successfully");
					
				}
				else System.out.println("Student cannot be added");
				break;
			case 3:
				if(Service.updateById(new Student(newId, name, age), oldId)==1) 
					System.out.println("Student updated successfully");
				else System.out.println("Student cannot be updated");
				break;
			case 4:
				System.out.println("Enter Student Id to be deleted : ");
				int deleteId=scn.nextInt();
				if(Service.removeById(deleteId)==1)
					System.out.println("Student updated successfully");
				else System.out.println("Student cannot be updated");
				break;
			case 5:
				if(Service.closeConnection())
					System.out.println("Thank you!!! Welcome ");
				else System.out.println("Database connection cannot be closed");
				System.exit(1);
				break;
			default:
				System.out.println("Invalid Input!!!");
			}
		}
	}
}
