package com.emergentes.dao;
import com.emergentes.utiles.Tienda;
public interface TiendaDao {
    public void agregar (Tienda t) throws Exception;
    public Tienda getById(int id) throws Exception;
    public void update (Tienda tienda) throws Exception;
    public void delete (int id) throws Exception;
    public void cerrar() throws Exception;
}
