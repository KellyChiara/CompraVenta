<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="https://kit.fontawesome.com/ecff04c145.js" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
        <title>Compra y Venta de Articulos</title>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <a class="navbar-brand" href="Controlador?accion=view">HOME</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="Controlador?accion=carrito"><i class="fas fa-cart-plus">(<label style="color : darkorange">${contador}</label>)</i>Carrito</a>
                    </li>
                    <li class="nav-item active">
                        <a class="nav-link" href="Controlador?accion=Vender">Empieza a vender</a>
                </ul>
            </div>
        </nav>
        <br><br>
        <div class="container mt-2">
            <div class="row">
                <c:forEach var="p" items="${productos}">
                    <div class="col-sm-4">
                        <div class="card">
                            <div class="card-header">
                                <label>${p.nombreP}</label>
                            </div>
                            <div class="card-body">
                                <i>Bs. ${p.getPrecioP()}</i>
                                <img src="ControladorIMG?id=${p.getIdP()}" width="200" height="180">
                            </div>
                            <div class="card-footer text-center">
                                <label>${p.getDescripcionP()}</label>
                                <div>
                                    <input type="hidden" name="idTienda" value="${p.getIdTienda()}">
                                    <a href="Controlador?accion=AgregarCarrito&idP=${p.getIdP()}" class="btn btn-outline-info">Agregar a carrito</a>
                                    <a href="Controlador?accion=Comprar&idP=${p.getIdP()}" class="btn btn-danger">Comprar</a>
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
