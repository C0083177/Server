import java.sql.*;

public class Insert
{
    private static final String SQL_INSERT = "INSERT INTO BOOKS (ISBN, NAME, AUTHOR, PUBLISHER, LANGUAGE) VALUES (?,?,?,?,?)";


    public Insert(String[] args) throws SQLException {

        {
            //Build SQL statement
            PreparedStatement stmt=conn.prepareStatement(SQL_INSERT);
            //1 specifies the first parameter in the query i.e. name
            stmt.setLong(1,9780141370354L);
            stmt.setString(2,"Matilda");
            stmt.setString(3, "Roald Dahl");
            stmt.setString(4, "Penguin");
            stmt.setString(5, "English");

            int i=stmt.executeUpdate();
            System.out.println(i+" records updated");

            String insert = new String(String.valueOf(stmt));
            System.out.println("The SQL statement is: " + insert + "\n");


        }catch(SQLException e)
        {
            e.printStackTrace();
        }
    }
}