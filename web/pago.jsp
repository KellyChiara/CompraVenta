<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
        <link href="css/estilos.css" rel="stylesheet" type="text/css"/>
        <title>Realizar Pago</title>
    </head>
    <body>
    <center>
        <div class="container-mt-4 col-lg-4">
            <div class="card col-sm-10">
                 <div class="card-body">
                     <form class="form-sign" action="LoginControlador" method="POST">
                         <div class="form-group text-center">
                             <p><strong> ¡GRACIAS POS ADQUIRIR NUESTROS PRODUCTOS !</strong></p>
                             
                             <img src="imagenes/inventario.png" alt=""/>
                             <label></label>
                         </div> 
                        
                         
                         <div class="form-group">
                             
                             <label>Numero de tajeta de debito</label>
                             <input type="hidden" value="idPago" >
                             <input type="text" name="numtarjeta"  id="nomtarjeta" placeholder="Ej. 5555-4444-3333-2222"  class="form-control" required>
                           
                         </div>
                         <div class="form-group">
                           <label>Contraseña</label>
                           <input type="password" name="contraseña" placeholder="Ingrese su contraseña" class="form-control">   
                         </div>
                         <div class="form-group">
                           <label>Total a Pagar</label>
                           <input type="text" value="Bs.${totalPagar}" readonly="" class="form-control">
                         </div>
                         <div>
                       
                         <p><a href="Controlador?accion=entrega" class="btn btn-primary btn-b">Siguiente</a></p>
                         </div>
                         
                     </form> 
                 </div>
             </div>
        </div>
    </center>
     <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
     <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
     <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>  
    </body>
</html>
