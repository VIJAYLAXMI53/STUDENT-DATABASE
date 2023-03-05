package sdbms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import customexception.InvalidChoiceException;
import customexp.StudentNotFoundException;
import customsorting.SortStudentByAge;
import customsorting.SortStudentById;
import customsorting.SortStudentByMarks;
import customsorting.SortStudentByName;

public class StudentManagementSystemImpl implements StudentManagementSystem{
	Scanner scan=new Scanner(System.in);
	Map <String,Student>db =new LinkedHashMap<String,Student>();


	@Override
	
	public void addStudent(){
		System.out.println("enter student age");
		int age=scan.nextInt();
		System.out.println("enter student name");
		String name=scan.next();
		System.out.println("enter student marks");
		int marks=scan.nextInt();
		Student s=new Student(age,name,marks);
		db.put(s.getId(),s);
		System.out.println("student record inserted successfully");
		System.out.println("Student Id is"+s.getId());


	}
	@Override

	public void displayStudent() {             //Accept the student id->101,102,103
		System.out.println("Enter student id");//touppercase
		String id=scan.next();
		id=id.toUpperCase();
		if(db.containsKey(id)) {
			Student s=db.get(id);
			System.out.println("Id:"+s.getId());
			System.out.println("Age:"+s.getAge());
			System.out.println("Name:"+s.getName());
			System.out.println("Marks:"+s.getMarks());
		}
		else {
			try {
				String message="student with Id:"+id+"not found";
				throw new StudentNotFoundException(message);
			}
			catch(StudentNotFoundException e) {
				System.out.println(e.getmessage());
			}
		}

	}
	@Override

	public void displayAllStudent() {                             //Accept the student id->101,102,103
		if(db.size()!=0) {                                        //touppercase
			System.out.println("student details are as follows");//check if id is present or not
			System.out.println("-----------------------------------");//if id is present ->get the value(student obj) 
			Set<String>keys=db.keySet();//jsp101,jsp102,jsp103        //getage(),getname().......
			for(String key:keys) {                                     //else
				Student s=db.get(key);
				System.out.println(s);//SYSOUT(db.get(key));
			}
		}
		else {
			try {
				String message="student Database is empty ,nothing to display";
				throw new StudentNotFoundException(message);
			}
			catch(StudentNotFoundException e) {
				System.out.println(e.getmessage());
			}
		}

	}

	@Override

	public void removeStudent() {
		System.out.println("enter student id");
		String id=scan.next();//String id=scan.next().touppercase();
		id=id.toUpperCase();
		if(db.containsKey(id)) {
			System.out.println("student record succesfully");
			System.out.println(db.get(id));//getting s object& printing it
			db.remove(id);
			System.out.println("student record deleted successfully");
		}
		else {
			try {
				String message="student with Id:"+id+"not found";
				throw new StudentNotFoundException(message);
			}
			catch(StudentNotFoundException e) {
				System.out.println(e.getmessage());
			}
		}

	}
	@Override

	public void removeAllStudent() {
		if(db.size()!=0) {
			System.out.println("Available student record:"+db.size());	 
			db.clear();
			System.out.println("All the student record deleted successfully");
		}
		else {
			try {
				String message="student Dtabase is Empty,Nothing to Delete";
				throw new StudentNotFoundException(message);
			}
			catch(StudentNotFoundException e) {
				System.out.println(e.getmessage());
			}
		}

	}

	@Override

	public void updateStudent() {
		System.out.println("enter student id");
		String id=scan.next();
		id=id.toUpperCase();
		if(db.containsKey(id))
		{
			Student s=db.get(id);
			System.out.println("1:update age\n2:update name\n3:update marks");
			System.out.println("Enter choice:");
			int choice=scan.nextInt();
			switch(choice)
			{
			case 1:System.out.println("Enter age");

			int age=scan.nextInt();
			s.setAge(age);
			System.out.println("age is updated succesfully");
			break;

			case 2:System.out.println("Enter name");
			String name=scan.next();
			s.setName(name);
			System.out.println("name is updated succesfully");


			case 3: System.out.println("Enter marks");
			int marks=scan.nextInt();
			s.setMarks(marks);
			System.out.println("marks are updated");

			default:
				try {
					throw new InvalidChoiceException("Invalid choice");
				}
				catch(Exception e) {
					System.out.println(e.getMessage());

				}
			}
		}

	}
	@Override
	public void countStudents() {
		System.out.println("Available student record:"+db.size()); 
	}
	@Override

	public void sortStudent() {
		if(db.size()>=2) {
			List<Student> l=new ArrayList<Student>();//
			Set <String> keys =db.keySet();//storing 101 102 103
			for(String key:keys) {
				l.add(db.get(key)); //getting &adding student object in Al
			}
			System.out.println("1:sort Student By Id\n2:sort student By Age\n3:sort student By name\n4:sort student By marks");    
			System.out.println("Enter choice");  
			int choice=scan.nextInt();
			switch(choice) {
			case 1:
				Collections.sort(l,new SortStudentById());//at time we can use display method for avoid for each loop
				for(Student s:l) {                                     //private static void display(List<student> l)
					System.out.println(s);                                      
				}
				break;
			case 2:
				Collections.sort(l,new SortStudentByAge());
				for(Student s:l) {
					System.out.println(s);
				}
				break;
			case 3:
				Collections.sort(l,new SortStudentByName());
				for(Student s:l) {
					System.out.println(s);
				}

				break;
			case 4:
				Collections.sort(l,new SortStudentByMarks());
				for(Student s:l) {
					System.out.println(s);
				}
				break;
			}
		}
		else {

			try {
				String message="No sufficient student record to sort";
				throw new StudentNotFoundException(message);

			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
	@Override

	public void getStudentwithHighestMarks() {
		if(db.size()>=2)
		{
			List<Student> l=new ArrayList<Student>();

			Set<String> keys=db.keySet();
			for(String key:keys) {
				l.add(db.get(key));//getting & ADDING STudent object in AL
			}
			Collections.sort(l,new SortStudentByMarks());
			System.out.println(l.get(l.size()-1));
		}
		else {
			try {
				String message="no sufficient student records to compare";
				throw new StudentNotFoundException(message);
			}
			catch(StudentNotFoundException e) {
				System.out.println(e.getmessage());
			}
		}
	}
	@Override
	public void getStudentwithLowestMarks() {
		if(db.size()>=2)
		{
			List<Student> l=new ArrayList<Student>();

			Set<String> keys=db.keySet();
			for(String key:keys) {
				l.add(db.get(key));//getting & ADDING STudent object in AL
			}
			Collections.sort(l,new SortStudentByMarks());
			System.out.println(l.get(0));
		}
		else {
			try {
				String message="no sufficient student records to compare";
				throw new StudentNotFoundException(message);
			}
			catch(StudentNotFoundException e) {
				System.out.println(e.getmessage());
			}
		}
	}

}















