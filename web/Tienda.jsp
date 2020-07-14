<%
    if (session.getAttribute("logueado") != "OK") {
        response.sendRedirect("Acceso.jsp");
    }
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="https://kit.fontawesome.com/ecff04c145.js" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
        <title>Tienda</title>
    </head>
    <body>
        <input type="hidden" id="idTienda" value="${sessionScope.tienda}">
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <a class="navbar-brand" href="Controlador?accion=VistaTienda">Tus Productos</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="#">Pedidos</a>
                    </li>
                    <li class="nav-item active">
                        <a class="nav-link" href="Controlador?accion=Nuevo&idTienda=${sessionScope.tienda}">Nuevo Producto</a>
                    </li>
                    <li class="nav-item active">
                        <a class="nav-link" href="Controlador?accion=DatosTienda&idTienda=${sessionScope.tienda}">Tu Tienda</a>
                    </li>
                    <li class="nav-item active">
                        <a class="nav-link" href="Controlador?accion=Cerrar">Cerrar sesion</a>
                    </li>
                </ul>
            </div>
        </nav>
        <br><br>
        <div class="container mt-2">
            <div class="row">
                <c:forEach var="p" items="${producto}">
                    <div class="col-sm-4">
                        <div class="card">
                            <div class="card-header">
                                <input type="hidden" name="idProducto" value="${p.idP}">
                                <label>${p.nombreP}</label>
                            </div>
                            <div class="card-body">
                                <i>Bs. ${p.precioP}</i>
                                <img src="ControladorIMG?id=${p.idP}" width="200" height="180">
                            </div>
                            <div class="card-footer text-center">
                                <label>${p.descripcionP}</label>
                                <input type="hidden" name="idTienda" value="${p.idTienda}">
                                <div>
                                    <a href="Controlador?accion=edit&id=${p.idP}" class="btn btn-outline-info">Editar</a>
                                    <a href="Controlador?accion=eliminar&id=${p.idP}&idTienda=${p.idTienda}" class="btn btn-danger">Eliminar</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>

        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
    </body>
</html>
