
import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Base64;
import java.util.Optional;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author rdunkley13
 */
public class Login {

    private Connection connect = null;
    private Statement statement = null;
    private ResultSet resultSet = null;
    Scanner console = new Scanner(System.in);

    //create user if not in table
    public void createLogin(String customerID, String email, String password) throws SQLException {

        try {

            //HASH THE PASSWORD.. upon creating the user login 
            //then put hashed password into the DB
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the test DataBase - EVERYONE HAS ACCESS, PLEASE BE CAREFUL!!
            // Obviously, if you were distributing this file, you would not include the username and password. There are other ways...
            connect = DriverManager.getConnection("jdbc:mysql://50.116.3.147/ai7321lr_RestaurantDelivery?user=in8738bw&password=in8738bw");

            String query = "INSERT INTO login (customerID, email, password)"
                    + "VALUES (?,?,?)";

            PreparedStatement pstmt = connect.prepareStatement(query);
            pstmt.setString(1, customerID);
            pstmt.setString(2, email);
            pstmt.setString(3, password);

            int resultsint = pstmt.executeUpdate();

            System.out.println("Query was executed...");
            System.out.println(resultsint);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private static final SecureRandom RAND = new SecureRandom();
    private static final int ITERATIONS = 65536;
    private static final int KEY_LENGTH = 512;
    private static final String ALGORITHM = "PBKDF2WithHmacSHA512";

    //Method for us to generate the salt so that we can add it to the password later
    public Optional<String> generateSalt(final int length) {

        if (length < 1) {
            System.err.println("error in generateSalt: length must be > 0");
            return Optional.empty();
        }

        byte[] salt = new byte[length];
        RAND.nextBytes(salt);

        return Optional.of(Base64.getEncoder().encodeToString(salt));
    }

    public Optional<String> hashPassword(String password, String salt) {

        char[] chars = password.toCharArray();
        byte[] bytes = salt.getBytes();

        PBEKeySpec spec = new PBEKeySpec(chars, bytes, ITERATIONS, KEY_LENGTH);

        Arrays.fill(chars, Character.MIN_VALUE);

        try {
            SecretKeyFactory fac = SecretKeyFactory.getInstance(ALGORITHM);
            byte[] securePassword = fac.generateSecret(spec).getEncoded();
            
            return Optional.of(Base64.getEncoder().encodeToString(securePassword));

        } catch (NoSuchAlgorithmException | InvalidKeySpecException ex) {
            System.err.println("Exception encountered in hashPassword()");
            return Optional.empty();

        } finally {
            spec.clearPassword();
        }
    }

    //verify password for login
    public boolean verifyPassword(String password, String key, String salt) {
        Optional<String> optEncrypted = hashPassword(password, salt);
        if (!optEncrypted.isPresent()) {
            return false;
        }
        return optEncrypted.get().equals(key);
    }
    
    ///?????? how to store in db
    public void addLoginToDB(String customerID, String securePassword){
        
    }
    
    
    
}


//https://dev.to/awwsmm/how-to-encrypt-a-password-in-java-42dh
