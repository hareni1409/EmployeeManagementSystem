package Bootathon_1;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.ItemSelectable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;


public class RegistrationForm extends JFrame implements ActionListener,ItemListener{

		 JLabel lbl_img,lbl_title,lbl_id,lbl_name,lbl_age,lbl_sex,lbl_dob,lbl_des,lbl_mail,lbl_pwd,lbl_fname,lbl_mname,lbl_mob,lbl_sal,lbl_date;
		 JTextField txt_id,txt_name,txt_age,txt_mail,txt_fname,txt_mname,txt_mob,txt_sal;
		 JDateChooser txt_dob,txt_date;
		 JPasswordField pwd;
		 ButtonGroup btngroup;
		 JRadioButton rdb_male,rdb_female,rdb_other;
		 JComboBox jcb_des;
		 JButton jbtn_submit,jbtn_back;
		 Container co1;
		 JFrame co=new JFrame();
		 String str_gender="";
 
 
 public RegistrationForm(String lid,String namenow,String user){
	 
				 co1=co.getContentPane();
			     co.setLayout(null);
			     setTitle("ADD EMPLOYEE");
			     co1.setBackground(new Color(223, 249, 251));
			     co.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			     
			     lbl_title=new JLabel("EMPLOYEE REGISTRATION");
			     lbl_title.setFont(new Font("Times New Roman",Font.BOLD,28));
				 lbl_title.setForeground(new Color(237, 76, 103));
			     lbl_title.setBounds(300, 30, 400, 25);
			     JLabel img=new JLabel(new ImageIcon("C:\\Users\\haren\\Desktop\\Bootathon_1\\customer.png"));
			     img.setBounds(700,25,40,40);
			     co.add(img);
			     lbl_title.setFont(new Font("Times new Roman", Font.BOLD, 26));
			     
			     //label
			     lbl_id=new JLabel("Employee ID");
			     lbl_name=new JLabel("Employee Name");
			     lbl_age=new JLabel("Age");     
			     lbl_sex=new JLabel("Gender");
			     lbl_dob=new JLabel("Date Of Birth");
			     lbl_des=new JLabel("Designation");
			     lbl_mail=new JLabel("Email ID");
			     lbl_pwd=new JLabel("Initial Password");
			     lbl_fname=new JLabel("Father's Name");
			     lbl_mname=new JLabel("Mother's Name");
			     lbl_mob=new JLabel("Mobile Number");
			     lbl_sal=new JLabel("Initial Salary");
			     lbl_date=new JLabel("Joining Date");
			     
			     //fields
			     txt_id=new JTextField();
			     txt_name=new JTextField();
			     txt_age=new JTextField();
			     txt_dob=new JDateChooser();
			     txt_mail=new JTextField();
			     pwd=new JPasswordField();
			     txt_fname=new JTextField();
			     txt_mname=new JTextField();
			     txt_mob=new JTextField();
			     txt_sal=new JTextField();
			     txt_date=new JDateChooser();
			     
			     pwd.setEchoChar('*');
			
			     btngroup=new ButtonGroup();
			     rdb_male=new JRadioButton("Male");
			     rdb_female=new JRadioButton("Female");
			     rdb_other=new JRadioButton("Others");
			     btngroup.add(rdb_male);
			     btngroup.add(rdb_female);
			     btngroup.add(rdb_other);
			
			     //adding items to combobox
			     jcb_des=new JComboBox<>();
			     jcb_des.addItem("Select");
			     jcb_des.addItem("HR Manager");
			     jcb_des.addItem("Admin");
			     jcb_des.addItem("Vice President");
			     jcb_des.addItem("Trainee Engineer");
			     jcb_des.addItem("Software Engineer");
			     jcb_des.addItem("System Analyst");
			     jcb_des.addItem("Project Manager");
			     jcb_des.addItem("Technical Specialist");
			    			
			     jbtn_submit=new JButton("Register Employee");
			     jbtn_back=new JButton("Go Back");
			    			
			     rdb_male.addItemListener(this);
			     rdb_female.addItemListener(this);
			     rdb_other.addItemListener(this);
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
			     lbl_sal.setBounds(550, 350, 350, 25);
			     lbl_date.setBounds(550, 400, 400, 25);
			     jbtn_submit.setBounds(240, 470, 210, 35);
			     jbtn_back.setBounds(550, 470, 210, 35);
			
			     txt_id.setBounds(250, 100, 200, 25);
			     txt_name.setBounds(250, 150, 200, 25);
			     txt_age.setBounds(250, 200, 200, 25);
			     rdb_male.setBounds(250, 250, 200, 25);
			     rdb_female.setBounds(250, 280, 200, 25);
			     rdb_other.setBounds(250, 310, 200, 25);
			     txt_dob.setBounds(250, 350, 200, 25);
			     txt_mob.setBounds(250, 400, 200, 25);
			     txt_mail.setBounds(700, 100, 200, 25);
			     pwd.setBounds(700, 150, 200, 25);
			     jcb_des.setBounds(700, 200, 200, 25);
			     txt_fname.setBounds(700, 250, 200, 25);
			     txt_mname.setBounds(700, 300, 200, 25);
			     txt_sal.setBounds(700, 350, 200, 25);
			     txt_date.setBounds(700, 400, 200, 25);
			     
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
			     
			    ActionListener back=(eme)->{
			 	    co.dispose();
			 	    new HomePageAdmin(lid,namenow,user);
			
			    };
			    jbtn_back.addActionListener(back);
			    
			     co.add(txt_id);
			     co.add(txt_name);
			     co.add(txt_age);
			     co.add(txt_dob);
			     co.add(rdb_male);
			     co.add(rdb_female);
			     co.add(txt_mail);
			     co.add(pwd);
			     co.add(txt_fname);
			     co.add(txt_mname);
			     co.add(txt_mob);
			     co.add(txt_sal);
			     co.add(txt_date);
			     
			     co.add(jcb_des);
			
			     co.setBounds(300,100,1000, 600);
			     co.setVisible(true);
 }

