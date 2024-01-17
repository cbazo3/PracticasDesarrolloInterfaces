package apartadoA;
import java.io.*;

	public class Aplicacion {
	    public static void main(String[] args) {
	        // Instanciar un objeto Libro
	        Libro libro1 = new Libro();

	        // Establecer los valores de las propiedades
	        libro1.setTitulo("Harry Potter");
	        libro1.setAutor("JK Rowlling");
	        libro1.setAnioPublicacion(2001);

	        // Mostrar información del libro
	        System.out.println("Información acerca del libro:");
	        System.out.println("Título: " + libro1.getTitulo());
	        System.out.println("Autor: " + libro1.getAutor());
	        System.out.println("Año de Publicación: " + libro1.getAnioPublicacion());

	        // Serializar el objeto Libro a un archivo
	        try (ObjectOutputStream ser = new ObjectOutputStream(new FileOutputStream("libro.ser"))) {
	        	ser.writeObject(libro1);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	        // Deserializar el objeto Libro desde el archivo y mostrar su información
	        try (ObjectInputStream desser = new ObjectInputStream(new FileInputStream("libro.ser"))) {
	            Libro libroDeserializado = (Libro) desser.readObject();
	            System.out.println("\nInformación del libro deserializado:");
	            System.out.println("Título: " + libroDeserializado.getTitulo());
	            System.out.println("Autor: " + libroDeserializado.getAutor());
	            System.out.println("Año de Publicación: " + libroDeserializado.getAnioPublicacion());
	        } catch (IOException | ClassNotFoundException e) {
	            e.printStackTrace();
	        }
	    }
	}
