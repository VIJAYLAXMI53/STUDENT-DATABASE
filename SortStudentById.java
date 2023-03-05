package customsorting;

import java.util.Comparator;

import sdbms.Student;

public class SortStudentById implements Comparator<Student>{
 public int compare(Student x,Student y) {
	 return x.getId().compareTo(y.getId());//id is in the private so we use get id and it is in the string
 }
}
