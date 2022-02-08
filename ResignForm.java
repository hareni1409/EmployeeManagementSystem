package Bootathon_1;

import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;
import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;  
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.*;
import com.lowagie.text.pdf.PdfWriter;
import java.awt.event.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.awt.*;
import java.sql.*;
import java.util.Calendar;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Date;
import java.text.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.io.IOException;
import java.io.OutputStream;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
public class ResignForm  {
    JFrame frame;
    

    JLabel headingLabel = new JLabel("RESIGNATION FORM");
    JLabel nameLabel=new JLabel("EMPLOYEE NAME");
    JLabel employeeIDLabel=new JLabel("EMPLOYEE ID");
    JLabel reasonLabel = new JLabel("ANY OTHER REASON");
    JTextField nameField=new JTextField();
    JTextField employeeIDField = new JTextField();
    JButton removeButton=new JButton("REMOVE");
    JButton resetButton=new JButton("RESET");
    private JTextField reasonText;
    private JTextField designationField;


    ResignForm(String empID, String uname,String user)
    {
    	frame=new JFrame();
        frame.getContentPane().setBackground(new Color(230,247,255));
        frame.setTitle("RESIGNATION");
        frame.setBounds(500,5,555,793);
        frame.getContentPane().setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        headingLabel.setForeground(new Color(237, 76, 103));
        nameLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
        nameLabel.setBounds(31,226,155,23);
        employeeIDLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
        employeeIDLabel.setBounds(31,129,144,35);
        nameField.setEditable(false);
        
        nameField.setFont(new Font("Times New Roman", Font.PLAIN, 17));
        nameField.setBounds(245,221,206,35);
        nameField.setText(uname);
        employeeIDField.setEditable(false);
        
        employeeIDField.setFont(new Font("Times New Roman", Font.PLAIN, 17));
        employeeIDField.setBounds(245,130,206,35);
        employeeIDField.setText(empID);
        
        removeButton.setBackground(new Color(245, 245, 245));
        removeButton.setFont(new Font("Times New Roman", Font.BOLD, 12));
        
        removeButton.setBounds(59,595,100,35);
        resetButton.setBackground(new Color(245, 245, 245));
        resetButton.setFont(new Font("Times New Roman", Font.BOLD, 12));
        resetButton.setBounds(204,595,100,35);
        
        frame.getContentPane().add(nameLabel);
        
        frame.getContentPane().add(employeeIDLabel);
        
        frame.getContentPane().add(nameField);
        
        frame.getContentPane().add(employeeIDField);
        
        frame.getContentPane().add(removeButton);
        frame.getContentPane().add(resetButton);
        
        
        headingLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22));
        headingLabel.setBounds(140, 33, 250, 35);
        frame.getContentPane().add(headingLabel);
        
        
        reasonLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
        reasonLabel.setBounds(31, 503, 171, 23);
        frame.getContentPane().add(reasonLabel);
        
        reasonText = new JTextField();
        reasonText.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        reasonText.setBounds(245, 483, 206, 63);
        frame.getContentPane().add(reasonText);
        reasonText.setColumns(10);
        
        JLabel designationLabel = new JLabel("DESIGNATION");
        designationLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
        designationLabel.setBounds(31, 315, 155, 23);
        frame.getContentPane().add(designationLabel);
        
        designationField = new JTextField();
        designationField.setEditable(false);
        designationField.setFont(new Font("Times New Roman", Font.PLAIN, 17));
        designationField.setBounds(245, 308, 206, 35);
        frame.getContentPane().add(designationField);
        
        JButton goback = new JButton("BACK");
        goback.setFont(new Font("Times New Roman", Font.BOLD, 12));
        goback.setBackground(new Color(245, 245, 245));
        goback.setBounds(351, 595, 100, 35);
        frame.getContentPane().add(goback);
        
        JButton printbtn = new JButton("");
        JLabel reasoncomboL = new JLabel("REASON TO RESIGN");
        printbtn.setBackground(Color.WHITE);
        printbtn.setIcon(new ImageIcon("C:\\Users\\haren\\Desktop\\Bootathon_1\\icons8-print-48.png"));
        printbtn.setBounds(226, 674, 58, 57);
        frame.getContentPane().add(printbtn);
        reasoncomboL.setFont(new Font("Times New Roman", Font.BOLD, 15));
        reasoncomboL.setBounds(31, 410, 155, 23);
        frame.getContentPane().add(reasoncomboL);
        
        JComboBox comboBox = new JComboBox();
        comboBox.setFont(new Font("Times New Roman", Font.PLAIN, 17));
        comboBox.setModel(new DefaultComboBoxModel(new String[] {"Select", "Corporate culture", "Financial instability", "Career promotion", "Professional development", "Overwork load", "Personal reasons"}));
        comboBox.setBounds(245, 403, 206, 35);
        frame.getContentPane().add(comboBox);
      
        goback.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		frame.dispose();
        		if(user.equals("employee"))
          		  new HomePage(empID,uname,user);
             		else if(user.equals("admin"))
             			new HomePageAdmin(empID,uname,user);
        		
        	}
        });
       
        
        
        printbtn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(!comboBox.getSelectedItem().equals("Select")){

        		 OutputStream file = null;
        	        try {
        	        	File file1=new File("C:\\Users\\haren\\Desktop\\Bootathon_1\\Resign.pdf");
        	            file = new FileOutputStream(file1);
        	            
          	            // Create a new Document object
        	            Document document = new Document(); 
        	            
        	            // You need PdfWriter to generate PDF document
        	            PdfWriter.getInstance(document, file); 
        	            
        	            // Opening document for writing PDF
        	            document.open();        
        	            
        	            // Writing content        	            
        	            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
        	            LocalDateTime now = LocalDateTime.now(); 
        	    		
        	            document.add(new Paragraph("                                                              "
        	            		+ "RESIGN LETTER"));
        	            document.add(new Paragraph("\n"));
        	            document.add(new Paragraph("\n"));
        	            document.add(new Paragraph(dtf.format(now)));
        	            document.add(new Paragraph("\n"));
        	            document.add(new Paragraph("From:"));
        	            document.add(new Paragraph(uname));
        	            document.add(new Paragraph(designationField.getText()));
        	            document.add(new Paragraph("\n"));
        	            document.add(new Paragraph("\n"));
        	            document.add(new Paragraph("To:"));
        	            document.add(new Paragraph("The Manager"));
        	            document.add(new Paragraph("MGH Private Limited")); 
        	            document.add(new Paragraph("Old Town Road,"));
        	            document.add(new Paragraph("Kentucky-508745"));
        	            document.add(new Paragraph("\n"));
        	            document.add(new Paragraph("Subject: Notice of Resignation - "+uname));
        	            document.add(new Paragraph("\n"));
        	            
        	            document.add(new Paragraph("Dear Madam/Sir"));
        	            document.add(new Paragraph("\n"));
        	            document.add(new Paragraph("This letter is to notify you that I am resigning from my position here as "+designationField.getText()+" "
        	            		+ "effective from " +new Date(new java.util.Date().getTime()).toString()
        	            		+". I am resigning the job due to "+ comboBox.getSelectedItem()+"."));
        	            
        	            document.add(new Paragraph("\n"));
        	            document.add(new Paragraph("Thank you so much for the opportunity to work in this position."
        	            		+ "I’ve greatly enjoyed and appreciated the opportunities I’ve had to grow our  team and pipeline, be a part of creating a great "
        	            		+ "product, and work with my fellow colleagues, and I’ve learned so much about strategy , which I"
        	            		+ " will certainly take with me throughout my career."));
        	    
        	            document.add(new Paragraph("\n"));
       	                document.add(new Paragraph("I’ll do everything possible to wrap up my duties and train other "
       	         		+ "team members . Please let me know if there’s anything else I can do to help during this transition."));        
        	            
       	                document.add(new Paragraph("\n"));
       	                document.add(new Paragraph("I wish the company continued success, and I hope to stay in touch in the future."));
       	                document.add(new Paragraph("\n"));   
       	                document.add(new Paragraph("\n")); 
       	                document.add(new Paragraph("Yours sincerely,"));
       	                document.add(new Paragraph(uname)); 
       	                
        	            // close the document
        	            document.close();        	            
        	          JOptionPane.showMessageDialog(null,"Your resignation letter PDF is succesfully created in\npath: "+file1.getAbsolutePath());
        	 
        	        } catch (Exception emw) {
        	            System.out.println(emw.toString());
        	 
        	        } 
        	        finally {
               	            try {
        	                    if (file != null) {
        	                    file.close();
        	                 }
        	            } 
               	        catch (IOException io) {
        	                System.out.println();
        	            }       	 
        	        }
       		
        	    }
        		else {
        			JOptionPane.showMessageDialog(null,"Select proper reason for resignation");
        		}
        	}
        });       
        

        try {
        	Connection connection=DataConnection.getConnection();
           	String sql = "SELECT Designation FROM employee WHERE employeeID='"+empID+"'";
        	Statement statement  = connection.createStatement();
        	ResultSet result =  statement.executeQuery(sql);
        	while(result.next()) {
        		String designationStr = result.getString("Designation");
        		System.out.println(designationStr);
        		designationField.setText(designationStr);
        	}
        }
        catch (SQLException e1) {
        	e1.printStackTrace();
    
        }  
        
        removeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection connection=DataConnection.getConnection();
		        	System.out.println("database connected successfully");
                    if(!comboBox.getSelectedItem().equals("Select")) {
                    	String sql = "DELETE FROM employee WHERE employeeID=?";
                    	PreparedStatement pstatement = connection.prepareStatement(sql);
                    	pstatement.setString(1, employeeIDField.getText());
                    	int rows = pstatement.executeUpdate();
                    	if(rows>0) {
                    		JOptionPane.showMessageDialog(null,"Employee details successfully removed from current database");
                    	}
                    	connection.setAutoCommit(true);
                    	connection.close();
                    	frame.dispose();
                    	new Login_form();
                    }
                    else {
                    	JOptionPane.showMessageDialog(null,"Please tell us the reason to resign.");
                    }
            	}
            	catch (SQLException e1) {
                    	e1.printStackTrace();
                
            	}    
			}
		});
        
        resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reasonText.setText("");
			}
		});


    	
    }
    
   public static void main(String[] args){
       new ResignForm("25","Hareni","admin");
 }

}


