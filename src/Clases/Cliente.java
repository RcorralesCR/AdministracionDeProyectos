package Clases;

public class Cliente {

    private int id_cliente;
    private String direccion;
    private String nombre;
    private String telefono;
    private String correo_electronico;

    //Constructores
    public Cliente() {
    }

    public Cliente(int id_cliente, String direccion, String nombre, String telefono, String correo_electronico) {
        this.id_cliente = id_cliente;
        this.direccion = direccion;
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo_electronico = correo_electronico;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo_electronico() {
        return correo_electronico;
    }

    public void setCorreo_electronico(String correo_electronico) {
        this.correo_electronico = correo_electronico;
    }

}
