import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReedFile {
    public static void BufferedReedFile (String fileName) {
        byte[] br = new byte[150];
        try (BufferedReader file = new BufferedReader(
                new FileReader(fileName))) {
            int x = -1;
            do {
                x = file.read();

                String brr = file.readLine();
                System.out.println(brr);
            }
            while (x != -1);

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
}
