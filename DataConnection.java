package Bootathon_1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class DataConnection {
    private static Connection connect;

    public static Connection getConnection() {
        
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connect = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","me","me");
          
        }
        catch(Exception ex){
            System.out.println("  "+ex);
        }
        return connect;
    }
}
