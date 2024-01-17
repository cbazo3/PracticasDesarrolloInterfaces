package t10.act1;

import java.net.*;
import java.util.Scanner;

public class UDPClient {
    public static void main(String args[]) throws Exception {
        DatagramSocket clientSocket = new DatagramSocket();
        InetAddress IPAddress = InetAddress.getByName("localhost");
        byte[] sendData;
        byte[] receiveData = new byte[1024];

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Escribe tu mensaje: ");
            String sentence = scanner.nextLine();
            sendData = sentence.getBytes();

            // Enviar el mensaje al servidor
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 9876);
            clientSocket.send(sendPacket);

            // Imprimir el mensaje en mayúsculas
            System.out.println("Mensaje enviado: " + sentence.toUpperCase());

            // Verificar si el mensaje es "byebye" para cerrar la conexión
            if (sentence.equalsIgnoreCase("byebye")) {
                System.out.println("Cerrando la sesión...");
                clientSocket.close();
                break;  // Salir del bucle
            }

            // Recibir la respuesta del servidor
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            clientSocket.receive(receivePacket);
            String modifiedSentence = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("DEL SERVIDOR:" + modifiedSentence);
        }
    }
}