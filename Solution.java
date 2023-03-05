package sdbms;

import java.util.Scanner;

import customexception.InvalidChoiceException;

public class Solution {

	public static void main(String[] args) throws InvalidChoiceException{
		Scanner scan=new Scanner(System.in);
		StudentManagementSystem s=new StudentManagementSystemImpl();
		while(true) {

			System.out.println("1:Add student\n2:display student \n3:displayAllstudent \n4:removeStudent\n5:removeAllStudent\n6:updateStudent");	
			System.out.println("7:countStudents\n8:sortStudent\n9:getstudentwithHighestMarks\n10:getstudentwithLowestMarks\n11:Exit");	
			System.out.println("enter your choice");
			int choice=scan.nextInt();
			switch (choice) {
			case 1:
				s.addStudent();
				break;
			case 2:
				s.displayStudent();
				break;
			case 3:
				s.displayAllStudent();
				break;
			case 4: 
				s.removeStudent();
				break;
			case 5:
				s.removeAllStudent();
				break;
			case 6:
				s.updateStudent();
				break;
			case 7:
				s.countStudents();
				break;
			case 8:
				s.sortStudent();
				break;
			case 9:
				s.getStudentwithHighestMarks();
				break;
			case 10:
				s.getStudentwithLowestMarks();
				break;
			case 11:
				System.out.println("Thank You");
				System.exit(0);

			default:
				try {
					throw new InvalidChoiceException("Invalid choice");

				}
				catch(InvalidChoiceException  e){
					System.out.println(e.getMessage());

				}
			}
		}
	}
}
