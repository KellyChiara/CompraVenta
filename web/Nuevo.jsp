<%@page import="com.emergentes.utiles.Producto"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% 
    Producto producto = (Producto) request.getAttribute("producto");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="https://kit.fontawesome.com/ecff04c145.js" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
        <title>Nuevo Producto</title>
    </head>
    <body>
    <center>
        <div class="container mt-4">
            <form form action="Controlador" method="post" enctype="multipart/form-data">
                <div class="card">
                    <div class="card-header">
                        <h3>
                            <c:if test="${producto.idP == 0}">Nuevo </c:if>
                            <c:if test="${producto.idP != 0}">Editar </c:if>
                            Producto
                        </h3>
                    </div>
                    <div class="card-body">
                        <div class="form-group">
                            <input type="hidden" name="id" value="${producto.idP}">
                            <label>Nombre Producto:</label>
                            <input type="text" name="nombre" class="form-control" value="${producto.nombreP}">
                        </div>
                        <div class="form-group">
                            <label>Descripcion: </label>
                            <input type="text" name="descripcion" class="form-control" value="${producto.descripcionP}">
                        </div>
                        <div class="form-group">
                            <label>Precio:</label>
                            <input type="number" name="precio" step="0.001" class="form-control" value="${producto.precioP}">
                        </div>
                        <div class="form-group">
                            <label>Stock:</label>
                            <input type="number" name="stock" class="form-control" value="${producto.stockP}">
                        </div>
                        <div class="form-group">
                            <label>Foto:</label>
                            <input type="file" name="foto">
                            <input type="hidden" name="idTienda" value="${producto.idTienda}">
                        </div>
                    </div>
                    <div class="card-footer">
                        <input type="submit" name="accion" value="Confirmar" class="btn btn-outline-primary">
                        <input type="submit" name="accion" value="Cancelar" class="btn btn-danger">
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
