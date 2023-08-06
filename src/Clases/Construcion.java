package Clases;

import javax.swing.JComboBox;

public class Construcion extends Producto {

    private String tipo = "Construcción";

    public Construcion() {

    }

    public Construcion(String nomProducto, String codigo, int cantiUnid, double precio, String detalles) {
        super(nomProducto, codigo, cantiUnid, precio, detalles);
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
