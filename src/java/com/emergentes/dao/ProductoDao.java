package com.emergentes.dao;
import com.emergentes.utiles.Producto;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
public interface ProductoDao {
    public void insert (Producto p) throws Exception;
    public List<Producto> getByIdTienda (int id) throws Exception;
    public void listarImg (int id, HttpServletResponse response) throws Exception;
    public Producto listarId (int id) throws Exception;
    public void update (Producto p) throws Exception;
    public void delete (int id) throws Exception;
    public List<Producto> listar () throws Exception;
}
