
/**
 *
 * @author rdunkley13
 */

public class testJDBC {

    // This is just a helper program to test your database connection
    public static void main(String[] args) throws Exception {
        MySQLAccess dao = new MySQLAccess();
        dao.readDataBase();
        
        //test to check customer loginID
        Customer cust = new Customer ();
        cust.readCustomerDB();
    }

}
