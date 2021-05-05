import java.net.*;
import java.io.*;
import java.util.Scanner;
import java.util.regex.PatternSyntaxException;

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
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Splits the input down into an array and performs checks
    public static String handleInput(String input) {

        String[] splitInput = input.split("\\s+");
        String bookCheck = splitInput[0];
        String actionCheck = splitInput[1];
        String titleCheck = splitInput[2];

        if (bookCheck.equalsIgnoreCase("Book")) {
        } else {
            System.out.println("Invalid - please start your query with the word Book");
        }
        if (actionCheck.equalsIgnoreCase("Add")) {
            System.out.println("Should trigger Add");
            Insert i = new Insert(splitInput);
        } else if (actionCheck.equalsIgnoreCase("Search")) {
            System.out.println("Should trigger search");
            String searchQuery = splitInput[2] + splitInput[3];
            return searchQuery;
        } else {
            System.out.println("Add or Search not defined");
        }

        return input;
    }
}


