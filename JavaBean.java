package Bootathon_1;


import java.util.Set;

class JavaBean {
	private String employeeID;
	private String Name;
	private String Age;
	private String Sex;
	private String Date_of_Birth;
	private String Designation;
	private String Email;
	private String Initial_Password;
	private String Fathers_name;
	private String Mothers_name;
	private String Mobile_number;
	private String Initial_Salary;
	private String Joining_date;
	private int leave_avail;
	private int leave_available;
	
	public void setEmployeeID(String employeeID) {
		this.employeeID = employeeID;
	}
	public String getEmployeeID() {
		return employeeID;
	}
	
	public void setName(String name) {
		Name = name;
	}
	public String getName() {
		return Name;
	}
	
	public void setAge(String age) {
		Age = age;
	}
	public String getAge() {
		return Age;
	}
	
	public void setSex(String sex) {
		Sex = sex;
	}
	public String getSex() {
		return Sex;
	}
	
	public void setDate_of_Birth(String date_of_Birth) {
		Date_of_Birth = date_of_Birth;
	}
	public String getDate_of_Birth() {
		return Date_of_Birth;
	}
	
	public void setDesignation(String designation) {
		Designation = designation;
	}
	public String getDesignation() {
		return Designation;
	}
	
	public void setEmail(String email) {
		Email = email;
	}
	public String getEmail() {
		return Email;
	}
	
	public void setInitial_Password(String initial_Password) {
		Initial_Password = initial_Password;
	}
	public String getInitial_Password() {
		return Initial_Password;
	}
	
	public void setFathers_name(String fathers_name) {
		Fathers_name = fathers_name;
	}
	public String getFathers_name() {
		return Fathers_name;
	}
	
	public void setMothers_name(String mothers_name) {
		Mothers_name = mothers_name;
	}
	public String getMothers_name() {
		return Mothers_name;
	}
	
	public void setMobile_number(String mobile_number) {
		Mobile_number = mobile_number;
	}
	public String getMobile_number() {
		return Mobile_number;
	}
	
	public void setInitial_Salary(String initial_Salary) {
		Initial_Salary = initial_Salary;
	}
	public String getInitial_Salary() {
		return Initial_Salary;
	}
	
	public void setJoining_date(String joining_date) {
		Joining_date = joining_date;
	}
	public String getJoining_date() {
		return Joining_date;
	}
	
	public void setLeave_avail(int leave_avail) {
		this.leave_avail = 0;
	}
	public int getLeave_avail() {
		return leave_avail;
	}
	
	public void setLeave_available(int leave_available) {
		this.leave_available = 5;
	}
	public int getLeave_available() {
		return leave_available;
	}
}