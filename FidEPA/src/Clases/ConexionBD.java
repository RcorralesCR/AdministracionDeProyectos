package Clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class ConexionBD {

    private String nombreBd= "FidEPA_Inventario";
    private String usuario= "root";
    private String password= "";
    private String url= "jdbc:mysql://localhost:3306/" + nombreBd+"?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private Connection con;
    
    public ConexionBD(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection(url, usuario, password);
            System.out.println("Conexión exitosa");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Error al conectar con la base de datos");
            System.err.println(e.getMessage());
        }
    }
    
    //Método para obtener la conexión
    public Connection getConexion(){
        return con;
    }
    
    //Método para cerrar la conexión
    public void cerrarConexion(){
        try {
            con.close();
            System.out.println("Conexión cerrada");
        } catch (SQLException e) {
            System.err.println("Error al cerrar la conexión");
            System.err.println(e.getMessage());
        }
    }
    
    //Método para ejecutar consultas
    public void ejecutarConsulta(String consulta){
        try {
            PreparedStatement ps= con.prepareStatement(consulta);
            ps.executeUpdate();
            System.out.println("Consulta ejecutada");
        } catch (SQLException e) {
            System.err.println("Error al ejecutar la consulta");
            System.err.println(e.getMessage());
        }
    }
}