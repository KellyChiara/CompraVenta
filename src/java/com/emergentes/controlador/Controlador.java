package com.emergentes.controlador;

import com.emergentes.dao.ClienteDao;
import com.emergentes.dao.ClienteDaoImp;
import com.emergentes.dao.CompraDAO;
import com.emergentes.dao.ProductoDao;
import com.emergentes.dao.ProductoDaoImp;
import com.emergentes.dao.TiendaDao;
import com.emergentes.dao.TiendaDaoImp;
import com.emergentes.modelo.Carrito;
import com.emergentes.modelo.Compra;
import com.emergentes.modelo.Pago;
import com.emergentes.utiles.Cliente;
import com.emergentes.utiles.ConexionBD;
import com.emergentes.utiles.Fecha;
import com.emergentes.utiles.Producto;
import com.emergentes.utiles.Tienda;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

@MultipartConfig
@WebServlet(name = "Controlador", urlPatterns = {"/Controlador"})
public class Controlador extends HttpServlet {

    static ProductoDao Pdao = new ProductoDaoImp();
    static Producto p = new Producto();
    static List<Producto> prod = new ArrayList();
    static TiendaDao dao = new TiendaDaoImp();

    static Tienda t = new Tienda();
    static List<Tienda> datos = new ArrayList();

