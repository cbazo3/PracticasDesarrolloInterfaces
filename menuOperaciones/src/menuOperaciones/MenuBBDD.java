package menuOperaciones;

//Celia Bazo Moliner 20/10/2023
//Menú operaciones insert, update, delete, select

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuBBDD {
    private static Connection conexion;
    private static boolean isConnected = false;

    public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in); //objeto scanner para guardar la entrada del ususario 
    	while (true) { //bucle-estructura principal del Programa
            
            try {
                System.out.println("Menú de Operaciones:");
                System.out.println("1. Conectar a la base de datos");
                System.out.println("2. Desconectar de la base de datos");
                System.out.println("3. Realizar consulta en la tabla");
                System.out.println("4. Realizar inserción en la tabla");
                System.out.println("5. Realizar eliminación en la tabla");
                System.out.println("6. Realizar actualización en la tabla");
                System.out.println("7. Salir");
                System.out.print("Elige una opción: ");
                int opElegida = scanner.nextInt();//guarda en opElegida la entrada por el ususario

                switch (opElegida) {
                    case 1:
                        if (!isConnected) {
                            isConnected = connectToDatabase();//llama a la función para nonectar a la bbdd
                        } else {
                            System.out.println("Ya estás conectado a la base de datos.");
                        }
                        break;
                    case 2:
                        if (isConnected) {
                            disconnectFromDatabase(); //llama a la función para desconectar de lla bbdd
                            isConnected = false;
                        } else {
                            System.out.println("No estás conectado a la base de datos.");
                        }
                        break;
                    case 3:
                        if (isConnected) {
                            executeSelectQuery(); //llama a la función para realizar la consulta
                        } else {
                            System.out.println("Debes estar conectado a la base de datos.");
                        }
                        break;
                    case 4:
                        if (isConnected) {
                            executeInsertQuery(); //llama a la función para realizar una inserción
                        } else {
                            System.out.println("Debes estar conectado a la base de datos.");
                        }
                        break;
                    case 5:
                        if (isConnected) {
                            executeDeleteQuery(); //llama a la función para realizar una eliminación
                        } else {
                            System.out.println("Debes estar conectado a la base de datos.");
                        }
                        break;
                    case 6:
                        if (isConnected) {
                            executeUpdateQuery(); //llama a la función para realizar una actualización
                        } else {
                            System.out.println("Debes estar conectado a la base de datos.");
                        }
                        break;
                    case 7:
                    	if(isConnected) {
                    		disconnectFromDatabase(); //llama a la función para desconectar la bbdd
                    		System.out.println("Lo primero que hace el programa es desconectar la bbdd.");
                        System.out.println("Y después sale del programa.");
                        System.exit(0); //sale del programa
                        } else {
                        	System.out.println("La bbdd no está conectada, sale directamente del programa.");
                        	System.exit(0);
                        }
                        break;
                    default:
                        System.out.println("Opción no válida. Inténtalo de nuevo.");
                }
            }
         catch (InputMismatchException e) {
            System.out.println("Ingrese un número"); //"excepción" si el usuario no inserta un numero
            scanner.nextLine(); //limpia el bufer del scanner
        }
        }
    }

    private static boolean connectToDatabase() {
        try {
            String url = "jdbc:mysql://localhost:3306/colegio";
            String usuario = "root";
            String contrasena = "root";
            conexion = DriverManager.getConnection(url, usuario, contrasena); //establece la conexión de la bbdd
            System.out.println("Conexión establecida con la base de datos."); 
            return true; //true si la conexión se establece con éxito
        } catch (SQLException e) {
            e.printStackTrace();
            return false; //devuelve falso en caso de error de conexión
        }
    }

    private static void disconnectFromDatabase() {
        try {
            if (conexion != null) {
                conexion.close(); //cierra la conexión sin hacerla nula
                conexion = null; //aquí hace nula la conexión
                System.out.println("Desconexión exitosa.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void executeSelectQuery() {
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            if (isConnected) {
                statement = conexion.createStatement();
                resultSet = statement.executeQuery("SELECT * FROM alumnos"); //ejecuta la consuklta sql

                while (resultSet.next()) {
                    String dni = resultSet.getString("dni");
                    String nombre = resultSet.getString("nombreAlumno");
                    int edad = resultSet.getInt("edadAlumno");
                    String comentario = resultSet.getString("comentario");
                    System.out.println("DNI: " + dni + ", Nombre: " + nombre + ", Edad: " + edad + ", Comentario: " + comentario);
                }
            } else {
                System.out.println("Debes estar conectado a la base de datos.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Cerrar recursos en el bloque finally
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void executeInsertQuery() {
        Statement statement = null;

        try {
            if (isConnected) {
                statement = conexion.createStatement();
                conexion.setAutoCommit(false); // Deshabilitar

                int rowCount = statement.executeUpdate("INSERT INTO alumnos (dni, nombreAlumno, edadAlumno, comentario) " +
                        "VALUES ('66897542L', 'Alejandro Miguel', 21, 'Le gusta jugar')");

                conexion.commit(); // Realizar el commit después de la inserción

                System.out.println("Se insertaron " + rowCount + " filas.");
            } else {
                System.out.println("Debes estar conectado a la base de datos.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                if (conexion != null) {
                    conexion.rollback(); // En caso de excepción, realizar rollback
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } finally {
            // Cerrar el recurso
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void executeDeleteQuery() {
        Statement statement = null;

        try {
            if (isConnected) {
                statement = conexion.createStatement();
                conexion.setAutoCommit(false); // Deshabilitar

                int rowCount = statement.executeUpdate("DELETE FROM alumnos WHERE dni = '66897542L'");

                conexion.commit(); // Realizar el commit después de la eliminación

                System.out.println("Se eliminaron " + rowCount + " filas.");
            } else {
                System.out.println("Debes estar conectado a la base de datos.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                if (conexion != null) {
                    conexion.rollback(); // En caso de excepción, realizar rollback
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } finally {
            // Cerrar el recurso
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void executeUpdateQuery() {
        Statement statement = null;

        try {
            if (isConnected) {
                statement = conexion.createStatement();
                conexion.setAutoCommit(false); // Deshabilitar

                int rowCount = statement.executeUpdate("UPDATE alumnos SET nombreAlumno = 'Mike' WHERE dni = '66897542L'");

                conexion.commit(); // Realizar el commit después de la actualización

                System.out.println("Se actualizaron " + rowCount + " filas.");
            } else {
                System.out.println("Debes estar conectado a la base de datos.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                if (conexion != null) {
                    conexion.rollback(); // En caso de excepción, realizar rollback
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } finally {
            // Cerrar el recurso
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
