
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

//CustomerObject, will be created when needed in customer class
// customer class will handle matching to db query login, and creating the new Customerobj.
//It will also handle adding this new customerobj to the db table 


public class CustomerObject {

 

        private String customerID; // = loginID **SHOULE BE THE SAME THING?? OK ACTUALLY DONT NEED LOGIND
        private String firstName;
        private String lastName;
        private String orderID; // for orderID & table
        private String paymentID = null; //= Payment status - all start as, will be changed later..??
        private String customerAddressID = null; // null for now until they update address info
        private String phoneNumber; 

    public CustomerObject() {
    }

    public CustomerObject(String customerID, String firstName, String lastName, String orderID, String phoneNumber) {
        this.customerID = customerID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.orderID = orderID;
        this.phoneNumber = phoneNumber;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(String paymentID) {
        this.paymentID = paymentID;
    }

    public String getCustomerAddressID() {
        return customerAddressID;
    }

    public void setCustomerAddressID(String customerAddressID) {
        this.customerAddressID = customerAddressID;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "CustomerObject{" + "customerID=" + customerID + ", firstName=" + firstName + ", lastName=" + lastName + ", orderID=" + orderID + ", paymentID=" + paymentID + ", customerAddressID=" + customerAddressID + ", phoneNumber=" + phoneNumber + '}';
    }
        
        
   

}
    
    
