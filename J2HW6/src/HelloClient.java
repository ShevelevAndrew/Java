/**
 * HomeWork 6
 *
 * @author Sergey Iryupin (modifid Andrew Shevelev)
 * @version dated Jan 23, 2018
 * @link https://github.com/ShevelevAndrew
 */

import java.net.*;
import java.io.*;

class HelloClient {

    public static void main(String[] args) {
        new HelloClient();

    }

    HelloClient() {

        while (true) {
            Thread clientThead = new Thread(new HelloClientThead());
            clientThead.start();
        }

    }

    class HelloClientThead implements Runnable {

        @Override
        public void run() {
            try (Socket socket = new Socket("127.0.0.1", 1024);
                 BufferedReader reader =
                         new BufferedReader(
                                 new InputStreamReader(socket.getInputStream()))) {
                System.out.println(reader.readLine());
            } catch (IOException ex) {
                System.out.println(ex);
            }

        }

    }
}