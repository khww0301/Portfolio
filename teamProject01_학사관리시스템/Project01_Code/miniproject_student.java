package classes;
import java.util.ArrayList;

public class miniproject_student extends miniproject_info
{
	String attendance;//출석
	ArrayList<String[]> result = new ArrayList<>();//성적
	public miniproject_student(String id, String name, String phonenum, String password, String field, String email){
		this.id = id;
		this.name = name;
		this.email = email;
		this.phonenum = phonenum;
		this.password = password;
		this.field = field;
		this.email = email;
	}
	public void setAttendance(String attendance){
		this.attendance = attendance;
	}

	public void setResult(ArrayList<String[]> result){
		this.result = result;
	}

	
	public String getAttendance(){
		return attendance;
	}
	
	public ArrayList<String[]> getResult(){
		return result;
	}
	
}
