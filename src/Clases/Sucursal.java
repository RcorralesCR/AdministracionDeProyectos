
import Clases.Producto;
import Clases.Construcion;
import Clases.Jardineria;
import Clases.Hogar;
import Clases.Garaje;
import java.util.ArrayList;

public class Sucursal {

    private Construcion matCons;
    private Garaje matGaraje;
    private Hogar matHogar;
    private Jardineria matJardin;
    private ArrayList<Producto> listado;

    public Sucursal() {

    }

    public Sucursal(Construcion matCons, Garaje matGaraje, Hogar matHogar, Jardineria matJardin, String locacion,
            ArrayList listado) {
        this.matCons = matCons;
        this.matGaraje = matGaraje;
        this.matHogar = matHogar;
        this.matJardin = matJardin;
        this.listado = new ArrayList<Producto>();
    }

    public Construcion getMatCons() {
        return matCons;
    }

    public void setMatCons(Construcion matCons) {
        this.matCons = matCons;
    }

    public Garaje getMatGaraje() {
        return matGaraje;
    }

    public void setMatGaraje(Garaje matGaraje) {
        this.matGaraje = matGaraje;
    }

    public Hogar getMatHogar() {
        return matHogar;
    }

    public void setMatHogar(Hogar matHogar) {
        this.matHogar = matHogar;
    }

    public Jardineria getMatJardin() {
        return matJardin;
    }

    public void setMatJardin(Jardineria matJardin) {
        this.matJardin = matJardin;
    }

    public ArrayList<Producto> getListado() {
        return listado;
    }

    public void setListado(ArrayList<Producto> listado) {
        this.listado = listado;
    }

}
