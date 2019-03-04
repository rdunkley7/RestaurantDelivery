
/**
 *
 * @author rdunkley13
 */

public class testJDBC {

    // This is just a helper program to test your database connection
    public static void main(String[] args) throws Exception {
//        MySQLAccess dao = new MySQLAccess();
//        dao.readDataBase();
//        
//        //test to check customer loginID
//        Customer cust = new Customer ();
//        cust.readCustomerDB();
//        


        PasswordUtils passwordUtils = new PasswordUtils();
        String salt = passwordUtils.generateSalt(255).get();
        System.out.println("salt: " + salt);
        System.out.println("\n");
                
        String password = "1234";
   
        //key is secured password
        String key = passwordUtils.hashPassword(password, salt).get();
        System.out.println("key: " +key);
        System.out.println("\n");
        
        System.out.println(passwordUtils.verifyPassword("1234", key, salt));
        System.out.println(passwordUtils.verifyPassword("4321", key, salt));  
       
     
        
    }

}
