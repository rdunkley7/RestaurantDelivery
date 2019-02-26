
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ai7321lr
 */
public class Customer {

    //check user to see if in table
    //check login table and customer table
    //connect to customer database
    private Connection connect = null;
    private Statement statement = null;
    private ResultSet resultSet = null;
    Scanner console = new Scanner(System.in);

    public void readCustomerDB() throws Exception {
        try {
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the test DataBase - EVERYONE HAS ACCESS, PLEASE BE CAREFUL!!
            // Obviously, if you were distributing this file, you would not include the username and password. There are other ways...
            connect = DriverManager.getConnection("jdbc:mysql://50.116.3.147/ai7321lr_RestaurantDelivery?user=in8738bw&password=in8738bw");

            //PROTECT SQL INJECTION
            //using prepared statments to solve this
            System.out.print("Enter your email address: ");
            String custEmail = console.next();
            String query = "select loginID from login where email = ? ";
            PreparedStatement pstmt = connect.prepareStatement(query);
            pstmt.setString(1, custEmail);
            ResultSet results = pstmt.executeQuery();

            // Statements allow to issue SQL queries to the database
            //statement = connect.createStatement();
            // Result set get the result of the SQL query
            //resultSet = statement.executeQuery("select loginID from login where email = 'rdunks7@gmail.com'");
            // writeResultSet(resultSet);
            if (results.next() == false) {
                //query results have no matching tables 
                //So now ask to create a customer
                System.out.println("No matching email/login found, please signup and create an account.");
                createCustomer();

            } else { //ask for password for login
//                do {
//                    String data = results.getString("emp_name");
//                    System.out.println(data);
//                } while (results.next());
//                Read more
//                : https://javarevisited.blogspot.com/2016/10/how-to-check-if-resultset-is-empty-in-Java-JDBC.html#ixzz5gVqdGOgF

                writeResultSet(results);
                System.out.print("Enter password to login: ");
            }

            //CreateUser createCustomer = new CreateUser();
        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }

    }

    private void writeResultSet(ResultSet resultSet) throws SQLException {
        // ResultSet is initially before the first data set
        while (resultSet.next()) {
            // It is possible to get the columns via name
            // also possible to get the columns via the column number
            // which starts at 1
            // e.g. resultSet.getSTring(2);
            String loginID = resultSet.getString("loginID");

            System.out.println("loginID " + loginID);

        }
    }

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

    //create user if not in table
    public String createCustomer() {

        String customerID; // = loginID **SHOULE BE THE SAME THING?? OK ACTUALLY DONT NEED LOGIND
        String firstName;
        String lastName;
        String orderID; // for orderID & table
        String paymentID = null; //= Payment status - all start as, will be changed later..??
        String customerAddressID = null; // null for now until they update address info
        String phoneNumber;
        
        System.out.print("Enter a customer ID: ");
        String custEmail = console.next();
        System.out.print("Enter a customer ID: ");
        
       
        
//        String query = "select loginID from login where email = ? ";
//        PreparedStatement pstmt = connect.prepareStatement(query);
//        pstmt.setString(1, custEmail);
//        ResultSet results = pstmt.executeQuery() //INSERT INTO Customers (CustomerName, ContactName, Address, City, PostalCode, Country)
        
        return "";
    }

}