    static Cliente c = new Cliente();
    static ClienteDao cdao = new ClienteDaoImp();
    //id tienda
    int id;
    //id productos
    int idp;
    //id cliente
    int cid;
    ///vivi
    List<Carrito> listaCarrito = new ArrayList<>();
    int item;
    double totalPagar = 0.0;
    int cantidad = 1;
    Carrito car;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = (request.getParameter("accion") != null) ? request.getParameter("accion") : "view";
        System.out.println("La accion es: " + accion);
        switch (accion) {
            case "AgregarCarrito":
                try {
                    int pos = 0;
                    cantidad = 1;
                    idp = Integer.parseInt(request.getParameter("idP"));
                    p = Pdao.listarId(idp);
                    if (listaCarrito.size() > 0) {
                        for (int i = 0; i < listaCarrito.size(); i++) {
                            if (idp == listaCarrito.get(i).getIdProducto()) {
                                pos = i;
                            }
                        }
                        if (idp == listaCarrito.get(pos).getIdProducto()) {
                            cantidad = listaCarrito.get(pos).getCantidad() + cantidad;
                            double subtotal = listaCarrito.get(pos).getPrecioCompra() * cantidad;
                            listaCarrito.get(pos).setCantidad(cantidad);
                            listaCarrito.get(pos).setSubTotal(subtotal);
                        } else {
                            item = item + 1;
                            car = new Carrito();
                            car.setItem(item);
                            car.setIdProducto(p.getIdP());
                            car.setNombreProducto(p.getNombreP());
                            car.setDescripcion(p.getDescripcionP());
                            car.setPrecioCompra(p.getPrecioP());
                            car.setCantidad(cantidad);
                            car.setSubTotal(cantidad * p.getPrecioP());
                            listaCarrito.add(car);
                        }
                    } else {
                        item = item + 1;
                        car = new Carrito();
                        car.setItem(item);
                        car.setIdProducto(p.getIdP());
                        car.setNombreProducto(p.getNombreP());
                        car.setDescripcion(p.getDescripcionP());
                        car.setPrecioCompra(p.getPrecioP());
                        car.setCantidad(cantidad);
                        car.setSubTotal(cantidad * p.getPrecioP());
                        listaCarrito.add(car);
                    }
                    request.setAttribute("contador", listaCarrito.size());
                    request.getRequestDispatcher("Controlador?accion=view").forward(request, response);
                } catch (Exception e) {
                }
                break;
            case "Comprar":
                try {
                    totalPagar = 0.0;
                    idp = Integer.parseInt(request.getParameter("idP"));
                    p = Pdao.listarId(idp);
                    item = item + 1;
                    car = new Carrito();
                    car.setItem(item);
                    car.setIdProducto(p.getIdP());
                    car.setNombreProducto(p.getNombreP());
                    car.setDescripcion(p.getDescripcionP());
                    car.setPrecioCompra(p.getPrecioP());
                    car.setCantidad(cantidad);
                    car.setSubTotal(cantidad * p.getPrecioP());
                    listaCarrito.add(car);
                    for (int i = 0; i < listaCarrito.size(); i++) {
                        totalPagar = totalPagar + listaCarrito.get(i).getSubTotal();
                    }
                    request.setAttribute("totalPagar", totalPagar);
                    request.setAttribute("carrito", listaCarrito);
                    request.setAttribute("contador", listaCarrito.size());
                    request.getRequestDispatcher("Carrito.jsp").forward(request, response);
                    break;
                } catch (Exception e) {
                    System.out.println("Error en comprar " + e.getMessage());
                }
                break;
            case "carrito":
                totalPagar = 0.0;
                request.setAttribute("carrito", listaCarrito);
                for (int i = 0; i < listaCarrito.size(); i++) {
                    totalPagar = totalPagar + listaCarrito.get(i).getSubTotal();
                }
                request.setAttribute("totalPagar", totalPagar);
                request.getRequestDispatcher("Carrito.jsp").forward(request, response);
                break;
            case "GenerarCompra":
                /*c.setIdCliente(1);
                CompraDAO dac = new CompraDAO();
                Pago pago = new Pago();
                Compra compra = new Compra(c, 1, Fecha.FechaBD(), totalPagar, "vendido", listaCarrito);
                int res = dac.GenerarCompra(compra);*/
                
                if (totalPagar > 0) {
                    if (c.getIdCliente() == 0){
                        request.getRequestDispatcher("Login.jsp").forward(request, response);
                    } else{
                        
                        System.out.println("El id es: "+cid);
                    }
                    //request.getRequestDispatcher("mensaje.jsp").forward(request, response);
                } else {
                    request.getRequestDispatcher("error.jsp").forward(request, response);
                }
                break;
            case "pago":
                totalPagar = 0.0;
                request.setAttribute("carrito", listaCarrito);
                for (int i = 0; i < listaCarrito.size(); i++) {
                    totalPagar = totalPagar + listaCarrito.get(i).getSubTotal();
                }
                request.setAttribute("totalPagar", totalPagar);
                request.getRequestDispatcher("pago.jsp").forward(request, response);
                break;
            case "entrega":
                request.getRequestDispatcher("entrega.jsp").forward(request, response);
                break;
            case "clientesD":
                response.sendRedirect("controladorCarrito");
                break;
            case "direccionDom":
                request.getRequestDispatcher("editarDatos.jsp").forward(request, response);
                break;
            case "agradecimiento":
                request.getRequestDispatcher("agradecimiento.jsp").forward(request, response);
                break;
            case "ditienda":
                request.getRequestDispatcher("direccion.jsp").forward(request, response);
                break;
            case "Vender":
                request.getRequestDispatcher("Acceso.jsp").forward(request, response);
                break;
            case "Nuevo":
                //recuperar el id de la tienda para guardar los productos
                p = new Producto();
                id = Integer.parseInt(request.getParameter("idTienda"));
                p.setIdTienda(id);
                request.setAttribute("producto", p);
                request.getRequestDispatcher("Nuevo.jsp").forward(request, response);
                break;
            case "Cerrar":
                t = new Tienda();
                try {
                    prod = Pdao.listar();
                } catch (Exception e) {
                    System.out.println("Error en listar " + e.getMessage());
                }
                request.setAttribute("productos", prod);
                request.getRequestDispatcher("Inicio.jsp").forward(request, response);
                break;
            case "DatosTienda":
                id = Integer.parseInt(request.getParameter("idTienda"));
                try {
                    t = dao.getById(id);
                } catch (Exception e) {
                    System.out.println("Error en Datos tienda " + e.getMessage());
                }
                request.setAttribute("datos", t);
                request.getRequestDispatcher("Datos.jsp").forward(request, response);
                break;
            case "Aceptar":
                id = Integer.parseInt(request.getParameter("id"));
                p.setIdTienda(id);
                request.getRequestDispatcher("Controlador?accion=VistaTienda").forward(request, response);
                break;
            case "Editar":
                id = Integer.parseInt(request.getParameter("id"));
                try {
                    t = dao.getById(id);
                } catch (Exception e) {
                    System.out.println("Error en editar " + e.getMessage());
                }
                request.setAttribute("datos", t);
                request.getRequestDispatcher("Venta.jsp").forward(request, response);
                break;
            case "Cancelar":
                id = Integer.parseInt(request.getParameter("id"));
                if (id == 0) {
                    request.getRequestDispatcher("Acceso.jsp").forward(request, response);
                } else {
                    request.getRequestDispatcher("Tienda.jsp").forward(request, response);
                }
                break;
            case "VistaTienda":
                //recupera id de la tienda
                id = p.getIdTienda();
                System.out.println("id es " + id);
                try {
                    prod = Pdao.getByIdTienda(id);
                } catch (Exception e) {
                    System.out.println("Error al listar " + e.getMessage());
                }
                request.setAttribute("producto", prod);
                request.getRequestDispatcher("Tienda.jsp").forward(request, response);
                break;
            case "edit":
                idp = Integer.parseInt(request.getParameter("id"));
                try {
                    p = Pdao.listarId(idp);
                    request.setAttribute("producto", p);
                    request.getRequestDispatcher("Nuevo.jsp").forward(request, response);
                } catch (Exception e) {
                }
                break;
            case "eliminar":
                idp = Integer.parseInt(request.getParameter("id"));
                id = Integer.parseInt(request.getParameter("idTienda"));
                try {
                    Pdao.delete(idp);
                } catch (Exception e) {
                    System.out.println("Error al eliminar");
                }
                p.setIdTienda(id);
                request.getRequestDispatcher("Controlador?accion=VistaTienda").forward(request, response);
                break;
            case "Login":
                request.getRequestDispatcher("Login.jsp").forward(request, response);
                break;
            case "view":
                try {
                    prod = Pdao.listar();
                } catch (Exception e) {
                    System.out.println("Error en listar " + e.getMessage());
                }
                request.setAttribute("productos", prod);
                request.getRequestDispatcher("Inicio.jsp").forward(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        System.out.println("La es:" + accion);
        switch (accion) {
            case "Acceder":
                try {
                    String tienda = request.getParameter("nombre");
                    String codigo = request.getParameter("codigo");
                    ResultSet rs;
                    ConexionBD canal = new ConexionBD();
                    Connection conn = canal.conectar();
                    PreparedStatement ps;
                    String sql = "select * from tienda where tiNombre = ? and tiCodigo = ? limit 1";
                    ps = canal.conn.prepareStatement(sql);
                    ps.setString(1, tienda);
                    ps.setString(2, codigo);
                    rs = ps.executeQuery();
                    if (rs.next()) {
                        id = rs.getInt(1);
                        HttpSession ses = request.getSession();
                        ses.setAttribute("logueado", "OK");
                        ses.setAttribute("tienda", id);
                        p.setIdTienda(id);
                        response.sendRedirect("Controlador?accion=VistaTienda");
                    } else {
                        response.sendRedirect("Acceso.jsp");
                    }
                } catch (Exception e) {
                    System.out.println("Error al acceder " + e.getMessage());
                }
                break;
            case "Registrate":
                id = t.getId();
                request.setAttribute("datos", t);
                request.getRequestDispatcher("Venta.jsp").forward(request, response);
                break;
            case "Guardar":
                id = Integer.parseInt(request.getParameter("idTienda"));
                String nombre = request.getParameter("nombre");
                String pais = request.getParameter("pais");
                String ciudad = request.getParameter("ciudad");
                String direccion = request.getParameter("direccion");
                String vende = request.getParameter("vende");
                int numero = Integer.parseInt(request.getParameter("numero"));
                String codigo = request.getParameter("codigo");
                t.setId(id);
                t.setNombre(nombre);
                t.setPais(pais);
                t.setCiudad(ciudad);
                t.setDireccion(direccion);
                t.setVende(vende);
                t.setNumero(numero);
                t.setCodigo(codigo);
                if (id == 0) {
                    try {
                        dao.agregar(t);
                        response.sendRedirect("Acceso.jsp");
                    } catch (Exception e) {
                        System.out.println("Error al agregar " + e.getMessage());
                    }
                } else {
                    try {
                        dao.update(t);
                        p.setIdTienda(id);
                        response.sendRedirect("Controlador?accion=VistaTienda");
                    } catch (Exception e) {
                        System.out.println("Error en editar " + e.getMessage());
                    }
                }
                break;
            case "Confirmar":
                id = Integer.parseInt(request.getParameter("idTienda"));
                idp = Integer.parseInt(request.getParameter("id"));
                String producto = request.getParameter("nombre");
                String decripcion = request.getParameter("descripcion");
                Double precio = Double.parseDouble(request.getParameter("precio"));
                int stock = Integer.parseInt(request.getParameter("stock"));
                Part foto = request.getPart("foto");
                InputStream inputStream = foto.getInputStream();
                p.setIdP(idp);
                p.setNombreP(producto);
                p.setDescripcionP(decripcion);
                p.setPrecioP(precio);
                p.setStockP(stock);
                p.setFoto(inputStream);
                p.setIdTienda(id);
                if (idp == 0) {
                    try {
                        Pdao.insert(p);
                    } catch (Exception e) {
                        System.out.println("Error en insertar " + e.getMessage());
                    }
                } else {
                    try {
                        Pdao.update(p);
                    } catch (Exception e) {
                        System.out.println("Error en update " + e.getMessage());
                    }
                }
                response.sendRedirect("Controlador?accion=VistaTienda");
                break;
            case "Cancelar":
                id = Integer.parseInt(request.getParameter("idTienda"));
                if (id == 0) {
                    response.sendRedirect("Acceso.jsp");
                } else {
                    p.setIdTienda(id);
                    response.sendRedirect("Controlador?accion=VistaTienda");
                }
                break;
            case "Iniciar":
                try {
                    String correo = request.getParameter("correo");
                    String password = request.getParameter("password");
                    ResultSet rs;
                    ConexionBD canal = new ConexionBD();
                    Connection conn = canal.conectar();
                    PreparedStatement ps;
                    String sql = "select * from clientes where Ccorreo = ? and Cpassword = ? limit 1";
                    ps = canal.conn.prepareStatement(sql);
                    ps.setString(1, correo);
                    ps.setString(2, password);
                    rs = ps.executeQuery();
                    if (rs.next()) {
                        cid = rs.getInt(1);
                        HttpSession ses = request.getSession();
                        ses.setAttribute("logueado", "OK");
                        ses.setAttribute("cliente", cid);
                        c.setIdCliente(cid);
                        response.sendRedirect("Controlador?accion=GenerarCompra");
                    } else {
                        response.sendRedirect("Acceso.jsp");
                    }
                } catch (Exception e) {
                    System.out.println("Error al acceder " + e.getMessage());
                }
                break;
            case "Registro":
                Cliente cliente = new Cliente();
                cid = cliente.getIdCliente();
                request.setAttribute("cliente", cliente);
                request.getRequestDispatcher("Registro.jsp").forward(request, response);
                break;
            case "Aceptar":
                cid = Integer.parseInt(request.getParameter("idCliente"));
                String nombreC = request.getParameter("nombres");
                String apellidoC = request.getParameter("apellidos");
                String correoC = request.getParameter("correo");
                String pass = request.getParameter("password");
                c.setNombres(nombreC);
                c.setApellidos(apellidoC);
                c.setCorreo(correoC);
                c.setPassword(pass);
                if (cid == 0){
                    try {
                        cdao.agregar(c);
                        response.sendRedirect("Controlador?accion=GenerarCompra");
                    } catch (Exception e) {
                        System.out.println("Error en agregar cliente "+e.getMessage());
                    }
                } else {
                    try {
                        cdao.update(c);
                    } catch (Exception e) {
                        System.out.println("Error en updateCliente "+e.getMessage());
                    }
                }
                break;
        }
    }
}
