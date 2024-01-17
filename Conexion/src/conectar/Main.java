package conectar;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        // Información de la conexión a la base de datos
        String url = "jdbc:mysql://localhost:3306/tu_basedatos";
        String usuario = "root";
        String contraseña = "root";

        try {
            // Cargar el controlador JDBC de MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establecer la conexión a la base de datos
            Connection conexion = DriverManager.getConnection(url, usuario, contraseña);

            if (conexion != null) {
                System.out.println("Conexión exitosa a la base de datos.");
                // Puedes realizar operaciones con la base de datos aquí.
                // Por ejemplo, ejecutar consultas SQL.

                // Cierra la conexión cuando hayas terminado
                conexion.close();
            } else {
                System.out.println("No se pudo establecer la conexión a la base de datos.");
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Error: No se pudo cargar el controlador JDBC");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Error: No se pudo establecer la conexión a la base de datos");
            e.printStackTrace();
        }
    }
}
