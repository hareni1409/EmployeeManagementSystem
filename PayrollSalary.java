package Bootathon_1;

import java.sql.*;

import java.util.Properties;
import javax.mail.Authenticator;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import javax.swing.*;

import Project1.Dataconnection;

import java.awt.*;
import java.awt.event.*;


public class PayrollSalary extends JFrame {
	private JTextField empidfield;
	private JTextArea t1;
	private JTextField nameField;
	private JTextField mailField;
	private JTextField designationField;
	private JTextField insuranceField;
	private JTextField salaryField;
	 static String lid1;
	 static String sal1,ins1,mail1,user;
		static String namenow1;

    PayrollSalary(String lid,String namenow,String user1){
    	  	
    	lid1=lid;
    	namenow1=namenow;
    	user=user1;
    	getContentPane().setBackground(new Color(224, 255, 255));
    	setTitle("Payroll");

        setSize(881,773);
        setLocation(300,0);
        getContentPane().setLayout(null);
        
        JLabel headingLabel = new JLabel("Pay Slip");
        headingLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 29));
        headingLabel.setBounds(395, 21, 114, 67);
        getContentPane().add(headingLabel);
        
        JLabel lblNewLabel = new JLabel("Employee ID");
        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 21));
        lblNewLabel.setBounds(195, 125, 131, 25);
        getContentPane().add(lblNewLabel);
        
        empidfield = new JTextField();
        empidfield.setEditable(false);
        empidfield.setBounds(441, 125, 203, 30);
        getContentPane().add(empidfield);
        empidfield.setColumns(10);
        
        JLabel namelabel = new JLabel("Employee Name");
        namelabel.setFont(new Font("Times New Roman", Font.BOLD, 21));
        namelabel.setBounds(195, 200, 165, 25);
        getContentPane().add(namelabel);
        
        nameField = new JTextField();
        nameField.setEditable(false);
        nameField.setColumns(10);
        nameField.setBounds(441, 200, 203, 30);
        getContentPane().add(nameField);
        
        JLabel mailLabel = new JLabel("Mail ID");
        mailLabel.setFont(new Font("Times New Roman", Font.BOLD, 21));
        mailLabel.setBounds(195, 275, 165, 25);
        getContentPane().add(mailLabel);
        
        mailField = new JTextField();
        mailField.setEditable(false);
        mailField.setColumns(10);
        mailField.setBounds(441, 275, 203, 30);
        getContentPane().add(mailField);
        
        JLabel designationLabel = new JLabel("Designation");
        designationLabel.setFont(new Font("Times New Roman", Font.BOLD, 21));
        designationLabel.setBounds(195, 350, 165, 25);
        getContentPane().add(designationLabel);
        
        designationField = new JTextField();
        designationField.setEditable(false);
        designationField.setColumns(10);
        designationField.setBounds(441, 350, 203, 30);
        getContentPane().add(designationField);
        
        JLabel insuranceLabel = new JLabel("Insurance");
        insuranceLabel.setFont(new Font("Times New Roman", Font.BOLD, 21));
        insuranceLabel.setBounds(195, 425, 165, 25);
        getContentPane().add(insuranceLabel);
        
        insuranceField = new JTextField();
        insuranceField.setEditable(false);
        insuranceField.setColumns(10);
        insuranceField.setBounds(441, 425, 203, 30);
        getContentPane().add(insuranceField);
        
        JLabel salaryLabel = new JLabel("Basic Salary");
        salaryLabel.setFont(new Font("Times New Roman", Font.BOLD, 21));
        salaryLabel.setBounds(195, 500, 165, 25);
        getContentPane().add(salaryLabel);
        
        salaryField = new JTextField();
        salaryField.setEditable(false);
        salaryField.setColumns(10);
        salaryField.setBounds(441, 500, 203, 30);
        getContentPane().add(salaryField);
        
        String name="";
        String mail="";
        String desig="";
        String insure="";
        String sal="";
        
        try{
           Connection con=Dataconnection.getConnection();
	       String query="select * from employee where employeeID=?";
           PreparedStatement pstmt=con.prepareStatement(query);
           pstmt.setString(1,lid1);
           ResultSet rs=pstmt.executeQuery();
           
           String query1="select * from insurance where EMPID=?";
           PreparedStatement pstmt1=con.prepareStatement(query1);
           pstmt1.setString(1,lid1);
           ResultSet rs1=pstmt1.executeQuery();
	        while(rs.next()) {
	        	
	        name = rs.getString("Name");
	        mail=rs.getString("Email");
	        desig=rs.getString("Designation");
	        sal=rs.getString("Initial_Salary");
	        }
	        System.out.println(name+"hel"+mail+""+desig+""+sal);
	        while(rs1.next()) {
	        	insure=rs1.getString("Amount");
	        }
	        empidfield.setText(lid);
	        nameField.setText(name);
	        mailField.setText(mail);
	        designationField.setText(desig);
	        salaryField.setText(sal);
	        insuranceField.setText(insure);
        }
        catch(Exception ee) {
            ee.printStackTrace();
        }

        sal1=sal;
        ins1=insure;
        mail1=mail;
        
        JButton payrollbtn = new JButton("View payroll\r\n\r\n");
        payrollbtn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		try{
                	Connection connection = DataConnection.getConnection();
                	Statement s  = connection.createStatement();
                	
                	t1 = new JTextArea();
                	t1.setFont(new Font("Calibri", Font.BOLD, 18));
                	t1.setEditable(false);
                	t1.setBounds(145, 200, 612, 396);
                	getContentPane().add(t1);
                	
                	JButton mailbtn = new JButton("");
               
                	//mail function
                    mailbtn.addActionListener(new ActionListener() {
                    	public void actionPerformed(ActionEvent e) {
                    		mailfun(t1.getText());
                    	}
                    });
                    mailbtn.setBorder(null);
                    mailbtn.setBackground(new Color(224, 255, 255));
                    mailbtn.setIcon(new ImageIcon("C:\\Users\\haren\\Desktop\\Bootathon_1\\mail.png\\"));
                    mailbtn.setBounds(402, 635, 63, 43);
                    getContentPane().add(mailbtn);
                    

                    double gross=0;
                    double net=0;
                                           
                        //setting payroll in text area
                        t1.append("\n\t             Employee ID   :  "+lid1);
                        t1.append("\n\t             Employee Name :  "+namenow1);

                        t1.append("\n----------------------------------------------------------------------------------------------------------------");
                        t1.append("\n");

                       
                        double hra = 40.8;
                        t1.append("\n  HRA                    : "+hra);
                                                                   
                        double da = 0.4*Integer.parseInt(sal1);
                        t1.append("\n  DA                       : "+da);
                        
                        double ins=Integer.parseInt(ins1);
                        t1.append("\n  INSURANCE      : "+ins);
                        
                        double pf = 0.2*Integer.parseInt(sal1);
                        t1.append("\n  PF                        : "+pf);
                        
                        double basic = 				Integer.parseInt(sal1);
                        gross = basic-(hra+da+ins);
                        net = gross - pf;
                        t1.append("\n  BASIC SALARY : "+basic);

                        t1.append("\n----------------------------------------------------------------------------------------------------------------");
                        t1.append("\n");

                        t1.append("\n  GROSS SALARY   :    "+gross+"    \n  NET SALARY        :    "+net);
                        t1.append("\n  TAX                        :    2.1% of gross "+ (gross*2.1/100));   
                        t1.append("\n----------------------------------------------------------------------------------------------------------------");
                        t1.append("\n");
                        t1.append("\n");    
                        t1.append("\n");
                        t1.append("   (  Signature  )      ");
                        System.out.println("end of if");
                    
                }
        		catch(Exception ee) {
                    ee.printStackTrace();
                }        		
        	}
        });
        
        payrollbtn.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        payrollbtn.setBounds(171, 635, 131, 36);
        getContentPane().add(payrollbtn);
        
        JButton btnGoBack = new JButton("Go Back");
        btnGoBack.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        		if(user.equals("employee"))
          		  new HomePage(lid1,namenow1,user);
             		else if(user.equals("admin"))
             			new HomePageAdmin(lid1,namenow1,user);
        	}
        });
        
        btnGoBack.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        btnGoBack.setBounds(562, 635, 114, 36);
        getContentPane().add(btnGoBack);
            
        setVisible(true);
        
    }
    
    //mailing
    public static void mailfun(String value) {
    	final String username = "mghprivateltd1@gmail.com";
		final String password = "Password!1";

        final String from = "mghprivateltd1@gmail.com";
        final String to = mail1;

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,new Authenticator() {

                        @Override
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(username, password);
                        }

                });
		
		try {
            
			Message message = new MimeMessage(session);

			message.setFrom(new InternetAddress(from));
			message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(to));
			message.setSubject("Your payslip is ready.");
			message.setText(value);

			Transport.send(message);

			JOptionPane.showMessageDialog(null, "Email sent successfully!!");

		} 
		catch (MessagingException ex) {
			ex.printStackTrace();
		}
		
    }
  
    public static void main(String[] args){
       	new PayrollSalary("21","gowshini","");
    }
}