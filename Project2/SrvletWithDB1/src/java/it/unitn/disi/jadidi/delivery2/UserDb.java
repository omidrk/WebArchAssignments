
package it.unitn.disi.jadidi.delivery2;

import static java.rmi.server.LogStream.log;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Dimo
 */

// this class is used for handling the database connection and also exec query 
public class UserDb {
    
    public User DOLogin(String username, String password) throws SQLException,
            ClassNotFoundException {
        String jdbcURL = "jdbc:derby://localhost:1527/DELIVERY2DB";
        String dbUser = "username";
        String dbPassword = "pw";
 
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        Connection connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
        String sql = "SELECT * FROM USERNAME.USERS WHERE USERNAME = ? and PASSWORD = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, username);
        statement.setString(2, password);
 
        ResultSet result = statement.executeQuery();
 
        User user = null;
 
        if (result.next()) {
            user = new User();
            user.setUSERNAME(username);
        }
 
        connection.close();
 
        return user;
    }
    
    // this method is used for changing the password
    public boolean DOChange(String username, String password) throws SQLException,
            ClassNotFoundException {
        String jdbcURL = "jdbc:derby://localhost:1527/DELIVERY2DB";
        String dbUser = "username";
        String dbPassword = "pw";
 
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        Connection connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
        String sql = "UPDATE USERS SET password = ? WHERE username = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, password);
        statement.setString(2, username);
 
        int result = statement.executeUpdate();
        log("result DOne");
 
 
        if (result >0) {
            connection.close();
            return true;
        } else {
            connection.close();
            return false;
            
        }
        
 
        
 
        
    }
    
}
