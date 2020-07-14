package com.emergentes.utiles;
public class Cliente {
    private int idCliente;
    private String nombres;
    private String apellidos;
    private String correo;
    private String password;
    public Cliente(){
    this.idCliente = 0;
        this.nombres = "";
        this.apellidos = "";
        this.correo = "";
        this.password = "";
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
