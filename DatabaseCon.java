package Bootathon_1;

import Bootathon_1.RegistrationForm;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseCon {
	private static Connection con;
	private static Connection con1;
	public static Connection con(JavaBean ob) {
        
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","me","me");
            Statement st=con.createStatement();
            
            String query="insert into employee values('" + ob.getEmployeeID() +"','" + ob.getName()+ "','" + ob.getAge() +"','" + ob.getSex() +"','" + ob.getDate_of_Birth() +"','" + ob.getDesignation() +"','" + ob.getEmail() +"','" + ob.getInitial_Password() +"','" + ob.getFathers_name() +"','" + ob.getMothers_name() +"','" + ob.getMobile_number() +"','" + ob.getInitial_Salary() +"','" + ob.getJoining_date() +"','" + "0" +"','" + "5" +"')";
            st.executeUpdate(query);
            con.setAutoCommit(true);
            con.close();
            System.out.println("Successfully added to the database!");
        }
        catch(Exception e){
        	System.out.println(e);
        }
        return con;
	}
}

//create table employee(employeeID varchar2(4) primary key, Name varchar2(20),Age varchar2(3),Sex varchar2(10),Date_of_Birth varchar2(30),
//		 Designation varchar2(25),Email varchar2(30),Initial_Password varchar2(25),Fathers_name varchar2(20),Mothers_name varchar2(20),
//    Mobile_number varchar2(10),Initial_Salary varchar2(10),Joining_date varchar2(30),leave_avail varchar2(10), leave_available varchar2(10));