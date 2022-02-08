package Bootathon_1;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import javax.swing.*;
import java.awt.*;
import Project1.Dataconnection;
import Bootathon_1.Insurance_form;
/*https://youtu.be/TAJoVkaVv-8*/

public class Login_form  implements ActionListener{
	JLabel l2,l0;
	JTextField eid;
	JPasswordField passw;
	JButton emp,adm;
	JFrame l=new JFrame();
	Container c=l.getContentPane();
	String lid;
	String ps;
	String namenow;
	
	Login_form(){
		l.setLayout(null);
		l.setBounds(480,200,600,360);
		l.setTitle("Login Form");
		c.setBackground(new Color(223, 249, 251));
		JLabel linl=new JLabel("LOGIN TO YOUR ACCOUNT");
		linl.setFont(new Font("Serif",Font.BOLD,20));
		linl.setForeground(new Color(234, 32, 39));	
		
		//labels
		l0=new JLabel("ENTER YOUR EMPLOYEE ID:");
		l2=new JLabel("ENTER YOUR PASSWORD:");
		eid=new JTextField();
		passw=new JPasswordField();
		JLabel em=new JLabel(new ImageIcon("C:\\Users\\haren\\Desktop\\Bootathon_1\\employee.png\\"));
		JLabel ad=new JLabel(new ImageIcon("C:\\Users\\haren\\Desktop\\Bootathon_1\\adminimg.png\\"));
		emp=new JButton("Login as Employee");
		adm=new JButton("Login as Admin");
		
		linl.setBounds(140,30,350,30);
		l0.setBounds(90,100,200,30);
		l2.setBounds(90,160,200,30);
		em.setBounds(75, 240, 30, 30);
		ad.setBounds(450,240,30,30);
		eid.setBounds(290,105,200,30);
		passw.setBounds(290,165,200,30);
		emp.setBounds(125,240,150,30);		
		adm.setBounds(290,240,150,30);
		
		adm.addActionListener(this);
		emp.addActionListener(this);
		
		l.add(l2);l.add(l0);l.add(em);
		l.add(eid);l.add(passw);l.add(ad);
		l.add(emp);l.add(adm);l.add(linl);
		l.setVisible (true);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object itemselected=e.getSource();
		 boolean flag=false;
		 Connection con=DataConnection.getConnection();
		 lid=eid.getText();
		 ps=passw.getText();
		 
		 //Employee login
		 if(itemselected==emp) {
			try {		
				   String nameno="select Name,Designation from employee where employeeID=?";
	               PreparedStatement pstmt1=con.prepareStatement(nameno);
	               pstmt1.setString(1,lid);
	               ResultSet rs1=pstmt1.executeQuery();
	               String namenow1="";
	               String desig="";
	               if(rs1.next()) {                
	                    namenow1 =rs1.getString("Name");
	                    desig=rs1.getString("Designation");
	                }
				   namenow=namenow1;
				  if(!desig.equals("Admin")) {
			          if(!(lid.equals("") || ps.equals(""))){	
			        	  String query="select Initial_Password from employee where employeeID=?";
			                PreparedStatement pstmt=con.prepareStatement(query);
			                pstmt.setString(1,lid);
			                ResultSet rs=pstmt.executeQuery();
			                String oripass="";
			                if(rs.next()) {                
			                    oripass=rs.getString("Initial_Password");
			                }              
			                if(oripass.equals(ps)) {
			                	flag=true;
			                	JOptionPane.showMessageDialog(null,"You are successfully Logged In!!");
			                }
			                else {
			                	JOptionPane.showMessageDialog(null, "Invalid Username or password!!");
			                }
			                if(flag==true) {
			                	l.dispose();
			                	new HomePage(lid,namenow,"employee");
			                }
			          }
			          else{
				         JOptionPane.showMessageDialog(null, "Value cannot be null");
			           }
				   }
			      else {
				      JOptionPane.showMessageDialog(null, "Login as Admin");	 
					}
              } 
			  catch(Exception ex) {
				 JOptionPane.showMessageDialog(null, ex.toString()+"Invalid Credentials");				
			  }
		}
		 
		 //Admin login
		  else if(itemselected==adm) {
			try {		
				   String nameno="select Name,Designation from employee where employeeID=?";
	               PreparedStatement pstmt1=con.prepareStatement(nameno);
	               pstmt1.setString(1,lid);
	               ResultSet rs1=pstmt1.executeQuery();
	               String namenow1="";
	               String desig1="";
	               if(rs1.next()) {                
	                    namenow1 =rs1.getString("Name");
	                    desig1=rs1.getString("Designation");
	                }
				   namenow=namenow1;
				   
				   if(desig1.equals("Admin")) {
					   if(!(lid.equals("") || ps.equals(""))){	
			                String query="select Initial_Password from employee where employeeID=?";
			                PreparedStatement pstmt=con.prepareStatement(query);
			                pstmt.setString(1,lid);
			                ResultSet rs=pstmt.executeQuery();
			                String oripass="";
			                if(rs.next()) {                
			                    oripass=rs.getString("Initial_Password");
			                }              
			                if(oripass.equals(ps)) {
			                	flag=true;
			                	JOptionPane.showMessageDialog(null,"You are successfully Logged In!!");
			                }
			                else {
			                	JOptionPane.showMessageDialog(null, "Invalid Username or password!!");
			                }
			                if(flag==true) {
			                	l.dispose();
			                	new HomePageAdmin(lid,namenow,"admin");
			                }
				         }
				       else{
					      JOptionPane.showMessageDialog(null, "Value cannot be null");
				        } 
				   }
				   else{
					  JOptionPane.showMessageDialog(null, "You are not an Admin");	 
				   }
              }
			  catch(Exception ex) {
				 JOptionPane.showMessageDialog(null, ex.toString()+"Invalid Credentials");				
			  }		
		}
        
	}

	public static void main(String[] args) {
		new Login_form();
 }
}
