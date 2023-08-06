package Clases;



public class Usuario {
	
	//Atributos
	private int id_usuario;
	private String password;
	
	//Constructor

    public Usuario() {
    }

    public Usuario(int id_usuario, String password) {
        this.id_usuario = id_usuario;
        this.password = password;
    }


    //Metodos

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



}