 public void itemStateChanged(ItemEvent ie){

     ItemSelectable itemselected=ie.getItemSelectable();

     if(itemselected==rdb_male){
             str_gender="Male";
     }
     else if(itemselected==rdb_female){
             str_gender="Female";
     }
     else if(itemselected==rdb_other){
         str_gender="Other";
 }
 }
 

 public void actionPerformed(ActionEvent ae){

     Object obj_source=ae.getSource();

     if(obj_source==jbtn_submit){
    	 try {
             String str_id=txt_id.getText();
             String str_name=txt_name.getText();
             String str_age=txt_age.getText();          
             DateFormat formater=new SimpleDateFormat("dd/MM/yyyy");
             String dat=(formater.parse(formater.format(txt_dob.getDate()))).toString(); 
             String str_mail=txt_mail.getText();
             String str_pwd=pwd.getText();
             String str_fname=txt_fname.getText();
             String str_mname=txt_mname.getText();
             String str_mob=txt_mob.getText();
             String str_sal=txt_sal.getText();
             DateFormat formater1=new SimpleDateFormat("dd/MM/yyyy");
             String str_date=(formater.parse(formater.format(txt_dob.getDate()))).toString(); 
             String str_des=jcb_des.getSelectedItem().toString();
             
             //regex
             Pattern name=Pattern.compile("^[a-zA-Z\\s]{1,15}+$");
             Matcher name1=name.matcher(str_name);
             if(name1.matches()){
            	 Pattern age=Pattern.compile("[0-9]{2}");
            	 Matcher age1=age.matcher(str_age);
            	 if(age1.matches()){
                  		 if(jcb_des.getSelectedItem()!="Select"){
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
						                    	 
             //creating javabean object            		 
             JavaBean ob=new JavaBean();
             ob.setEmployeeID(str_id);
             ob.setName(str_name);
             ob.setAge(str_age);
             ob.setSex(str_gender);
             ob.setDate_of_Birth(dat);
             ob.setDesignation(str_des);
             ob.setEmail(str_mail);
             ob.setInitial_Password(str_pwd);
             ob.setFathers_name(str_fname);
             ob.setMothers_name(str_mname);
             ob.setMobile_number(str_mob);
             ob.setInitial_Salary(str_sal);
             ob.setJoining_date(str_date);
             
             try {
  				DatabaseCon.con(ob);
  				
  			} catch (Exception e) {
  				JOptionPane.showMessageDialog(null, e);
  			}
             
             JOptionPane.showMessageDialog(null, "Registration Successfull");
             }
						                		else
						                    		JOptionPane.showMessageDialog(null,"Please select valid designation");
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
       catch(Exception e) {
            	 
             }
      }   	 
           
 } 
                
 public static void main(String args[]){
	 new RegistrationForm ("1","renu","");
 }
}