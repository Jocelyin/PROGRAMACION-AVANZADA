package sqlconexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

    private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=PUNTOVENT;encrypt=true;trustServerCertificate=true;";
    private static final String USUARIO = "jocelyin";
    private static final String CONTRASEÑA = "idontknow04";
    private static Connection conexion;

    public ConexionBD() {
        
    }

    public static Connection obtenerConexion() {
        if (conexion == null) {
            try {
                // Cargar el driver JDBC de SQL Server
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                // Establecer la conexión
                conexion = DriverManager.getConnection(URL, USUARIO, CONTRASEÑA);
                System.out.println("Conexión a la base de datos exitosa.");
            } catch (ClassNotFoundException e) {
                System.err.println("Error: No se encontró el driver JDBC.");
                e.printStackTrace();
            } catch (SQLException e) {
                System.err.println("Error al conectar a la base de datos.");
                e.printStackTrace();
            }
        }
        return conexion;
    }

    public static void cerrarConexion() {
        if (conexion != null) {
            try {
                conexion.close();
                System.out.println("Conexión a la base de datos cerrada.");
                conexion = null;
            } catch (SQLException e) {
                System.err.println("Error al cerrar la conexión.");
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        // Método de prueba para verificar la conexión
        Connection con = ConexionBD.obtenerConexion();
        if (con != null) {
            ConexionBD.cerrarConexion();
        }
    }
}
