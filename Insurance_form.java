/*create table insurance(EMPID number,name varchar(15),Age Number(3),Mobile varchar(11),gender varchar(10),type varchar(25),
dob varchar(30),Amount varchar(10),  total_years varchar(10),total_members varchar(15));*/

package Bootathon_1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.regex.Pattern;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import Project1.Dataconnection;
import com.toedter.calendar.JDateChooser;

public class Insurance_form extends JFrame implements ActionListener,ItemListener{
		JLabel l_id,l_un,l_age,l_mb,l_typ,l_gen,l_amt,l_yr,l_mem,l_dob;
	    JTextField eid,mob,uname;
	    JTextField age1;
	    ButtonGroup gen;
	    JRadioButton m,f,o;
	    JComboBox plan,amt,year,memb;
	    JDateChooser db;
	    JButton reg,apply,back;
	    String gender="";
	    Container c=getContentPane();
	    JFrame c1=new JFrame();
	    String lid1;
	    String namenow1;
	    String user1;
	    
	     Insurance_form(String lid,String namenow,String user){
	    	 JLabel insu=new JLabel("INSURANCE FORM");
	    	 JLabel ins=new JLabel(new ImageIcon("C:\\Users\\haren\\Desktop\\Bootathon_1\\health-insurance.png"));
	    	 ins.setBackground(new Color(223, 249, 251));
	    	 ins.setBounds(350,20,30,30);
	    	 insu.setFont(new Font("Times New Roman", Font.BOLD, 20));
	    	 lid1=lid;
	    	 namenow1=namenow;
	    	 user1=user;
	    	 c1.setLayout(null);
	    	 c1.add(ins);
	      	 c1.getContentPane().setBackground(new Color(223, 249, 251));
	    	 c1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    	 c1.setBounds(460, 45, 530, 700);
	    	 insu.setBounds(150, 20, 200, 30);;
	    	 insu.setForeground(new Color(237, 76, 103));
	    	 c1.setTitle("Insurance");
	    	 
	    	 //labels
	    	 l_id=new JLabel("EMPLOYEE ID:");
	    	 l_un=new JLabel("EMPLOYEE NAME:");
	    	 l_age=new JLabel("Age :");
	    	 l_mb=new JLabel("ACCOUNT NUMBER:");
	    	 l_gen=new JLabel("GENDER :");
	    	 l_typ=new JLabel("INSURANCE TYPE:");
	    	 l_dob=new JLabel("DATE OF BIRTH: ");
	    	 l_amt=new JLabel("INSURANCE AMOUNT:  ");
	    	 l_yr=new JLabel("NUMBER OF YEARS: ");
	    	 l_mem=new JLabel("NUMBER OF MEMBERS: ");	
	    	 
	    	 //fields
	    	 db=new JDateChooser();   
	    	 eid=new JTextField();
	    	 eid.setText(lid);
	    	 eid.setEditable(false);
	    	 mob=new JTextField();
	  	     uname=new JTextField();
	  	     uname.setText(namenow);
		     uname.setEditable(false);
	    	 age1=new JTextField();
	    	 db=new JDateChooser();
	    	 gen=new ButtonGroup();
	    	 m=new JRadioButton("Male");
	    	 f=new JRadioButton("Female");
	    	 o=new JRadioButton("Others");
	         String[] plans= {"Select","Mediclaim Insurance","Individual Insurance","Family floater plan","Senior Citizen coverage","Linked health plans","Group Mediclaim"};
	         plan=new JComboBox(plans);
	         String[] amount= {"Select","6000","3000","1000","2000","10000","8000"};
	         amt=new JComboBox(amount);
	         String[] years= {"Select","1 year","2 year","5 year","7 year","10 year"};
	         year =new JComboBox(years);
	         String members[]= {"Select","1","2","3","4","5"};
	         memb=new JComboBox(members);
	         reg=new JButton("Add members");
	         
	   	     m.addItemListener(this);
	         f.addItemListener(this);
	         o.addItemListener(this);
	         reg.addActionListener(this);
	         
	         gen.add(m);
	         gen.add(f);
	         gen.add(o); 
	         
	         //labels
	          l_id.setBounds(50, 60, 200, 70);
	              eid.setBounds(260,75,170,30);
	          l_un.setBounds(50, 110, 200, 50);
	              uname.setBounds(260,120,170,30);
	          l_mb.setBounds(50, 155, 200, 50);
	              mob.setBounds(260,165,170,30);
	          l_gen.setBounds(50, 200, 200, 50);
	               m.setBounds(260,215,170,30);
	               f.setBounds(260,245,170,30);
	               o.setBounds(260,275,170,30);
	          l_typ.setBounds(50, 315, 200, 50);
	               plan.setBounds(260,325,170,30);
	          l_dob.setBounds(50, 360, 200, 50);
	                db.setBounds(260,370,170,30);
	          l_amt.setBounds(50, 405, 200, 50);
	                amt.setBounds(260,415,170,30);
	          l_yr.setBounds(50, 450, 200, 50);
	                 year.setBounds(260,465,170,30);          
	          l_mem.setBounds(50, 500, 200, 50);
	                memb.setBounds(260,510,170,30);
	          reg.setBounds(280,570,150,30);
	        	    back=new JButton("Go Back");
	        	    back.setBounds(80,570,150,30);
	          apply=new JButton("Apply for Insurance");
	          
	          c1.add(f);c1.add(m);c1.add(memb);c1.add(o);c1.add(amt);c1.add(year);c1.add(db);c1.add(l_id);c1.add(eid);c1.add(plan);c1.add(mob);
	          c1.add(l_typ);c1.add(uname);c1.add(l_amt);c1.add(age1);c1.add(l_dob);c1.add(l_mem);c1.add(l_mb);c1.add(l_gen);c1.add(l_yr);
	          c1.add(l_un);c1.add(l_age);c1.add(reg); c1.add(back);c1.add(insu); 
	          
	          //back button
	          ActionListener bck=(eme)->{
	        	   c1.dispose();
	        	   if(user.equals("employee"))
	         		  new HomePage(lid1,namenow1,user1);
	            		else if(user1.equals("admin"))
	            			new HomePageAdmin(lid1,namenow1,user1);
	           };
	    	 back.addActionListener(bck);
	         c1.setVisible(true);
	    }
	     
