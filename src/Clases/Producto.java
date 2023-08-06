package Clases;

import javax.swing.JComboBox;
import javax.swing.JOptionPane; //Sacar al final, está aquí para facilitar demo.

public abstract class Producto {

    private String nomProducto = ""; //Autoexplicativo.
    private int cantiUnid = 0; //Cantidad de unidades.
    private double precio = 0;//Autoexplicativo.
    private String codigo = "";/*Es string porque puede tener número, pero un prefijo "PR-001"
                      ayuda a entender de donde proviene este código: ¿es de jardín o garaje?
                      por ejemplo*/

    private String detalles = "";//Opcional, es para explicar qué es. Puede que se use o no.

    public Producto() {

    }

    public Producto(String nomProducto, String codigo, int cantiUnid, double precio, String detalles) {
        this.nomProducto = nomProducto;

        this.codigo = codigo;
        this.cantiUnid = cantiUnid;
        this.precio = precio;
        this.detalles = detalles;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNomProducto() {
        return nomProducto;
    }

    public void setNomProducto(String nomProducto) {
        this.nomProducto = nomProducto;
    }

    public int getCantiUnid() {
        return cantiUnid;
    }

    public void setCantiUnid(int cantiUnid) {
        this.cantiUnid = cantiUnid;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    @Override
    public String toString() {
        return "Productos{" + "codigo=" + codigo + ", nomProducto=" + nomProducto + ", cantiUnid=" + cantiUnid + ", precio=" + precio + ", detalles=" + detalles + '}';
    }

}
