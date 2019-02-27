

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rdunkley13
 */
public class Address {
   
    private Connection connect = null;
    private Statement statement = null;
    private ResultSet resultSet = null;
    Scanner console = new Scanner(System.in);

    //create user if not in table
    public void createCustomerAddress(String customerID, String address, String city, int zipcode) throws SQLException {

        try {
            
           String customerAddressID = customerID + "999";
           
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the test DataBase - EVERYONE HAS ACCESS, PLEASE BE CAREFUL!!
            // Obviously, if you were distributing this file, you would not include the username and password. There are other ways...
            connect = DriverManager.getConnection("jdbc:mysql://50.116.3.147/ai7321lr_RestaurantDelivery?user=in8738bw&password=in8738bw");

            String query = "INSERT INTO login (customerID, customerAddressID, address, city, zipcode)"
                    + "VALUES (?,?,?,?,?,?,?)";

            PreparedStatement pstmt = connect.prepareStatement(query);
            pstmt.setString(1, customerID);
            pstmt.setString(2, customerAddressID);
            pstmt.setString(3, address);
            pstmt.setString(4, city);
            pstmt.setInt(5, zipcode);
          
            
            int resultsint = pstmt.executeUpdate();

            System.out.println("Query was executed...");
            System.out.println(resultsint);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public void createRestAddress(String restID, String address, String city, int zipcode) throws SQLException {

        try {
            
            String restAddressID = restID + "888"; //IDK really what this is for anymore
           
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://50.116.3.147/ai7321lr_RestaurantDelivery?user=in8738bw&password=in8738bw");

            String query = "INSERT INTO restaurantAddress (customerID, restAddressID, number, street, city, zipcode, state)"
                    + "VALUES (?,?,?,?,?,?,?)";

            PreparedStatement pstmt = connect.prepareStatement(query);
            pstmt.setString(1, restID);
            pstmt.setString(2, restAddressID);
            pstmt.setString(3, address);
            pstmt.setString(4, city);
            pstmt.setInt(5, zipcode);
            
            
            int resultsint = pstmt.executeUpdate();

            System.out.println("Query was executed...");
            System.out.println(resultsint);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}

