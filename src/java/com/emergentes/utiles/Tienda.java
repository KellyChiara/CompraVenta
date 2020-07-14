package com.emergentes.utiles;
public class Tienda {
    private int id;
    private String nombre;
    private String pais;
    private String ciudad;
    private String direccion;
    private String vende;
    private int numero;
    private String codigo;
    public Tienda() {
        this.id = 0;
        this.nombre ="";
        this.pais="";
        this.ciudad = "";
        this.direccion = "";
        this.vende = "";
        this.numero = 0;
        this.codigo = "";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getVende() {
        return vende;
    }

    public void setVende(String vende) {
        this.vende = vende;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
}
