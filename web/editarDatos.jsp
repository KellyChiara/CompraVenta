<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.emergentes.modelo.Cliente" %>
<%
    Cliente libro = (Cliente)request.getAttribute("libro");
 %>   
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container-mt-4 col-lg-4">
            <div class="card col-sm-10">
                 <div class="card-body">
        <h1>
            <c:if test="${item.id == 0}">Nuevo direccion</c:if>
            <c:if test="${item.id != 0}">Editar</c:if>
        </h1>
        <form action="controladorCarrito" method="post">
            <input type="hidden" name="idCliente" value="${libro.id}"/>
        
                     <div class="form-group text-center">
                         <h1><strong>CONFIRMA TUS DATOS!</strong></h1>
                             <label></label>
                         </div> 
                     
               
                <div class="form-group">
                  <label>NOMBRE COMPLETO</label>
                  <input type="text" name="nombreCliente" value="${libro.nombreCliente}">
                </div>
                <div class="form-group">
                    <label>DIRECCION:</label>
                    <input type="text" name="direccion" value="${libro.direccion}">
                </div>
              <div class="form-group">
                <label>EMAIL</label>
                 <input type="text" name="email" value="${libro.email}">
                </div>
                <div class="form-group">
                   
                    <input type="hidden" name="password" value="${libro.password}">
                </div>
                
                    <td><input type="hidden" name="dni" value="${libro.dni}">
                
                <div>
                    <input type="submit" value="Enviar"/>
                 <a href="Controlador?accion=agradecimiento" class="btn btn-danger">Comprar</a>
                </div>
                    
                    
        </form> 
       </div>
       </div>
      </div>
    
     <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
     <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
     <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>  
   
    </body>
</html>

