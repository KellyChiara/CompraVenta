package com.emergentes.utiles;
import java.io.InputStream;
public class Producto {
    private int idP;
    private String nombreP;
    private String descripcionP;
    private double precioP;
    private int stockP;
    private InputStream foto;
    private int idTienda;

    public Producto() {
        this.idP = 0;
        this.nombreP = "";
        this.descripcionP = "";
        this.precioP = 0;
        this.stockP = 0;
        this.idTienda = 0;
    }

    public int getIdP() {
        return idP;
    }

    public void setIdP(int idP) {
        this.idP = idP;
    }

    public String getNombreP() {
        return nombreP;
    }

    public void setNombreP(String nombreP) {
        this.nombreP = nombreP;
    }

    public String getDescripcionP() {
        return descripcionP;
    }

    public void setDescripcionP(String descripcionP) {
        this.descripcionP = descripcionP;
    }

    public double getPrecioP() {
        return precioP;
    }

    public void setPrecioP(double precioP) {
        this.precioP = precioP;
    }

    public int getStockP() {
        return stockP;
    }

    public void setStockP(int stockP) {
        this.stockP = stockP;
    }

    public InputStream getFoto() {
        return foto;
    }

    public void setFoto(InputStream foto) {
        this.foto = foto;
    }

    public int getIdTienda() {
        return idTienda;
    }

    public void setIdTienda(int idTienda) {
        this.idTienda = idTienda;
    }
}
