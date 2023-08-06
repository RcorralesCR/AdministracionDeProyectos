package Clases;



import java.sql.ResultSet;
import java.sql.PreparedStatement;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class EjecutarOperaciones {

    public static void registrarUsuario(String nombre, String password) {
        try {
            ConexionBD conexion = new ConexionBD();
            String consulta = "INSERT INTO usuario (nombre, password) VALUES ('" + nombre + "', '" + password + "')";
            conexion.ejecutarConsulta(consulta);
            conexion.cerrarConexion();
        } catch (Exception e) {
            System.err.println("Error al registrar usuario: " + e);
        }
    }
        public static void registrarCliente(String nombre,String direccion,String correo_electronico,String telefono) {
        try {
            ConexionBD conexion = new ConexionBD();
            String consulta = "INSERT INTO cliente (nombre, direccion,correo_electronico,telefono) VALUES ('" + nombre + "', '" + direccion + "','"+correo_electronico+"','"+telefono+"')";
            conexion.ejecutarConsulta(consulta);
            conexion.cerrarConexion();
        } catch (Exception e) {
            System.err.println("Error al registrar usuario: " + e);
        }
    }

    public static boolean verificarUsuario(String nombre, String pass) {
        boolean valido = false;
        try {
            ConexionBD conexion = new ConexionBD();
            String consulta = "SELECT * FROM usuario WHERE nombre='" + nombre + "' AND password='" + pass + "'";
            PreparedStatement ps = conexion.getConexion().prepareStatement(consulta);
            ResultSet resultado = ps.executeQuery();
            if (resultado.next()) {
                valido = true;
            }
            conexion.cerrarConexion();
        } catch (Exception e) {
            System.err.println("Error al verificar usuario: " + e);
        }
        return valido;
    }

    //llenarComboIdProducto
    public static void llenarComboIdProducto(JComboBox<String> combo) {
        try {
            ConexionBD conexion = new ConexionBD();
            String consulta = "SELECT id_producto FROM producto";
            PreparedStatement ps = conexion.getConexion().prepareStatement(consulta);
            ResultSet resultado = ps.executeQuery();
            while (resultado.next()) {
                combo.addItem(resultado.getString("id_producto"));
            }
            conexion.cerrarConexion();
        } catch (Exception e) {
            System.err.println("Error al llenar ComboIdProducto: " + e);
        }
    }
        public static void llenarComboIdMovimiento(JComboBox<String> combo) {
        try {
            ConexionBD conexion = new ConexionBD();
            String consulta = "SELECT id_movimiento FROM movimiento";
            PreparedStatement ps = conexion.getConexion().prepareStatement(consulta);
            ResultSet resultado = ps.executeQuery();
            while (resultado.next()) {
                combo.addItem(resultado.getString("id_movimiento"));
            }
            conexion.cerrarConexion();
        } catch (Exception e) {
            System.err.println("Error al llenar ComboIdMovimiento: " + e);
        }
    }
//llenarComboIdUsuario

    public static void llenarComboIdUsuario(JComboBox<String> combo) {
        try {
            ConexionBD conexion = new ConexionBD();
            String consulta = "SELECT id_usuario FROM usuario";
            PreparedStatement ps = conexion.getConexion().prepareStatement(consulta);
            ResultSet resultado = ps.executeQuery();
            while (resultado.next()) {
                combo.addItem(resultado.getString("id_usuario"));
            }
            conexion.cerrarConexion();
        } catch (Exception e) {
            System.err.println("Error al llenar ComboIdUsuario: " + e);
        }
    }

    public static void agregarProducto(String nombre, int cantidad, float precio_unitario, String descripcion, String ubicacion, String Sucursal) {
        try {
            ConexionBD conexion = new ConexionBD();
            String consulta = "INSERT INTO producto  (nombre,cantidad,precio_unitario,descripcion,ubicacion,id_sucursal) VALUES ('" + nombre + "','" + cantidad + "','" + precio_unitario + "','" + descripcion + "','" + ubicacion + "','" + Sucursal + "')";
            conexion.ejecutarConsulta(consulta);
            conexion.cerrarConexion();
        } catch (Exception e) {
            System.err.println("Error al agregar producto: " + e);
        }
    }

        public static String[] obtenerProducto(int id_producto) {
        String[] producto = new String[6];
        try {
            ConexionBD conexion = new ConexionBD();
            String consulta = "SELECT * FROM producto WHERE id_producto='" + id_producto + "'";
            PreparedStatement ps = conexion.getConexion().prepareStatement(consulta);
            ResultSet resultado = ps.executeQuery();
            if (resultado.next()) {
                producto[0] = resultado.getString("nombre");
                producto[1] = resultado.getString("cantidad");
                producto[2] = resultado.getString("precio_unitario");
                producto[3] = resultado.getString("descripcion");
                producto[4] = resultado.getString("ubicacion");
                producto[5] = resultado.getString("id_sucursal");
            }
            conexion.cerrarConexion();
        } catch (Exception e) {
            System.err.println("Error al obtener producto: " + e);
        }
        return producto;
    }
        
    public static void registrarPedido(int id_usuario, int id_producto, int cantidad, String fecha_pedido) {
        try {
            ConexionBD conexion = new ConexionBD();
            String consulta = "INSERT INTO pedido (id_usuario, id_producto, cantidad, fecha_pedido) VALUES ('" + id_usuario + "', '" + id_producto + "', '" + cantidad + "', '" + fecha_pedido + "')";
            conexion.ejecutarConsulta(consulta);
            conexion.cerrarConexion();
        } catch (Exception e) {
            System.err.println("Error al registrar pedido: " + e);
        }
    }

   public  static void llenarComboIdProducto(int id_producto, JLabel labelNombreProducto) {
        try {
            ConexionBD conexion = new ConexionBD();
            String consulta = "SELECT nombre FROM producto WHERE id_producto=" + id_producto;
            PreparedStatement ps = conexion.getConexion().prepareStatement(consulta);
            ResultSet resultado = ps.executeQuery();
            if (resultado.next()) {
                labelNombreProducto.setText(resultado.getString("nombre"));
            }
            conexion.cerrarConexion();
        } catch (Exception e) {
            System.err.println("Error al llenar ComboIdProducto: " + e);
        }
    }

    public static void llenarComboSucursal(JComboBox comboSucursal) {
        try {
            ConexionBD conexion = new ConexionBD();
            String consulta = "SELECT nombre from sucursal";
            PreparedStatement ps = conexion.getConexion().prepareStatement(consulta);
            ResultSet resultado = ps.executeQuery();
            while (resultado.next()) {
                comboSucursal.addItem(resultado.getString("nombre"));
            }
            conexion.cerrarConexion();
        } catch (Exception e) {
            System.err.println("Error al llenar el combo de sucursales: " + e);
        }
    }

    public static void llenarTablaUsuarios(JTable tableUsuarios) {
        DefaultTableModel modelo = (DefaultTableModel) tableUsuarios.getModel();
        try {
            ConexionBD conexion = new ConexionBD();
            String consulta = "SELECT * FROM usuario";
            PreparedStatement ps = conexion.getConexion().prepareStatement(consulta);
            ResultSet resultado = ps.executeQuery();
            //Se eliminan todas las filas de la tabla
            while (modelo.getRowCount() > 0) {
                modelo.removeRow(0);
            }
            //se recorren todos los registros de la tabla de usuarios
            while (resultado.next()) {
                //se crea un array para almacenar los datos de cada registro
                Object[] fila = new Object[3];
                //se llena el array con los datos de cada registro
                fila[0] = resultado.getInt("id_usuario");
                fila[1] = resultado.getString("nombre");
                fila[2] = resultado.getString("password");
                //se agrega el array a la tabla
                modelo.addRow(fila);
            }
            conexion.cerrarConexion();
        } catch (Exception e) {
            System.err.println("Error al llenar tabla Usuarios: " + e);
        }
    }

    //registrarSucursal
    public static void registrarSucursal(int id_sucursal, String nombre, String direccion) {
        try {
            ConexionBD conexion = new ConexionBD();
            String consulta = "INSERT INTO sucursal (id_sucursal, nombre, direccion) VALUES ('" + id_sucursal + "', '" + nombre + "', '" + direccion + "')";
            conexion.ejecutarConsulta(consulta);
            conexion.cerrarConexion();
        } catch (Exception e) {
            System.err.println("Error al registrar sucursal: " + e);
        }
    }
//Eliminar Sucursal

    public static void eliminarSucursal(int id_sucursal) {
        try {
            ConexionBD conexion = new ConexionBD();
            String consulta = "DELETE FROM sucursal WHERE id_sucursal='" + id_sucursal + "'";
            conexion.ejecutarConsulta(consulta);
            conexion.cerrarConexion();
        } catch (Exception e) {
            System.err.println("Error al eliminar sucursal: " + e);
        }
    }
//modificarSucursal

    public static void modificarSucursal(int id_sucursal, String nombre, String direccion) {
        try {
            ConexionBD conexion = new ConexionBD();
            String consulta = "UPDATE sucursal SET nombre='" + nombre + "', direccion='" + direccion + "' WHERE id_sucursal='" + id_sucursal + "'";
            conexion.ejecutarConsulta(consulta);
            conexion.cerrarConexion();
        } catch (Exception e) {
            System.err.println("Error al modificar sucursal: " + e);
        }
    }

    //buscarSucursal y llenar txtNombre y txtDireccion
    public static String[] buscarSucursal(int id_sucursal) {
        String[] sucursal = new String[2];
        try {
            ConexionBD conexion = new ConexionBD();
            String consulta = "SELECT * FROM sucursal WHERE id_sucursal='" + id_sucursal + "'";
            PreparedStatement ps = conexion.getConexion().prepareStatement(consulta);
            ResultSet resultado = ps.executeQuery();
            if (resultado.next()) {
                JOptionPane.showMessageDialog(null, "Sucursal Encontrada");
                sucursal[0] = resultado.getString("nombre");
                sucursal[1] = resultado.getString("direccion");
            }
            conexion.cerrarConexion();
        } catch (Exception e) {
            System.err.println("Error al buscar sucursal: " + e);
        }
        return sucursal;
    }

    public static void crearMovimiento(int sucursal_origen, int sucursal_destino, String producto, int cantidad, String fecha_envio) {
        try {

            ConexionBD conexion = new ConexionBD();
            String consulta = "INSERT INTO movimiento (sucursal_origen, sucursal_destino, producto, cantidad, fecha_envio) VALUES ('" + sucursal_origen + "','" + sucursal_destino + "','" + producto + "','" + cantidad + "','" + fecha_envio + "')";
            conexion.ejecutarConsulta(consulta);
            conexion.cerrarConexion();
        } catch (Exception e) {
            System.err.println("Error al crear Movimiento: " + e);
        }
    }

    public static void editarMovimiento(int id_movimiento, String sucursal_origen, String sucursal_destino, String producto, int cantidad, String fecha_envio) {
        try {
            ConexionBD conexion = new ConexionBD();
            String consulta = "UPDATE movimiento SET sucursal_origen = '" + sucursal_origen + "', sucursal_destino = '" + sucursal_destino + "', producto = '" + producto + "', cantidad = '" + cantidad + "', fecha_envio = '" + fecha_envio + "' WHERE id_movimiento = '" + id_movimiento + "'";
            conexion.ejecutarConsulta(consulta);
            conexion.cerrarConexion();
        } catch (Exception e) {
            System.err.println("Error al editar Movimiento: " + e);
        }
    }

    public static void eliminarMovimiento(int id_movimiento) {
        try {
            ConexionBD conexion = new ConexionBD();
            String consulta = "DELETE FROM movimiento WHERE id_movimiento = '" + id_movimiento + "'";
            conexion.ejecutarConsulta(consulta);
            conexion.cerrarConexion();
        } catch (Exception e) {
            System.err.println("Error al eliminar Movimiento: " + e);
        }
    }

    public static String[] buscarMovimiento(int id_movimiento) {
        String[] movimiento = new String[5];
        try {
            ConexionBD conexion = new ConexionBD();
            String consulta = "SELECT * FROM movimiento WHERE id_movimiento='" + id_movimiento + "'";
            PreparedStatement ps = conexion.getConexion().prepareStatement(consulta);
            ResultSet resultado = ps.executeQuery();
            if (resultado.next()) {
                movimiento[0] = resultado.getString("sucursal_origen");
                movimiento[1] = resultado.getString("sucursal_destino");
                movimiento[2] = resultado.getString("producto");
                movimiento[3]= resultado.getString("codigo_producto");
                movimiento[4] = resultado.getString("cantidad");
                movimiento[5] = resultado.getString("fecha_envio");
            }
            conexion.cerrarConexion();
        } catch (Exception e) {
            System.err.println("Error al buscar movimiento: " + e);
        }
        return movimiento;
    }

    public static void actualizarTablaMovimientos(JTable tabla) {
        try {
            ConexionBD conexion = new ConexionBD();
            String consulta = "SELECT * FROM movimiento";
            PreparedStatement ps = conexion.getConexion().prepareStatement(consulta);
            ResultSet rs = ps.executeQuery();
            DefaultTableModel modelo = new DefaultTableModel();
            tabla.setModel(modelo);
            modelo.setColumnIdentifiers(new Object[]{"id_movimiento", "sucursal_origen", "sucursal_destino", "producto","codigo_producto", "cantidad", "fecha_envio"});
            while (rs.next()) {
                modelo.addRow(new Object[]{rs.getInt("id_movimiento"), rs.getString("sucursal_origen"), rs.getString("sucursal_destino"), rs.getString("producto"),rs.getInt("codigo_producto"), rs.getInt("cantidad"), rs.getString("fecha_envio")});
            }
            conexion.cerrarConexion();
        } catch (Exception e) {
            System.err.println("Error al actualizar la tabla Movimientos: " + e);
        }
    }

    public static int calcularCantidadProducto(int idProducto) {

        int cantidad = 0;
        try {
            ConexionBD conexion = new ConexionBD();
            String consulta = "SELECT cantidad FROM producto WHERE id_producto=" + idProducto;
            PreparedStatement ps = conexion.getConexion().prepareStatement(consulta);
            ResultSet resultado = ps.executeQuery();
            if (resultado.next()) {
                cantidad = resultado.getInt("cantidad");
            }
            conexion.cerrarConexion();
        } catch (Exception e) {
            System.err.println("Error al calcular cantidad del producto: " + e);
        }
        return cantidad;
    }

    public static void restarUnidades(int cantidad, int idProducto) {
        try {
            ConexionBD conexion = new ConexionBD();
            String consulta = "UPDATE producto SET cantidad=" + (cantidad) + " WHERE id_producto=" + idProducto;
            conexion.ejecutarConsulta(consulta);
            conexion.cerrarConexion();
        } catch (Exception e) {
            System.err.println("Error al restar unidades: " + e);
        }
    }


        public static void actualizarTablaCantidadProductos(JTable tabla, int cantidad) {
        try {
            ConexionBD conexion = new ConexionBD();
            String consulta = "SELECT * FROM producto where cantidad <"+cantidad;
            PreparedStatement ps = conexion.getConexion().prepareStatement(consulta);
            ResultSet rs = ps.executeQuery();
            DefaultTableModel modelo = new DefaultTableModel();
            tabla.setModel(modelo);
            modelo.setColumnIdentifiers(new Object[]{"id_producto", "nombre", "cantidad", "precio_unitario", "descripcion", "ubicacion", "id_sucursal"});
            while (rs.next()) {
                modelo.addRow(new Object[]{rs.getInt("id_producto"), rs.getString("nombre"), rs.getInt("cantidad"), rs.getString("precio_unitario"), rs.getString("descripcion"), rs.getString("ubicacion"),rs.getString("id_sucursal")});
            }
            conexion.cerrarConexion();
        } catch (Exception e) {
            System.err.println("Error al actualizar la tabla Movimientos: " + e);
        }
    }

    public static void aumentarMontoSucursal(float precioTotalCompraUnitaria, int idSucursal) {
            //int precioTotal= precioUnitario*cantidad;
            //int idSucursal = Integer.parseInt(producto[5]);
            //a la funcion le mandaremos Numero de sucursal y monto a agregar a esa sucursal.
            float precioActual = 0;
        try {
            ConexionBD conexion = new ConexionBD();
            String consulta = "SELECT ingresos_totales FROM Sucursal WHERE id_sucursal=" + idSucursal;
            PreparedStatement ps = conexion.getConexion().prepareStatement(consulta);
            ResultSet resultado = ps.executeQuery();
            if (resultado.next()) {
                precioActual = resultado.getInt("ingresos_totales");
            }
            conexion.cerrarConexion();
        } catch (Exception e) {
            System.err.println("Error al calcular cantidad del producto: " + e);
        }
        //cantidad;
        
        float totalFinal=precioTotalCompraUnitaria+precioActual;
        try {
            ConexionBD conexion = new ConexionBD();
            //update Sucursal set ingresosTotales = 100 where id_sucursal = 1;
            String consulta = "UPDATE Sucursal SET ingresos_totales=" + (totalFinal) + " WHERE id_sucursal=" + idSucursal;
            conexion.ejecutarConsulta(consulta);
            conexion.cerrarConexion();
        } catch (Exception e) {
            System.err.println("Error al restar unidades: " + e);
        }
            
    }
    
    
        public static void actualizarTablaIngresosSucursales(JTable tabla) {
        try {
            ConexionBD conexion = new ConexionBD();
            String consulta = "select * from Sucursal order by ingresos_totales desc";
            PreparedStatement ps = conexion.getConexion().prepareStatement(consulta);
            ResultSet rs = ps.executeQuery();
            DefaultTableModel modelo = new DefaultTableModel();
            tabla.setModel(modelo);
            modelo.setColumnIdentifiers(new Object[]{"id_sucursal", "nombre", "direccion", "ingresos_totales"});
            while (rs.next()) {
                modelo.addRow(new Object[]{rs.getInt("id_sucursal"), rs.getString("nombre"), rs.getString("direccion"), rs.getInt("ingresosTotales")});
            }
            conexion.cerrarConexion();
        } catch (Exception e) {
            System.err.println("Error al actualizar la tabla Movimientos: " + e);
        }
    }
    
    
}
