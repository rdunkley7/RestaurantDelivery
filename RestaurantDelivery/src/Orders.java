/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rdunkley13
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JTextArea;
public class Orders {
    
    //handle adding an order to the customer
    
     private Connection connect = null;
    private Statement statement = null;
    private ResultSet resultSet = null;
  
    public int addOrderForCustomer(String menuItemID, String customerID) throws Exception{
        
        String orderStatus;
        String timeSubmitted;
        int orderID =  (int)(Math.random()*100);
                ///"999"; // random number
        try {

            Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection connect = DriverManager.getConnection("jdbc:mysql://50.116.3.147/ai7321lr_RestaurantDelivery?user=in8738bw&password=in8738bw");

          
            String query = "INSERT INTO foodOrder (orderID, restaurantID, orderStatus, timeSubmitted, menuItemID, customerID)"
                    + "VALUES (?,?,?,?,?,?)";

            PreparedStatement pstmt = connect.prepareStatement(query);
            pstmt.setInt(1, orderID);
            pstmt.setString(2, "");
            pstmt.setString(3, "");
            pstmt.setString(4, "");
            pstmt.setString(5, menuItemID);
            pstmt.setString(6, customerID);
           int resultsint = pstmt.executeUpdate();

            return orderID;
            
        } catch (Exception e) {
            throw e;
        } finally {
            //close();
        }

        

    }

    
    
    public ResultSet readOrdersMenu(String customerID) throws Exception {
        try {

            
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection connect = DriverManager.getConnection("jdbc:mysql://50.116.3.147/ai7321lr_RestaurantDelivery?user=in8738bw&password=in8738bw");

            String query = "select * from menuItem where menuItemID = "
                                + "(select menuItemID from foodOrder where customerID =? )";
                 
            PreparedStatement pstmt = connect.prepareStatement(query);
           
            pstmt.setString(1, customerID);
            ResultSet resultSet = pstmt.executeQuery();

            
           
            return resultSet;
            
        } catch (Exception e) {
            throw e;
        } finally {
            //close();
        }
    }
    
    
    public void writeResultSet(ResultSet resultSet) throws SQLException {
        // ResultSet is initially before the first data set
        while (resultSet.next()) {
            // It is possible to get the columns via name
            // also possible to get the columns via the column number
            // which starts at 1
            // e.g. resultSet.getSTring(2);

            String menuItemID = resultSet.getString("menuItemID");
            String menuItemName = resultSet.getString("menuItemName");
            String menuItemDesc = resultSet.getString("menuItemDescription");
            String menuItemPrice = resultSet.getString("menuItemPrice");
            String restID = resultSet.getString("restID");

            System.out.print("menuItemID: " + menuItemID);
            System.out.print("menuItemName: " + menuItemName);
            System.out.print("menuItemDesc : " + menuItemDesc);
            System.out.print("menuItemPrice : " + menuItemPrice);
            System.out.print("restID : " + restID);
            System.out.print("\n");

        }
    }

    // You need to close the resultSet
    private void close() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }

            if (statement != null) {
                statement.close();
            }

            if (connect != null) {
                connect.close();
            }
        } catch (Exception e) {

        }
    }

}
    
