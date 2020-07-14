package com.emergentes.controlador;
import com.emergentes.dao.ProductoDao;
import com.emergentes.dao.ProductoDaoImp;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(name = "ControladorIMG", urlPatterns = {"/ControladorIMG"})
public class ControladorIMG extends HttpServlet {
    ProductoDao dao = new ProductoDaoImp();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            dao.listarImg(id, response);
        } catch (Exception ex) {
            System.out.println("Error en listar imagen "+ex.getMessage());
        }
    }
}
