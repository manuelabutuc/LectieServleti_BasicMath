import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Manu on 18-Jun-16.
 */
public class DB {
    private static void insert(double value) throws ClassNotFoundException, SQLException {
        // 1. load driver
        Class.forName("org.postgresql.Driver");

        // 2. define connection params to db
        final String URL = "jdbc:postgresql://54.93.65.5/4_Manu";
        final String USERNAME = "fasttrackit_dev";
        final String PASSWORD = "fasttrackit_dev";

        // 3. obtain a connection
        Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        // 4. create a query statement
        PreparedStatement pSt = conn.prepareStatement("INSERT into numbers (value) VALUES (?)");
        pSt.setDouble(1,value);

        // 5. execute a prepared statement
        int rowsInserted = pSt.executeUpdate();

        // 6. close the objects
        pSt.close();
        conn.close();
    }
}

