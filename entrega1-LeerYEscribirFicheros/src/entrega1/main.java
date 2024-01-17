package entrega1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class main {
    static final String directorio = "src/ficheros";  // Directorio en el que se almacenarán los archivos

    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            while (true) {
                System.out.println("Menú:");
                System.out.println("a) Escribir fichero");
                System.out.println("b) Leer fichero");
                System.out.println("c) Salir");
                System.out.print("Elija una opción (a, b, c): ");

                String opcion = reader.readLine();

                if (opcion.equals("a")) {
                    System.out.print("Ingrese el nombre del fichero: ");
                    String nombreFichero = reader.readLine();
                    System.out.print("Ingrese el texto a escribir en el fichero: ");
                    String texto = reader.readLine();
                    escribir(nombreFichero, texto);
                } else if (opcion.equals("b")) {
                    System.out.print("Ingrese el nombre del fichero a leer: ");
                    String nombreFichero = reader.readLine();
                    lectura(nombreFichero);
                } else if (opcion.equals("c")) {
                    System.out.println("Saliendo del programa.");
                    break;
                } else {
                    System.out.println("Opción no válida. Por favor, elija 'a', 'b' o 'c'.");
                }
            }
        } catch (IOException e) {
            System.err.println("Error de entrada/salida: " + e.getMessage());
        }
    }

    private static void lectura(String nombreFichero) {
        try {
            // Abre el archivo que se ha elegido para hacer la lectura
            BufferedReader lector = new BufferedReader(new FileReader(directorio + "/" + nombreFichero));
            String linea;
            System.out.println("Contenido del fichero " + nombreFichero + ":");
            // Lee y muestra el contenido línea por línea
            while ((linea = lector.readLine()) != null) {
                System.out.println(linea);
            }
            lector.close(); // Cierra el archivo
        } catch (IOException e) {
            System.err.println("Error al leer el fichero: " + e.getMessage());
        }
    }

    private static void escribir(String nombreFichero, String texto) {
        try {
            // Abre el archivo especificado para escritura (con 'true' para agregar al final del archivo)
            PrintWriter escritor = new PrintWriter(new FileWriter(directorio + "/" + nombreFichero, true));
            escritor.println(texto); // Escribe el texto en el archivo
            escritor.close(); // Cierra el archivo
            System.out.println("Texto agregado exitosamente al fichero " + nombreFichero);
        } catch (IOException e) {
            System.err.println("Error al escribir en el fichero: " + e.getMessage());
        }
    }
}
