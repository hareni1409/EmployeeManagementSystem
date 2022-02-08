package Bootathon_1;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Bootathon_1.HomePage;
public class AnnouncementPage extends JFrame {
     JFrame contentPane=new JFrame();
       Container cp=contentPane.getContentPane();
       
		public AnnouncementPage(String empID, String uname,String user) {
			
			contentPane.setTitle("Announcements");
			
			contentPane.setFont(new Font("Times New Roman", Font.BOLD, 17));
			contentPane.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			contentPane.setBounds(0, 5, 1602, 882);
  			cp.setBackground(new Color(223, 249, 251));
  			contentPane.setForeground(new Color(230, 230, 250));
  			contentPane.setLayout(null);
  			
  			JLabel announcegif = new JLabel("New label");
  			announcegif.setIcon(new ImageIcon("C:\\Users\\haren\\Desktop\\Bootathon_1\\announcegif.gif\\"));
  			announcegif.setBounds(438, 10, 562, 161);
  			contentPane.add(announcegif);
  			
  			JLabel halloween = new JLabel("Get ready with your Halloween costumes and beat face! Halloween celebration on Oct 25!");
  			halloween.setFont(new Font("Segoe Print", Font.BOLD, 28));
  			halloween.setBackground(new Color(175, 238, 238));
  			halloween.setBounds(146, 196, 1298, 84);
  			contentPane.add(halloween);
  			
  			JLabel halloweengif = new JLabel("");
  			halloweengif.setIcon(new ImageIcon("C:\\Users\\haren\\Desktop\\Bootathon_1\\source_2_110x110.gif\\"));
  			halloweengif.setBounds(38, 196, 111, 84);
  			contentPane.add(halloweengif);
  			
  			JLabel trip = new JLabel("We are providing a trip to Himalayas for successful completion of the project. Bon Voyage!");
  			trip.setFont(new Font("Segoe Print", Font.BOLD, 28));
  			trip.setBackground(new Color(175, 238, 238));
  			trip.setBounds(146, 320, 1298, 84);
			contentPane.add(trip);
			
			JLabel newproject = new JLabel("Good News! Good Luck! A new project has been took over by our company!");
			newproject.setFont(new Font("Segoe Print", Font.BOLD, 28));
			newproject.setBackground(new Color(175, 238, 238));
			newproject.setBounds(146, 457, 1131, 84);
			contentPane.add(newproject);
			
			JLabel newprojectgif = new JLabel("");
			newprojectgif.setIcon(new ImageIcon("C:\\Users\\haren\\Desktop\\Bootathon_1\\source_2_110x110.gif\\"));
			newprojectgif.setBounds(38, 457, 111, 84);
			contentPane.add(newprojectgif);
			
			JLabel payraise = new JLabel("Confirm pay raise for employees who exhibited outstanding performance this month!");
			payraise.setFont(new Font("Segoe Print", Font.BOLD, 28));
			payraise.setBackground(new Color(175, 238, 238));
			payraise.setBounds(146, 590, 1218, 84);
			contentPane.add(payraise);
			
			JLabel payraisegif = new JLabel("");
			payraisegif.setIcon(new ImageIcon("C:\\Users\\haren\\Desktop\\Bootathon_1\\source_2_110x110.gif\\"));
			payraisegif.setBounds(38, 590, 111, 84);
			contentPane.add(payraisegif);
			
			JLabel tripgif = new JLabel("");
			tripgif.setIcon(new ImageIcon("C:\\Users\\haren\\Desktop\\Bootathon_1\\source_2_110x110.gif\\"));
			tripgif.setBounds(38, 320, 111, 84);
			contentPane.add(tripgif);
			
			JLabel pumpkinicon = new JLabel("");
			pumpkinicon.setIcon(new ImageIcon("C:\\Users\\haren\\Desktop\\Bootathon_1\\icons8-halloween-pumpkin-50.png\\"));
			pumpkinicon.setBounds(1434, 215, 53, 50);
			contentPane.add(pumpkinicon);
			
			JLabel travelicon = new JLabel("");
			travelicon.setIcon(new ImageIcon("C:\\Users\\haren\\Desktop\\Bootathon_1\\icons8-wedding-travel-50.png\\"));
			travelicon.setBounds(1444, 341, 53, 53);
			contentPane.add(travelicon);
			
			JLabel projecticon = new JLabel("");
			projecticon.setIcon(new ImageIcon("C:\\Users\\haren\\Desktop\\Bootathon_1\\icons8-project-50.png\\"));
			projecticon.setBounds(1234, 474, 53, 55);
			contentPane.add(projecticon);
			
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon("C:\\Users\\haren\\Desktop\\Bootathon_1\\icons8-money-50.png\\"));
			lblNewLabel.setBounds(1366, 611, 53, 44);
			contentPane.add(lblNewLabel);
			
			//back button 
			JButton back = new JButton("Go Back");
			back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  contentPane.setVisible(false);
				  if(user.equals("employee"))
	        		  new HomePage(empID,uname,user);
	           		else if(user.equals("admin"))
	           			new HomePageAdmin(empID,uname,user);
			}
			});
			back.setBackground(new Color(135, 206, 250));
			back.setBounds(1352, 719, 111, 31);
			contentPane.add(back);
			contentPane.setVisible(true);
			
		}
}