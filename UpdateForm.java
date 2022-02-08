package Bootathon_1;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class UpdateForm extends JFrame implements ActionListener{
	 JLabel lbl_img,lbl_title,lbl_id,lbl_name,lbl_age,lbl_sex,lbl_dob,lbl_des,lbl_mail,lbl_pwd,lbl_fname,lbl_mname,lbl_mob,lbl_sal,lbl_date;
	 JTextField txt_id,txt_name,txt_age,txt_dob,txt_mail,txt_pwd,txt_fname,txt_mname,txt_mob,txt_sal,txt_date;
	 ButtonGroup btngroup;
	 JRadioButton rdb_male,rdb_female,rdb_other;
	 JButton jbtn_submit,jbtn_back;
	 Container co1;
	 JFrame co=new JFrame();
	 String str_gender="";
	 JComboBox jcb_des;
	 
	 public UpdateForm(String lid,String name,String user){
		 
		 co1=co.getContentPane();
		 co1.setBackground(new Color(223, 249, 251));
	     co.setLayout(null);
	     setTitle("UPDATE");
	     co.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	     
	     
	     lbl_title=new JLabel("UPDATE EMPLOYEE DETAILS");
	     lbl_title.setBounds(400, 25, 400, 25);
	     //lbl_title.setFont(new Font("Times New Roman", Font.BOLD, 26));
	     
	     lbl_id=new JLabel("Employee ID");
	     //lbl_id.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 20));
	     lbl_name=new JLabel("Employee Name");
	     //lbl_name.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 20));
	     lbl_age=new JLabel("Age");     
	     //lbl_age.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 20));
	     lbl_sex=new JLabel("Gender");
	     //lbl_sex.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 20));
	     lbl_dob=new JLabel("Date Of Birth");
	     //lbl_dob.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 20));
	     lbl_des=new JLabel("Designation");
	     //lbl_des.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 20));
	     lbl_mail=new JLabel("Email ID");
	     //lbl_mail.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 20));
	     lbl_pwd=new JLabel("Initial Password");
	     //lbl_pwd.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 20));
	     lbl_fname=new JLabel("Father's Name");
	     //lbl_fname.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 20));
	     lbl_mname=new JLabel("Mother's Name");
	     //lbl_mname.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 20));
	     lbl_mob=new JLabel("Mobile Number");
	     //lbl_mob.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 20));
	     lbl_sal=new JLabel("Initial Salary");
	     //lbl_sal.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 20));
	     lbl_date=new JLabel("Joining Date");
	     //lbl_date.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 20));
	     
	     txt_id=new JTextField();
	     txt_name=new JTextField();
	     txt_age=new JTextField();
	     txt_dob=new JTextField();
	     jcb_des=new JComboBox();
	     txt_mail=new JTextField();
	     txt_pwd=new JTextField();
	     txt_fname=new JTextField();
	     txt_mname=new JTextField();
	     txt_mob=new JTextField();
	     txt_sal=new JTextField();
	     txt_date=new JTextField();
	     
	     btngroup=new ButtonGroup();

	     rdb_male=new JRadioButton("Male");
	     //rdb_male.setFont(new Font("Times New Roman", Font.ITALIC, 20));
	     rdb_female=new JRadioButton("Female");
	     //rdb_female.setFont(new Font("Times New Roman", Font.ITALIC, 20));
	     rdb_other=new JRadioButton("Others");
	     btngroup.add(rdb_male);
	     btngroup.add(rdb_female);
	     btngroup.add(rdb_other);

	     jbtn_submit=new JButton("Update Employee");
	     //jbtn_submit.setFont(new Font("Times New Roman", Font.ITALIC, 20));
	     jbtn_back=new JButton("Go Back");
	     //jbtn_back.setFont(new Font("Times New Roman", Font.ITALIC, 20));

	     jbtn_submit.addActionListener(this);
	     
	     lbl_id.setBounds(100, 100, 300, 25);
	     lbl_name.setBounds(100, 150, 300, 25);
	     lbl_age.setBounds(100, 200, 300, 25);
	     lbl_sex.setBounds(100, 250, 300, 25);
	     lbl_dob.setBounds(100, 350, 300, 25);
	     lbl_mob.setBounds(100, 400, 300, 25);
	     lbl_mail.setBounds(550, 100, 300, 25);
	     lbl_pwd.setBounds(550, 150, 300, 25);
	     lbl_des.setBounds(550, 200, 300, 25);
	     lbl_fname.setBounds(550, 250, 300, 25);
	     lbl_mname.setBounds(550, 300, 300, 25);
	     lbl_sal.setBounds(550, 350, 300, 25);
	     lbl_date.setBounds(550, 400, 300, 25);
	     jbtn_submit.setBounds(270, 470, 210, 35);
	     jbtn_back.setBounds(550, 470, 210, 35);

	     
	     txt_id.setBounds(250, 100, 175, 25);
	     txt_name.setBounds(250, 150, 175, 25);
	     txt_age.setBounds(250, 200, 175, 25);
	     rdb_male.setBounds(250, 250, 175, 25);
	     rdb_female.setBounds(250, 280, 175, 25);
	     rdb_other.setBounds(250, 310, 175, 25);
	     txt_dob.setBounds(250, 350, 175, 25);
	     txt_mob.setBounds(250, 400, 175, 25);
	     txt_mail.setBounds(700, 100, 175, 25);
	     txt_pwd.setBounds(700, 150, 175, 25);
	     jcb_des.setBounds(700, 200, 175, 25);
	     txt_fname.setBounds(700, 250, 175, 25);
	     txt_mname.setBounds(700, 300, 175, 25);
	     txt_sal.setBounds(700, 350, 175, 25);
	     txt_date.setBounds(700, 400, 175, 25);
	     
	     co.add(lbl_title);
	     co.add(lbl_id);
	     co.add(lbl_name);
	     co.add(lbl_age);
	     co.add(lbl_sex);
	     co.add(lbl_dob);
	     co.add(lbl_des);
	     co.add(lbl_mail);
	     co.add(lbl_pwd);
	     co.add(lbl_fname);
	     co.add(lbl_mname);
	     co.add(lbl_mob);
	     co.add(lbl_sal);
	     co.add(lbl_date);
	     co.add(jbtn_submit);
	     co.add(jbtn_back);
	     co.add(rdb_other);
	     jbtn_back.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		co.dispose();
	        		if(user.equals("employee"))
	          		  new HomePage(lid,name,user);
	             		else if(user.equals("admin"))
	             			new HomePageAdmin(lid,name,user);
	        	}
	        });
	     
	     jcb_des.addItem("Select");
	     jcb_des.addItem("HR Manager");
	     //jcb_des.setFont(new Font("Times New Roman", Font.ITALIC, 20));
	     jcb_des.addItem("Admin");
	     //jcb_des.setFont(new Font("Times New Roman", Font.ITALIC, 20));
	     jcb_des.addItem("Vice President");
	     //jcb_des.setFont(new Font("Times New Roman", Font.ITALIC, 20));
	     jcb_des.addItem("Trainee Engineer");
	     //jcb_des.setFont(new Font("Times New Roman", Font.ITALIC, 20));
	     jcb_des.addItem("Software Engineer");
	     //jcb_des.setFont(new Font("Times New Roman", Font.ITALIC, 20));
	     jcb_des.addItem("System Analyst");
	     //jcb_des.setFont(new Font("Times New Roman", Font.ITALIC, 20));
	     jcb_des.addItem("Project Manager");
	     //jcb_des.setFont(new Font("Times New Roman", Font.ITALIC, 20));
	     jcb_des.addItem("Technical Specialist");
	     co.add(txt_id);
	     co.add(txt_name);
	     co.add(txt_age);
	     co.add(txt_dob);
	     co.add(jcb_des);
	     co.add(rdb_male);
	     co.add(rdb_female);
	     co.add(txt_mail);
	     co.add(txt_pwd);
	     co.add(txt_fname);
	     co.add(txt_mname);
	     co.add(txt_mob);
	     co.add(txt_sal);
	     co.add(txt_date);
	     
	     
	     co.setBounds(300,70,1000, 600);
	     co.setVisible(true);
	        
	             try{
	                 Class.forName("oracle.jdbc.driver.OracleDriver");
	                 Connection con=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","me","me");
	                 String query="select * from employee where employeeID=?";
	                 PreparedStatement pstmt=con.prepareStatement(query);

	                 pstmt.setString(1,lid);

	                 ResultSet rst=pstmt.executeQuery();
	                 if(rst.next()){
	                	 txt_id.setText(rst.getString("employeeID"));
	                     txt_name.setText(rst.getString("Name"));
	                     txt_age.setText(rst.getString("Age"));
	                     String gen=rst.getString("Sex");
	                     System.out.println("---->"+gen);
	                     if(gen.equals("Female")){
	                    	 rdb_male.setSelected(false);
	                    	 rdb_female.setSelected(true);
	                     }
	                     else if(gen.equals("Male")){
	                    	 rdb_female.setSelected(false);
	                    	 rdb_male.setSelected(true);
	                     }
	                     else if(gen.equals("Other")){
	                    	 rdb_female.setSelected(false);
	                    	 rdb_male.setSelected(true);
	                     }
	                     txt_dob.setText(rst.getString("Date_of_Birth"));
	                     jcb_des.setSelectedItem(rst.getString("Designation"));
	                     txt_mail.setText(rst.getString("Email"));
	                     txt_pwd.setText(rst.getString("Initial_Password"));
	                     txt_fname.setText(rst.getString("Fathers_name"));
	                     txt_mname.setText(rst.getString("Mothers_name"));
	                     txt_mob.setText(rst.getString("Mobile_number"));
	                     txt_sal.setText(rst.getString("Initial_Salary"));
	                     txt_date.setText(rst.getString("Joining_date"));
	                     str_gender=gen;
	                     
	                     txt_dob.setEditable(false);
	                     txt_date.setEditable(false);
	                     
	                 }
	            }
	            catch(Exception ex){
	               JOptionPane.showMessageDialog(this,"++++"+ex.toString());

	            }

}


	 public void actionPerformed(ActionEvent ae){

	     Object obj_source=ae.getSource();
	     if(obj_source==jbtn_submit){
	    	 String str_id=txt_id.getText();
	    	 String str_name=txt_name.getText();
             String str_age=txt_age.getText();
             String str_dob=txt_dob.getText();
             String str_mail=txt_mail.getText();
             String str_pwd=txt_pwd.getText();
             String str_fname=txt_fname.getText();
             String str_mname=txt_mname.getText();
             String str_mob=txt_mob.getText();
             String str_sal=txt_sal.getText();
             String str_date=txt_date.getText();
             String str_des=jcb_des.getSelectedItem().toString();
             
             Pattern name=Pattern.compile("^[a-zA-Z\\s]{1,15}+$");
             Matcher name1=name.matcher(str_name);
             if(name1.matches()){
            	 Pattern age=Pattern.compile("[0-9]{2}");
            	 Matcher age1=age.matcher(str_age);
            	 if(age1.matches()){
//            		 Pattern dob=Pattern.compile("^(1[0-2]|0[1-9])/(3[01]"+"|[12][0-9]|0[1-9])/[0-9]{4}$");
//            		 Matcher dob1=dob.matcher(str_dob);
//            		 if(dob1.matches()){
            			 Pattern mail=Pattern.compile("[a-zA-Z0-9_/-/.]+[@][a-z]+[/.][a-z]{2,3}");
                    	 Matcher mail1=mail.matcher(str_mail);
                    	 if(mail1.matches()){
                    		 Pattern pwd=Pattern.compile("^[a-zA-Z0-9]{4,15}");
                        	 Matcher pwd1=pwd.matcher(str_pwd);
                        	 if(pwd1.matches()){
                        		 Pattern fname=Pattern.compile("^[a-zA-Z\\s]{1,15}+$");
                        		 Matcher fname1=fname.matcher(str_fname);
                        		 if(fname1.matches()){
			                    	 Pattern mname=Pattern.compile("^[a-zA-Z\\s]{1,15}+$");
			                		 Matcher mname1=mname.matcher(str_mname);
						             if(mname1.matches()){
						            	 Pattern mob=Pattern.compile("[6789][0-9]{9}+");
						    			 Matcher mob1=mob.matcher(str_mob);
						                 if(mob1.matches()){
						                	 Pattern sal=Pattern.compile("[0-9]{3,8}");
						        			 Matcher sal1=sal.matcher(str_sal);
						                     if(sal1.matches()){
                           		 
             JavaBean ob=new JavaBean();
             ob.setEmployeeID(str_id);
             ob.setName(str_name);
             ob.setAge(str_age);
             ob.setSex("Female");
             ob.setDate_of_Birth(str_dob);
             ob.setDesignation(str_des);
             ob.setEmail(str_mail);
             ob.setInitial_Password(str_pwd);
             ob.setFathers_name(str_fname);
             ob.setMothers_name(str_mname);
             ob.setMobile_number(str_mob);
             ob.setInitial_Salary(str_sal);
             ob.setJoining_date(str_date);
            
             try{
                 
                 Connection con1=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","me","me");
                 
                 String query1="update employee set Name=?,Age=?,Sex=?,Date_of_Birth=?,Designation=?,Email=?,Initial_Password=?,Fathers_name=?,Mothers_name=?,Mobile_number=?,Initial_Salary=?,Joining_date=? where employeeID=?";
                 
                 PreparedStatement pstmt=con1.prepareStatement(query1);
                 pstmt.setString(13, ob.getEmployeeID());
                 pstmt.setString(1, ob.getName());
                 pstmt.setString(2, ob.getAge());
                 pstmt.setString(3, ob.getSex());
                 pstmt.setString(4, ob.getDate_of_Birth());
                 pstmt.setString(5, ob.getDesignation());
                 pstmt.setString(6, ob.getEmail());
                 pstmt.setString(7, ob.getInitial_Password());
                 pstmt.setString(8, ob.getFathers_name());
                 pstmt.setString(9, ob.getMothers_name());
                 pstmt.setString(10, ob.getMobile_number());
                 pstmt.setString(11, ob.getInitial_Salary());
                 pstmt.setString(12, ob.getJoining_date());
                 pstmt.executeUpdate();
                 con1.setAutoCommit(true);
                 JOptionPane.showMessageDialog(this, "Updation Success!");
                 }
                 
                 catch(Exception ex){
                     JOptionPane.showMessageDialog(this,"----"+ex.toString());
                 }          	 
                 
	     }

						                     else
										   		 JOptionPane.showMessageDialog(null, "Please enter valid Initial Salary");                       		 
										 }
						                 else
					                		 JOptionPane.showMessageDialog(null, "Please enter valid mobile number");                       		 
					                     }
						             else
	                                	 JOptionPane.showMessageDialog(null, "Please enter valid Mother's Name");
	                               }
                        		 else
                                	 JOptionPane.showMessageDialog(null, "Please enter valid Father's Name");
                               }
                        	 else
                        		 JOptionPane.showMessageDialog(null, "Please enter valid password");
                    	 	}
                    	 else
	                		 JOptionPane.showMessageDialog(null, "Please enter valid Mail ID");
	                    }
              	 else
            		 JOptionPane.showMessageDialog(null, "Please enter valid Age");
             	}
             else
           		 JOptionPane.showMessageDialog(null,"Please enter valid Name");
         	}
           
 } 
	 public static void main(String args[]){
	     new UpdateForm("25","hareni","admin");
	 }
}
