
package com.emergentes.dao;

import com.emergentes.utiles.Cliente;
import java.util.List;

public interface Validar {
    
    public void insert(Cliente cliente)throws Exception;
    public void update(Cliente cliente)throws Exception;
    public void delete(int id) throws Exception;
    public Cliente getById(int id) throws Exception;
    public List<Cliente> getAll() throws Exception;
}
