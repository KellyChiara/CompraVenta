<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="https://kit.fontawesome.com/ecff04c145.js" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
        <title>Tu tienda</title>
    </head>
    <body>
    <center>
        <div class="container mt-2">
            <div class="row">
                <div class="col-sm-4">
                    <div class="card">
                        <div class="card-header">
                            <input type="hidden" name="idTienda" value="${datos.id}">
                            <label>Tu tienda: ${datos.nombre}</label>
                        </div>
                        <div class="card-body">
                            <p>Tu pais: ${datos.pais}</p>
                            <p>Tu ciudad: ${datos.ciudad}</p>
                            <p>Tu direccion: ${datos.direccion}</p>
                            <p>Vendes: ${datos.vende}</p>
                            <p>Tu numero: ${datos.numero}</p>
                            <p>Tu codigo: ${datos.codigo}</p>
                        </div>
                        <div class="card-footer">
                            <a href="Controlador?accion=Aceptar&id=${datos.id}" class="btn btn-outline-info">Aceptar</a>
                            <a href="Controlador?accion=Editar&id=${datos.id}" class="btn btn-danger">Editar</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </center>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
</body>
</html>
