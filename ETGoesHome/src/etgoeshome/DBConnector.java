package etgoeshome;

import java.sql.*;
import java.util.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Daniel
 */
public class DBConnector {

   private static Connection conn;
   private static int target = 1;

   /**
    * Try to connect to the database
    */
   public DBConnector() {

   }

   public boolean loginToDB(String user, String pw) {
      try
      {
         Class.forName("com.mysql.jdbc.Driver").newInstance();
      } catch (Exception ex)
      {
         System.out.println("Driver not found");
         System.out.println(ex);
      };

      String url = "jdbc:mysql://cslvm74.csc.calpoly.edu/";

      conn = null;
      try
      {
         // conn = DriverManager.getConnection(url, "LOGIN_ID", "PASSWORD");
         conn = DriverManager.getConnection(url + user + "?user=" + user + "&password=" + pw + "&");
         System.out.println("Connected");

      } catch (Exception ex)
      {
         System.out.println("Could not open connection");
         System.out.println(ex);
         return false;
      }
      return true;
   }

   public DefaultTableModel selectTab1(String dbState) {
      
      String colNames[] = {"State", "City"};
      DefaultTableModel table = new DefaultTableModel(colNames, 0);
      
      try
      {
         Statement state = conn.createStatement();
         ResultSet result = state.executeQuery("SELECT *\n"
                 + "FROM Location\n"
                 + "WHERE State = '" + dbState.toLowerCase() + "'\n"
                 + "ORDER BY City;");
         boolean f = result.next();
         while (f)
         {
            String s1 = result.getString(1); //State
            String s2 = result.getString(2); //City name
            
            Object[] objs = {s1, s2};
            table.addRow(objs);
            
            System.out.println(s1 + "   :   " + s2);
                    
            f = result.next();
         }

      } catch (Exception ee)
      {
         System.out.println(ee);
      }
      
      return table;
   }
}
