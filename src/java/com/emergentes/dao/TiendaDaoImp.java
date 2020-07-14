package com.emergentes.dao;
import com.emergentes.utiles.ConexionBD;
import com.emergentes.utiles.Tienda;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class TiendaDaoImp extends ConexionBD implements TiendaDao {
    static PreparedStatement ps;
    static ResultSet rs;
    @Override
    public void agregar(Tienda t) throws Exception {
        try {
            this.conectar();
            String sql = "insert into tienda (tiNombre,tiPais,tiCiudad,tiDireccion,tiVende,tiNumero,tiCodigo) values (?,?,?,?,?,?,?)";
            ps = this.conn.prepareStatement(sql);
            ps.setString(1, t.getNombre());
            ps.setString(2, t.getPais());
            ps.setString(3, t.getCiudad());
            ps.setString(4, t.getDireccion());
            ps.setString(5, t.getVende());
            ps.setInt(6, t.getNumero());
            ps.setString(7, t.getCodigo());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al agregar tienda" + e.getMessage());
        } 
    }

    @Override
    public Tienda getById(int id) throws Exception {
        Tienda t = new Tienda();
        try {
            this.conectar();
            String sql = "select * from tienda where idTienda = ?";
            ps = this.conn.prepareStatement(sql);
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

    @Override
    public void update(Tienda tienda) throws Exception {
        try {
            this.conectar();
            String sql = "update tienda set tiNombre = ?,tiPais = ?,tiCiudad = ?,tiDireccion = ?,tiVende = ?,tiNumero = ?,tiCodigo=? where idTienda = ?";
            ps = this.conn.prepareStatement(sql);
            ps.setString(1, tienda.getNombre());
            ps.setString(2, tienda.getPais());
            ps.setString(3, tienda.getCiudad());
            ps.setString(4, tienda.getDireccion());
            ps.setString(5, tienda.getVende());
            ps.setInt(6, tienda.getNumero());
            ps.setString(7, tienda.getCodigo());
            ps.setInt(8, tienda.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error en update " + e.getMessage());
        } 
    }
    @Override
    public void delete(int id) throws Exception {
        try {
            this.conectar();
            String sql = "delete from tienda where idTienda = ?";
            ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error en delete "+e.getMessage());
        } 
    }

    @Override
    public void cerrar() throws Exception {
        this.desconectar();
        System.out.println("desconectado");
    }
}
