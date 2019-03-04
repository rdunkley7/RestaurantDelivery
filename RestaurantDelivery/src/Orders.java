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
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class Orders {

    //handle adding an order to the customer
    private Connection connect = null;
    private Statement statement = null;
    private ResultSet resultSet = null;

    public int addOrderForCustomer(String menuItemID, String customerID) throws Exception {

        String orderStatus;
        String timeSubmitted;
        int orderID = (int) (Math.random() * 100);
        ///"999"; // random number
        try {

            String restID = updateRestID(menuItemID);
            Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection connect = DriverManager.getConnection("jdbc:mysql://50.116.3.147/ai7321lr_RestaurantDelivery?user=in8738bw&password=in8738bw");

            String query = "INSERT INTO foodOrder (orderID, restaurantID, orderStatus, timeSubmitted, menuItemID, customerID)"
                    + "VALUES (?,?,?,?,?,?)";

            PreparedStatement pstmt = connect.prepareStatement(query);
            pstmt.setInt(1, orderID);
            pstmt.setString(2, restID);
            pstmt.setString(3, "");
            pstmt.setString(4, "");
            pstmt.setString(5, menuItemID);
          //  int resultsint = pstmt.executeUpdate();

            pstmt.setString(6, customerID);
            int resultsint = pstmt.executeUpdate();


            
            return orderID;

        } catch (Exception e) {
            throw e;
        } finally {
            //close();
        }

    }

    private String updateRestID(String menuItemID) throws Exception {
        String restID = null;

        try {

            Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection connect = DriverManager.getConnection("jdbc:mysql://50.116.3.147/ai7321lr_RestaurantDelivery?user=in8738bw&password=in8738bw");

            String query = "select restID from menuItem where menuItemID = ?";
            PreparedStatement pstmt = connect.prepareStatement(query);
            pstmt.setString(1, menuItemID);
            ResultSet resultSet = pstmt.executeQuery();

            while (resultSet.next()) {
                restID = resultSet.getString(1);
            }

            return restID;

        } catch (Exception e) {
            throw e;
        } finally {
            //close();
        }

    }

    public ResultSet readOrdersMenu(int orderID) throws Exception {
        try {

            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection connect = DriverManager.getConnection("jdbc:mysql://50.116.3.147/ai7321lr_RestaurantDelivery?user=in8738bw&password=in8738bw");

            
            //fix load menu - if you load mexican menu, then sushi, mexican is still visible.
            String query = "select * from menuItem where menuItemID = "
                    + "(select menuItemID from foodOrder where orderID =? )";

            PreparedStatement pstmt = connect.prepareStatement(query);

            pstmt.setInt(1, orderID);
            ResultSet resultSet = pstmt.executeQuery();

            return resultSet;

        } catch (Exception e) {
            throw e;
        } finally {
            //close();
        }
    }

    //not really using anymore 
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

    public Double readCheckout(String customerID) throws Exception {

        //Need to read orders associated with a customer
        //should print out their total price 
        //and should update 
        double totalPrice = 0;

        try {

            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection connect = DriverManager.getConnection("jdbc:mysql://50.116.3.147/ai7321lr_RestaurantDelivery?user=in8738bw&password=in8738bw");

            String query = "select sum(menuItemPrice) from menuItem where menuItemID in "
                    + "(select menuItemID from foodOrder where customerID =? )";
            PreparedStatement pstmt = connect.prepareStatement(query);

            pstmt.setString(1, customerID);
            ResultSet resultSet = pstmt.executeQuery();
            while (resultSet.next()) {

                totalPrice = resultSet.getDouble(1);
            }

            
            return totalPrice;

        } catch (Exception e) {
            throw e;
        } finally {
            //close();
        }

    }

    public String checkoutUpdate(String customerID) throws Exception {
//method should update the order table with updated information 
/// UPDATE: orderStatus, time submitted

        //Checkout default status
        String orderStatus = "In Progress";

        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
        System.out.println("Today's date is: " + dateFormat.format(date));
        String timeSubmitted = dateFormat.format(date);

        //SimpleDateFormat sdfStopTime = new SimpleDateFormat("hh:mm:ss a", Locale.ENGLISH);

        String estimatedDeliveryTime = dateFormat.format(new Date(System.currentTimeMillis() + 3600000));

        try {

            Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection connect = DriverManager.getConnection("jdbc:mysql://50.116.3.147/ai7321lr_RestaurantDelivery?user=in8738bw&password=in8738bw");

            String query = "update foodOrder "
                    + "set orderStatus = ?, timeSubmitted = ?, estimatedDeliverTime = ?"
                    + "where customerID = ?";

            PreparedStatement pstmt = connect.prepareStatement(query);

            pstmt.setString(1, orderStatus);
            pstmt.setString(2, timeSubmitted);
            pstmt.setString(3, estimatedDeliveryTime);
            pstmt.setString(4, customerID);
            int resultsint = pstmt.executeUpdate();

            
            return estimatedDeliveryTime;
        } catch (Exception e) {
            throw e;
        } finally {
            //close();
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
