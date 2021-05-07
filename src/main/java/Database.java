import java.sql.*;

public class Database
            {
                public static Connection connection (String[]args) throws SQLException {
                //Create a connection
                Connection conn = DriverManager.getConnection
                        ("jdbc:mysql://localhost:3306/mydb?useSSL=false",
                                "root", "3001");
                return conn;
            }
    public Database(String[] splitInput) throws SQLException {

        Statement statement = connection(splitInput).createStatement();
        {
            //Build SQL statement
            String insert = "INSERT INTO `mydb`.`books`" +
                    "(`ISBN`," +
                    "`Title`)" +
                    "VALUES" +
                    "('9780747538486'," +
                    "'Harry Potter and the Chamber of Secrets');";
            System.out.println("The SQL statement is: " + insert + "\n");


        }
    }



}
