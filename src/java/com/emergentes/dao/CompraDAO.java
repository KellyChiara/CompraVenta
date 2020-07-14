package com.emergentes.dao;

import com.emergentes.modelo.Carrito;
import com.emergentes.modelo.Compra;
import com.emergentes.utiles.ConexionBD;
import com.emergentes.utiles.Tienda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CompraDAO {

    Connection con;
    ConexionBD cn = new ConexionBD();
    PreparedStatement ps;
    ResultSet rs;
    int r = 0;

    public int GenerarCompra(Compra compra) {
        int idCompras;
        String sql = "insert into compras(idCliente, fechaCompras, monto,estado) values(?,?,?,?,?)";
        try {
            con = cn.conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(2, compra.getCliente());
            ps.setString(3, compra.getFechaCompra());
            ps.setDouble(4, compra.getMonto());
            ps.setString(5, compra.getEstado());
            r = ps.executeUpdate();
            sql = "Select @@IDENTITY AS idCompras";
            rs = ps.executeQuery(sql);
            rs.next();
            idCompras = rs.getInt("idCompras");
            rs.close();
            for (Carrito detalle : compra.getDetallecompras()) {
                sql = "insert into detallecompras(idP, idCompras, cantidad, precioCompra, idTienda) values(?,?,?,?)";
                ps = con.prepareStatement(sql);
                ps.setInt(1, detalle.getIdProducto());
                ps.setInt(2, idCompras);
                ps.setInt(3, detalle.getCantidad());
                ps.setDouble(4, detalle.getPrecioCompra());
                r = ps.executeUpdate();
            }
        } catch (Exception e) {
            System.out.println("Error en generaCompra " + e.getMessage());
        }
        return r;
    }

    public Tienda getById(int id) {
        Tienda t = new Tienda();
        try {
            con = cn.conectar();
            String sql = "select * from tienda where idTienda = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                t.setId(rs.getInt(1));
                t.setNombre(rs.getString(2));
                t.setPais(rs.getString(3));
                t.setCiudad(rs.getString(4));
                t.setDireccion(rs.getString(5));
                t.setVende(rs.getString(6));
                t.setNumero(rs.getInt(7));
                t.setCodigo(rs.getString(8));
            }
        } catch (Exception e) {
            System.out.println("Error en getById " + e.getMessage());
        }
        return t;
    }

}
