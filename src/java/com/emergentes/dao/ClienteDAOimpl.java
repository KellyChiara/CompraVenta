package com.emergentes.dao;
import com.emergentes.utiles.Cliente;
import com.emergentes.utiles.ConexionBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
public class ClienteDAOimpl extends ConexionBD implements Validar {
    @Override
    public void insert(Cliente cliente) throws Exception {
        try {
            this.conectar();
            String sql = "insert into clientes (Cnombres,Capellidos,Ccorreo,Cpassword) values(?,?,?,?)";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1,cliente.getNombres());
            ps.setString(2, cliente.getApellidos());
            ps.setString(3, cliente.getCorreo());
            ps.setString(4, cliente.getPassword());
            //Ejecutar la consulta
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally{
            this.desconectar();
        }
    }

    @Override
    public void update(Cliente cliente) throws Exception {
        try {
            this.conectar();
            String sql = "update clientes set Cnombres=?, Capellidos=?, Ccorreo=? ,  Cpassword=? where idCliente = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1,cliente.getNombres());
            ps.setString(2, cliente.getApellidos());
            ps.setString(3, cliente.getCorreo());
            ps.setString(4, cliente.getPassword());
            ps.setInt(6, cliente.getIdCliente());
            //Ejecutar la consulta
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally{
            this.desconectar();
        }
    }
    @Override
    public void delete(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Cliente getById(int id) throws Exception {
        Cliente avi = new Cliente();
        try {
            this.conectar();
            
            String sql ="select * from clientes where idCliente = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
               
               avi.setIdCliente(rs.getInt("idCliente"));
               avi.setNombres(rs.getString("Cnombres"));
               avi.setApellidos(rs.getString("Capellidos"));
               avi.setCorreo(rs.getString("Ccorreo"));
               avi.setPassword(rs.getString("Cpassword"));
            }
        } catch (Exception e) {
            throw e;
        }finally{
            this.desconectar();
        }
        return avi;
    }

    @Override
    public List<Cliente> getAll() throws Exception {
       List<Cliente> lista = null;
        try {
            this.conectar();
            String sql = "select * from clientes";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            lista = new ArrayList<Cliente>();
            while(rs.next()){
                Cliente avi = new Cliente();
               avi.setIdCliente(rs.getInt("idCliente"));
               avi.setNombres(rs.getString("Cnombres"));
               avi.setApellidos(rs.getString("Capellidos"));
               avi.setCorreo(rs.getString("Ccorreo"));
               avi.setPassword(rs.getString("Cpassword"));
                //adicionar a la coleccion
                lista.add(avi);
            }
        } catch (Exception e) {
            throw e;
        }finally {
           this.desconectar();
        }
        return lista;
    }
}
    

