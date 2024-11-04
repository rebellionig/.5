package student.java.homework.weeks.week3_3_1;

import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        String hostname = "localhost";
        int port = 12345;

        try (Socket socket = new Socket(hostname, port);
             PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in))) {

            String userInputString;
            System.out.println("Enter messages (type 'exit' to quit):");

            while ((userInputString = userInput.readLine()) != null) {
                if ("exit".equalsIgnoreCase(userInputString)) {
                    break;
                }
                output.println(userInputString);
                System.out.println("Server response: " + input.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

