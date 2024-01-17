package t10.act1;

import java.net.*;

public class UDPServer {
    public static void main(String args[]) throws Exception {
        DatagramSocket serverSocket = new DatagramSocket(9876);
        byte[] receiveData = new byte[1024];
        byte[] sendData;

        System.out.println("Servidor UDP iniciado en el puerto 9876");

        while (true) {
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            serverSocket.receive(receivePacket);
            String sentence = new String(receivePacket.getData(), 0, receivePacket.getLength());
            InetAddress IPAddress = receivePacket.getAddress();
            int port = receivePacket.getPort();

            // Procesar el mensaje (en este caso, convertir a mayúsculas)
            sentence = sentence.toUpperCase();

            sendData = sentence.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
            serverSocket.send(sendPacket);

            System.out.println("Recibido de " + IPAddress + ":" + port + " - " + sentence);

            // Verificar si el mensaje es "byebye" para cerrar la conexión
            if (sentence.equalsIgnoreCase("byebye")) {
                System.out.println("Cerrando la conexión...");
                serverSocket.close();
                break;  // Salir del bucle
            }
        }
    }
}