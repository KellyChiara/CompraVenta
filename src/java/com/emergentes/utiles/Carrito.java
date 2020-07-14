package com.emergentes.utiles;
public class Carrito {
    private int item;
    private int idProducto;
    private String nombres;
    private String descripcion;
    private double precioCompra;
    private int cantidad;
    private double subTotal;

    public Carrito( ) {
        this.item = 0;
        this.idProducto =0;
        this.nombres = "";
        this.descripcion = "";
        this.precioCompra = 0.0;
        this.cantidad = 0;
        this.subTotal = 0.0;
    }
    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(double precioCompra) {
        this.precioCompra = precioCompra;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }
}

