package Bootathon_1;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import Bootathon_1.Login_form;
import Bootathon_1.Insurance_form;

public class HomePage {
	
    HomePage(String lid,String namenow,String user){

    	JFrame f=new JFrame();
    	f.setLayout(null);
	    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  	    f.setBounds(290, 50, 900, 700);
  	    JLabel home=new JLabel("HOME PAGE");
	    JLabel homeim=new JLabel(new ImageIcon("C:\\Users\\haren\\Desktop\\Bootathon_1\\home.png"));
	    home.setBounds(300,50,250,50);
	    homeim.setBounds(560,55,40,40);
	    home.setFont(new Font("Times New Roman",Font.BOLD,40));
		home.setForeground(new Color(237, 76, 103));
  	    Container c1=f.getContentPane();
  	    
  	    //creating buttons
  	    JButton insure=new JButton(new ImageIcon("C:\\Users\\haren\\Desktop\\Bootathon_1\\insurance.png\\"));
  	    JButton payroll=new JButton(new ImageIcon("C:\\Users\\haren\\Desktop\\Bootathon_1\\payroll.png\\"));
  	    JButton attendance=new JButton(new ImageIcon("C:\\Users\\haren\\Desktop\\Bootathon_1\\attendance.png\\"));
  	    JButton announcements=new JButton(new ImageIcon("C:\\Users\\haren\\Desktop\\Bootathon_1\\announcem_100x100.png\\"));
  	    JButton calendar=new JButton(new ImageIcon("C:\\Users\\haren\\Desktop\\Bootathon_1\\calendar-100.png\\"));
  	    JButton resign=new JButton(new ImageIcon("C:\\Users\\haren\\Desktop\\Bootathon_1\\resign.png\\"));
  	    JButton update=new JButton(new ImageIcon("C:\\Users\\haren\\Desktop\\Bootathon_1\\update.png\\"));
  	    JButton view=new JButton(new ImageIcon("C:\\Users\\haren\\Desktop\\Bootathon_1\\view.png\\"));
  	    c1.setBackground(new Color(179, 252, 196));
  	    insure.setBorderPainted(false);
	  	payroll.setBorderPainted(false);
	    attendance.setBorderPainted(false);
	  	announcements.setBorderPainted(false);
	  	calendar.setBorderPainted(false);
	  	resign.setBorderPainted(false);
	  	update.setBorderPainted(false);
	  	view.setBorderPainted(false);
  	   
	  	//view employees
  	    ActionListener vieew=(eme)->{
	  	    f.dispose();
	    	new ViewForm(lid,namenow,user);
	    };
	    view.addActionListener(vieew);
        
	    //update details
        ActionListener updt=(eme)->{
	        f.dispose();
	        new UpdateForm(lid,namenow,user);
        };
        update.addActionListener(updt);
        
        //view calendar
        ActionListener cale=(eme)->{
 	         f.dispose();
 	         new CalendarPage(lid,namenow,user);
        };
        calendar.addActionListener(cale);  
     
        //insurance form
  	    ActionListener act=(eme)->{
  	    	 f.dispose();
	    	 new Insurance_form(lid,namenow,user);
   	    };
   	    insure.addActionListener(act);
  	    
   	    //announcement
   	    ActionListener announ=(eme)->{
	  	   f.dispose();
	    	new AnnouncementPage(lid,namenow,user);
	
        };
        announcements.addActionListener(announ);
        
        //attendance
        ActionListener att1=(eme)->{
	  	     f.dispose();
	    	AttendanceForm er = new AttendanceForm(lid,namenow,user);
        	er.setTitle("attendance");
    		er.setSize(1602,800);
    		er.setVisible(true);
    		er.setResizable(true);
    		er.setLocationRelativeTo(null);
    		er.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   	
       };
       attendance.addActionListener(att1);
       
       //resign
       ActionListener resi=(eme)->{
	  	    f.dispose();
	    	new ResignForm(lid,namenow,user);
	
       };
       resign.addActionListener(resi);
       
       //payroll
       ActionListener pay1=(eme)->{
	  	    f.dispose();
	    	new PayrollSalary(lid,namenow,user);
	
       };
       payroll.addActionListener(pay1);
       
        //button bounds
  	    insure.setBounds(100,150,110,110);
  	    announcements.setBounds(290,150,110,110);
  	    payroll.setBounds(475,150,110,110);
  	    calendar.setBounds(670, 150, 110, 110);
  	    attendance.setBounds(100,340,110,110);
  	    resign.setBounds(290,340,110,110);
  	    update.setBounds(475,340,110,110);
  	    view.setBounds(670,340,110,110);
  	    
  	    //setting background
  	    insure.setBackground(Color.white);
  	    announcements.setBackground(Color.white);
  	    payroll.setBackground(Color.white);
  	    calendar.setBackground(Color.white);
	    attendance.setBackground(Color.white);
	    resign.setBackground(Color.white);
	    update.setBackground(Color.white);
  	    view.setBackground(Color.white);
  	    
  	    //logout
  	    JLabel lo=new JLabel(new ImageIcon("C:\\Users\\haren\\Desktop\\Bootathon_1\\logout.png\\"));
  	    lo.setBackground(new Color(179, 252, 196));
	    lo.setBounds(810, 550, 30, 30);
	    JButton lout=new JButton("Log Out");
	    lout.setBounds(700,550,100,30);
	    ActionListener logout=(eme)->{
	    	f.dispose();
	 	    	new Login_form();
    	};
    	lout.addActionListener(logout);
    	
    	//button labels
   	    JLabel in=new JLabel("INSURANCE");
  	    in.setBounds(120, 265, 150, 30);
  	    JLabel ann=new JLabel("ANNOUNCEMENT");
	    ann.setBounds(297, 265, 150, 30);
	    JLabel pay=new JLabel("PAYROLL");
  	    pay.setBounds(505, 265, 150, 30);
  	    JLabel cal=new JLabel("CALENDAR");
	    cal.setBounds(690, 265, 150, 30);
	    JLabel att=new JLabel("ATTENDANCE");
  	    att.setBounds(110, 455, 150, 30);
  	    JLabel res=new JLabel("RESIGNATION");
	    res.setBounds(300, 455, 150, 30);
	    JLabel upd=new JLabel("UPDATE");
  	    upd.setBounds(500, 455, 150, 30);
  	    JLabel vie=new JLabel("VIEW EMPLOYEE");
	    vie.setBounds(675, 455, 150, 30);
	    
  	    f.add(in);	
  	    f.add(lo);
	    f.add(lout);f.add(ann);f.add(pay);f.add(cal);f.add(att);f.add(res);f.add(upd);f.add(vie);f.add(homeim);f.add(home);
  	    f.add(insure);f.add(announcements);f.add(payroll);f.add(calendar);f.add(attendance);f.add(resign);f.add(update);f.add(view);
  	    f.setVisible(true);
    }
    public static void main(String[] args) {
    	new HomePage("","","");
    }
}
