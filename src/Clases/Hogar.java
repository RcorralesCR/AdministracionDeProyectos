package Clases;

import javax.swing.JComboBox;

public class Hogar extends Producto {

    private String tipo = "Hogar";

    public Hogar() {

    }

    public Hogar(String nomProducto, String codigo, int cantiUnid, double precio, String detalles) {
        super(nomProducto, codigo, cantiUnid, precio, detalles);
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
