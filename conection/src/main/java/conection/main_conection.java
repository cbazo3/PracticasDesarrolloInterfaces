package conection;

// Celia Bazo Moliner 11/10/2023
// Conexión mysql con java

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class main_conection {

    public static void main(String[] args) {
        // Defines el enlace de la conexión, el usuario y la contraseña
        String jdbcUrl = "jdbc:mysql://localhost:3306/colegio";
        String usuario = "root";
        String contraseña = "root";

        // Variables para la conexión, la sentencia y el resultado.
        Connection conexion = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            
            conexion = DriverManager.getConnection(jdbcUrl, usuario, contraseña);

            // Selecciona todos los elementos de la tabla Alumnos en la base de datos
            String sql = "SELECT * FROM alumnos";

            statement = conexion.prepareStatement(sql);

            // Ejecuta la consulta y almacena los resultados 
            resultSet = statement.executeQuery();

            // Muestra la información del resultado por pantalla
            while (resultSet.next()) {
                String dni = resultSet.getString("dni");
                String nombreAlumno = resultSet.getString("nombreAlumno");
                int edadAlumno = resultSet.getInt("edadAlumno");
                String comentario = resultSet.getString("comentario");

                System.out.println("Dni: " + dni + ", Nombre del alumno: " + nombreAlumno + ", Edad del alumno: " + edadAlumno + ", Comentario: " + comentario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                // Cierre de recursos
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (conexion != null) conexion.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
