package Bootathon_1;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class CalendarPage{
    static JLabel lblMonth, lblYear;
    static JButton btnPrev, btnNext;
    static JTable tblCalendar;
    static JComboBox cmbYear;
    static JFrame frmMain;
    static Container pane;
    static DefaultTableModel mtblCalendar; //Table model
    static JScrollPane stblCalendar; //The scrollpane
    static JPanel pnlCalendar;
    static int realYear, realMonth, realDay, currentYear, currentMonth;
    private static JButton goBackbtn;
    
    CalendarPage(String lid,String name,String user){
    	try {UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());}
        catch (ClassNotFoundException e) {}
        catch (InstantiationException e) {}
        catch (IllegalAccessException e) {}
        catch (UnsupportedLookAndFeelException e) {}
        
        //Prepare frame
        frmMain = new JFrame ("calendar"); 
        frmMain.setTitle("Calendar");
        frmMain.setLocation(300, 10);
        frmMain.setSize(917, 790);
        pane = frmMain.getContentPane(); 
        pane.setLayout(null); 
        frmMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        JLabel tit = new JLabel ("BUSINESS CALENDAR");
        tit.setFont(new Font("Times New Roman", Font.BOLD, 25));
        tit.setBounds(300,20,300,50);
        JLabel climg = new JLabel (new ImageIcon("C:\\Users\\haren\\Desktop\\Bootathon_1\\calendaramal.png"));
        climg.setBounds(590,30,30,30);
        tit.setForeground(Color.black);
        
        //Create controls
        lblMonth = new JLabel ("January");
        lblMonth.setHorizontalAlignment(SwingConstants.CENTER);
        lblMonth.setBounds(354, 101, 171, 25);
        lblMonth.setFont(new Font("Times New Roman", Font.ITALIC, 23));
        lblYear = new JLabel ("Change year:");
        lblYear.setBounds(161, 651, 123, 32);
        lblYear.setFont(new Font("Times New Roman", Font.BOLD | Font.BOLD, 19));
        cmbYear = new JComboBox();
        cmbYear.setBounds(310, 654, 123, 27);
        cmbYear.setBackground(new Color(224, 255, 255));
        cmbYear.setFont(new Font("Times New Roman", Font.BOLD, 18));
        btnPrev = new JButton ("<<");
        btnPrev.setBounds(134, 104, 50, 25);
        btnPrev.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        btnNext = new JButton (">>");
        btnNext.setBounds(692, 103, 53, 25);
        btnNext.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnNext.setBackground(new Color(176, 196, 222));
        mtblCalendar = new DefaultTableModel(){public boolean isCellEditable(int rowIndex, int mColIndex){return false;}};
        tblCalendar = new JTable(mtblCalendar);
        stblCalendar = new JScrollPane(tblCalendar);
        stblCalendar.setBounds(135, 161, 610, 447);
        pnlCalendar = new JPanel(null);
        pnlCalendar.setBackground(new Color(223, 249, 251));
        
        //Set border
        pnlCalendar.setBorder(BorderFactory.createTitledBorder("Calendar"));
        
        //Register action listeners
        btnPrev.addActionListener(new btnPrev_Action());
        btnNext.addActionListener(new btnNext_Action());
        cmbYear.addActionListener(new cmbYear_Action());
        
        //Add controls to pane
        pane.add(pnlCalendar);
        pnlCalendar.setLayout(null);
        pnlCalendar.add(tit);
        pnlCalendar.add(lblMonth);
        pnlCalendar.add(lblYear);
        pnlCalendar.add(cmbYear);
        pnlCalendar.add(btnPrev);
        pnlCalendar.add(btnNext);
        pnlCalendar.add(stblCalendar);
        pnlCalendar.add(climg);
        
        //Set bounds
        pnlCalendar.setBounds(0, 0, 903, 753);
        
        //Make frame visible
        frmMain.setResizable(false);
       
        
        //Get real month/year
        GregorianCalendar cal = new GregorianCalendar(); //Create calendar
        realDay = cal.get(GregorianCalendar.DAY_OF_MONTH); //Get day
        realMonth = cal.get(GregorianCalendar.MONTH); //Get month
        realYear = cal.get(GregorianCalendar.YEAR); //Get year
        currentMonth = realMonth; //Match month and year
        currentYear = realYear;
        
        //Add headers
        String[] headers = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"}; //All headers
        for (int i=0; i<7; i++){
            mtblCalendar.addColumn(headers[i]);
        }
        
        tblCalendar.getParent().setBackground(tblCalendar.getBackground()); //Set background
        
        //No resize/reorder
        tblCalendar.getTableHeader().setResizingAllowed(false);
        tblCalendar.getTableHeader().setReorderingAllowed(false);
        
        //Single cell selection
        tblCalendar.setColumnSelectionAllowed(true);
        tblCalendar.setRowSelectionAllowed(true);
        tblCalendar.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        //Set row/column count
        tblCalendar.setRowHeight(70);
        tblCalendar.setEditingColumn(currentMonth);
        
        goBackbtn = new JButton("Go Back");
        goBackbtn.setBackground(new Color(184, 233, 148));
                
        goBackbtn.setFont(new Font("Times New Roman",Font.BOLD, 17));
        goBackbtn.setBounds(592, 651, 123, 29);
        goBackbtn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		frmMain.dispose();
        		if(user.equals("employee"))
          		  new HomePage(lid,name,user);
             		else if(user.equals("admin"))
             			new HomePageAdmin(lid,name,user);
        	}
        });
        pnlCalendar.add(goBackbtn);
        mtblCalendar.setColumnCount(7);
        mtblCalendar.setRowCount(6);
        
        //Populate table
        for (int i=realYear-100; i<=realYear+100; i++){
            cmbYear.addItem(String.valueOf(i));
        }
        
        //Refresh calendar
        refreshCalendar (realMonth, realYear); 
    }
   
    public static void refreshCalendar(int month, int year){
        //Variables
    	//Number Of Days, Start Of Month
        String[] months =  {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        int nod, som; 
        
        //Allow/disallow buttons
        btnPrev.setEnabled(true);
        btnNext.setEnabled(true);
        if (month == 0 && year <= realYear-10){btnPrev.setEnabled(false);} 
        if (month == 11 && year >= realYear+100){btnNext.setEnabled(false);} 
        lblMonth.setText(months[month]);
        cmbYear.setSelectedItem(String.valueOf(year)); //Select the correct year in the combo box
        
        //Clear table
        for (int i=0; i<6; i++){
            for (int j=0; j<7; j++){
                mtblCalendar.setValueAt(null, i, j);
            }
        }
        
        //Get first day of month and number of days
        GregorianCalendar cal = new GregorianCalendar(year, month, 1);
        nod = cal.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
        som = cal.get(GregorianCalendar.DAY_OF_WEEK);
        
        //Draw calendar
        for (int i=1; i<=nod; i++){
            int row = new Integer((i+som-2)/7);
            int column  =  (i+som-2)%7;
            mtblCalendar.setValueAt(i, row, column);
        }
        
        //Apply renderers
        tblCalendar.setDefaultRenderer(tblCalendar.getColumnClass(0), new tblCalendarRenderer());
        frmMain.setVisible(true);
    }
    
    static class tblCalendarRenderer extends DefaultTableCellRenderer{
        public Component getTableCellRendererComponent (JTable table, Object value, boolean selected, boolean focused, int row, int column){
            super.getTableCellRendererComponent(table, value, selected, focused, row, column);
            
            //Week-end
            if (column == 0 || column == 6){ 
                setBackground(new Color(243, 150, 181));
            }
            
            //Week
            else{ 
                setBackground(new Color(255, 255, 255));
            }
            
            //Adding events for specific dates
            if (value != null){
                if (Integer.parseInt(value.toString()) ==realDay && currentMonth == realMonth && currentYear == realYear){ //Today
                    setBackground(new Color(216, 221, 217));
                    setText(Integer.valueOf(realDay)+"   (Today)" );
                }
                if(Integer.parseInt(value.toString())==5 && currentMonth ==realMonth+1) {
                	setBackground(new Color(196, 240, 211));
                	setText(value.toString()+" (Teachers day)" );
                }
                if(Integer.parseInt(value.toString())==15 && currentMonth ==realMonth+1) {
                	setBackground(new Color(196, 240, 211));
                	setText(value.toString()+" (Engineer day)" );
                }
                if(Integer.parseInt(value.toString())==10 && currentMonth ==realMonth+1) {
                	setBackground(new Color(243, 150, 181));
                	setText(value.toString()+"   (Holiday)" );
                }
                if(Integer.parseInt(value.toString())==30 && currentMonth ==realMonth+1) {
                	setBackground(new Color(196, 240, 211));
                	setText(value.toString()+"  (Project Due)" );
                }
                if(Integer.parseInt(value.toString())==2 && currentMonth ==realMonth+2) {
                	setBackground(new Color(243, 150, 181));;
                	setText(value.toString()+"   (Holiday)" );
                }
                if(Integer.parseInt(value.toString())==6 && currentMonth ==realMonth+2) {
                	setBackground(new Color(196, 240, 211));
                	setText(value.toString()+" (Project starts)" );
                }
                if(Integer.parseInt(value.toString())==22 && currentMonth ==realMonth+2) {
                	setBackground(new Color(196, 240, 211));
                	setText(value.toString()+" (Durga Puja)");
                }
                if(Integer.parseInt(value.toString())==16 && currentMonth ==realMonth+2) {
                	setBackground(new Color(196, 240, 211));
                	setText(value.toString()+" (Holiday)");
                }
                if(Integer.parseInt(value.toString())==26 && currentMonth ==realMonth+2) {
                	setBackground(new Color(196, 240, 211));
                	setText(value.toString()+"  (Proj. review)");
                }
            }
            setBorder(null);
            setForeground(Color.black);
            return this;
        }
    }
    
    static class btnPrev_Action implements ActionListener{
        public void actionPerformed (ActionEvent e){
            if (currentMonth == 0){ //Back one year
                currentMonth = 11;
                currentYear -= 1;
            }
            else{ //Back one month
                currentMonth -= 1;
            }
            refreshCalendar(currentMonth, currentYear);
        }
    }
    static class btnNext_Action implements ActionListener{
        public void actionPerformed (ActionEvent e){
            if (currentMonth == 11){ //Foward one year
                currentMonth = 0;
                currentYear += 1;
            }
            else{ //Foward one month
                currentMonth += 1;
            }
            refreshCalendar(currentMonth, currentYear);
        }
    }
    static class cmbYear_Action implements ActionListener{
        public void actionPerformed (ActionEvent e){
            if (cmbYear.getSelectedItem() != null){
                String b = cmbYear.getSelectedItem().toString();
                currentYear = Integer.parseInt(b);
                refreshCalendar(currentMonth, currentYear);
            }
        }
    }
    
    
    public static void main (String args[]){
        new CalendarPage("","","");
        
}
}
 
