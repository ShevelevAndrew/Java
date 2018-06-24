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
            new Thread(new ClientReeder(socket)).start(); //Second solution
            //BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream())); //The first variant of the solution
                do {
                System.out.print(CLIENT_PROMPT);
                message = scanner.nextLine();
                writer.println(message);
                writer.flush();
                //System.out.println(reader.readLine()); //The first variant of the solution
            } while (!message.equals(EXIT_COMMAND));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println(CONNECT_CLOSED);
    }


    class ClientReeder implements Runnable {
        BufferedReader reader;
        Socket socket;

        ClientReeder(Socket clientSocket) {
            try {
                socket = clientSocket;
                reader = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));
            } catch(Exception ex) {
                System.out.println(ex.getMessage());
            }
        }

        @Override
        public void run() {
            String message;
            try {
                while(true){
                    message = reader.readLine();
                    System.out.println(message);
                }
            } catch(Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

}