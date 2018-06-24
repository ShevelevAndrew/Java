/**
 * J2HomeWork6
 *
 * @author Sergey Iryupin (modifid Andrew Shevelev)
 * @version Jun, 23 2018
 * @link https://github.com/ShevelevAndrew
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Scanner;

class SimpleClient {

    final String SERVER_ADDR = "127.0.0.1"; // or "localhost"
    final int SERVER_PORT = 2048;
    final String CLIENT_PROMPT = "$ ";
    final String CONNECT_TO_SERVER = "Connection to server established.";
    final String CONNECT_CLOSED = "Connection closed.";
    final String EXIT_COMMAND = "exit"; // command for exit

    public static void main(String[] args) {
        new SimpleClient();
    }

    SimpleClient() {
        String message;
        try (Socket socket = new Socket(SERVER_ADDR, SERVER_PORT);
             PrintWriter writer = new PrintWriter(socket.getOutputStream());
             Scanner scanner = new Scanner(System.in)) {
            System.out.println(CONNECT_TO_SERVER);
            do {
                System.out.print(CLIENT_PROMPT);
                message = scanner.nextLine();
                writer.println(message);
                writer.flush();
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                System.out.println(reader.readLine());
            } while (!message.equals(EXIT_COMMAND));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println(CONNECT_CLOSED);
    }
}