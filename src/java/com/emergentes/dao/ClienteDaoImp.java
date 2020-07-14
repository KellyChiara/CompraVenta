package com.emergentes.dao;
import com.emergentes.utiles.Cliente;
import com.emergentes.utiles.ConexionBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class ClienteDaoImp extends ConexionBD implements ClienteDao{
    static PreparedStatement ps;
    static ResultSet rs;
    @Override
    public void agregar(Cliente c) throws Exception {
        try {
            this.conectar();
            String sql = "insert into clientes (Cnombres, Capellidos, Ccorreo, Cpassword) values (?,?,?,?)";
            ps = this.conn.prepareStatement(sql);
            ps.setString(1, c.getNombres());
            ps.setString(2, c.getApellidos());
            ps.setString(3, c.getCorreo());
            ps.setString(4, c.getPassword());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error agregar "+e.getMessage());
        }
    }
    @Override
    public void update(Cliente c) throws Exception {
        try {
            this.conectar();
            String sql = "update clientes set Cnombres = ?, Capellidos = ?, Ccorreo = ?, Cpassword = ? where idCliente = ?";
            ps = this.conn.prepareStatement(sql);
            ps.setString(1, c.getNombres());
            ps.setString(2, c.getApellidos());
            ps.setString(3, c.getCorreo());
            ps.setString(4, c.getPassword());
            ps.setInt(5, c.getIdCliente());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al editar "+e.getMessage());
        }
    }

    @Override
    public Cliente getById(int id) throws Exception {
        Cliente c = new Cliente();
        try {
            this.conectar();
            String sql = "select * from clientes where idCliente="+id;
            ps = this.conn.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()){
                c.setIdCliente(rs.getInt(1));
                c.setNombres(rs.getString(2));
                c.setApellidos(rs.getString(3));
                c.setCorreo(rs.getString(4));
                c.setPassword(rs.getString(5));
            }
        } catch (Exception e) {
            System.out.println("Error en getByCliente "+e.getMessage());
        }
        return c;
    }
}
