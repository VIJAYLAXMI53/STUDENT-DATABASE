package customexp;

public class StudentNotFoundException extends RuntimeException{
 private String message;
 public StudentNotFoundException(String message){
	this.message=message;
	
}
 
public String getmessage() {
	return message;
}
}
