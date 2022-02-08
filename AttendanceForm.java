package Bootathon_1;

import java.util.*;
import java.text.*;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;

public class AttendanceForm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel content;
	private JTextField namefield;
	private JTextField emailfield;
	
     
	public AttendanceForm(String empID,String uname,String user1){
		setTitle("Attendance");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(5, 5, 1602, 80);
		
		content = new JPanel();
		content.setBackground(new Color(223, 249, 251));
		content.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(content);
		content.setLayout(null);
		
		JLabel attendanceheading = new JLabel("Attendance");
		attendanceheading.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 41));
		attendanceheading.setBounds(666, 10, 209, 87);
		content.add(attendanceheading);
		
		JLabel profilepic = new JLabel("");
		profilepic.setIcon(new ImageIcon("C:\\Users\\haren\\Desktop\\Bootathon_1\\dummy_profile_1_200x200.png"));
		profilepic.setBounds(1177, 90, 209, 221);
		content.add(profilepic);
		
		JLabel name = new JLabel("Name of the Employee:");
		name.setFont(new Font("Times New Roman", Font.BOLD, 24));
		name.setBounds(33, 407, 290, 27);
		content.add(name);
		
		namefield = new JTextField();
		namefield.setFont(new Font("Tahoma", Font.PLAIN, 19));
		namefield.setEditable(false);
		namefield.setBounds(370, 407, 253, 36);
		content.add(namefield);
		namefield.setColumns(10);
		
		  
		JLabel attendanceL = new JLabel("Attendance:");
		attendanceL.setFont(new Font("Times New Roman", Font.BOLD, 24));
		attendanceL.setBounds(930, 493, 144, 31);
		content.add(attendanceL);
		
		JRadioButton presentradio = new JRadioButton("Present",true);
		presentradio.setBackground(new Color(240, 248, 255));
		presentradio.setFocusable(false);
		presentradio.setFont(new Font("Times New Roman", Font.ITALIC, 22));
		presentradio.setBounds(1148, 497, 114, 27);
		content.add(presentradio);
		
		JRadioButton leaveradio = new JRadioButton("Sick leave",false);
		leaveradio.setBackground(new Color(240, 248, 255));
		leaveradio.setFocusable(false);
		leaveradio.setFont(new Font("Times New Roman", Font.ITALIC, 22));
		leaveradio.setBounds(1148, 551, 114, 21);
		content.add(leaveradio);
		
		JRadioButton permittedradio = new JRadioButton("Permitted leave",false);
		permittedradio.setBackground(new Color(240, 248, 255));
		permittedradio.setFocusable(false);
		permittedradio.setFont(new Font("Times New Roman", Font.ITALIC, 22));
		permittedradio.setBounds(1148, 604, 181, 21);
		content.add(permittedradio);
		
		ButtonGroup bg=new ButtonGroup(); 
		bg.add(presentradio);
		bg.add(leaveradio);
		bg.add(permittedradio);
		
		JLabel workL = new JLabel("Number of working days:");
		workL.setFont(new Font("Rockwell", Font.PLAIN, 28));
		workL.setBounds(279, 131, 365, 56);
		content.add(workL);
		
		JLabel workdays = new JLabel("23 days");
		workdays.setFont(new Font("Rockwell", Font.ITALIC, 28));
		workdays.setBounds(675, 139, 137, 40);
		content.add(workdays);
		
		JLabel leaveL = new JLabel("Number of leave availed:");
		leaveL.setFont(new Font("Rockwell", Font.PLAIN, 28));
		leaveL.setBounds(279, 197, 344, 64);
		content.add(leaveL);
		
		JLabel leavetakendays = new JLabel("");
		leavetakendays.setFont(new Font("Rockwell", Font.ITALIC, 28));
		leavetakendays.setBounds(675, 209, 137, 40);
		content.add(leavetakendays);
		
		JLabel leaveleftL = new JLabel("Number of leave available:");
		leaveleftL.setFont(new Font("Rockwell", Font.PLAIN, 28));
		leaveleftL.setBounds(279, 271, 365, 64);
		content.add(leaveleftL);
		
		JLabel leaveleftdays = new JLabel("");
		leaveleftdays.setFont(new Font("Rockwell", Font.ITALIC, 28));
		leaveleftdays.setBounds(675, 282, 137, 40);
		content.add(leaveleftdays);
		
		JLabel email = new JLabel("Email ID:");
		email.setFont(new Font("Times New Roman", Font.BOLD, 24));
		email.setBounds(33, 508, 104, 27);
		content.add(email);
		
		
		emailfield = new JTextField();
		emailfield.setFont(new Font("Tahoma", Font.PLAIN, 19));
		emailfield.setEditable(false);
		emailfield.setColumns(10);
		emailfield.setBounds(370, 508, 253, 36);
		content.add(emailfield);
		
	
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBackground(new Color(176, 224, 230));
		btnSubmit.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnSubmit.setBounds(571, 692, 128, 36);
		content.add(btnSubmit);
		
		
		btnSubmit.addActionListener(new ActionListener() {
			@SuppressWarnings("unlikely-arg-type")
			
			public void actionPerformed(ActionEvent e) {
				System.out.println("Submitted");
	
				if(leaveradio.isSelected()) {
					System.out.println("leavee");
					try {
						//Creating Connection Object
						Connection connection = DataConnection.getConnection();
						Statement statement  = connection.createStatement();
						String sql = "SELECT leave_available, leave_avail FROM employee WHERE employeeID='"+empID+"'";
						ResultSet result =  statement.executeQuery(sql);
						int remainingleave=0,absents=0;
						while(result.next()) {
							System.out.println("inside while loop");
							String left = result.getString("leave_available");
							remainingleave = Integer.parseInt(left);
							System.out.println(left);
							System.out.println(remainingleave--);
							String taken = result.getString("leave_avail");
							absents = Integer.parseInt(taken);
							
						}
						System.out.println(remainingleave);
						System.out.println(absents);
						
		                //Specifying the values of it's parameter
		                if(remainingleave>=0) {
		                	String sql1 = "update employee set leave_available =?, leave_avail=? where employeeID='"+empID+"'";
		                	PreparedStatement Pstatement=connection.prepareStatement(sql1);
		                	Pstatement.setInt(1,remainingleave);
		                	Pstatement.setInt(2,absents);
		                	Pstatement.executeUpdate();
		                	
		                }
		                else {
		                	JOptionPane.showMessageDialog(null,"Leave exceeded! Please meet the manager.");
		                }
		                
		                sql = "SELECT leave_available, leave_avail FROM employee WHERE employeeID='"+empID+"'";
		     			result =  statement.executeQuery(sql);
		                while(result.next()) {
		                 	String left = result.getString("leave_available");
		                 	leaveleftdays.setText(left+" day(s)");
		                 	
		                 	String taken = result.getString("leave_avail");
		                 	leavetakendays.setText(taken+" day(s)");
		                }
		    		
		    			connection.setAutoCommit(true);
		        		connection.close();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
		
				JOptionPane.showMessageDialog(null,"Attendance Submitted Successfully!");
				presentradio.setEnabled(false);
				leaveradio.setEnabled(false);
				permittedradio.setEnabled(false);
				btnSubmit.setEnabled(false);
				
				
			}
		});
	
		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnGoBack.setBackground(new Color(176, 224, 230));
		btnGoBack.setBounds(778, 692, 128, 36);
		content.add(btnGoBack);
		
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				if(user1.equals("employee"))
	        		  new HomePage(empID,uname,user1);
	           		else if(user1.equals("admin"))
	           			new HomePageAdmin(empID,uname,user1);
			}
		});
		
		JLabel datetimeL = new JLabel("Date & Time:");
		datetimeL.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 23));
		datetimeL.setBounds(930, 384, 137, 50);
		content.add(datetimeL);
		
		Date date = Calendar.getInstance().getTime();  
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy, HH:mm:ss");  
		String strDate = dateFormat.format(date);  
		JLabel todayDate = new JLabel(strDate);
		todayDate.setFont(new Font("Serif", Font.ITALIC, 22));
		todayDate.setBounds(1148, 396, 209, 27);
		content.add(todayDate);
		
		
		try {
			Connection connection=DataConnection.getConnection();
            String sql = "SELECT Email, Name FROM employee WHERE employeeID='"+empID+"'";
            Statement statement  = connection.createStatement();
			ResultSet result =  statement.executeQuery(sql);
			while(result.next()) {
				String mailid = result.getString("Email");
				String user = result.getString("Name");
				namefield.setText(user);
                emailfield.setText(mailid);
                System.out.println(mailid);
			}
			sql = "SELECT leave_available, leave_avail FROM employee WHERE employeeID='"+empID+"'";
 			result =  statement.executeQuery(sql);
            while(result.next()) {
             	String left = result.getString("leave_available");
             	leaveleftdays.setText(left+" day(s)");
             	
             	String taken = result.getString("leave_avail");
             	leavetakendays.setText(taken+" day(s)");
            }
		}catch (SQLException e1) {
			e1.printStackTrace();
		}
		  
	}
	
}

