<%@page import="com.emergentes.utiles.Cliente"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% 
    Cliente cliente = (Cliente) request.getAttribute("cliente");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="https://kit.fontawesome.com/ecff04c145.js" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
        <title>Datos</title>
    </head>
    <body>
        <center>
        <div class="container mt-4">
            <form action="Controlador" method="post">
                <div class="card">
                    <div class="card-header">
                        <h3>
                            <c:if test="${cliente.idCliente == 0}"> Nuevo </c:if>
                            <c:if test="${cliente.idCliente != 0}"> Editar</c:if>
                            Cliente
                        </h3>
                    </div>
                    <div class="card-body">
                        <div class="form-group">
                            <input type="hidden" name="idCliente" value="${cliente.idCliente}">
                            <label>Nombres:</label>
                            <input type="text" name="nombres" class="form-control" value="${cliente.nombres}">
                        </div>
                        <div class="form-group">
                            <label>Apellidos: </label>
                            <input type="text" name="apellidos" class="form-control" value="${cliente.apellidos}">
                        </div>
                        <div class="form-group">
                            <label>Correo Electronico: </label>
                            <input type="email" name="correo" class="form-control" value="${cliente.correo}">
                        </div>
                        <div class="form-group">
                            <label>Password: </label>
                            <input type="password" name="password" class="form-control" value="${cliente.password}">
                        </div>
                    </div>
                    <div class="card-footer">
                        <input type="submit" name="accion" class="btn btn-outline-info" value="Aceptar"/>
                        <input type="submit" name="accion" class="btn btn-danger" value="Volver">
                    </div>
                </div>
            </form>
        </div>
    </center>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
    </body>
</html>
