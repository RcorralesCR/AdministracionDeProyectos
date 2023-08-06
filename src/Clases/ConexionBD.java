package Clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class ConexionBD {

    private static String nombreBd = "fidEPA_Inventario";
    private static String usuario = "root";
    private static String password = "Panqueque1594#";
    private static String url = "jdbc:mysql://localhost:3306/" + nombreBd + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static Connection con;

    public ConexionBD() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, usuario, password);
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos");
            System.err.println(e.getMessage());
        }
    }

    //Método para obtener la conexión
    public static Connection getConexion() {
        return con;
    }

    //Método para cerrar la conexión
    public static void cerrarConexion() {
        try {
            con.close();
            System.out.println("Conexión cerrada");
        } catch (SQLException e) {
            System.err.println("Error al cerrar la conexión");
            System.err.println(e.getMessage());
        }
    }

    //Método para ejecutar consultas
    public static void ejecutarConsulta(String consulta) {
        try {
            PreparedStatement ps = con.prepareStatement(consulta);
            ps.executeUpdate();
            System.out.println("Consulta ejecutada");
        } catch (SQLException e) {
            System.err.println("Error al ejecutar la consulta");
            System.err.println(e.getMessage());
        }
    }
}
