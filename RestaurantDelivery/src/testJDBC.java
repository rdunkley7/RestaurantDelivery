
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


        Login login = new Login();
        String salt = login.generateSalt(512).get();
        System.out.println("salt: " + salt);
        System.out.println("\n");
                
        String password = "1234";
   
        //key is secured password
        String key = login.hashPassword(password, salt).get();
        System.out.println("key: " +key);
        System.out.println("\n");
        
        System.out.println(login.verifyPassword("1234", key, salt));
        System.out.println(login.verifyPassword("4321", key, salt));  
       
        ////////////
        
        String salt2 = login.generateSalt(512).get();
        System.out.println("salt2: " + salt2);
        System.out.println("\n");
                
        String password2 = "1234";
   
        //key is secured password
        String key2 = login.hashPassword(password, salt).get();
        System.out.println("key2: " +key2);
        System.out.println("\n");
        
        System.out.println(login.verifyPassword("1234", key2, salt2));
        
        
        
        
    }

}