		public void itemStateChanged(ItemEvent e) {
			ItemSelectable itemselected=e.getItemSelectable();

	        if(itemselected==m){
	              gender="male";
	        }
	        else if(itemselected==f){
	                gender="female";         
	        }
	        else if(itemselected==o) {
	        	   gender="others";
	        }
			
		}
	
		public void actionPerformed(ActionEvent e) {
			Object obj=e.getSource();
	        if(obj==reg){
	      	            try{
	            	String id1=eid.getText();
	                String fname1=mob.getText();
	                String uname1=uname.getText();
	                String passw=age1.getText();
	                String cntry=plan.getSelectedItem().toString();
	                String gra=amt.getSelectedItem().toString();
	                String where=year.getSelectedItem().toString();
	                DateFormat formater=new SimpleDateFormat("dd/MM/yyyy");
	                String dat=(formater.parse(formater.format(db.getDate()))).toString();                
	                String cval=memb.getSelectedItem().toString();
	                
	                //regex
	                Boolean flag=true;
	           	           if(!(Pattern.matches("^\\d{9,18}$", fname1))) {
	                	   JOptionPane.showMessageDialog(this, "Account number length varies from 9 digits to 18 digits.");
	                	   flag=false;
	          	           }
	           	           if(plan.getSelectedItem()=="Select") {
	           	           JOptionPane.showMessageDialog(this, "Select valid insurance type");
		                   flag=false;
	           	           }
	    	        	   if(amt.getSelectedItem()=="Select") {
	    	        			JOptionPane.showMessageDialog(this, "Select your insurance amount");
	 	                	    flag=false;
	    	        		}
	    	        	    if(year.getSelectedItem()=="Select") {
	    	        	    	JOptionPane.showMessageDialog(this, "Select number of years");
	 	                	   flag=false;
	    	        	    }
	    	        	     if(memb.getSelectedItem()=="Select") {
	    	        	    	 JOptionPane.showMessageDialog(this, "Select number of members");
	  	                	   flag=false;
	    	        	     }
	    	        		
	    	        	
	                //to add members	 
	                if(flag==true) {
	                   if(cval=="1") {
	                	 c1.setLayout(null);
	                	 c1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	                	 c1.setBounds(450, 15, 600, 700);
	                	 c1.setVisible(true);
	                	 
	       	    	     JLabel lm1=new JLabel("Member1 :Name & Age");
	       	    	     lm1.setBounds(50, 560, 150, 30);  
	                	 JTextField m1=new JTextField();
	                	 m1.setBounds(260,560,150,30);
	                	 JTextField m1a=new JTextField();
	                	 m1a.setBounds(430, 560, 100, 30);	                	 
	                	 apply.setBounds(300,610,160,30);
	                	 reg.setBounds(280,900,160,30);
	                	 
	                	 back.setBounds(120, 610, 130, 30);
	    	             c1.add(back);
	                	 c1.add(apply);
	                	 c1.add(m1);
	                	 c1.add(lm1);
	                	 c1.add(m1a);
	 	                }
	                
	                else if(cval=="2") {
	                	c1.setLayout(null);
	                	c1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	                	c1.setBounds(450, 15, 600, 720);
	                	c1.setVisible(true);
	       	    	     JLabel lm1=new JLabel("Member1 :Name & Age"); 
	       	    	     JLabel lm2=new JLabel("Member2: Name & Age");  
	    	             JTextField m1a=new JTextField();
	                	 m1a.setBounds(430, 560, 100, 30);
	                	 JTextField m2a=new JTextField();
	                	 m2a.setBounds(430, 590, 100, 30);
	    	             JTextField m1=new JTextField();
	                	 JTextField m2=new JTextField();
	                	 JTextField m3=new JTextField();
	                	 JTextField m4=new JTextField();
	                	 JTextField m5=new JTextField();
	                	 m1.setBounds(260,560,150,30);
	                	 m2.setBounds(260,590,150,30);
	                	 lm1.setBounds(50, 560, 150, 30);
	                	 lm2.setBounds(50, 590, 150, 30);		                 
	                	 apply.setBounds(300,640,160,30);
	                	 
	                	 back.setBounds(120, 640, 130, 30);
	    	             c1.add(back);
	                	 reg.setBounds(280,900,160,30);
	                	 c1.add(m1); c1.add(m2); 
	                	 c1.add(apply);
	                	 c1.add(lm1);c1.add(lm2);
	                	 c1.add(m1a);c1.add(m2a);
	              }
	                
	                else if(cval=="3") {
	                	c1.setLayout(null);
	  	       	    	 c1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	       	    	     c1.setBounds(450, 15, 600, 760);
	       	    	     c1.setVisible(true);
	       	    	     JLabel lm1=new JLabel("Member1 :Name & Age"); 
	       	    	     JLabel lm2=new JLabel("Member2: Name & Age");  
	       	    	     JLabel lm3=new JLabel("Member3: Name & Age");  
	  	                 JTextField m1a=new JTextField();
	                	 m1a.setBounds(430, 560, 100, 30);
	                	 JTextField m2a=new JTextField();
	                	 m2a.setBounds(430, 590, 100, 30);
	                	 JTextField m3a=new JTextField();
	                	 m3a.setBounds(430, 620, 100, 30);
	 	                 JTextField m1=new JTextField();
	                	 JTextField m2=new JTextField();
	                	 JTextField m3=new JTextField();
	                	 JTextField m4=new JTextField();
	                	 JTextField m5=new JTextField();
	                	 m1.setBounds(260,560,150,30);
	                	 m2.setBounds(260,590,150,30);
	                	 m3.setBounds(260,620,150,30);	                	 
	                	 lm1.setBounds(50, 560, 150, 30);
	                	 lm2.setBounds(50, 590, 150, 30);
	                	 lm3.setBounds(50, 620, 150, 30);
	                	
	                	 back.setBounds(120, 680, 130, 30);
	    	             c1.add(back);
	                	 apply.setBounds(280,680,160,30);
	                	 reg.setBounds(230,900,160,30);
	                	 c1.add(m1); c1.add(m2); c1.add(m3); 
	                	 c1.add(apply);
	                	 c1.add(lm1);c1.add(lm2);c1.add(lm3);
	                	 c1.add(m1a);c1.add(m2a);c1.add(m3a);	                	
	                }
	                
	                else if(cval=="4") {
	                	 c1.setLayout(null);
	  	       	    	 c1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  	       	         c1.setBounds(450, 15, 600, 785);
	  	       	         c1.setVisible(true);
	       	    	     JLabel lm1=new JLabel("Member1 :Name & Age"); 
	       	    	     JLabel lm2=new JLabel("Member2: Name & Age");  
	       	    	     JLabel lm3=new JLabel("Member3: Name & Age");  
	       	    	     JLabel lm4=new JLabel("Member4: Name & Age");  
	  	                 JTextField m1a=new JTextField();
	                	 m1a.setBounds(430, 560, 100, 30);
	                	 JTextField m2a=new JTextField();
	                	 m2a.setBounds(430, 590, 100, 30);
	                	 JTextField m3a=new JTextField();
	                	 m3a.setBounds(430, 620, 100, 30);
	                	 JTextField m4a=new JTextField();
	                	 m4a.setBounds(430, 650, 100, 30);
	  	                 JTextField m1=new JTextField();
	                	 JTextField m2=new JTextField();
	                	 JTextField m3=new JTextField();
	                	 JTextField m4=new JTextField();	                	 
	                	 m1.setBounds(260,560,150,30);
	                	 m2.setBounds(260,590,150,30);
	                	 m3.setBounds(260,620,150,30);
	                	 m4.setBounds(260,650,150,30);	                	 
	                	 lm1.setBounds(50, 560, 150, 30);
	                	 lm2.setBounds(50, 590, 150, 30);
	                	 lm3.setBounds(50, 620, 150, 30);
	                	 lm4.setBounds(50, 650, 150, 30); 
	                	
	                	 back.setBounds(120, 705, 130, 30);
	    	             c1.add(back);
	                	 apply.setBounds(280,705,160,30);
	                	 reg.setBounds(230,900,160,30);
	                	 c1.add(m1); c1.add(m2); c1.add(m3); c1.add(m4); 
	                	 c1.add(apply);
	                	 c1.add(lm1);c1.add(lm2);c1.add(lm3);c1.add(lm4);
	                	 c1.add(m1a);c1.add(m2a);c1.add(m3a);c1.add(m4a);
	    	                }
	                
	                else if(cval=="5") {
	                	c1.setLayout(null);
	                	c1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	                	c1.setBounds(450, 15, 600, 800);
	                	c1. setVisible(true);
	       	    	     JLabel lm1=new JLabel("Member1 :Name & Age"); 
	       	    	     JLabel lm2=new JLabel("Member2: Name & Age");  
	       	    	     JLabel lm3=new JLabel("Member3: Name & Age");  
	       	    	     JLabel lm4=new JLabel("Member4: Name & Age");  
	       	    	     JLabel lm5=new JLabel("Member5: Name & Age");  
	                	 JTextField m1a=new JTextField();
	                	 m1a.setBounds(430, 560, 100, 30);
	                	 JTextField m2a=new JTextField();
	                	 m2a.setBounds(430, 590, 100, 30);
	                	 JTextField m3a=new JTextField();
	                	 m3a.setBounds(430, 620, 100, 30);
	                	 JTextField m4a=new JTextField();
	                	 m4a.setBounds(430, 650, 100, 30);
	                	 JTextField m5a=new JTextField();
	                	 m5a.setBounds(430, 680, 100, 30);
	                	 JTextField m1=new JTextField();
	                	 JTextField m2=new JTextField();
	                	 JTextField m3=new JTextField();
	                	 JTextField m4=new JTextField();
	                	 JTextField m5=new JTextField();
	                	 m1.setBounds(260,560,150,30);
	                	 m2.setBounds(260,590,150,30);
	                	 m3.setBounds(260,620,150,30);
	                	 m4.setBounds(260,650,150,30);
	                	 m5.setBounds(260,680,150,30);
	                	 lm1.setBounds(50, 560, 150, 30);
	                	 lm2.setBounds(50, 590, 150, 30);
	                	 lm3.setBounds(50, 620, 150, 30);
	                	 lm4.setBounds(50, 650, 150, 30);
	                	 lm5.setBounds(50, 680, 150, 30);
	                	   
	                	 back.setBounds(120, 720, 130, 30);
	                     apply.setBounds(310,720,160,30);
	                     c1.add(back);
	                	 reg.setBounds(280,900,160,30);
	                	 c1.add(m1); c1.add(m2); c1.add(m3); c1.add(m4); c1.add(m5);
	                	 c1.add(apply);
	                	 c1.add(lm1);c1.add(lm2);c1.add(lm3);c1.add(lm4);c1.add(lm5);
	                	 c1.add(m1a);c1.add(m2a);c1.add(m3a);c1.add(m4a);c1.add(m5a);
	                	}
	                
	                }
	                   //inserting into insurance table
	                   if(flag==true) { 
	                	   ActionListener insi=(eme)->{
	                		    try {
	                		        int id=Integer.parseInt(eid.getText());
	  	                            Connection con=Dataconnection.getConnection();   
	  	                            Statement stmt=con.createStatement();
	  	                            String query="insert into insurance values("+id+",'"+uname1+"','"+passw+"','"+fname1+"','"+gender+"','"+cntry+"','"+dat+"','"+gra+"','"+where+"','"+cval+"')";
	  	                            stmt.executeUpdate(query);
	  	                            con.setAutoCommit(true);
	  	                            JOptionPane.showMessageDialog(this, "Successfully Applied for Insurance!!");  
	                		   }
	                		   catch(Exception ensi) {
	                			   JOptionPane.showMessageDialog(this, ensi.toString());
	                		   }
     	    	           };
     	    	          apply.addActionListener(insi);
     	    	          
     	    	          //back
     	    	          ActionListener bck=(eme)->{
   	    	        	     c1.dispose();
   	    	        	     new HomePage(lid1,namenow1,user1);
   	    	             };
   	    	    	 
   	    	              back.addActionListener(bck);
     	    	           
	               }
	            }
	            catch(Exception ex){
	                JOptionPane.showMessageDialog(this, ex.toString());
	            }

	        }
			
		}
//		public static void main(String args[]) throws Exception{
//			new Insurance_form("","");
//		}
	}


