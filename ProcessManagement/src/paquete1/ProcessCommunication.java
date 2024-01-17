package paquete1;
import java.io.*;

public class ProcessCommunication {

    public static void main(String[] args) {
        try {
            System.out.print("Ingrese una dirección IP: ");
            BufferedReader userReader = new BufferedReader(new InputStreamReader(System.in));
            String ipAddress = userReader.readLine();

            ProcessBuilder processBuilder = new ProcessBuilder("cmd.exe", "/c", "ping " + ipAddress);
            Process process = processBuilder.start();

            BufferedReader outputReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            BufferedReader errorReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));

            String line;
            while ((line = outputReader.readLine()) != null) {
                System.out.println(line);
            }

            while ((line = errorReader.readLine()) != null) {
                System.err.println(line);
            }

            process.destroy();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}