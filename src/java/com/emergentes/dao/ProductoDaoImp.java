package com.emergentes.dao;
import com.emergentes.utiles.ConexionBD;
import com.emergentes.utiles.Producto;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
public class ProductoDaoImp extends ConexionBD implements ProductoDao{
    static PreparedStatement ps;
    static ResultSet rs;
    @Override
    public void insert(Producto p) throws Exception {
        try {
            this.conectar();
            String sql = "insert into productos (nombreP,descripcionP,precioP,stockP,foto,idTienda) values (?,?,?,?,?,?)";
            ps = this.conn.prepareStatement(sql);
            ps.setString(1, p.getNombreP());
            ps.setString(2, p.getDescripcionP());
            ps.setDouble(3, p.getPrecioP());
            ps.setInt(4, p.getStockP());
            ps.setBlob(5, p.getFoto());
            ps.setInt(6, p.getIdTienda());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error en insert "+e.getMessage());
        }
    }

    @Override
    public List<Producto> getByIdTienda(int id) throws Exception {
        List<Producto> producto = new ArrayList();
        try {
            this.conectar();
            String sql = "select * from productos where idTienda="+id;
            ps = this.conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                Producto p = new Producto();
                p.setIdP(rs.getInt(1));
                p.setNombreP(rs.getString(2));
                p.setDescripcionP(rs.getString(3));
                p.setPrecioP(rs.getDouble(4));
                p.setStockP(rs.getInt(5));
                p.setFoto(rs.getBinaryStream(6));
                p.setIdTienda(rs.getInt(7));
                producto.add(p);
            }
        } catch (Exception e) {
            System.out.println("Error en getByIdTienda "+e.getMessage());
        } 
        return producto;
    }

    @Override
    public void update(Producto p) throws Exception {
        try {
            this.conectar();
            String sql = "update productos set nombreP = ?, descripcionP = ?, precioP = ?, stockP = ?, foto = ?,idTienda = ? where idP = ?";
            ps = this.conn.prepareStatement(sql);
            ps.setString(1, p.getNombreP());
            ps.setString(2, p.getDescripcionP());
            ps.setDouble(3, p.getPrecioP());
            ps.setInt(4, p.getStockP());
            ps.setBlob(5, p.getFoto());
            ps.setInt(6, p.getIdTienda());
            ps.setInt(7, p.getIdP());       
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error en update "+e.getMessage());
        } 
    }

    @Override
    public void delete(int id) throws Exception {
        try {
            this.conectar();
            String sql = "delete from productos where idP = "+id;
            ps = this.conn.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error en delete "+e.getMessage());
        } 
    }

    @Override
    public void listarImg(int id, HttpServletResponse response) throws Exception {
        String sql = "select * from productos where idP="+id;
        InputStream inputStream = null;
        OutputStream outputStream = null;
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            outputStream = response.getOutputStream();
            this.conectar();
            ps = this.conn.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()){
                inputStream = rs.getBinaryStream("foto");
            }
            bufferedInputStream = new BufferedInputStream(inputStream);
            bufferedOutputStream = new BufferedOutputStream(outputStream);
            int i = 0;
            while ((i = bufferedInputStream.read()) != -1){
                bufferedOutputStream.write(i);
            }
        } catch (Exception e) {
            System.out.println("Error al listarImg "+e.getMessage());
        }
    }

    @Override
    public Producto listarId(int id) throws Exception {
        String sql = "select * from productos where idP="+id;
        Producto p = new Producto();
        try {
            this.conectar();
            ps = this.conn.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()){
                p.setIdP(rs.getInt(1));
                p.setNombreP(rs.getString(2));
                p.setDescripcionP(rs.getString(3));
                p.setPrecioP(rs.getDouble(4));
                p.setStockP(rs.getInt(5));
                p.setFoto(rs.getBinaryStream(6));
                p.setIdTienda(rs.getInt(7));
            }
        } catch (Exception e) {
            System.out.println("Error en listarId "+e.getMessage());
        } 
        return p;
    }

    @Override
    public List<Producto> listar() throws Exception {
        List<Producto> productos = new ArrayList();
        String sql = "select * from productos";
        try {
            this.conectar();
            ps = this.conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Producto p = new Producto();
                p.setIdP(rs.getInt(1));
                p.setNombreP(rs.getString(2));
                p.setDescripcionP(rs.getString(3));
                p.setPrecioP(rs.getDouble(4));
                p.setStockP(rs.getInt(5));
                p.setFoto(rs.getBinaryStream(6));
                p.setIdTienda(rs.getInt(7));
                productos.add(p);
            }
        } catch (Exception e) {
            throw e;
        }
        return productos;
    }
}
