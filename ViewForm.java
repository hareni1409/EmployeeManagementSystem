package Bootathon_1;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
 
public class ViewForm extends JFrame  {
 
    JFrame frame1;
    JButton jbtn_view,jbtn_bck;
    Container co;
    DefaultTableModel model;
    JTable table;
    
    ViewForm(String lid,String name,String user) {
    	
    	
    	frame1 = new JFrame("Database Results");
        frame1.setLayout(new FlowLayout());
        frame1.setBounds(350,150,800, 500);
        
        model = new DefaultTableModel();
        table = new JTable(model);
        table.setPreferredScrollableViewportSize(new Dimension(700, 300));
        table.setFillsViewportHeight(true);
        frame1.add(new JScrollPane(table));
        model.addColumn("Emp ID");
        model.addColumn("Name");
        model.addColumn("Designation");
        model.addColumn("Email ID");
        model.addColumn("Salary");
        jbtn_bck=new JButton("Back");
        jbtn_bck.setBounds(100, 20, 750, 300);
        frame1.add(jbtn_bck);
        jbtn_bck.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
           		frame1.dispose();
           		if(user.equals("employee"))
        		  new HomePage(lid,name,user);
           		else if(user.equals("admin"))
           			new HomePageAdmin(lid,name,user);
        	}
        });
        
         
        try {
        	Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","me","me");     
            Statement st = conn.createStatement();
            String query = "select employeeID,Name,Designation,Email,Initial_Salary from employee";
            ResultSet rst = st.executeQuery(query);
            
            while (rst.next()) { 
            	String str_id = rst.getString("employeeID");
                String str_name = rst.getString("Name");
                String str_des = rst.getString("Designation");
                String str_mail = rst.getString("Email");
                String str_sal = rst.getString("Initial_Salary");
                   
                model.addRow(new Object[]{str_id, str_name, str_des,str_mail,str_sal,});
                frame1.setVisible(true);               
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }
 
//    public static void main(String[] args) {
//        new ViewForm("1","renu");
//    }
 
    
}
