package com.emergentes.dao;
import com.emergentes.utiles.Cliente;
public interface ClienteDao {
    public void agregar (Cliente c) throws Exception;
    public void update (Cliente c) throws Exception;
    public Cliente getById (int id) throws Exception;
}
