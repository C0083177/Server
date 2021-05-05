import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.sql.*;

public class Database
{
    public static void connection (String[] args) throws SQLException {
        //Create a connection
        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/mydb?useSSL=false",
                "root", "3001");
    }

    public static void searchDB(
    ) throws SQLException {

    }

}
