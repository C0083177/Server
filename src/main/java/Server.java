import java.net.*;
import java.io.*;
import java.sql.SQLException;
import java.util.Scanner;

public class Server {

    public static void main(String arg[]) {

        try (ServerSocket listener = new ServerSocket(new Integer(3000))) {
            String runningMessage = "Client connected successfully";
            System.out.println(runningMessage);
            while (true) {
                try (Socket socket = listener.accept()) {
                    //Scanner getting input from client
                    Scanner in = new Scanner(socket.getInputStream());
                    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

                    while (in.hasNext()) {
                        String input = in.nextLine();
                        String response = handleInput(input);
                        out.println(response);
                    }
                } catch (IOException | SQLException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Splits the input down into an array and performs checks
    public static String handleInput(String input) throws SQLException {

        String[] splitInput = input.split("\\s+");
        String bookCheck = splitInput[0];
        String actionCheck = splitInput[1];

        if (bookCheck.equalsIgnoreCase("Book")) {
            if (actionCheck.equalsIgnoreCase("Add")) {
                System.out.println("Should trigger Add");
                Database i = new Database(splitInput);
            } else if (actionCheck.equalsIgnoreCase("Search")) {
                System.out.println(input);
            } else {
                System.out.println("Add or Search not defined");
            }
        } else {System.out.println ("Invalid entry - Please start your query with the word Book!");}
        return input;
    }
}


