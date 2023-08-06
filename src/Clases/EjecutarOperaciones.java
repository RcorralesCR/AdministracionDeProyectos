package Clases;

import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class EjecutarOperaciones {

    //METODO PARA REGISTRAR USUARIO
    public static void registrarUsuario(String nombre, String password) {
        try {
            ConexionBD conexion = new ConexionBD();
            String consulta = "INSERT INTO usuario (nombre_usuario, password) VALUES ('" + nombre + "', '" + password + "')";
            conexion.ejecutarConsulta(consulta);
            conexion.cerrarConexion();
        } catch (Exception e) {
            System.err.println("Error al registrar usuario: " + e);
        }
    }

    //METODO PARA REGISTRAR CLIENTE
    public static void registrarCliente(String nombre, String direccion, String correo_electronico, String telefono) {
        try {
            ConexionBD conexion = new ConexionBD();
            String consulta = "INSERT INTO cliente (nombre_cliente, direccion,correo_electronico,telefono) VALUES ('" + nombre + "', '" + direccion + "','" + correo_electronico + "','" + telefono + "')";
            conexion.ejecutarConsulta(consulta);
            conexion.cerrarConexion();
        } catch (Exception e) {
            System.err.println("Error al registrar usuario: " + e);
        }
    }

    //METODO PARA VERIFICAR USUARIO EN LA BASE DE DATOS
    public static boolean verificarUsuario(String nombre, String pass) {
        boolean valido = false;
        try {
            ConexionBD conexion = new ConexionBD();
            String consulta = "SELECT * FROM usuario WHERE nombre_usuario='" + nombre + "' AND password='" + pass + "'";
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
//llenar ComboBOX NOMBRE PRODUCTO
    public static void llenarComboNombreProducto(JComboBox<String> combo) {
        try {
            ConexionBD conexion = new ConexionBD();
            String consulta = "SELECT nombre_producto FROM producto";
            PreparedStatement ps = conexion.getConexion().prepareStatement(consulta);
            ResultSet resultado = ps.executeQuery();
            while (resultado.next()) {
                combo.addItem(resultado.getString("nombre_producto"));
            }
            conexion.cerrarConexion();
        } catch (Exception e) {
            System.err.println("A: " + e);
        }
    }
//llenar ComboBOX IdUsuario

    public static void llenarComboNombreUsuario(JComboBox<String> combo) {
        try {
            ConexionBD conexion = new ConexionBD();
            String consulta = "SELECT nombre_usuario FROM usuario";
            PreparedStatement ps = conexion.getConexion().prepareStatement(consulta);
            ResultSet resultado = ps.executeQuery();
            while (resultado.next()) {
                combo.addItem(resultado.getString("nombre_usuario"));
            }
            conexion.cerrarConexion();
        } catch (Exception e) {
            System.err.println("Error al llenar Combo Nombre Usuario: " + e);
        }
    }
//LLENAR COMBOBOX NOMBRE CLIENTE
    public static void llenarComboNombreCliente(JComboBox<String> combo) {
        try {
            ConexionBD conexion = new ConexionBD();
            String consulta = "SELECT nombre_cliente FROM cliente";
            PreparedStatement ps = conexion.getConexion().prepareStatement(consulta);
            ResultSet resultado = ps.executeQuery();
            while (resultado.next()) {
                combo.addItem(resultado.getString("nombre_cliente"));
            }
            conexion.cerrarConexion();
        } catch (Exception e) {
            System.err.println("Error al llenar ComboNombreCliente: " + e);
        }
    }
    //llenar ComboBOX IdProducto

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
    //AGREGA UN PRODUCTO A LA BASE DE DATOS CONTIENE SU COMANDO SQL CORRESPONDIENTE
    public static void agregarProducto(ArrayList<Producto> lproductos, String sucursal, String tipoProd) {
        try {

            for (Producto vproducto : lproductos) {
                ConexionBD conexion = new ConexionBD();
                String consulta = "INSERT INTO producto(codigo_producto,tipo_producto,nombre_producto, cantidad ,precio ,descripcion, id_sucursal ) VALUES ('" + vproducto.getCodigo() + "','" + tipoProd + "','" + vproducto.getNomProducto() + "','" + vproducto.getCantiUnid() + "','" + vproducto.getPrecio() + "','" + vproducto.getDetalles() + "','" + sucursal + "')";
                conexion.ejecutarConsulta(consulta);
                conexion.cerrarConexion();
                JOptionPane.showMessageDialog(null, "Compra registrada exitosamente", "Registro exitoso", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            System.err.println("Error al agregar producto: " + e);
        }
    }
//SELECCIONA LOS PRODUCTOS DE LA BASE DE DATOS ,CONTIENE SU COMANDO SQL CORRESPONDIENTE
    public static String[] obtenerProducto(String nombre_producto) {
        String[] producto = new String[6];
        try {
            ConexionBD conexion = new ConexionBD();
            String consulta = "SELECT * FROM producto WHERE nombre_producto ='" + nombre_producto + "'";
            PreparedStatement ps = conexion.getConexion().prepareStatement(consulta);
            ResultSet resultado = ps.executeQuery();
            if (resultado.next()) {
                producto[0] = resultado.getString("codigo_producto");
                producto[1] = resultado.getString("nombre_producto");
                producto[2] = resultado.getString("cantidad");
                producto[3] = resultado.getString("precio");
                producto[4] = resultado.getString("descripcion");
                producto[5] = resultado.getString("id_sucursal");
            }
            conexion.cerrarConexion();
        } catch (Exception e) {
            System.err.println("Error al obtener producto: " + e);
        }
        return producto;
    }
//REGISTRA UN PRODUCTO EN  LA BASE DE DATOS CONTIENE SU COMANDO SQL CORRESPONDIENTE
    public static void registrarPedido(String nombreUsuario, String nombreCliente, String nombre_producto, String codigo_producto, int cantidad, String fecha_pedido) {
        try {
            ConexionBD conexion = new ConexionBD();
            String consulta = "INSERT INTO pedido (nombre_usuario,nombre_cliente,producto, codigo_producto, cantidad, fecha_pedido) VALUES ('" + nombreUsuario + "', '" + nombreCliente + "','" + nombre_producto + "','" + codigo_producto + "', '" + cantidad + "', '" + fecha_pedido + "')";
            conexion.ejecutarConsulta(consulta);
            conexion.cerrarConexion();
        } catch (Exception e) {
            System.err.println("Error al registrar pedido: " + e);
        }
    }
//LLENA LA COMBOBOX CON LOS NOMBRES DE LOS PRODUCTOS
    public static void llenarComboNombreProducto(String nombre, JLabel labelNombreProducto) {
        try {
            ConexionBD conexion = new ConexionBD();
            String consulta = "SELECT codigo_producto FROM producto WHERE nombre_producto  = '" + nombre + "'";
            PreparedStatement ps = conexion.getConexion().prepareStatement(consulta);
            ResultSet resultado = ps.executeQuery();
            if (resultado.next()) {
                labelNombreProducto.setText(resultado.getString("codigo_producto"));
            }
            conexion.cerrarConexion();
        } catch (Exception e) {
            System.err.println("Error al llenar ComboNombreProducto: " + e);
        }
    }
//LLENA EL COMBOBOX CON LOS NOMBRES DE LAS SUCURSALES
    public static void llenarComboSucursal(JComboBox comboSucursal) {
        try {
            ConexionBD conexion = new ConexionBD();
            String consulta = "SELECT nombre_sucursal from sucursal";
            PreparedStatement ps = conexion.getConexion().prepareStatement(consulta);
            ResultSet resultado = ps.executeQuery();
            while (resultado.next()) {
                comboSucursal.addItem(resultado.getString("nombre_sucursal"));
            }
            conexion.cerrarConexion();
        } catch (Exception e) {
            System.err.println("Error al llenar el combo de sucursales: " + e);
        }
    }
//LLENA LA TABLA DE USUARIOS PARA MOSTRARLA
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
                Object[] fila = new Object[1];
                //se llena el array con los datos de cada registro

                fila[0] = resultado.getString("nombre_usuario");

                //se agrega el array a la tabla
                modelo.addRow(fila);
            }
            conexion.cerrarConexion();
        } catch (Exception e) {
            System.err.println("Error al llenar tabla Usuarios: " + e);
        }
    }

    //REGISTRA LA SUCURSAL EN LA BASE DE DATOS CONTIENE SU COMANDO SQL CORRESPONDIENTE
    public static void registrarSucursal(int id_sucursal, String nombre, String direccion) {
        try {
            ConexionBD conexion = new ConexionBD();
            String consulta = "INSERT INTO sucursal (id_sucursal, nombre_sucursal, direccion) VALUES ('" + id_sucursal + "', '" + nombre + "', '" + direccion + "')";
            conexion.ejecutarConsulta(consulta);
            conexion.cerrarConexion();

        } catch (Exception e) {
            System.err.println("Error al registrar sucursal: " + e);
        }
    }
//ELIMINA UNA SUCURSAL DE LA BASE DE DATOS

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
//MODIFICA UNA SUCURSAL EN LA BASE DE DATOS

    public static void modificarSucursal(int id_sucursal, String nombre, String direccion) {
        try {
            ConexionBD conexion = new ConexionBD();
            String consulta = "UPDATE sucursal SET nombre_sucursal='" + nombre + "', direccion='" + direccion + "' WHERE id_sucursal='" + id_sucursal + "'";
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
                sucursal[0] = resultado.getString("nombre_sucursal");
                sucursal[1] = resultado.getString("direccion");
            } else if (!resultado.next()) {
                JOptionPane.showMessageDialog(null, "Sucursal No Encontrada");
            }
            conexion.cerrarConexion();
        } catch (Exception e) {
            System.err.println("Error al buscar sucursal: " + e);
        }
        return sucursal;
    }
    //CREA UN MOVIMIENTO Y LO GUARDA EN LA BASE DE DATOS
    public static void crearMovimiento(int sucursal_origen, int sucursal_destino, String producto, String codigo_producto, int cantidad, String fecha_envio) {
        try {

            ConexionBD conexion = new ConexionBD();
            String consulta = "INSERT INTO movimiento (sucursal_origen, sucursal_destino, producto,codigo_producto, cantidad, fecha_envio) VALUES ('" + sucursal_origen + "','" + sucursal_destino + "','" + producto + "','" + codigo_producto + "','" + cantidad + "','" + fecha_envio + "')";
            conexion.ejecutarConsulta(consulta);
            conexion.cerrarConexion();
        } catch (Exception e) {
            System.err.println("Error al crear Movimiento: " + e);
        }
    }

    public static void editarMovimiento(int id_movimiento, String sucursal_origen, String sucursal_destino, String producto, int cantidad, String fecha_envio) {
        try {
            ConexionBD conexion = new ConexionBD();
            String consulta = "UPDATE movimiento SET sucursal_origen = ('" + sucursal_origen + "', sucursal_destino = '" + sucursal_destino + "', producto = '" + producto + "', cantidad = '" + cantidad + "', fecha_envio = '" + fecha_envio + "' WHERE id_movimiento = '" + id_movimiento + "')";
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
//METODO BUSCAR MOVIMIENTO

    public static String[] buscarMovimiento(int id_movimiento) {
        String[] movimiento = new String[6];
        try {
            ConexionBD conexion = new ConexionBD();
            String consulta = "SELECT * FROM movimiento WHERE id_movimiento='" + id_movimiento + "'";
            PreparedStatement ps = conexion.getConexion().prepareStatement(consulta);
            ResultSet resultado = ps.executeQuery();
            if (resultado.next()) {
                movimiento[0] = resultado.getString("sucursal_origen");
                movimiento[1] = resultado.getString("sucursal_destino");
                movimiento[2] = resultado.getString("producto");
                movimiento[3] = resultado.getString("codigo_producto");
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
            modelo.setColumnIdentifiers(new Object[]{"id_movimiento", "sucursal_origen", "sucursal_destino", "producto", "codigo_producto", "cantidad", "fecha_envio"});
            while (rs.next()) {
                modelo.addRow(new Object[]{rs.getInt("id_movimiento"), rs.getString("sucursal_origen"), rs.getString("sucursal_destino"), rs.getString("producto"), rs.getString("codigo_producto"), rs.getInt("cantidad"), rs.getString("fecha_envio")});
            }
            conexion.cerrarConexion();
        } catch (Exception e) {
            System.err.println("Error al actualizar la tabla Movimientos: " + e);
        }
    }

    public static int calcularCantidadProducto(String nombre_producto) {

        int cantidad = 0;
        try {
            ConexionBD conexion = new ConexionBD();
            String consulta = "SELECT cantidad FROM producto WHERE nombre_producto  = '" + nombre_producto + "'";
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

    public static void restarUnidades(int cantidad, String nombre_producto) {
        try {
            ConexionBD conexion = new ConexionBD();
            String consulta = "UPDATE producto SET cantidad=" + (cantidad) + " WHERE nombre_producto = '" + nombre_producto + "'";
            conexion.ejecutarConsulta(consulta);
            conexion.cerrarConexion();
        } catch (Exception e) {
            System.err.println("Error al restar unidades: " + e);
        }
    }

    public static void actualizarTablaCantidadProductos(JTable tabla, int cantidad) {
        try {
            ConexionBD conexion = new ConexionBD();
            String consulta = "SELECT * FROM producto where cantidad <" + cantidad;
            PreparedStatement ps = conexion.getConexion().prepareStatement(consulta);
            ResultSet rs = ps.executeQuery();
            DefaultTableModel modelo = new DefaultTableModel();
            tabla.setModel(modelo);
            modelo.setColumnIdentifiers(new Object[]{"codigo_producto", "nombre_producto", "cantidad", "precio", "descripcion", "id_sucursal"});
            while (rs.next()) {
                modelo.addRow(new Object[]{rs.getString("codigo_producto"), rs.getString("nombre_producto"), rs.getInt("cantidad"), rs.getString("precio"), rs.getString("descripcion"), rs.getString("id_sucursal")});
            }
            conexion.cerrarConexion();
        } catch (Exception e) {
            System.err.println("Error al actualizar la tabla Movimientos: " + e);
        }
    }

    public static void aumentarMontoSucursal(float precioTotalCompraUnitaria, int idSucursal) {

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

        float totalFinal = precioTotalCompraUnitaria + precioActual;
        try {
            ConexionBD conexion = new ConexionBD();
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
                modelo.addRow(new Object[]{rs.getInt("id_sucursal"), rs.getString("nombre_sucursal"), rs.getString("direccion"), rs.getInt("ingresos_totales")});
            }
            conexion.cerrarConexion();
        } catch (Exception e) {
            System.err.println("Error al actualizar la tabla Movimientos: " + e);
        }
    }

    public static void agregarProductoaMovimiento(String codigoProducto, String nombreProducto, int cantidad, int precioUnitario, String descripcion, String sucursal) {
        try {
            ConexionBD conexion = new ConexionBD();
            String consulta = "INSERT INTO producto(codigo_producto,nombre_producto, cantidad ,precio ,descripcion, id_sucursal ) VALUES ('" + codigoProducto + "'," + nombreProducto + "','" + cantidad + "','" + precioUnitario + "','" + descripcion + "','" + sucursal + "')";
            conexion.ejecutarConsulta(consulta);
            conexion.cerrarConexion();
        } catch (Exception e) {
            System.err.println("Error al agregar producto: " + e);
        }
    }

    public static void actualizarTablaPedidos(JTable tabla) {
        try {
            ConexionBD conexion = new ConexionBD();
            String consulta = "SELECT * FROM pedido";
            PreparedStatement ps = conexion.getConexion().prepareStatement(consulta);
            ResultSet rs = ps.executeQuery();
            DefaultTableModel modelo = new DefaultTableModel();
            tabla.setModel(modelo);
            modelo.setColumnIdentifiers(new Object[]{"id_pedido", "Nombre Usuario", "Nombre Cliente", "Producto", "Codigo Producto", "Cantidad", "Fecha_envio"});
            while (rs.next()) {
                modelo.addRow(new Object[]{rs.getInt("id_pedido"), rs.getString("nombre_usuario"), rs.getString("nombre_cliente"), rs.getString("producto"), rs.getString("codigo_producto"), rs.getInt("cantidad"), rs.getString("fecha_pedido")});
            }
            conexion.cerrarConexion();
        } catch (Exception e) {
            System.err.println("Error al actualizar la tabla Pedidos: " + e);
        }
    }
    
        public static void llenarComboIDMovimiento(JComboBox<String> combo) {
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
            System.err.println("Error al llenar Combo Id Movimiento: " + e);
        }
    }

}
